# Bambu Handy「跳过打印对象」逆向分析记录

分析对象:`APK/app_zh_release.apk`(179 MB,拓竹 Handy 中国版,React Native 应用)
分析日期:2026-10-25
方法:APK 解包 → dex 字符串表检索 → jadx 1.5.2 反编译(Java 层)→ 类间调用链追踪

---

## 0. 总体架构与加密情况

| 层 | 内容 | 加密 |
|---|---|---|
| `lib/arm64-v8a/*.so` | React Native 0.7x(libreactnative/libhermesvm)、Go 运行时(libgojni, gomobile)、HiveMQ MQTT | — |
| `assets/index.android.bundle` | RN 主 bundle(Hermes 字节码,**业务 UI 与大部分逻辑**) | **加密**(24 字节固定头 `ee8f36ba…`,三个子 bundle 相同) |
| `assets/jsbundle/*/main.jsbundle` | HMS/客服/儿童模式子 bundle | **加密**(同头) |
| `assets/files/*.zip` | 错误动作/设备 HMS 配置 | **加密**(同壳,`c8a5479e…` 固定 14 字节前缀 → 流密码/XOR 特征) |
| `classes*.dex`(8 个,60 MB) | Java 层:设备模型、命令网关、MQTT 栈、RN 桥 | **未加密**(jadx 正常反编译) |
| `assets/l1eb3a150_a64.so` | **Virbox Protector**(深思数盾)加固壳,AAssetManager 读取加密资源,无导出符号,init_array 自启 | — |

加密资源具有「相同明文前缀 → 相同密文前缀」特征(流密码),解密逻辑在 Virbox 壳内,
静态脱壳成本高。**放弃解密 JS,改走 Java 层** —— 设备命令协议在 Java 层完整可见。

## 1. 跳过命令的定义与序列化

### 1.1 命令对象

`defpackage/ab2.java`(`ob2` 基类 = BblCommand):

```java
public final class ab2 extends ob2 {
    public final List a;
    // toString: "SkipObjects(objectList=...)"
}
```

- 构造点 1:`defpackage/pam.java` → `pam.d(String deviceId, List ids)` = **PrintControl.skipObjects**,
  `pam` 即 `rlm.java` 中标注的 `PrintSummaryTaskCardDeps.printControl`
- 构造点 2:`defpackage/a20.java`(case 25,合并 lambda)

### 1.2 命令 → MQTT JSON

`defpackage/ubv.java`(L500):

```java
if ((r25 instanceof ab2) == false) goto L214;
    r12 = new xhb("print",                    // ModelPreviewEntry.PRINT
                  "skip_objects",
                  {"obj_list": ((ab2) r25).a}, // izr.f("obj_list", ...)
                  null, 24);
```

`xhb` = `EncodedCommand(key, command, extraData, sign, encryptKeys)`(toString 确认),
**skip 命令 sign=false、encryptKeys=null,无需签名/加密**。

`defpackage/bhp.java`(commandTracker,`a()` 方法)统一组包:

```java
JSONObject cmd = new JSONObject();
cmd.put("sequence_id", seq);                    // AtomicInteger(2001) 递增
cmd.put(b.y, command);                          // b.y = "command"
cmd.put("timestamp", System.currentTimeMillis());
cmd.putAll(extraData);                          // obj_list: [...]
JSONObject root = new JSONObject();
root.put("user_id", userId);                    // 为 null 时不放(LAN 模式)
root.put("print", cmd);                         // key = "print"
```

- `b.y = "command"`(`com/heytap/mcssdk/constant/b.java`,R8 常量池碰撞)
- sequence_id 起始值:`bhp` 字段 `this.d = new AtomicInteger(2001)`;
  校验侧 `defpackage/s0a.java`:"sequence_id must bigger than 2001"
- 发布 topic / 订阅 topic:`com/bbl/device/BblPrinterChannel.java`:
  `unsubscribe("device/" + sn + "/report")` → 对称推出 `device/<SN>/request`

### 1.3 最终 payload

```json
{"print": {"sequence_id": "2002", "command": "skip_objects",
           "timestamp": 1729834567890, "obj_list": [1, 3]}}
```

旧协议兼容格式(Bambu Studio / 社区通用):
`{"print": {"sequence_id": "…", "skip_objects": "1,3"}}`

## 2. 对象 ID 的来源与语义

### 2.1 云端数据模型(Handy 实际路径)

`com/bambulab/bambulab/model/IotPlate.java`(kotlinx.serialization,@Serializable):

- 键名(`IotPlate$$serializer`):`objects`、`skipped_objects`、`index`、`name`、
  `pick_picture`、`top_picture`、`weight`、`prediction` …
- `IotPlateObjectId`:键名 `identify_id`、`object_id`、`name`、`skipped`

