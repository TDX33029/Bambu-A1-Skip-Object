# Bambu-A1-Skip-Object(打印中跳过指定零件 · PC 端)

从拓竹 Bambu Handy 安卓版(`APK/app_zh_release.apk`)逆向「打印中跳过对象」的完整协议,
重新实现为电脑端工具。**云端与局域网双通道,云端模式零配置**(自动读取本机已登录的
Bambu Studio 凭证)。已在真实 A1 上验证证书申请、安装与签名命令通过固件校验;
打印中跳过的端到端实测待打印机维修后复测。

## 交付物

| 文件 | 说明 |
|---|---|
| `skipobj-go/` | **Go 重写版(推荐)**:`build.bat` 构建双 exe,零运行时依赖;原生窗口界面 |
| `bambu_skip_objects.py` | Python 原型(功能相同,依赖 `paho-mqtt`、`pycryptodome`) |
| `docs/reverse-notes.md` | 完整逆向记录(含实测证据) |
| `research/decompiled/` | 逆向证据:关键类反编译源码摘录(含角色索引) |
| `APK/app_zh_release.apk` | 分析对象(179MB,不入库,见 `.gitignore`;Virbox 加壳的 RN 应用,协议在 Java 层完整还原) |

## 使用

**Go 版(推荐)**:运行 `skipobj-go/BambuSkipObjects.exe`(双击,原生窗口界面),
或 `cd skipobj-go && build.bat` 自行构建(同时生成 `bbl-skip-cli.exe` 控制台版)。
需要浏览器界面时用 `BambuSkipObjects.exe --web`。
CLI:`bbl-skip-cli.exe --cli --sn <SN> --ids 197,175`。

Python 版:

```bash
pip install paho-mqtt pycryptodome
python bambu_skip_objects.py
```

1. **连接**:自动读取 `%APPDATA%\BambuStudio` 的账号 token 和打印机列表 → 云端 MQTT。
   (无需打印机处于任何特殊模式;也可切换局域网模式:打印机 IP + 屏幕上的 8 位访问码)
2. **状态**:实时显示打印状态、层号、进度、当前任务(含 task_id)
3. **零件列表**:点「从云端任务获取」自动列出当前打印任务的零件(identify_id + 文件名);
   本地 SD 打印可打开切片后的 3mf,或手动输入 ID
4. **跳过**:勾选零件 → 「跳过选中零件」(打印中生效,不可撤销)。
   首次发送会自动向云端申请 App 证书并安装到打印机(约 2 秒),之后所有控制命令
   都以 RSA-SHA256 签名发送;证书失效时会自动重装重试。

CLI:

```bash
# 云端(自动凭证),跳过当前任务中 ID 为 197 和 175 的零件
python bambu_skip_objects.py --cli --sn <打印机SN> --ids 197,175

# 局域网模式
python bambu_skip_objects.py --cli --lan --ip 192.168.1.100 --code 12345678 --ids 1,2
```

## 协议摘要(逆向结论)

- **连接**:`cn/us.mqtt.bambulab.com:8883` 云端(用户名 `u_<user_id>`、密码=账号 token)
  或 `<IP>:8883` 局域网(用户名 `bblp`、密码=访问码);TLS 3.1.1 自签不校验
  (逆向:`BblBrokerConfig.remote()/local()`)
- **固件签名要求**(2026 固件):`print` 分类的控制命令必须带签名,否则回
  `err_code=84033543`(0x05024007)+ HMS `0500050000010007`。工具会自动:
  1) 用账号 token 向云端申请 App 证书(`/v1/iot-service/api/user/applications/{appKey}/cert`);
  2) 通过 `security.app_cert_install` 把证书链 + CRL 装到打印机;
  3) 对 canonical JSON 做 RSA-SHA256 签名,根级附 `header{cert_id,sign_string,payload_len,...}`。
  细节见 `docs/reverse-notes.md` §5e/§5f
- **跳过命令**(签名后发送;云端额外带 `user_id`):

```json
{"print": {"sequence_id": "2001+", "command": "skip_objects",
           "timestamp": <ms>, "obj_list": [<identify_id>...]},
 "user_id": "<uid>",
 "header": {"cert_id": "CN=...:<serial>", "payload_len": <n>,
            "sign_alg": "RSA_SHA256", "sign_string": "<base64>", "sign_ver": "v1.0"}}
```

- 旧协议 `{"print":{"skip_objects":"1,2"}}` 已废弃:此前看到的“接受”只是打印机的
  拒绝回显,固件并未执行
- **对象 ID**:identify_id,与切片 obj_id 同源;来源三选一:
  云端 `{api}/v1/iot-service/api/user/task/{task_id}`(Handy 同源接口)、
  3mf 的 `Metadata/slice_info.config`、report 的 `skip_objects` 回报
- **约束**:打印机上报 `supports_skip_objects`;Handy 仅 2~64 零件启用;
  A1 / A1 mini 均支持

## 安全说明

- 工具读取的 Studio 凭证仅在**本机内存**中使用,不落盘、不上传
- 云端 MQTT 的 `u_<user_id>/token` 即 Handy 同款凭据,权限仅限账号名下打印机
- 跳过已开始的零件会导致该部分缺失;请确认后再发送
- 仅限自己设备上的合法用途

## 常见问题

**卡在「正在连接 cn.mqtt.bambulab.com:8883 …」?**
代理软件(Clash/Mihomo 的 Fake-IP 模式)把 MQTT 长连接转发到了境外节点。
工具会自动检测并在日志中警告(显示 `198.18.x.x`)。解决:把 `*.bambulab.com`
加入代理**直连(DIRECT)规则**,或临时关代理,或切局域网模式(见下)。

**断开/关窗卡死?**
已在 v1.2 修复:断开与关闭改为后台强制拆除(不等待网络线程),UI 永不因此冻结。

**云端不可用时**:GUI 里切「局域网(IP+访问码)」—— 打印机 IP 可在打印机屏幕
(设置→无线)或路由器后台看到,访问码 8 位在同一页面;内网直连不经过代理。
注意:局域网模式下固件同样要求签名,而签名证书来自云端账号,因此当前版本
仅云端模式支持签名;局域网模式留作诊断/旧固件使用。

**报 `84033543 / MQTT 命令校验失败`?**
说明证书未安装或已失效。工具会自动重装并重试一次;仍失败时检查网络能否访问
`api.bambulab.cn`,或在 CLI 用 `--install-cert` 单独安装证书、用 `--cert` 检查取证是否成功。
