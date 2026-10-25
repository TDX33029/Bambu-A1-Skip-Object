# Bambu-A1-Skip-Object(打印中跳过指定零件 · PC 端)

从拓竹 Bambu Handy 安卓版(`APK/app_zh_release.apk`)逆向「打印中跳过对象」的完整协议,
重新实现为电脑端工具。**云端与局域网双通道,云端模式零配置**(自动读取本机已登录的
Bambu Studio 凭证),已在真实 A1 + 正在进行的打印任务上全链路验证。

## 交付物

| 文件 | 说明 |
|---|---|
| `skipobj-go/` | **Go 重写版(推荐)**:`build.bat` 构建双 exe,零运行时依赖 |
| `bambu_skip_objects.py` | Python 原型(功能相同,依赖 `paho-mqtt`、`pycryptodome`) |
| `docs/reverse-notes.md` | 完整逆向记录(含实测证据) |
| `research/decompiled/` | 逆向证据:关键类反编译源码摘录(含角色索引) |
| `APK/app_zh_release.apk` | 分析对象(179MB,不入库,见 `.gitignore`;Virbox 加壳的 RN 应用,协议在 Java 层完整还原) |

## 使用

```bash
pip install paho-mqtt pycryptodome
python bambu_skip_objects.py
```

1. **连接**:自动读取 `%APPDATA%\BambuStudio` 的账号 token 和打印机列表 → 云端 MQTT。
   (无需打印机处于任何特殊模式;也可切换局域网模式:打印机 IP + 屏幕上的 8 位访问码)
2. **状态**:实时显示打印状态、层号、进度、当前任务(含 task_id)
3. **零件列表**:点「从云端任务获取」自动列出当前打印任务的零件(identify_id + 文件名);
   本地 SD 打印可打开切片后的 3mf,或手动输入 ID
4. **跳过**:勾选零件 → 「跳过选中零件」(打印中生效,不可撤销)

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
- **跳过命令**(Handy 新协议,无需签名;云端额外带 `user_id`):

```json
{"print": {"sequence_id": "2001+", "command": "skip_objects",
           "timestamp": <ms>, "obj_list": [<identify_id>...]}}
```

- **旧协议备选**:`{"print": {"sequence_id": "…", "skip_objects": "1,2"}}`
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