API(`com/bambulab/bambulab/common/device/data/api/DeviceTaskDetailApi.java`):

```
GET iot-service/api/user/task/{task_id}  → IotTaskData(含 plates)
```

### 2.2 identify_id 即打印机认识的 ID

`defpackage/rk9.java` → `n(wl9, IotPlate)`(构建跳过页面路由 `HomeAppRoute.DesignSkipObjects`):

- 对象数 **2 ≤ n < 65** 才启用(L35:`if (2 > r2) goto L93; if (r2 >= 65) goto L93;`)
- `disabledIds` 优先取 **打印机 report 的 `skip_objects`**(逗号分隔字符串,L38-49),
  其次取云端 `skippedObjects[].identifyId`
- `selectedIds` = `objects[].identifyId` 排除已跳过

`defpackage/scv.java`:`a(IotPlate, Set, Set)` 将可选对象(identifyId)转为字符串列表;
`b(IotPlate, Set)` 将打印机 skip_objects 字符串与 identifyId 直接比对 —— **数值同源**。

打印机续打命令也带该字段(`defpackage/x0k.java` L678):
`r510.put("skip_objects", r115)`(start_print 请求的可选参数)。

### 2.3 UI 提交链

`HomeAppRoute.DesignSkipObjects`(plateIndex, pickPictureUrl, topPictureUrl,
objects: List<IotPlateObjectId>, disabledIds: List<Long>, selectedIds: List<Long>, …)
→ `defpackage/jr9.java`(Compose UI,selectedIds List<Long> → Set)
→ `defpackage/to9.java`(case 2)→ `defpackage/a03.java`
= `BblRawSkipObjectsPickerParams(mode, objects, initialSelectedIds, imageSource,
deviceModelName, onConfirm)` → RN 对象拾取页 → onConfirm → `pam.d` → `ab2` → MQTT。

## 3. 连接参数(局域网)

`com/bbl/device/BblBrokerConfig.java`:

```java
PORT = 1883; PORT_SSL = 8883; REMOTE_HOST = "us.mqtt.bambulab.com";

public final BrokerConfig local(String host, String password, boolean ssl, int port) {
    return new BrokerConfig(host, port,
        UUID.randomUUID(),            // clientId
        "bblp",                       // username
        password,                     // = 设备访问码
        ssl, ..., MqttVersion.V3_1_1, ...);
}
```

- 端口 8883 + TLS(自签证书,不校验;HiveMQ 客户端)
- 云/局域网判别:`inferConnectionMode`:用户名以 `u_` 开头 = 云端
- RN 侧 bundle 加载(`defpackage/gpn.java`):标准 `JSBundleLoader.createAssetLoader`,
  Java 层无解密 —— 解密在 Virbox 壳 / native 侧

## 4. 打印机能力与机型

- `com/bambulab/printer/model/generated/BblpCapabilities.java`:
  `@SerialName("skip_objects_command")` → 能力位由打印机上报
- `BblpResolvedState.java`:`@SerialName("supports_skip_objects")`
- `com/bbl/device/model/BblProductWorkflowProfile.java`:`skipObjectsOnPrinterScreen`
  (机型级配置,云端下发)
- `BblOfficialProductAnchors.java`:A1(`DeviceImageModelKey.A1`)、A1_MINI 在列
- report 状态字段含 `is_paused` / `remain_minutes` / `layer_num` / `total_layer_num`
  等(与社区已知的 Bambu MQTT report 字段一致;report 解析本体在加密 JS 层)

## 5. PC 工具实现要点(bambu_skip_objects.py)

| 逆向结论 | 工具实现 |
|---|---|
| TLS 8883 / bblp / 访问码 / MQTT 3.1.1 | paho-mqtt + `CERT_NONE`,clientId 随机 UUID |
| 订阅 `device/+/report` | 免输入 SN,自动发现并显示 |
| `{"print":{command:skip_objects,obj_list:[…]}}` | `PrinterClient.skip_objects(ids)` |
| 云端命令额外带 `user_id`(bhp.kt:userId 非空时 put) | 云端模式自动附加 |
| 旧协议字符串格式 | `--legacy` / GUI 复选框 |
| sequence_id 从 2001 递增 | `AtomicInteger` 等价实现 |
| pushall 触发完整 report | `request_push()` |
| 对象列表取自 slice_info | 本地解析 3mf `Metadata/slice_info.config`(与云端 IotPlate 同源) |
| 2~64 对象约束 / 已跳过禁选 | GUI 中体现(report 的 skip_objects 交叉标记) |

## 5b. 云端链路(实测打通,2026-10-25)

云模式(非 LAN-only)打印机同时接受局域网直连,也接受云端 MQTT —— 即 Handy 的
标准路径(逆向 `BblBrokerConfig.remote`:**username = "u_" + 用户ID**,password = 账号 token;
`inferConnectionMode` 以 `u_` 前缀判别云端):

