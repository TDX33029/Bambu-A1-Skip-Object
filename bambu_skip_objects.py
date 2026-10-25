#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Bambu 跳过对象 PC 端工具(打印中跳过指定零件)
==============================================

协议逆向自拓竹 Bambu Handy 安卓版(证据链见 docs/reverse-notes.md)。
支持两种通道,协议完全一致:

  云端(默认,零配置) : cn/us.mqtt.bambulab.com:8883,用户名 u_<user_id>,密码=账号 token
                        凭证自动从本机 Bambu Studio 配置读取并解密(AES-128-ECB 固定密钥)
  局域网              : <打印机IP>:8883,用户名 bblp,密码=设备访问码(8位)

跳过命令(Handy 新协议):
  {"print": {"sequence_id": "2001+", "command": "skip_objects",
             "timestamp": <ms>, "obj_list": [<identify_id>...]}}
旧协议(Studio 兼容):{"print": {"sequence_id": "…", "skip_objects": "1,2"}}

对象列表来源(三选一,自动优先):
  1. 云端任务接口  {api}/v1/iot-service/api/user/task/{task_id}
                    (Handy 同源;task_id 取自打印机 report,仅云任务有效)
  2. 本地切片 3mf  Metadata/slice_info.config(与云端数据同源)
  3. 手动输入 ID

依赖:pip install paho-mqtt pycryptodome
用法:python bambu_skip_objects.py              # 图形界面(自动读取 Studio 凭证)
      python bambu_skip_objects.py --cli --ids 197,175
      python bambu_skip_objects.py --cli --lan --ip 192.168.1.100 --code 12345678 --ids 1,2
