# 逆向证据源码摘录

`APK/app_zh_release.apk`(Bambu Handy 中国版,React Native + Virbox 加壳)经
jadx 1.5.2 反编译后,与「打印中跳过对象」功能证据链直接相关的关键类。
**仅为个人学习研究摘录**,版权归拓竹科技所有;反编译产物不可运行、不构成可用程序。

完整分析见 [docs/reverse-notes.md](../docs/reverse-notes.md)。
`defpackage/*` 为 R8 混淆后的类名,角色标注由调用链与字符串证据推定。

## 命令定义与序列化(→ MQTT payload)

| 文件 | 角色 |
|---|---|
| `defpackage/ob2.java` | 命令基类(ob2) |
| `defpackage/ab2.java` | **SkipObjects 命令**(toString: `SkipObjects(objectList=...)`) |
| `defpackage/xhb.java` | EncodedCommand(key/command/extraData/sign/encryptKeys),skip 命令 sign=false |
| `defpackage/bhp.java` | 命令组包:`sequence_id`(AtomicInteger(**2001**) 递增)、`command`、`timestamp`、`user_id`(云端才有);header 排序签名逻辑 |
| `defpackage/ubv.java` | SkipObjects → `("print", "skip_objects", {"obj_list": [...]})`(L500 附近) |
| `defpackage/pam.java` | PrintControl 门面,`d(deviceId, ids)` = skipObjects |
| `defpackage/rlm.java` | PrintSummaryTaskCardDeps(toString 标注 pam=printControl) |
| `defpackage/s0a.java` | "sequence_id must bigger than 2001" 校验 |
| `defpackage/a03.java` | BblRawSkipObjectsPickerParams(mode/objects/initialSelectedIds/imageSource/onConfirm) |

## 对象列表与「点图选零件」

| 文件 | 角色 |
|---|---|
| `defpackage/djm.java` | 零件数据(name, **identify_id, color**, skipped) |
| `defpackage/b1v.java` | `i(int)`:identify_id → 遮罩图颜色(R=低8位,G=中8位,B=高8位) |
| `defpackage/olm.java` | "toMachineSkipSource":打印机本地存储路径的跳过数据源(同样使用 pick 遮罩) |
| `defpackage/rk9.java` | `n(wl9, IotPlate)`:构建 DesignSkipObjects 路由;**2~64 个零件**约束;disabledIds 优先取 report 的 `skip_objects` |
| `defpackage/scv.java` | 可选零件集合;打印机回报与 identify_id 同源比对 |
| `defpackage/x0k.java` | 开始打印命令(续打场景附带 `skip_objects` 参数) |
| `defpackage/i50.java` | `getSkipObjectsCommand()` 能力位检查 |
| `defpackage/cv3.java` | BblpRuntimeState(supportsSkipObjects 等) |
| `defpackage/a20.java` | 多路 lambda 合并类(SkipObjects 构造点之一,case 25) |
| `defpackage/jr9.java` | 跳过页 Compose UI(selectedIds: List\<Long\> → Set 提交链) |
| `defpackage/to9.java` | 提交协程(case 2 → a03) |

## 连接与云端任务

| 文件 | 角色 |
|---|---|
| `com/bbl/device/BblBrokerConfig.java` | `local()`:8883/bblp/访问码;`remote()`:username=`u_<用户ID>`、password=token;`inferConnectionMode` 以 `u_` 前缀判别云端 |
| `com/bbl/device/BblPrinterChannel.java` | `device/<SN>/report` 订阅(对称推出 request topic) |
| `com/bbl/device/command/BblCommandGateway.java` | 命令网关接口 |
| `com/bbl/device/command/internal/BblCommandGatewayImpl.java` | 网关实现(xhb EncodedCommand 消费) |
| `com/bbl/device/model/BblProductWorkflowProfile.java` | 机型工作流配置(skipObjectsOnPrinterScreen) |
| `com/bambulab/bambulab/model/IotPlate.java` | 云端任务盘数据(objects/skipped_objects/pick_picture/top_picture) |
| `com/bambulab/bambulab/model/IotPlateObjectId.java` | 对象(identify_id/object_id/name/skipped;JSON 键见同名 `$$serializer`) |
| `com/bambulab/bambulab/common/device/data/api/DeviceTaskDetailApi.java` | 云端接口:`iot-service/api/user/task/{task_id}` |
| `com/bambulab/bambulab/navigation/route/HomeAppRoute.java` | `DesignSkipObjects`(plateIndex/pickPictureUrl/objects/disabledIds/selectedIds);文件较大,仅作类定义取证 |
| `defpackage/gpn.java` | RN bundle 经 `assets://` 标准 JSBundleLoader 加载 —— Java 层无解密,解密在 Virbox 壳 |

## 序列化模型补充

`IotPlate$$serializer.java` / `IotPlateObjectId$$serializer.java` 含各字段的
实际 JSON 键名(`identify_id`、`object_id`、`skipped_objects` 等),因体积原因
未摘录,可用 jadx 从 APK 直接查看(`classes3.dex`)。