- host:`cn.mqtt.bambulab.com:8883`(中国区)/ `us.mqtt.bambulab.com:8883`(国际区),TLS 自签
- topic 与局域网完全相同:`device/<SN>/report` + `device/<SN>/request`
- 订阅后需主动 `{"pushing":{"sequence_id":"…","command":"pushall"}}` 触发完整 report

实测 report(print 对象)字段:`gcode_state`、`task_id`、`project_id`、`profile_id`、
`subtask_id`、`subtask_name`、`gcode_file`、`layer_num`、`total_layer_num`、`skip_objects`。

云端任务对象列表(Handy 同源,`DeviceTaskDetailApi`):

```
GET https://api.bambulab.cn/v1/iot-service/api/user/task/{task_id}    # 中国区
GET https://api.bambulab.com/v1/iot-service/api/user/task/{task_id}   # 国际区
Authorization: Bearer <token> ; 需要移动端 User-Agent(否则 403)
```

响应 `context.plates[]` 即 IotPlate:`objects:[{identify_id, object_id, name, skipped}]`、
`pick_picture.url`(俯视图)、`skipped_objects`。**注意 URL 必须带 `/v1/` 前缀**(无 v1 → 404)。

凭证获取(用户已登录的本机 Bambu Studio,无需再次登录):

- `%APPDATA%\BambuStudio\BambuStudio.conf`:明文 JSON(尾部有 MD5 校验行,需 raw_decode),
  含 `access_code: {SN: 访问码}` 映射与 `user_last_selected_machine`
- `%APPDATA%\BambuStudio\BambuNetworkEngine.conf`:AES-128-ECB,固定密钥
  `i4crL3LESLnWapLS`(社区公开已知),解出 `user.token / user.user_id / user.account`;
  区域由 avatar 域名(`bblmw.cn` → cn)判断

实测结果:report 得 task_id=123456789《示例任务》→ API 返回 2 个对象
(identify_id 197 / 175)→ 符合 2~64 对象约束。

## 5c. 实测记录(真实 A1,打印中)

| 实验 | 结果 |
|---|---|
| 云端 MQTT 连接(cn.mqtt.bambulab.com:8883,u_\<uid\>/token) | CONNECTED |
| `device/<SN>/report` 订阅 + pushall | 收到完整 report:RUNNING、task_id=123456789、层 69/222、任务《示例任务》 |
| 云端 API `…/v1/iot-service/api/user/task/123456789` | 200,`context.plates[0].objects = [{identify_id:'197', name:'零件A.STL'}, {identify_id:'175', name:'零件B.STL'}]` |
| 发送旧协议 `{"print":{"skip_objects":"999999"}}`(故意不存在的 ID,安全验证) | **打印机接受并在 report 回显 `skip_objects:999999`**,随后自行清理恢复;打印继续正常 —— 命令通道确认有效 |
| 云端 report 形态 | 分段推送(不同报文携带不同字段),客户端需按字段合并 |

注意:
- 云端 API 无 `/v1` 前缀 → 404;无移动端 UA → 403(网关拦截)
- 通配订阅 `device/+/report` 在云端 broker 上收不到任何报文,必须**精确订阅** `device/<SN>/report`
- identify_id 在 JSON 中为字符串,发送时转整数

## 5d. 跳过界面的「点图选零件」机制(逆向 + 实测验证)

Handy 跳过界面能直观显示打印板俯视图并点击选中零件,实现方式是**颜色编码遮罩图**:

- `IotPlate.pick_picture`(切片 3mf 的 `Metadata/pick_<盘号>.png` 同源上传)是一张
  黑底遮罩:每个零件填充一种唯一纯色,颜色由 identify_id 字节重排而来
  (`defpackage/b1v.java` `i(int)`):

  ```
  R = id & 0xFF ; G = (id >> 8) & 0xFF ; B = (id >> 16) & 0xFF ; A = 0xFF
  反解: id = R + G*256 + B*65536(黑色/未命中 = 0)
  ```

- 运行时数据类 `djm(name, identify_id, color, skipped)` 第三字段即该颜色
  (`olm.java`: `new djm(getName(), id, b1v.i(id), false)`;olm 的
  "toMachineSkipSource" 说明打印机本地存储路径也用同一套 pick 图)
- 点击图片 → 取像素颜色 → 反解 identify_id → 选中。无需任何坐标数据

**实测**(任务 123456789):pick 图 512×512,仅两种非黑颜色,
RGBA(197,0,0,255)→id 197、RGBA(175,0,0,255)→id 175,与 API 对象列表完全一致。