"""

import argparse
import json
import os
import re
import socket
import ssl
import sys
import threading
import time
import urllib.request
import uuid
import zipfile
import xml.etree.ElementTree as ET
from dataclasses import dataclass, field

try:
    import paho.mqtt.client as mqtt
    from paho.mqtt.client import CallbackAPIVersion
except ImportError:
    print("缺少 paho-mqtt: pip install paho-mqtt")
    sys.exit(1)

SEQ_START = 2001  # 逆向自 bhp.kt: AtomicInteger(2001)
UA = "bambu-handry/3.15.5 (Android)"
VERSION = "1.2"


# ================================================================ 凭证

def _studio_dir():
    if os.name == "nt":
        return os.path.join(os.environ.get("APPDATA", ""), "BambuStudio")
    return os.path.expanduser("~/Library/Application Support/BambuStudio")


@dataclass
class CloudCreds:
    user_id: str
    token: str
    account: str = ""
    region: str = "cn"          # cn / us
    printers: dict = field(default_factory=dict)   # sn -> access_code(来自 Studio)
    last_sn: str = ""

    @property
    def mqtt_host(self):
        return "cn.mqtt.bambulab.com" if self.region == "cn" else "us.mqtt.bambulab.com"

    @property
    def api_base(self):
        return "https://api.bambulab.cn" if self.region == "cn" else "https://api.bambulab.com"


def load_studio_creds() -> CloudCreds | None:
    """从本机 Bambu Studio 配置读取账号 token 与打印机访问码(仅本机使用)"""
    d = _studio_dir()
    netconf = os.path.join(d, "BambuNetworkEngine.conf")
    if not os.path.isfile(netconf):
        return None
    try:
        from Crypto.Cipher import AES
    except ImportError:
        print("提示: 检测到 Bambu Studio 但缺少 pycryptodome,"
              "云端模式不可用: pip install pycryptodome")
        return None
    raw = open(netconf, "rb").read()
    raw = raw[:len(raw) // 16 * 16]
    dec = AES.new(b"i4crL3LESLnWapLS", AES.MODE_ECB).decrypt(raw)  # 公开已知固定密钥
    try:
        net = json.loads(dec.rstrip(b"\x00").rstrip())
    except Exception:
        return None
    user = net.get("user") or {}
    token, uid = user.get("token"), user.get("user_id")
    if not token or not uid:
        return None
    region = "cn" if ".cn" in (user.get("avatar") or "") else "us"

    printers, last_sn = {}, ""
    stconf = os.path.join(d, "BambuStudio.conf")
    if os.path.isfile(stconf):
        try:
            st, _ = json.JSONDecoder().raw_decode(
                open(stconf, encoding="utf-8").read())
            printers = dict(st.get("access_code") or {})
            last_sn = st.get("user_last_selected_machine", "")
        except Exception:
            pass
    # 上次在本工具中成功连接的打印机优先
    cache = _load_cache()
    if cache.get("last_ok_sn") in printers:
        last_sn = cache["last_ok_sn"]
    return CloudCreds(user_id=uid, token=token,
                      account=user.get("account", ""), region=region,
                      printers=printers, last_sn=last_sn)


def _cache_path():
    return os.path.join(os.path.dirname(os.path.abspath(__file__)),
                        ".bbl_skip_cache.json")


def _load_cache():
    try:
        return json.loads(open(_cache_path(), encoding="utf-8").read())
    except Exception:
        return {}


def save_last_sn(sn: str):
    try:
        c = _load_cache()
        c["last_ok_sn"] = sn
        json.dump(c, open(_cache_path(), "w", encoding="utf-8"))
    except Exception:
        pass


# ================================================================ 3mf 解析

@dataclass
class SkipObject:
    obj_id: int
    identify_id: int
    name: str = ""
    skipped: bool = False

    def label(self) -> str:
        return f"#{self.identify_id}  {self.name}" + ("  [已跳过]" if self.skipped else "")


@dataclass
class Plate:
    index: int
    name: str = ""
    objects: list = field(default_factory=list)
    pick_url: str = ""
    pick_bytes: bytes = b""    # pick 遮罩图 PNG(颜色编码 identify_id,可点击)
    top_bytes: bytes = b""     # 渲染俯视图 PNG(仅预览)
    source: str = ""


def decode_pick_id(rgba) -> int:
    """pick 遮罩图像素 → identify_id(逆向自 b1v.i:字节重排编码)。
    Handy 的点图选零件即此机制:R=id低8位, G=id中8位, B=id高8位。"""
    r, g, b = rgba[0], rgba[1], rgba[2]
    if (r, g, b) == (0, 0, 0):
        return 0
    return r + g * 256 + b * 65536


def parse_slice_info(xml_bytes: bytes) -> list:
    plates = []
    root = ET.fromstring(xml_bytes)
    for plate in root.iter("plate"):
        idx, pname = 0, ""
        for meta in plate.findall("metadata"):
            if meta.get("key") == "index":
                idx = int(meta.get("value", "0") or 0)
            elif meta.get("key") == "name":
                pname = meta.get("value", "")
        objs = []
        for obj in plate.findall("object"):
            def _int(a):
                try:
                    return int(obj.get(a))
                except (TypeError, ValueError):
                    return None
            oid, iid = _int("object_id"), _int("identify_id")
            if iid is None:
                iid = oid
            if iid is None:
                continue
            objs.append(SkipObject(oid if oid is not None else iid, iid,
                                   obj.get("name", ""),
                                   obj.get("skipped", "").lower() == "true"))
        plates.append(Plate(idx, pname, objs, source="3mf"))
    return plates


def load_objects_from_file(path: str):
    lower = path.lower()
    if lower.endswith(".3mf"):
        with zipfile.ZipFile(path) as z:
            names = z.namelist()
            for cand in ("Metadata/slice_info.config", "metadata/slice_info.config"):
                if cand in names:
                    plates = parse_slice_info(z.read(cand))
                    for p in plates:   # 附带 pick/top 遮罩与渲染图(点击选零件用)
                        for pre, attr in (("pick", "pick_bytes"), ("top", "top_bytes")):
                            for cand2 in (f"Metadata/{pre}_{p.index}.png",
                                          f"metadata/{pre}_{p.index}.png"):
                                if cand2 in names:
                                    if attr == "pick_bytes":
                                        p.pick_bytes = z.read(cand2)
                                    else:
                                        p.top_bytes = z.read(cand2)
                                    break
                    return plates
            raise ValueError("该 3mf 未包含切片信息(Metadata/slice_info.config)。\n"
                             "请在 Bambu Studio 切片后用『导出切片文件』导出。")
    raise ValueError("仅支持切片后的 .3mf 文件(或使用云端任务/手动输入 ID)")


# ================================================================ 云端任务对象列表

def _download(url: str, timeout=25) -> bytes:
    req = urllib.request.Request(url, headers={"User-Agent": UA})
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return r.read()


def fetch_task_objects(task_id: str, creds: CloudCreds, timeout=20):
    """Handy 同源接口:{api}/v1/iot-service/api/user/task/{task_id} → context.plates"""
    url = f"{creds.api_base}/v1/iot-service/api/user/task/{task_id}"
    req = urllib.request.Request(url, headers={
        "Authorization": "Bearer " + creds.token,
        "User-Agent": UA,
        "Accept": "application/json",
    })
    with urllib.request.urlopen(req, timeout=timeout) as r:
        d = json.loads(r.read())
    ctx = d.get("context") or {}
    plates = []
    for p in ctx.get("plates") or []:
        objs = []
        for o in p.get("objects") or []:
            try:
                iid = int(o.get("identify_id"))
            except (TypeError, ValueError):
                continue
            try:
                oid = int(o.get("object_id", iid))
            except (TypeError, ValueError):
                oid = iid
            objs.append(SkipObject(oid, iid, o.get("name", ""),
                                   bool(o.get("skipped"))))
        pick = ((p.get("pick_picture") or {}).get("url") or "")
        top = ((p.get("top_picture") or {}).get("url") or "")
        plate = Plate(int(p.get("index") or 0), p.get("name") or "",
                      objs, pick, source="cloud")
        for url_, attr in ((pick, "pick_bytes"), (top, "top_bytes")):
            if url_:
                try:
                    if attr == "pick_bytes":
                        plate.pick_bytes = _download(url_)
                    else:
                        plate.top_bytes = _download(url_)
                except Exception:
                    pass   # 图片缺失不影响列表选择
        plates.append(plate)
    return plates, d


# ================================================================ 连接诊断(代理/Fake-IP)

FAKEIP_RANGES = ((198, 18), (198, 19))   # RFC 2544 段,Clash/Mihomo Fake-IP 默认池


def is_fake_ip(ip: str) -> bool:
    try:
        a, b = (int(x) for x in ip.split(".")[:2])
    except ValueError:
        return False
    return (a, b) in FAKEIP_RANGES


def resolve_host(host: str):
    """返回 (ip, notes);检测代理 Fake-IP 接管 DNS 的情况"""
    notes = []
    try:
        infos = socket.getaddrinfo(host, 8883, socket.AF_INET, socket.SOCK_STREAM)
        ip = infos[0][4][0]
    except Exception as e:
        raise RuntimeError(f"DNS 解析失败 {host}: {e}")
    notes.append(f"DNS {host} -> {ip}")
    if is_fake_ip(ip):
        notes.append("警告: 解析结果是 Fake-IP(代理软件接管了 DNS)。MQTT 长连接可能被"
                     "代理转发到境外节点导致握手无响应。建议:把 *.bambulab.com 加入代理"
                     "直连(DIRECT)规则,或临时关闭代理。下方改用该地址继续尝试。")
    t0 = time.time()
    try:
        probe = socket.create_connection((ip, 8883), timeout=6)
        probe.close()
        notes.append(f"TCP {ip}:8883 可达({time.time()-t0:.1f}s)")
    except Exception as e:
        raise RuntimeError(f"TCP 连接 {ip}:8883 失败: {e}\n" + "\n".join(notes))
    return ip, notes


# ================================================================ 打印机客户端

STATE_CN = {
    "IDLE": "空闲", "RUNNING": "打印中", "PAUSE": "已暂停", "FINISH": "已完成",
    "FAILED": "已失败", "SLICING": "切片中", "SYSLAYER": "首层扫描",
    "PREPARE": "准备中", "CHANGE_FILAMENT": "换料中", "M600_PAUSE": "换料暂停",
    "HAIR_LINE": "调平扫线", "SKIRT": "打印裙边",
}


class PrinterClient:
    """云端/局域网 MQTT(协议一致,来自 BblBrokerConfig.local/remote)"""

    def __init__(self, on_event=None):
        self.on_event = on_event or (lambda kind, data=None: None)
        self.mode = "cloud"          # cloud | lan
        self.host = ""
        self.username = ""
        self.password = ""
        self.user_id = ""            # 云端命令会带 user_id
        self.sn = ""                 # 目标打印机(云端模式必填,局域网可自动发现)
        self.client = None
        self.connected = False
        self.devices = {}
        self._seq = SEQ_START
        self._lock = threading.Lock()

    # ---- 配置
    def setup_cloud(self, creds: CloudCreds, sn: str):
        self.mode, self.sn = "cloud", sn
        self.host = creds.mqtt_host
        self.username, self.password = "u_" + creds.user_id, creds.token
        self.user_id = creds.user_id

    def setup_lan(self, host: str, access_code: str, sn: str = ""):
        self.mode, self.sn = "lan", sn
        self.host, self.username, self.password = host, "bblp", access_code
        self.user_id = ""

    # ---- MQTT
    def connect(self, connect_ip=None):
        c = mqtt.Client(CallbackAPIVersion.VERSION2, client_id=str(uuid.uuid4()),
                        protocol=mqtt.MQTTv311)
        ctx = ssl.SSLContext(ssl.PROTOCOL_TLS_CLIENT)
        ctx.check_hostname = False
        ctx.verify_mode = ssl.CERT_NONE
        c.tls_set_context(ctx)
        c.username_pw_set(self.username, self.password)
        c.on_connect = self._on_connect
        c.on_disconnect = self._on_disconnect
        c.on_message = self._on_message
        c.connect(connect_ip or self.host, 8883, keepalive=60)
        c.loop_start()
        self.client = c

    def connect_with_diagnosis(self):
        """先做 DNS/TCP 诊断(检测代理 Fake-IP),再用真实 IP 连接。
        返回诊断行列表;异常向上抛。"""
        ip, notes = resolve_host(self.host)
        self.connect(connect_ip=ip)
        return notes

    def disconnect(self):
        """立即返回;后台线程强制断开。paho 的 disconnect/loop_stop 会等待网络线程,
        遇到半死连接(如代理挂起)会在 UI 线程无限卡死,故绝不在调用线程执行。"""
        c = self.client
        self.client = None
        self.connected = False
        if not c:
            return

        def _kill():
            try:
                s = c.socket()
            except Exception:
                s = None
            try:
                c.disconnect()
            except Exception:
                pass
            if s:
                try:
                    s.shutdown(socket.SHUT_RDWR)
                except Exception:
                    pass
                try:
                    s.close()
                except Exception:
                    pass
            try:
                c.loop_stop(force=True)
            except Exception:
                pass

        threading.Thread(target=_kill, daemon=True).start()

    def _emit(self, kind, data=None):
        try:
            self.on_event(kind, data)
        except Exception:
            pass

    def _on_connect(self, client, userdata, flags, reason_code, properties):
        if getattr(reason_code, "is_failure", False):
            self._emit("error", f"MQTT 认证被拒绝: {reason_code}")
            return
        self.connected = True
        if self.sn:
            client.subscribe(f"device/{self.sn}/report", qos=0)
        else:
            client.subscribe("device/+/report", qos=0)   # 局域网自动发现
        self._emit("connected")

    def _on_disconnect(self, client, userdata, flags, reason_code, properties):
        self.connected = False
        self._emit("disconnected", str(reason_code))

    def _on_message(self, client, userdata, msg):
        try:
            data = json.loads(msg.payload.decode("utf-8", "ignore"))
        except Exception:
            return
        sn = msg.topic.split("/")[1] if "/" in msg.topic else "?"
        if isinstance(data, dict) and isinstance(data.get("print"), dict):
            if not self.sn and self.mode == "lan":
                self.sn = sn           # 局域网模式自动锁定唯一设备
            # 云端 report 分段推送:按字段合并,避免部分报文覆盖已有状态
            self.devices.setdefault(sn, {}).update(data["print"])
            self._emit("report", (sn, self.devices[sn]))

    # ---- 命令(逆向自 BblCommandGatewayImpl / bhp.kt)
    def _publish_print(self, body: dict, category="print"):
        if not self.connected:
            raise RuntimeError("未连接打印机")
        sn = self.sn or self.current_sn()
        if not sn:
            raise RuntimeError("尚未发现打印机(等待 report 或手动指定序列号)")
        with self._lock:
            self._seq += 1
            body["sequence_id"] = str(self._seq)
            body.setdefault("timestamp", int(time.time() * 1000))
        root = {}
        if self.user_id:                       # 云端模式带 user_id(逆向 bhp.kt)
            root["user_id"] = self.user_id
        root[category] = body
        topic = f"device/{sn}/request"
        raw = json.dumps(root, separators=(",", ":"))
        self.client.publish(topic, raw, qos=0)
        self._emit("sent", (topic, raw))

    def current_sn(self):
        if self.sn:
            return self.sn
        if not self.devices:
            return None
        if len(self.devices) == 1:
            return next(iter(self.devices))
        return max(self.devices.items(), key=lambda kv: kv[1].get("timestamp", 0))[0]

    def request_push(self):
        with self._lock:
            self._seq += 1
            body = {"sequence_id": str(self._seq), "command": "pushall"}
        if not self.connected:
            return
        sn = self.sn or self.current_sn()
        if sn:
            self.client.publish(f"device/{sn}/request",
                                json.dumps({"pushing": body}, separators=(",", ":")), qos=0)

    # ---- 跳过对象
    def skip_objects(self, ids, legacy=False):
        if isinstance(ids, str):
            ids = re.split(r"[,\s]+", ids.strip())
        ids = sorted({int(i) for i in ids if str(i).strip()})
        if not ids:
            raise ValueError("未选择任何对象")
        if legacy:
            self._publish_print({"skip_objects": ",".join(map(str, ids))})
        else:
            self._publish_print({"command": "skip_objects", "obj_list": ids})


# ================================================================ CLI

def run_cli(args):
    creds = None if args.lan else load_studio_creds()
    pc = PrinterClient()
    if args.lan:
        if not (args.ip and args.code):
            print("局域网模式需要 --ip 和 --code(打印机屏幕:设置→无线→局域网)")
            return
        pc.setup_lan(args.ip, args.code, args.sn or "")
        print(f"[*] 局域网模式 {args.ip}:8883 (bblp)")
    else:
        if not creds:
            print("未找到 Bambu Studio 凭证(或缺少 pycryptodome)。"
                  "请先在本机登录 Bambu Studio,或改用 --lan 局域网模式。")
            return
        sn = args.sn or creds.last_sn or (next(iter(creds.printers), "") if len(creds.printers) == 1 else "")
        if not sn:
            print("无法确定打印机序列号:请用 --sn 指定。已知:", ", ".join(creds.printers) or "无")
            return
        pc.setup_cloud(creds, sn)
        print(f"[*] 云端模式 {creds.mqtt_host}(账号 {creds.account or creds.user_id},"
              f"区域 {creds.region}),打印机 {sn}")

    ids = []
    if args.ids:
        ids += [int(x) for x in re.split(r"[,\s]+", args.ids.strip()) if x]
    sent = threading.Event()

    def on_event(kind, data=None):
        if kind == "connected":
            print("[+] MQTT 已连接,等待 report …")
        elif kind == "error":
            print("[!] " + str(data))
        elif kind == "report":
            sn, prt = data
            state = prt.get("gcode_state", "?")
            print(f"[{sn}] {STATE_CN.get(state, state)}  层 {prt.get('layer_num','-')}/{prt.get('total_layer_num','-')}"
                  f"  任务 {prt.get('subtask_name','-')}  已跳过 {prt.get('skip_objects','-')}")
            if not sent.is_set() and not ids and prt.get("task_id") and creds:
                try:
                    plates, _ = fetch_task_objects(prt["task_id"], creds)
                    cur = int((json.loads(prt.get("content", "{}")).get("info", {}) or {}).get("plate_idx", 0)) \
                        if prt.get("content") else 0
                    plate = next((p for p in plates if p.index == cur), plates[0] if plates else None)
                    if plate:
                        got = [o.identify_id for o in plate.objects if not o.skipped]
                        print(f"[*] 云端任务对象: {[f'{o.identify_id}:{o.name}' for o in plate.objects]}"
                              f"(未跳过: {got})")
                        print("[*] CLI 未指定 --ids,不发送。示例: --ids " + ",".join(map(str, got[:2])))
                except Exception as e:
                    print("[!] 获取云端对象列表失败: " + str(e))
            elif not sent.is_set() and ids and state in ("RUNNING", "PAUSE"):
                time.sleep(0.6)
                pc.skip_objects(ids, legacy=args.legacy)
                print(f"[+] 已发送跳过命令: {ids}")
                sent.set()
        elif kind == "sent":
            print(f"[>] {data[0]}  {data[1]}")

    pc.on_event = on_event
    try:
        ip, notes = resolve_host(pc.host)
        for ln in notes:
            print("    " + ln)
        pc.connect(connect_ip=ip)
    except Exception as e:
        print("[!] 连接失败: " + str(e))
        return
    try:
        deadline = time.time() + 30
        while time.time() < deadline and not sent.is_set():
            time.sleep(0.5)
            if pc.connected:
                pc.request_push()
                time.sleep(2.5)
        if sent.is_set():
            time.sleep(3)
            sn2 = pc.current_sn()
            if sn2 and pc.devices.get(sn2):
                print(f"[*] 打印机当前已跳过: {pc.devices[sn2].get('skip_objects', '-')}")
        else:
            print("[!] 未完成发送(未处于打印中/未收到 report)。")
    except Exception as e:
        print("[!] " + str(e))
    finally:
        pc.disconnect()
    print("完成。")


# ================================================================ GUI

def run_gui():
    import tkinter as tk
    from tkinter import ttk, filedialog, messagebox

    creds = load_studio_creds()
    root = tk.Tk()
    root.title("拓竹跳过对象工具(打印中跳过指定零件)")
    root.geometry("900x720")
    root.minsize(780, 600)

    pc = PrinterClient()
    plates = []
    obj_vars = {}

    # ---------- 凭证 / 连接
    top = ttk.LabelFrame(root, text="1. 连接(自动读取本机 Bambu Studio 凭证)", padding=8)
    top.pack(fill="x", padx=10, pady=(10, 5))
    mode_var = tk.StringVar(value="cloud" if creds else "lan")
    sn_var = tk.StringVar()
    ip_var, code_var = tk.StringVar(), tk.StringVar()
    conn_info = ttk.Label(top, text="")
    if creds:
        sns = list(creds.printers.keys())
        info = f"账号 {creds.account or creds.user_id}(区域 {creds.region.upper()})"
        sn_sel = ttk.Combobox(top, textvariable=sn_var, width=22, state="readonly",
                              values=sns)
        if creds.last_sn in sns:
            sn_sel.current(sns.index(creds.last_sn))
        elif sns:
            sn_sel.current(0)
        ttk.Radiobutton(top, text=f"云端 {creds.mqtt_host}", value="cloud",
                        variable=mode_var).grid(row=0, column=0, sticky="w")
        sn_sel.grid(row=0, column=1, padx=6)
        ttk.Radiobutton(top, text="局域网(IP+访问码)", value="lan",
                        variable=mode_var).grid(row=0, column=2, padx=6)
        conn_info.configure(text=info)
    else:
        conn_info.configure(text="未检测到 Bambu Studio 凭证 → 请填打印机 IP 与访问码"
                                 "(打印机屏幕:设置→无线→局域网)")
    ttk.Label(top, text="IP:").grid(row=1, column=0, sticky="e", pady=(4, 0))
    ttk.Entry(top, textvariable=ip_var, width=16).grid(row=1, column=1, sticky="w", pady=(4, 0))
    ttk.Label(top, text="访问码:").grid(row=1, column=2, sticky="e", pady=(4, 0))
    e_code = ttk.Entry(top, textvariable=code_var, width=12, show="●")
    e_code.grid(row=1, column=3, sticky="w", pady=(4, 0))
    if creds and creds.printers:
        first_code = next(iter(creds.printers.values()), "")
        code_var.set(first_code)
    conn_info.grid(row=2, column=0, columnspan=4, sticky="w", pady=(4, 0))
    btn_conn = ttk.Button(top, text="连接")
    btn_conn.grid(row=1, column=4, rowspan=2, padx=10)

    # ---------- 状态
    stf = ttk.LabelFrame(root, text="2. 打印状态", padding=8)
    stf.pack(fill="x", padx=10, pady=5)
    st_labels = {}
    for i, key in enumerate(["状态", "任务", "层号", "进度", "已跳过", "任务ID"]):
        ttk.Label(stf, text=key + ":", foreground="#666").grid(row=0, column=i * 2, sticky="e", padx=(6, 0))
        v = ttk.Label(stf, text="-")
        v.grid(row=0, column=i * 2 + 1, sticky="w", padx=(2, 10))
        st_labels[key] = v

    # ---------- 对象
    objf = ttk.LabelFrame(root, text="3. 要跳过的零件(云端任务自动获取;俯视图上点击零件即可选中)", padding=8)
    objf.pack(fill="both", expand=True, padx=10, pady=5)
    objbar = ttk.Frame(objf)
    objbar.pack(fill="x")
    btn_fetch = ttk.Button(objbar, text="从云端任务获取", state="disabled")
    btn_fetch.pack(side="left")
    ttk.Button(objbar, text="打开切片 3mf…", command=lambda: pick_file()).pack(side="left", padx=6)
    plate_var = tk.StringVar()
    plate_cb = ttk.Combobox(objbar, textvariable=plate_var, width=30, state="readonly")
    plate_cb.pack(side="left", padx=4)
    plate_cb.bind("<<ComboboxSelected>>", lambda e: show_plate())
    ttk.Button(objbar, text="全选", command=lambda: set_all(True)).pack(side="left", padx=2)
    ttk.Button(objbar, text="清空", command=lambda: set_all(False)).pack(side="left", padx=2)

    mid = ttk.Frame(objf)
    mid.pack(fill="both", expand=True, pady=(4, 0))

    # 左:俯视图(pick 遮罩图可点击,颜色反解 identify_id —— 逆向自 Handy 跳过界面)
    imgf = ttk.Frame(mid)
    imgf.pack(side="left", fill="both", expand=False)
    view_var = tk.StringVar(value="pick")
    viewbar = ttk.Frame(imgf)
    viewbar.grid(row=0, column=0, columnspan=2, sticky="ew")
    ttk.Radiobutton(viewbar, text="选择视图(可点击)", value="pick",
                    variable=view_var, command=lambda: load_plate_image()).pack(side="left")
    ttk.Radiobutton(viewbar, text="渲染图(预览)", value="top",
                    variable=view_var, command=lambda: load_plate_image()).pack(side="left", padx=4)
    img_wrap = ttk.Frame(imgf)
    img_wrap.grid(row=1, column=0, sticky="nw")
    img_canvas = tk.Canvas(img_wrap, width=400, height=430, bg="#0a0a0a",
                           highlightthickness=1, highlightbackground="#444")
    img_sb_y = ttk.Scrollbar(img_wrap, orient="vertical", command=img_canvas.yview)
    img_sb_x = ttk.Scrollbar(imgf, orient="horizontal", command=img_canvas.xview)
    img_canvas.configure(yscrollcommand=img_sb_y.set, xscrollcommand=img_sb_x.set)
    img_canvas.grid(row=0, column=0, sticky="nw")
    img_sb_y.grid(row=0, column=1, sticky="ns")
    img_sb_x.grid(row=2, column=0, sticky="ew")

    # 右:零件复选列表
    listf = ttk.Frame(mid)
    listf.pack(side="left", fill="both", expand=True, padx=(8, 0))
    canvas = tk.Canvas(listf, highlightthickness=0)
    sb = ttk.Scrollbar(listf, orient="vertical", command=canvas.yview)
    inner = ttk.Frame(canvas)
    inner.bind("<Configure>", lambda e: canvas.configure(scrollregion=canvas.bbox("all")))
    canvas.create_window((0, 0), window=inner, anchor="nw")
    canvas.configure(yscrollcommand=sb.set)
    canvas.pack(side="left", fill="both", expand=True)
    sb.pack(side="right", fill="y")

    # ---------- 发送
    sendf = ttk.LabelFrame(root, text="4. 发送跳过命令", padding=8)
    sendf.pack(fill="x", padx=10, pady=5)
    manual_var = tk.StringVar()
    ttk.Label(sendf, text="手动 ID(逗号分隔):").pack(side="left")
    ttk.Entry(sendf, textvariable=manual_var, width=22).pack(side="left", padx=6)
    legacy_var = tk.BooleanVar(value=False)
    ttk.Checkbutton(sendf, text="旧协议(Studio 格式)", variable=legacy_var).pack(side="left", padx=6)
    btn_send = ttk.Button(sendf, text="跳过选中零件", state="disabled")
    btn_send.pack(side="right", padx=4)
    btn_send2 = ttk.Button(sendf, text="跳过手动输入", state="disabled")
    btn_send2.pack(side="right")

    # ---------- 日志
    logf = ttk.LabelFrame(root, text="MQTT 日志", padding=4)
    logf.pack(fill="both", padx=10, pady=(5, 10))
    log = tk.Text(logf, height=8, font=("Consolas", 9), state="disabled",
                  bg="#111", fg="#9f9")
    log.pack(fill="both", expand=True)

    def logln(s):
        log.configure(state="normal")
        log.insert("end", time.strftime("[%H:%M:%S] ") + s + "\n")
        log.see("end")
        log.configure(state="disabled")

    # ---------- 逻辑
    def reported_ids():
        prt = pc.devices.get(pc.sn, {})
        raw = prt.get("skip_objects")
        if not raw:
            return set()
        out = set()
        for tok in str(raw).replace(" ", "").split(","):
            try:
                out.add(int(tok))
            except ValueError:
                pass
        return out

    def set_plates(pls, default_idx=None):
        nonlocal plates
        plates = sorted(pls, key=lambda p: p.index)
        plate_cb["values"] = [f"盘 {p.index} {p.name}({len(p.objects)} 零件)[{p.source}]"
                              for p in plates]
        if plates:
            idx = 0
            if default_idx is not None:
                for i, p in enumerate(plates):
                    if p.index == default_idx:
                        idx = i
                        break
            plate_cb.current(idx)
            show_plate()

    def show_plate():
        for w in inner.winfo_children():
            w.destroy()
        obj_vars.clear()
        for it in img_canvas.find_all():
            img_canvas.delete(it)
        marks.clear()
        if not plates:
            return
        rep = reported_ids()
        for o in plates[plate_cb.current()].objects:
            if o.identify_id in rep:
                o.skipped = True
            var = tk.BooleanVar(value=o.skipped)
            row = ttk.Frame(inner)
            row.pack(fill="x", anchor="w")
            cb = ttk.Checkbutton(row, text=o.label(), variable=var,
                                 command=lambda oid=o.identify_id: sync_mark(oid))
            if o.skipped:
                cb.state(["disabled"])
            cb.pack(anchor="w")
            obj_vars[o.identify_id] = var
        load_plate_image()

    def sync_mark(iid):
        """列表勾选变化 → 同步图上标记(有点击位置才画圈)"""
        if iid in marks and not obj_vars[iid].get():
            img_canvas.delete(marks.pop(iid))
        elif obj_vars[iid].get() and iid in last_click:
            mark_at(iid)

    # ---- 俯视图(pick 遮罩图颜色反解 identify_id,逆向自 Handy 跳过界面 b1v.i)
    photos = []          # PhotoImage 防 GC
    marks = {}           # identify_id -> canvas oval item
    current_photo = [None]

    def load_plate_image():
        for it in img_canvas.find_all():
            img_canvas.delete(it)
        marks.clear()
        current_photo[0] = None
        if not plates:
            return
        pl = plates[plate_cb.current()]
        data = pl.pick_bytes if view_var.get() == "pick" else pl.top_bytes
        if not data and view_var.get() == "pick" and pl.top_bytes:
            data = pl.top_bytes     # 无遮罩图时退化为渲染预览
        if not data:
            img_canvas.create_text(200, 200, text="无俯视图\n(可直接在右侧列表勾选)",
                                   fill="#888", justify="center", font=("", 11))
            return
        try:
            ph = tk.PhotoImage(data=data)
        except Exception as e:
            img_canvas.create_text(200, 200, text=f"图片加载失败\n{e}",
                                   fill="#888", justify="center")
            return
        photos.append(ph)
        current_photo[0] = ph
        img_canvas.create_image(0, 0, anchor="nw", image=ph)
        img_canvas.configure(scrollregion=(0, 0, ph.width(), ph.height()))
        # 已勾选的零件补画标记
        for iid, var in obj_vars.items():
            if var.get():
                mark_at(iid)

    def mark_at(iid):
        """在点击位置画选中/取消标记圈"""
        old = marks.pop(iid, None)
        if old:
            img_canvas.delete(old)
        var = obj_vars.get(iid)
        if var is None or not var.get():
            return
        x, y = last_click.get(iid, (img_canvas.winfo_width() / 2, img_canvas.winfo_height() / 2))
        r = 18
        oval = img_canvas.create_oval(x - r, y - r, x + r, y + r,
                                      outline="#00e676", width=3)
        marks[iid] = oval

    def on_img_click(event):
        ph = current_photo[0]
        if ph is None or not obj_vars:
            return
        px = int(img_canvas.canvasx(event.x))
        py = int(img_canvas.canvasy(event.y))
        if not (0 <= px < ph.width() and 0 <= py < ph.height()):
            return
        try:
            rgb = ph.get(px, py)               # ('197', '0', '0')
            iid = decode_pick_id(tuple(int(v) for v in rgb))
        except Exception:
            return
        var = obj_vars.get(iid)
        if var is None:
            return                              # 黑背景/未知区域
        # 已跳过的零件不允许改(与列表禁用一致)
        pl = plates[plate_cb.current()]
        if any(o.identify_id == iid and o.skipped for o in pl.objects):
            return
        var.set(not var.get())
        last_click[iid] = (px, py)
        mark_at(iid)

    last_click = {}
    img_canvas.bind("<Button-1>", on_img_click)

    def pick_file():
        path = filedialog.askopenfilename(
            title="选择切片后的 3mf",
            filetypes=[("Bambu 3mf", "*.3mf"), ("全部", "*.*")])
        if not path:
            return
        try:
            set_plates(load_objects_from_file(path))
            logln(f"已加载 {path}")
        except Exception as e:
            messagebox.showerror("解析失败", str(e))

    def do_fetch_cloud():
        prt = pc.devices.get(pc.sn) or (next(iter(pc.devices.values()), None) if pc.devices else None)
        if not prt or not prt.get("task_id"):
            messagebox.showinfo("提示", "尚未从 report 获得任务 ID(需云端任务,本地 SD 打印请用 3mf)")
            return
        if not creds:
            messagebox.showinfo("提示", "云端对象列表需要 Bambu Studio 凭证(未检测到)")
            return
        try:
            pls, full = fetch_task_objects(str(prt["task_id"]), creds)
            if not pls:
                messagebox.showinfo("提示", "任务数据中没有对象列表(可能非云端切片任务)")
                return
            cur = 0
            try:
                cur = int((json.loads(prt.get("content") or "{}").get("info") or {}).get("plate_idx", 0))
            except Exception:
                pass
            set_plates(pls, default_idx=cur)
            logln(f"已获取任务 {prt['task_id']}《{full.get('name','')}》对象列表")
        except Exception as e:
            messagebox.showerror("获取失败", str(e))

    btn_fetch.configure(command=do_fetch_cloud)

    def set_all(v):
        pl = plates[plate_cb.current()] if plates else None
        for iid, var in obj_vars.items():
            if pl and any(o.identify_id == iid and o.skipped for o in pl.objects):
                continue
            var.set(v)
        for it in marks.values():
            img_canvas.delete(it)
        marks.clear()

    def do_send(ids):
        try:
            pc.skip_objects(ids, legacy=legacy_var.get())
        except Exception as e:
            messagebox.showerror("发送失败", str(e))

    def on_send_sel():
        ids = [i for i, v in obj_vars.items() if v.get()]
        if not ids:
            messagebox.showinfo("提示", "请先勾选要跳过的零件")
            return
        do_send(ids)

    def on_send_manual():
        try:
            ids = [int(x) for x in re.split(r"[,\s]+", manual_var.get().strip()) if x]
        except ValueError:
            messagebox.showerror("格式错误", "ID 必须是数字,逗号分隔")
            return
        do_send(ids)

    btn_send.configure(command=on_send_sel)
    btn_send2.configure(command=on_send_manual)

    def on_event(kind, data=None):
        root.after(0, lambda: handle(kind, data))

    def handle(kind, data):
        if kind == "connected":
            logln(f"已连接 {pc.host}:8883({pc.mode} 模式)目标打印机:{pc.sn or '待发现'}")
            btn_conn.configure(text="断开")   # 「从云端任务获取」仍禁用,等首个 report
            conn_time[0] = time.time()
        elif kind == "disconnected":
            logln("连接已断开: " + str(data))
            btn_conn.configure(text="连接")
            btn_fetch.state(["disabled"])
        elif kind == "error":
            logln("[错误] " + str(data))
            messagebox.showerror("连接错误", str(data))
        elif kind == "log":
            for ln in data:
                logln(ln)
        elif kind == "sent":
            logln(f">>> {data[0]}\n    {data[1]}")
        elif kind == "conn_done":
            try:
                btn_conn.state(["!disabled"])
            except Exception:
                pass
        elif kind == "report":
            sn, prt = data
            if not pc.sn:
                pc.sn = sn
            now = time.time()
            if now - last_report_log[0] >= 10:   # 限频:每 10 秒最多一行
                last_report_log[0] = now
                logln(f"收到打印机 report(状态 {STATE_CN.get(prt.get('gcode_state', '?'), '?')},"
                      f"字段 {len(prt)} 项)")
            if prt.get("task_id") and not st_reported[0]:
                st_reported[0] = True
                save_last_sn(sn)
                logln(f"已解析打印状态:{prt.get('subtask_name') or '-'}"
                      f"(任务 {prt['task_id']},第 {prt.get('layer_num','-')}/"
                      f"{prt.get('total_layer_num','-')} 层)→ 可从云端任务获取零件")
            state = prt.get("gcode_state", "?")
            st_labels["状态"].configure(text=STATE_CN.get(state, state))
            st_labels["任务"].configure(text=str(prt.get("subtask_name") or "-")[:28])
            st_labels["层号"].configure(text=f"{prt.get('layer_num','-')}/{prt.get('total_layer_num','-')}")
            try:
                pct = int(prt.get("print_percent", -1))
                st_labels["进度"].configure(text=f"{pct}%" if 0 <= pct <= 100 else "-")
            except (TypeError, ValueError):
                st_labels["进度"].configure(text="-")
            st_labels["已跳过"].configure(text=str(prt.get("skip_objects") or "-"))
            st_labels["任务ID"].configure(text=str(prt.get("task_id") or "-"))
            # 只有拿到任务 ID(打印状态解析完成)才允许「从云端任务获取」
            if prt.get("task_id") and creds:
                btn_fetch.state(["!disabled"])
            else:
                btn_fetch.state(["disabled"])
            if state in ("RUNNING", "PAUSE"):
                btn_send.state(["!disabled"])
                btn_send2.state(["!disabled"])

    def toggle():
        if pc.connected or pc.client:
            pc.disconnect()
            btn_conn.configure(text="连接")
            return
        if creds and mode_var.get() == "cloud":
            sn = sn_var.get()
            if not sn:
                messagebox.showwarning("缺少信息", "请选择打印机序列号")
                return
            pc.setup_cloud(creds, sn)
        else:
            host, code = ip_var.get().strip(), code_var.get().strip()
            if not host or not code:
                messagebox.showwarning("缺少信息", "请填写打印机 IP 和 8 位访问码")
                return
            pc.setup_lan(host, code)
        pc.on_event = on_event          # 关键:挂接事件回调(连接/状态/错误→界面)
        btn_conn.state(["disabled"])
        logln(f"正在连接 {pc.host}:8883 …")

        done = threading.Event()

        def work():
            # paho connect() 会阻塞等待 CONNACK;限制 socket 超时以防代理场景无限挂起
            old_t = socket.getdefaulttimeout()
            socket.setdefaulttimeout(15)
            try:
                notes = pc.connect_with_diagnosis()
                if done.is_set():      # 看门狗已超时放弃 → 丢弃这次迟到连接
                    try:
                        pc.disconnect()
                    except Exception:
                        pass
                    return
                pc.on_event("log", notes)
            except Exception as e:
                if not done.is_set():
                    done.set()
                    pc.on_event("error", "连接失败: " + str(e))
                    pc.on_event("conn_done", None)
                return
            finally:
                socket.setdefaulttimeout(old_t)

        def watchdog():
            for _ in range(30):          # 15 秒
                if pc.connected:
                    done.set()
                    pc.on_event("conn_done", None)
                    return
                time.sleep(0.5)
            if not pc.connected and not done.is_set():
                done.set()
                pc.disconnect()      # 强拆(非阻塞),让可能仍阻塞的 work 线程退出
                pc.on_event("error",
                            "TCP 已通但 15 秒内未完成 MQTT 握手(CONNACK 无响应)。\n\n"
                            "最常见原因:代理软件(Clash/Mihomo 等)把 mqtt.bambulab.com "
                            "转发到了境外节点。\n"
                            "解决:① 把 *.bambulab.com 加入代理直连(DIRECT)规则;或 ② "
                            "临时关闭代理;或 ③ 改用局域网模式(打印机 IP + 访问码,不经过代理)。")
                pc.on_event("conn_done", None)

        threading.Thread(target=work, daemon=True).start()
        threading.Thread(target=watchdog, daemon=True).start()

    btn_conn.configure(command=toggle)

    def on_close():
        pc.disconnect()          # 非阻塞;后台线程自行清理
        root.destroy()

    root.protocol("WM_DELETE_WINDOW", on_close)

    pushed_once = [False]
    st_reported = [False]
    last_report_log = [0.0]
    conn_time = [0.0]
    no_report_hint = [False]

    def poll():
        if pc.connected and (pc.sn or pc.devices):
            try:
                pc.request_push()
                if not pushed_once[0]:
                    pushed_once[0] = True
                    logln("已请求打印机上报完整状态(pushall)…")
            except Exception:
                pass
        if (pc.connected and conn_time[0] and not no_report_hint[0]
                and not st_reported[0] and time.time() - conn_time[0] > 30):
            no_report_hint[0] = True
            logln(f"提示: 连接已建立 30 秒仍未收到 {pc.sn} 的 report。"
                  "若在打印中,请确认顶部序列号选的是正在打印的那台(切换后重新连接);"
                  "云端模式下也要留意代理拦截。")
        root.after(5000, poll)

    logln(f"跳过对象工具 v{VERSION}(协议逆向自 Bambu Handy)")
    if creds:
        logln(f"凭证: 已从 Bambu Studio 读取(账号 {creds.account or creds.user_id},"
              f"区域 {creds.region.upper()},打印机 {len(creds.printers)} 台)")
    else:
        logln("凭证: 未检测到 Bambu Studio → 请使用局域网模式(IP + 8 位访问码)")
    logln("步骤:连接 →(打印中)从云端任务获取零件列表 → 勾选 → 跳过选中零件。")
    logln("云端任务/3mf 均无对象时,可在 Handy 或切片文件中查看零件 ID 后手动输入。")
    root.after(2500, poll)
    root.mainloop()


# ================================================================ 入口

def main():
    ap = argparse.ArgumentParser(description="拓竹打印机打印中跳过指定零件(PC 端)")
    ap.add_argument("--cli", action="store_true", help="命令行模式(默认 GUI)")
    ap.add_argument("--lan", action="store_true", help="局域网模式(默认云端)")
    ap.add_argument("--ip", help="打印机 IP(局域网)")
    ap.add_argument("--code", help="设备访问码 8 位(局域网)")
    ap.add_argument("--sn", help="打印机序列号(云端多台时必填)")
    ap.add_argument("--ids", help="要跳过的对象 ID,逗号分隔")
    ap.add_argument("--legacy", action="store_true", help="旧协议(Studio 格式)")
    args = ap.parse_args()

    if args.cli:
        run_cli(args)
    else:
        run_gui()


if __name__ == "__main__":
    main()
