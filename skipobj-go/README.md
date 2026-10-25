# skipobj-go — 拓竹跳过对象工具(Go 版)

Python 版 `bambu_skip_objects.py` 的 Go 重写:**编译为独立 exe,零运行时依赖**
(不需要 Python / pip / 任何 DLL,唯一第三方库 `paho.mqtt.golang` 已静态编译进二进制)。

## 构建

```
build.bat          (或手动:)
go build -trimpath -ldflags "-s -w -H windowsgui" -o BambuSkipObjects.exe .
go build -trimpath -ldflags "-s -w" -o bbl-skip-cli.exe .
```

产物:

| 文件 | 用途 |
|---|---|
| `BambuSkipObjects.exe` | 双击运行:**原生窗口界面**(Win32,自动读取凭证);`--web` 可切本机 Web 界面 |
| `bbl-skip-cli.exe` | 控制台 CLI:`bbl-skip-cli.exe --cli --sn <SN> --ids 197,175` |

## 结构

| 文件 | 内容 |
|---|---|
| `main.go` | 入口 / CLI(云端自动凭证、等 report、列对象、发命令) |
| `creds.go` | Bambu Studio 凭证读取:明文 conf + **AES-128-ECB**(手写 ECB,标准库无此模式)解密 token;区域判断;上次打印机记忆 |
| `printer.go` | MQTT 客户端:云端/局域网双通道、report 分段字段合并、skip_objects 新旧协议、pushall、非阻塞强拆断开 |
| `task.go` | 云端任务接口(`{api}/v1/iot-service/api/user/task/{id}`)+ 3mf `slice_info.config` 解析 + pick/top 图下载 |
| `ui_windows.go` | **原生窗口界面**(lxn/walk,无 CGO):状态面板、零件列表、俯视图自绘控件点选(遮罩像素反解 + 中心孔搜索)、圈选标记与列表联动 |
| `webui.go` + `web/index.html` | 备用本机 Web 界面(`--web` 启用):同款功能的 HTML 实现 |

## 与 Python 版的对应

功能 1:1 对齐(连接门控、点图选零件、Fake-IP 诊断、非阻塞断开、打印机记忆),
另有两处增强:CLI 输出固定 UTF-8(Windows 控制台不再乱码)、界面不依赖 tkinter。

## 协议与逆向依据

见 [../docs/reverse-notes.md](../docs/reverse-notes.md)。