PC 工具已实现同等交互:俯视图 Canvas 展示(pick 遮罩可点击 / 渲染图预览切换),
点击取像素(`tk.PhotoImage.get`)反解 ID → 列表勾选联动 + 圈选标记;
云端任务自动下载 pick/top 图,本地 3mf 直接读 `Metadata/pick_N.png`。

## 5e. 跳过命令格式的关键实测结论(2026-10)

对 A1(当前固件)在云端 MQTT 上实测,同一零件 175 三种格式:

| 格式 | payload | 打印机反应 |
|---|---|---|
| Handy 新协议(int) | `{"print":{"command":"skip_objects","obj_list":[175]}}` | **无响应**(report 的 skip_objects 不变) |
| Handy 新协议(string) | `obj_list:["175"]` | **无响应** |
| **Studio 旧协议** | `{"print":{"skip_objects":"175"}}` | **✓ 立即接受**,skip_objects=175 持续回报 |

结论:**A1 固件只认旧协议**;新协议 `command:skip_objects` 在 LAN/云端 MQTT 直连上均无效
(该协议可能由云端服务转译,或仅特定固件支持)。工具的 SkipObjects 已实现**自动降级**:
先发新协议,5 秒内打印机未回报包含目标的 skip_objects 即自动补发旧协议,三端(GUI/CLI/Web)共享。
另:打印机对无效 ID 会短暂回显后清理;有效跳过的回报也会随后续打印上下文变化而清除,
发送瞬间的回显即代表接受。

## 6. 已知环境问题:代理软件(Fake-IP)会卡死 MQTT 连接

**现象**:GUI 卡在「正在连接 cn.mqtt.bambulab.com:8883 …」。

**根因**:Clash/Mihomo 类代理的 Fake-IP DNS 模式会把 `cn.mqtt.bambulab.com`
解析为 `198.18.x.x`(RFC 2544 保留段)。TCP/TLS 能建立(代理接管),
但 MQTT 的 CONNECT→CONNACK 长连接按代理分流规则处理,被转发境外节点时握手无响应,
paho 的 `connect()` 在 UI 线程里阻塞 → 界面卡死。实测同机状态下时通时不通
(取决于代理当时的分流规则),完全解释"开发时测试成功、用户运行卡住"。

**修复(工具已内置)**:
1. 连接移入后台线程,UI 不再冻结;15 秒 CONNACK 看门狗,超时给出针对性提示
2. 连接前 DNS 诊断,检测到 Fake-IP(198.18.0.0/15)立即在日志中警告
3. TCP 可达性预检(TCP 失败会给出明确阶段报错)

**用户侧解决(治本,任选其一)**:
- 代理软件中把 `*.bambulab.com`、`*.bambulab.cn` 加入**直连(DIRECT)规则**(推荐)
- 发送期间临时关闭代理
- 改用**局域网模式**(打印机 IP + 访问码,内网直连不经过代理)

## 6b. 「断开/关闭程序卡死」的根因与修复

**根因**:初版在 **UI 线程**里同步调用 paho 的 `disconnect()` + `loop_stop()`。
paho 内部要等待网络线程退出(`join`),而半死连接(代理挂起的 TLS socket)的
`recv` 永不返回 → UI 线程被 join 挂住 → 点「断开」或关窗口都直接卡死。

**修复(已实测:断开→重连往返、关窗均零冻结)**:
1. `PrinterClient.disconnect()` 改为**立即返回**:后台 daemon 线程里依次
   `disconnect()` → `socket.shutdown(SHUT_RDWR)+close()`(强制让 recv 返回)
   → `loop_stop(force=True)`(不等待线程自然退出)
2. 「断开」按钮立即回弹为「连接」,不等网络层确认
3. 关窗流程 `on_close`:先非阻塞 `disconnect()` 再 `destroy()`,清理线程随进程退出
4. 握手超时看门狗同样走强拆路径

## 7. 工程实践备注

- 云端 broker **拒绝通配订阅** `device/+/report`,必须精确订阅 `device/<SN>/report`
  (GUI 多台打印机默认选中项可能不对:连接后 30 秒无 report 会提示切换;成功连接的
  SN 会记忆,下次默认选中)
- report 为**分段推送**,客户端按字段合并
- GUI 所有 MQTT 回调经 `root.after` 转 UI 线程;后台线程从不直接触碰 Tk 控件

## 6. 局限与后续

1. **JS 层未解密**:UI 细节(如对象拾取页交互)不可见,但不影响协议正确性。
   如需解密,路线是分析 Virbox 壳(unicorn/unidbg 模拟或运行时 dump)。
2. 云端任务路径(`iot-service/api/user/task/{id}`)需要账号登录,工具未实现;
   使用本地切片 3mf 中的 identify_id 等效替代。
3. `identify_id` 与 `object_id` 在切片 3mf 中通常相等;若某任务出现两者不一致,
   以 `identify_id` 为准(逆向证据 §2.2)。
