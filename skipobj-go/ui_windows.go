//go:build windows

package main

// 原生 Win32 窗口界面(lxn/walk,无 CGO)。
// 交互模型与 Web 版一致:连接 → 状态轮询(pushall 触发完整 report)→
// 云端任务/3mf 零件列表 → 俯视图点击选零件(遮罩颜色反解 identify_id)→
// 发送跳过命令(打印机应答为准)。
//
// 布局注意:declarative 里的 Size/MinSize 单位是 DIP(96 DPI),不是像素。
// 窗口创建后按显示器工作区做一次 clamp,避免高 DPI 下窗口比屏幕还大
// (旧版固定 1010x840,在 150% 缩放的 1080p 屏上会超出屏幕下沿)。

import (
	"fmt"
	"image"
	_ "image/png"
	"math"
	"os"
	"sort"
	"strings"
	"sync"
	"time"
	"unsafe"

	"github.com/lxn/walk"
	. "github.com/lxn/walk/declarative"
	"github.com/lxn/win"
)

const spiGetWorkArea = 0x0030

type winUI struct {
	mw *walk.MainWindow
	sv *walk.ScrollView

	snCB    *walk.ComboBox
	ipEd    *walk.LineEdit
	codeEd  *walk.LineEdit
	connBtn *walk.PushButton
	connLb  *walk.Label

	stState, stTask, stLayer, stPct, stSkip, stTid *walk.Label
	stAck                                          *walk.Label

	plateCw     *walk.CustomWidget
	objList     *walk.ListBox
	plateCB     *walk.ComboBox
	manualEd    *walk.LineEdit
	certBtn     *walk.PushButton
	rawCB       *walk.CheckBox
	logView     *walk.TextEdit
	fetchBtn    *walk.PushButton
	sendSelBtn  *walk.PushButton
	sendManBtn  *walk.PushButton
	modeCloudRB *walk.RadioButton
	modeLanRB   *walk.RadioButton
	viewPickRB  *walk.RadioButton
	viewTopRB   *walk.RadioButton

	printer *Printer
	creds   *Creds

	mu         sync.Mutex
	plates     []Plate
	images     map[int]map[string]image.Image // plateIndex -> pick/top
	curPlate   int
	selected   map[int]bool
	reported   map[int]bool // 打印机已上报跳过(s_obj)
	imgKind    string       // pick | top
	syncingSel bool
	gen        int // 图片代次:bmpCache/centers 的失效依据
	bmpCache   map[string]walk.Image
	centers    map[string]map[int]image.Point // "gen:plate:kind" -> id -> 图像坐标
	logLines   []string
	lastState  string
	lastHMS    string
}

func sortedSNs(m map[string]string) []string {
	out := make([]string, 0, len(m))
	for k := range m {
		out = append(out, k)
	}
	sort.Strings(out)
	return out
}

func runUI() {
	ui := &winUI{
		selected: map[int]bool{},
		reported: map[int]bool{},
		images:   map[int]map[string]image.Image{},
		bmpCache: map[string]walk.Image{},
		centers:  map[string]map[int]image.Point{},
		imgKind:  "pick",
	}
	if err := ui.build(); err != nil {
		fmt.Fprintln(os.Stderr, "窗口创建失败:", err)
		RunWebUI("127.0.0.1:8974", true)
		return
	}
	ui.fitToScreen()

	if c, err := LoadCreds(); err != nil {
		ui.setConnInfo("凭证: 未读取到 → 可用局域网模式")
		ui.Log(fmt.Sprintf("凭证读取失败: %v(可切换局域网模式:IP + 访问码)", err))
	} else {
		ui.mu.Lock()
		ui.creds = c
		ui.mu.Unlock()
		sns := sortedSNs(c.Printers)
		ui.snCB.SetModel(sns)
		for i, sn := range sns {
			if sn == c.LastSN {
				ui.snCB.SetCurrentIndex(i)
				break
			}
		}
		ui.setConnInfo(fmt.Sprintf("凭证: 已读取(账号 %s,区域 %s,%d 台)",
			c.Account, strings.ToUpper(c.Region), len(c.Printers)))
		ui.Log(fmt.Sprintf("凭证: 已从 Bambu Studio 读取(账号 %s,区域 %s,打印机 %d 台)",
			c.Account, strings.ToUpper(c.Region), len(c.Printers)))
	}
	ui.Log(fmt.Sprintf("跳过对象工具 v%s(Go,原生窗口)", Version))
	ui.Log("步骤:连接 →(打印中)从云端任务获取零件 → 点图/列表选择 → 跳过选中零件(自动申请并安装签名证书)")

	go ui.statusLoop()

	ui.mw.Run()
}

func (ui *winUI) build() error {
	err := MainWindow{
		AssignTo: &ui.mw,
		Title:    "拓竹跳过对象工具(打印中跳过指定零件)",
		MinSize:  Size{Width: 900, Height: 600}, // DIP
		Size:     Size{Width: 1120, Height: 820},
		Layout:   VBox{MarginsZero: true},
		Children: []Widget{
			ScrollView{
				AssignTo:        &ui.sv,
				HorizontalFixed: true, // 只在纵向滚动,内容宽度跟随窗口
				Layout:          VBox{Margins: Margins{Left: 8, Top: 10, Right: 8, Bottom: 8}, Spacing: 14},
				Children: []Widget{
					GroupBox{Title: "1. 连接", Layout: VBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}, Spacing: 4},
						Children: []Widget{
							Composite{Layout: HBox{MarginsZero: true, Spacing: 6},
								Children: []Widget{
									Label{Text: "打印机:"},
									ComboBox{AssignTo: &ui.snCB, MinSize: Size{Width: 220, Height: 0}},
									RadioButton{AssignTo: &ui.modeCloudRB, Text: "云端"},
									RadioButton{AssignTo: &ui.modeLanRB, Text: "局域网"},
									PushButton{AssignTo: &ui.connBtn, Text: "连接", OnClicked: ui.onConnect},
								}},
							Composite{Layout: HBox{MarginsZero: true, Spacing: 6},
								Children: []Widget{
									Label{Text: "IP:"},
									LineEdit{AssignTo: &ui.ipEd, CueBanner: "192.168.x.x", MinSize: Size{Width: 130, Height: 0}, MaxSize: Size{Width: 160, Height: 0}},
									Label{Text: "访问码:"},
									LineEdit{AssignTo: &ui.codeEd, PasswordMode: true, MinSize: Size{Width: 100, Height: 0}, MaxSize: Size{Width: 120, Height: 0}},
									Label{AssignTo: &ui.connLb, Text: ""},
								}},
						}},
					GroupBox{Title: "2. 打印状态", Layout: Grid{Columns: 6, Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}, Spacing: 4},
						Children: []Widget{
							Label{Row: 0, Column: 0, Text: "状态"},
							Label{Row: 0, Column: 1, Text: "任务"},
							Label{Row: 0, Column: 2, Text: "层"},
							Label{Row: 0, Column: 3, Text: "进度"},
							Label{Row: 0, Column: 4, Text: "已跳过"},
							Label{Row: 0, Column: 5, Text: "任务ID"},
							Label{AssignTo: &ui.stState, Row: 1, Column: 0, Text: "-", MinSize: Size{Width: 80, Height: 0}},
							Label{AssignTo: &ui.stTask, Row: 1, Column: 1, Text: "-", MinSize: Size{Width: 160, Height: 0}},
							Label{AssignTo: &ui.stLayer, Row: 1, Column: 2, Text: "-", MinSize: Size{Width: 80, Height: 0}},
							Label{AssignTo: &ui.stPct, Row: 1, Column: 3, Text: "-", MinSize: Size{Width: 70, Height: 0}},
							Label{AssignTo: &ui.stSkip, Row: 1, Column: 4, Text: "-", MinSize: Size{Width: 100, Height: 0}},
							Label{AssignTo: &ui.stTid, Row: 1, Column: 5, Text: "-", MinSize: Size{Width: 90, Height: 0}},
						}},
					GroupBox{Title: "3. 要跳过的零件(点击俯视图中的零件即可选中,与右侧列表联动)", Layout: HBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}, Spacing: 6},
						Children: []Widget{
							CustomWidget{
								AssignTo:      &ui.plateCw,
								MinSize:       Size{Width: 400, Height: 400},
								StretchFactor: 1,
								Paint:         ui.paintPlate,
							},
							Composite{
								StretchFactor: 1,
								Layout:        VBox{Margins: Margins{Left: 4, Top: 0, Right: 0, Bottom: 0}, Spacing: 4},
								Children: []Widget{
									PushButton{AssignTo: &ui.fetchBtn, Text: "从云端任务获取", Enabled: false,
										OnClicked: ui.onFetch},
									PushButton{Text: "打开切片 3mf…", OnClicked: ui.onOpen3mf},
									Composite{
										Layout: HBox{MarginsZero: true, Spacing: 4},
										Children: []Widget{
											Label{Text: "盘:"},
											ComboBox{AssignTo: &ui.plateCB, MinSize: Size{Width: 160, Height: 0}, MaxSize: Size{Width: 240, Height: 0},
												OnCurrentIndexChanged: ui.onPlateChanged},
										},
									},
									ListBox{AssignTo: &ui.objList, MultiSelection: true,
										MinSize: Size{Width: 0, Height: 240}, StretchFactor: 1,
										OnSelectedIndexesChanged: ui.onListSelChanged},
									Composite{
										Layout: HBox{MarginsZero: true, Spacing: 4},
										Children: []Widget{
											PushButton{Text: "全选", OnClicked: func() { ui.setAll(true) }},
											PushButton{Text: "清空", OnClicked: func() { ui.setAll(false) }},
											RadioButton{AssignTo: &ui.viewPickRB, Text: "选择视图",
												OnClicked: func() { ui.setView("pick") }},
											RadioButton{AssignTo: &ui.viewTopRB, Text: "渲染图",
												OnClicked: func() { ui.setView("top") }},
										},
									},
								},
							},
						}},
					GroupBox{Title: "4. 发送跳过命令", Layout: VBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}, Spacing: 4},
						Children: []Widget{
							Composite{Layout: HBox{MarginsZero: true, Spacing: 6},
								Children: []Widget{
									Label{Text: "手动 ID(逗号分隔):"},
									LineEdit{AssignTo: &ui.manualEd, CueBanner: "如 197,175", MinSize: Size{Width: 180, Height: 0}, MaxSize: Size{Width: 260, Height: 0}},
									PushButton{AssignTo: &ui.sendManBtn, Text: "跳过手动输入", OnClicked: ui.onSendManual},
									PushButton{AssignTo: &ui.certBtn, Text: "准备签名证书", OnClicked: ui.onPrepareCert, MaxSize: Size{Width: 130, Height: 0}},
									CheckBox{AssignTo: &ui.rawCB, Text: "原始报文", OnCheckedChanged: ui.onRawToggle},
								}},
							Composite{Layout: HBox{MarginsZero: true, Spacing: 6},
								Children: []Widget{
									Label{AssignTo: &ui.stAck, Text: "打印机应答: -"},
									PushButton{AssignTo: &ui.sendSelBtn, Text: "跳过选中零件", OnClicked: ui.onSendSelected, MaxSize: Size{Width: 180, Height: 0}},
								}},
						}},
					GroupBox{Title: "MQTT 日志", Layout: VBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
						Children: []Widget{
							TextEdit{AssignTo: &ui.logView, ReadOnly: true,
								MinSize: Size{Width: 0, Height: 150}},
						}},
				},
			},
		},
	}.Create()
	if err != nil {
		return err
	}
	ui.plateCw.MouseDown().Attach(func(x, y int, _ walk.MouseButton) {
		ui.onPlateClick(x, y)
	})
	return nil
}

// fitToScreen 按当前显示器工作区收缩窗口,保证高 DPI / 小屏下窗口完整可见。
func (ui *winUI) fitToScreen() {
	dpi := ui.mw.DPI()
	if dpi <= 0 {
		dpi = 96
	}
	wa := workAreaPixels()
	availW := int(wa.Width)*96/dpi - 16
	availH := int(wa.Height)*96/dpi - 40
	wantW, wantH := 1120, 820
	if availW > 400 && wantW > availW {
		wantW = availW
	}
	if availH > 300 && wantH > availH {
		wantH = availH
	}
	minW, minH := 900, 600
	if wantW < minW {
		minW = wantW
	}
	if wantH < minH {
		minH = wantH
	}
	_ = ui.mw.SetMinMaxSize(walk.Size{Width: minW, Height: minH}, walk.Size{})
	_ = ui.mw.SetSize(walk.Size{Width: wantW, Height: wantH})
	if availW > 0 && availH > 0 {
		x := int(wa.X)*96/dpi + (availW-wantW)/2
		y := int(wa.Y)*96/dpi + (availH-wantH)/2
		_ = ui.mw.SetX(x)
		_ = ui.mw.SetY(y)
	}
}

func workAreaPixels() walk.Rectangle {
	var rc win.RECT
	if win.SystemParametersInfo(spiGetWorkArea, 0, unsafe.Pointer(&rc), 0) {
		return walk.Rectangle{
			X: int(rc.Left), Y: int(rc.Top),
			Width: int(rc.Right - rc.Left), Height: int(rc.Bottom - rc.Top),
		}
	}
	return walk.Rectangle{Width: 1920, Height: 1080}
}

// ---- 日志(线程安全) ----

func (ui *winUI) Log(s string) {
	if ui.logView == nil {
		return
	}
	f := func() {
		ui.logLines = append(ui.logLines, time.Now().Format("[15:04:05] ")+s)
		if len(ui.logLines) > 500 {
			ui.logLines = ui.logLines[len(ui.logLines)-400:]
		}
		ui.logView.SetText(strings.Join(ui.logLines, "\r\n"))
	}
	ui.mw.Synchronize(f)
}

func (ui *winUI) setConnInfo(s string) {
	if ui.connLb != nil {
		ui.mw.Synchronize(func() { ui.connLb.SetText(s) })
	}
}

func (ui *winUI) onRawToggle() {
	p := ui.currentPrinter()
	if p == nil {
		return
	}
	if ui.rawCB.Checked() {
		p.SetRawLog(func(s string) { ui.Log("RAW " + s) })
		ui.Log("已开启原始报文记录")
	} else {
		p.SetRawLog(nil)
		ui.Log("已关闭原始报文记录")
	}
}

// ---- 连接 ----

func (ui *winUI) onConnect() {
	if p := ui.currentPrinter(); p != nil && p.IsConnected() {
		p.Disconnect()
		ui.connBtn.SetText("连接")
		ui.Log("已请求断开连接")
		return
	}
	ui.mu.Lock()
	c := ui.creds
	ui.mu.Unlock()

	p := NewPrinter()
	p.Log = ui.Log
	lanMode := ui.modeLanRB.Checked() || c == nil
	if !lanMode {
		sn := ui.snCB.Text()
		if sn == "" {
			walk.MsgBox(ui.mw, "提示", "请选择打印机序列号", walk.MsgBoxIconWarning)
			return
		}
		p.SetupCloud(c, sn)
	} else {
		ip, code := ui.ipEd.Text(), ui.codeEd.Text()
		if ip == "" || code == "" {
			walk.MsgBox(ui.mw, "提示", "请填写打印机 IP 和 8 位访问码", walk.MsgBoxIconWarning)
			return
		}
		p.SetupLAN(strings.TrimSpace(ip), strings.TrimSpace(code), "")
	}
	if ui.rawCB.Checked() {
		p.SetRawLog(func(s string) { ui.Log("RAW " + s) })
	}
	ui.setPrinter(p)
	ui.connBtn.SetEnabled(false)
	ui.Log(fmt.Sprintf("正在连接 %s:8883 …", p.Host))
	go func() {
		err := p.Connect()
		ui.mw.Synchronize(func() {
			ui.connBtn.SetEnabled(true)
			if err != nil {
				ui.Log("[错误] 连接失败: " + err.Error())
				walk.MsgBox(ui.mw, "连接失败", err.Error(), walk.MsgBoxIconError)
				return
			}
			ui.connBtn.SetText("断开")
		})
	}()
}

func (ui *winUI) currentPrinter() *Printer {
	ui.mu.Lock()
	defer ui.mu.Unlock()
	return ui.printer
}

func (ui *winUI) credsOrNil() *Creds {
	ui.mu.Lock()
	defer ui.mu.Unlock()
	return ui.creds
}

func (ui *winUI) setPrinter(p *Printer) {
	ui.mu.Lock()
	ui.printer = p
	ui.mu.Unlock()
}

// ---- 状态轮询与 pushall ----

func (ui *winUI) statusLoop() {
	reportedOnce := false
	tick := 0
	for {
		time.Sleep(1 * time.Second)
		tick++
		p := ui.currentPrinter()
		if p == nil || !p.IsConnected() {
			reportedOnce = false
			continue
		}
		if tick%3 == 1 {
			p.RequestPush()
		}
		sn, report := p.Report()
		if report == nil {
			continue
		}
		tid := validTaskID(report)
		gcode := asString(report["gcode_state"])
		skipped := skippedIDList(report)
		skips := make([]int, 0, len(skipped))
		hms := HMSNotices(report)
		hasCreds := ui.credsOrNil() != nil
		ui.mw.Synchronize(func() {
			ui.stState.SetText(stateText(gcode))
			setLabel(ui.stTask, elide(orDash(report["subtask_name"]), 26))
			ui.stLayer.SetText(orDash(report["layer_num"]) + "/" + orDash(report["total_layer_num"]))
			ui.stPct.SetText(pctText(report["mc_percent"]))
			ui.stSkip.SetText(orDash(skips))
			ui.stTid.SetText(orDash(report["task_id"]))
			printing := gcode == "RUNNING" || gcode == "PAUSE"
			ui.sendSelBtn.SetEnabled(printing)
			ui.sendManBtn.SetEnabled(printing)
			ui.fetchBtn.SetEnabled(tid != "" && hasCreds)

			// 已跳过集合以打印机 s_obj 为准;新出现的标记进列表并取消勾选
			changed := false
			for _, id := range skips {
				if !ui.reported[id] {
					ui.reported[id] = true
					delete(ui.selected, id)
					changed = true
				}
			}
			if changed && len(ui.plates) > 0 {
				ui.rebuildObjectListLocked()
				ui.plateCw.Invalidate()
			}
			if gcode != ui.lastState {
				ui.lastState = gcode
				if gcode != "" {
					ui.Log("状态: " + stateText(gcode))
				}
			}
			if len(hms) > 0 {
				joined := strings.Join(hms, ";")
				if joined != ui.lastHMS {
					ui.lastHMS = joined
					for _, h := range hms {
						ui.Log("[HMS] " + h)
					}
				}
			}
			if !reportedOnce && tid != "" {
				reportedOnce = true
				SaveLastSN(sn)
				ui.Log(fmt.Sprintf("已解析打印状态:%v(任务 %s,%s/%s 层)",
					orDash(report["subtask_name"]), tid,
					orDash(report["layer_num"]), orDash(report["total_layer_num"])))
			}
		})
	}
}

// ---- 云端任务 / 3mf ----

func (ui *winUI) onFetch() {
	p := ui.currentPrinter()
	ui.mu.Lock()
	c := ui.creds
	ui.mu.Unlock()
	if p == nil || c == nil {
		return
	}
	_, report := p.Report()
	if report == nil {
		walk.MsgBox(ui.mw, "提示", "尚未收到打印机 report", walk.MsgBoxIconWarning)
		return
	}
	tid := validTaskID(report)
	if tid == "" {
		walk.MsgBox(ui.mw, "提示",
			"report 中没有任务 ID(需云端任务;本地 SD 打印请打开切片 3mf)", walk.MsgBoxIconWarning)
		return
	}
	ui.fetchBtn.SetEnabled(false)
	ui.Log("正在获取云端任务 " + tid + " …")
	go func() {
		plates, name, err := FetchTaskObjects(tid, c)
		ui.mw.Synchronize(func() {
			ui.fetchBtn.SetEnabled(true)
			if err != nil {
				ui.Log("[错误] 获取失败: " + err.Error())
				walk.MsgBox(ui.mw, "获取失败", err.Error(), walk.MsgBoxIconError)
				return
			}
			ui.setPlates(plates)
			n := 0
			for _, pl := range plates {
				n += len(pl.Objects)
			}
			ui.Log(fmt.Sprintf("已获取任务 %s《%s》对象列表(%d 盘,%d 零件)", tid, name, len(plates), n))
		})
	}()
}

func (ui *winUI) onOpen3mf() {
	dlg := walk.FileDialog{Filter: "Bambu 3mf (*.3mf)|*.3mf|全部文件 (*.*)|*.*"}
	ok, _ := dlg.ShowOpen(ui.mw)
	if !ok {
		return
	}
	path := dlg.FilePath
	go func() {
		plates, err := Parse3MF(path)
		ui.mw.Synchronize(func() {
			if err != nil {
				walk.MsgBox(ui.mw, "解析失败", err.Error(), walk.MsgBoxIconError)
				return
			}
			ui.setPlates(plates)
			n := 0
			for _, pl := range plates {
				n += len(pl.Objects)
			}
			ui.Log(fmt.Sprintf("已加载 3mf(%d 盘,%d 零件)", len(plates), n))
		})
	}()
}

// setPlates:UI 线程。装载新盘数据并解码 pick/top 图
func (ui *winUI) setPlates(plates []Plate) {
	ui.mu.Lock()
	ui.plates = plates
	ui.images = map[int]map[string]image.Image{}
	ui.selected = map[int]bool{}
	ui.curPlate = 0
	ui.gen++
	ui.bmpCache = map[string]walk.Image{}
	ui.centers = map[string]map[int]image.Point{}
	for _, pl := range plates {
		m := map[string]image.Image{}
		dec := func(data []byte, key string) {
			if len(data) == 0 || m[key] != nil {
				return
			}
			if im, _, err := image.Decode(strings.NewReader(string(data))); err == nil {
				m[key] = im
			}
		}
		dec(pl.PickPNG, "pick")
		dec(pl.TopPNG, "top")
		ui.images[pl.Index] = m
	}
	ui.mu.Unlock()
	ui.rebuildPlateUI()
}

// rebuildPlateUI:UI 线程。重建盘下拉、零件列表
func (ui *winUI) rebuildPlateUI() {
	ui.mu.Lock()
	var items []string
	for _, pl := range ui.plates {
		items = append(items, fmt.Sprintf("盘 %d %s(%d 零件)[%s]",
			pl.Index, pl.Name, len(pl.Objects), pl.Source))
	}
	ui.syncingSel = true
	ui.plateCB.SetModel(items)
	if len(items) > 0 {
		ui.plateCB.SetCurrentIndex(0)
	}
	ui.syncingSel = false
	ui.rebuildObjectListLocked()
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

// rebuildObjectListLocked:UI 线程(调用方持锁)
func (ui *winUI) rebuildObjectListLocked() {
	if ui.curPlate >= len(ui.plates) {
		ui.objList.SetModel([]string{})
		return
	}
	pl := ui.plates[ui.curPlate]
	items := make([]string, 0, len(pl.Objects))
	for _, o := range pl.Objects {
		skipped := o.Skipped || ui.reported[o.IdentifyID]
		tag := ""
		if skipped {
			tag = "  [已跳过]"
		}
		items = append(items, fmt.Sprintf("#%d  %s%s", o.IdentifyID, o.Name, tag))
	}
	ui.objList.SetModel(items)
	ui.syncSelectionToListLocked()
}

// selected → ListBox 选中态(UI 线程,调用方持锁)
func (ui *winUI) syncSelectionToListLocked() {
	if ui.curPlate >= len(ui.plates) {
		return
	}
	var idx []int
	for i, o := range ui.plates[ui.curPlate].Objects {
		if ui.selected[o.IdentifyID] {
			idx = append(idx, i)
		}
	}
	ui.syncingSel = true
	ui.objList.SetSelectedIndexes(idx)
	ui.syncingSel = false
}

// ListBox 选择 → selected(用户手动多选)
func (ui *winUI) onListSelChanged() {
	if ui.syncingSel {
		return
	}
	ui.mu.Lock()
	if ui.curPlate >= len(ui.plates) {
		ui.mu.Unlock()
		return
	}
	objs := ui.plates[ui.curPlate].Objects
	newSel := map[int]bool{}
	for _, i := range ui.objList.SelectedIndexes() {
		if i >= 0 && i < len(objs) {
			newSel[objs[i].IdentifyID] = true
		}
	}
	ui.selected = newSel
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

func (ui *winUI) onPlateChanged() {
	if ui.syncingSel {
		return
	}
	i := ui.plateCB.CurrentIndex()
	ui.mu.Lock()
	ui.curPlate = i
	ui.selected = map[int]bool{}
	ui.rebuildObjectListLocked()
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

func (ui *winUI) setAll(v bool) {
	ui.mu.Lock()
	if ui.curPlate >= len(ui.plates) {
		ui.mu.Unlock()
		return
	}
	for _, o := range ui.plates[ui.curPlate].Objects {
		if o.Skipped || ui.reported[o.IdentifyID] {
			continue
		}
		ui.selected[o.IdentifyID] = v
	}
	ui.syncSelectionToListLocked()
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

func (ui *winUI) setView(kind string) {
	ui.mu.Lock()
	ui.imgKind = kind
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

// ---- 俯视图绘制(Paint 在 UI 线程) ----

// fitImage 计算图片在画布内的等比缩放布局(像素)
func fitImage(iw, ih int, cb walk.Rectangle) (ox, oy, w, h int) {
	if iw <= 0 || ih <= 0 || cb.Width <= 0 || cb.Height <= 0 {
		return 0, 0, 0, 0
	}
	s := float64(cb.Width) / float64(iw)
	if s > float64(cb.Height)/float64(ih) {
		s = float64(cb.Height) / float64(ih)
	}
	w, h = int(float64(iw)*s), int(float64(ih)*s)
	ox, oy = cb.X+(cb.Width-w)/2, cb.Y+(cb.Height-h)/2
	return
}

func (ui *winUI) paintPlate(canvas *walk.Canvas, updateBounds walk.Rectangle) error {
	if brushBG, err := walk.NewSolidColorBrush(walk.RGB(10, 10, 10)); err == nil {
		defer brushBG.Dispose()
		canvas.FillRectangle(brushBG, updateBounds)
	}
	ui.mu.Lock()
	var pl *Plate
	var img, pick image.Image
	if ui.curPlate < len(ui.plates) {
		pl = &ui.plates[ui.curPlate]
		m := ui.images[pl.Index]
		img = m[ui.imgKind]
		if img == nil && ui.imgKind == "pick" {
			img = m["top"]
		}
		pick = m["pick"]
	}
	sel := make(map[int]bool, len(ui.selected))
	for k, v := range ui.selected {
		sel[k] = v
	}
	gen, plateIdx := ui.gen, ui.curPlate
	ui.mu.Unlock()

	if pl == nil {
		ui.drawText(canvas, updateBounds, "尚未加载零件列表")
		return nil
	}
	if img == nil {
		ui.drawText(canvas, updateBounds, "无俯视图,可直接在右侧列表勾选")
		return nil
	}
	b := img.Bounds()
	ox, oy, w, h := fitImage(b.Dx(), b.Dy(), updateBounds)
	if w <= 0 || h <= 0 {
		return nil
	}
	dpi := canvas.DPI()
	if dpi <= 0 {
		dpi = 96
	}
	key := fmt.Sprintf("%d:%s:%d:%d:%d:%d", gen, ui.imgKind, plateIdx, w, h, dpi)
	ui.mu.Lock()
	bmp, ok := ui.bmpCache[key]
	ui.mu.Unlock()
	if !ok {
		nb, err := walk.NewBitmapFromImageForDPI(img, dpi)
		if err != nil {
			return nil
		}
		ui.mu.Lock()
		// 旧的代次/尺寸缓存直接丢弃,避免内存增长
		for k := range ui.bmpCache {
			if !strings.HasPrefix(k, fmt.Sprintf("%d:", gen)) {
				delete(ui.bmpCache, k)
			}
		}
		ui.bmpCache[key] = nb
		ui.mu.Unlock()
		bmp = nb
	}
	canvas.DrawImageStretched(bmp, walk.Rectangle{X: ox, Y: oy, Width: w, Height: h})

	// 选中标记:以 pick 遮罩的包围盒中心画绿圈(不受中心孔影响)
	if pick != nil {
		centers := ui.pickCenters(gen, plateIdx, pick)
		if len(centers) > 0 && len(sel) > 0 {
			pb := pick.Bounds()
			sx := float64(w) / float64(pb.Dx())
			sy := float64(h) / float64(pb.Dy())
			if pen, err := walk.NewCosmeticPen(walk.PenSolid, walk.RGB(0, 230, 118)); err == nil {
				defer pen.Dispose()
				for id, on := range sel {
					if !on {
						continue
					}
					c, ok := centers[id]
					if !ok {
						continue
					}
					r := 16 * dpi / 96
					canvas.DrawEllipse(pen, walk.Rectangle{
						X: ox + int(float64(c.X)*sx) - r, Y: oy + int(float64(c.Y)*sy) - r,
						Width: 2 * r, Height: 2 * r})
				}
			}
		}
	}
	return nil
}

func (ui *winUI) drawText(canvas *walk.Canvas, cb walk.Rectangle, text string) {
	canvas.DrawText(text, ui.mw.Font(), walk.RGB(136, 136, 136),
		walk.Rectangle{X: cb.X + cb.Width/2 - 150, Y: cb.Y + cb.Height/2 - 10, Width: 300, Height: 20}, 0)
}

// pickCenters 一次扫描 pick 遮罩,缓存每个 identify_id 的包围盒中心(图像坐标)
func (ui *winUI) pickCenters(gen, plateIdx int, img image.Image) map[int]image.Point {
	key := fmt.Sprintf("%d:%d:pick", gen, plateIdx)
	ui.mu.Lock()
	if c, ok := ui.centers[key]; ok {
		ui.mu.Unlock()
		return c
	}
	ui.mu.Unlock()

	b := img.Bounds()
	type box struct{ minx, miny, maxx, maxy int }
	boxes := map[int]*box{}
	step := 2
	if b.Dx()*b.Dy() < 700*700 {
		step = 1
	}
	for y := b.Min.Y; y < b.Max.Y; y += step {
		for x := b.Min.X; x < b.Max.X; x += step {
			r, g, bl, _ := img.At(x, y).RGBA()
			id := int(uint8(r>>8)) + int(uint8(g>>8))<<8 + int(uint8(bl>>8))<<16
			if id == 0 {
				continue
			}
			bx := boxes[id]
			if bx == nil {
				boxes[id] = &box{x, y, x, y}
				continue
			}
			if x < bx.minx {
				bx.minx = x
			}
			if y < bx.miny {
				bx.miny = y
			}
			if x > bx.maxx {
				bx.maxx = x
			}
			if y > bx.maxy {
				bx.maxy = y
			}
		}
	}
	out := make(map[int]image.Point, len(boxes))
	for id, bx := range boxes {
		if id == 0 {
			continue
		}
		out[id] = image.Pt((bx.minx+bx.maxx)/2, (bx.miny+bx.maxy)/2)
	}
	ui.mu.Lock()
	ui.centers[key] = out
	ui.mu.Unlock()
	return out
}

// onPlateClick:控件坐标 → 图像坐标 → 用 pick 遮罩反解 identify_id
// (渲染图视图下也按同一几何关系取 pick,避免在照片上取色导致点不中)
func (ui *winUI) onPlateClick(mx, my int) {
	ui.mu.Lock()
	if ui.curPlate >= len(ui.plates) {
		ui.mu.Unlock()
		return
	}
	pl := &ui.plates[ui.curPlate]
	m := ui.images[pl.Index]
	disp := m[ui.imgKind]
	if disp == nil && ui.imgKind == "pick" {
		disp = m["top"]
	}
	pick := m["pick"]
	ui.mu.Unlock()
	if disp == nil || pick == nil {
		return
	}
	cb := ui.plateCw.ClientBounds()
	ox, oy, w, h := fitImage(disp.Bounds().Dx(), disp.Bounds().Dy(), cb)
	if w <= 0 || h <= 0 || mx < ox || my < oy || mx >= ox+w || my >= oy+h {
		return
	}
	pb := pick.Bounds()
	ix := pb.Min.X + int(float64(mx-ox)*float64(pb.Dx())/float64(w))
	iy := pb.Min.Y + int(float64(my-oy)*float64(pb.Dy())/float64(h))
	dec := func(x, y int) int {
		if x < pb.Min.X || y < pb.Min.Y || x >= pb.Max.X || y >= pb.Max.Y {
			return 0
		}
		r, g, bl, _ := pick.At(x, y).RGBA()
		return int(uint8(r>>8)) + int(uint8(g>>8))<<8 + int(uint8(bl>>8))<<16
	}
	valid := map[int]bool{}
	for _, o := range pl.Objects {
		valid[o.IdentifyID] = true
		valid[o.ObjectID] = true
	}
	iid := dec(ix, iy)
	if !valid[iid] {
		// 零件中心孔等镂空区域:环形搜索最近的有效遮罩色
		best, bestD := 0, 1<<30
		for r := 3; r <= 90; r += 3 {
			for a := 0; a < 360; a += 5 {
				nx := ix + int(float64(r)*math.Cos(float64(a)*math.Pi/180))
				ny := iy + int(float64(r)*math.Sin(float64(a)*math.Pi/180))
				id := dec(nx, ny)
				if valid[id] {
					dd := (nx-ix)*(nx-ix) + (ny-iy)*(ny-iy)
					if dd < bestD {
						best, bestD = id, dd
					}
				}
			}
			if best != 0 {
				break
			}
		}
		iid = best
	}
	var obj *SkipObject
	for i := range pl.Objects {
		if pl.Objects[i].IdentifyID == iid || pl.Objects[i].ObjectID == iid {
			obj = &pl.Objects[i]
			break
		}
	}
	if obj == nil || obj.Skipped {
		return
	}
	ui.mu.Lock()
	key := obj.IdentifyID
	if ui.selected[key] {
		delete(ui.selected, key)
	} else {
		ui.selected[key] = true
	}
	ui.syncSelectionToListLocked()
	ui.mu.Unlock()
	ui.plateCw.Invalidate()
}

// ---- 发送 ----

func (ui *winUI) collectSelected() []int {
	ui.mu.Lock()
	defer ui.mu.Unlock()
	ids := make([]int, 0, len(ui.selected))
	for id, on := range ui.selected {
		if on {
			ids = append(ids, id)
		}
	}
	sort.Ints(ids)
	return ids
}

// onPrepareCert 预先申请并安装签名证书(跳过时会自动做,这里便于手动排查)
func (ui *winUI) onPrepareCert() {
	p := ui.currentPrinter()
	if p == nil {
		walk.MsgBox(ui.mw, "提示", "请先连接打印机", walk.MsgBoxIconWarning)
		return
	}
	ui.certBtn.SetEnabled(false)
	ui.Log("正在申请并安装签名证书 …")
	go func() {
		err := p.EnsureCertInstalled()
		ui.mw.Synchronize(func() {
			ui.certBtn.SetEnabled(true)
			if err != nil {
				ui.Log("[错误] 证书准备失败: " + err.Error())
				walk.MsgBox(ui.mw, "证书准备失败", err.Error(), walk.MsgBoxIconError)
				return
			}
			ac, _ := p.ensureAppCert()
			id := ""
			if ac != nil {
				id = ac.CertID
			}
			ui.Log("[+] 签名证书就绪: " + id)
			walk.MsgBox(ui.mw, "完成", "签名证书已安装到打印机:\n"+id, walk.MsgBoxIconInformation)
		})
	}()
}

func (ui *winUI) sendIDs(ids []int) {
	p := ui.currentPrinter()
	if p == nil {
		walk.MsgBox(ui.mw, "提示", "请先连接打印机", walk.MsgBoxIconWarning)
		return
	}
	ui.sendSelBtn.SetEnabled(false)
	ui.sendManBtn.SetEnabled(false)
	ui.Log(fmt.Sprintf("正在发送跳过命令: %v", ids))
	go func() {
		res, err := p.SkipObjects(ids)
		ui.mw.Synchronize(func() {
			ui.sendSelBtn.SetEnabled(true)
			ui.sendManBtn.SetEnabled(true)
			if err != nil {
				ui.Log("[错误] " + err.Error())
				ui.stAck.SetText("打印机应答: 未发送(" + err.Error() + ")")
				walk.MsgBox(ui.mw, "未发送", err.Error(), walk.MsgBoxIconWarning)
				return
			}
			if res.Accepted {
				msg := fmt.Sprintf("已确认跳过 %v(%s)", res.IDs, res.Note)
				ui.Log("[+] " + msg)
				ui.stAck.SetText("打印机应答: " + msg)
			} else {
				msg := fmt.Sprintf("跳过失败(%s):%s", res.Variant, res.Note)
				ui.Log("[!] " + msg)
				ui.stAck.SetText("打印机应答: " + msg)
				walk.MsgBox(ui.mw, "打印机未接受", msg, walk.MsgBoxIconError)
			}
		})
	}()
}

func (ui *winUI) onSendSelected() {
	ids := ui.collectSelected()
	if len(ids) == 0 {
		walk.MsgBox(ui.mw, "提示", "请先点图/勾选要跳过的零件", walk.MsgBoxIconWarning)
		return
	}
	if walk.MsgBox(ui.mw, "确认",
		fmt.Sprintf("确认跳过零件: %v?\n该操作不可撤销。", ids),
		walk.MsgBoxOKCancel|walk.MsgBoxIconQuestion) != walk.DlgCmdOK {
		return
	}
	ui.sendIDs(ids)
}

func (ui *winUI) onSendManual() {
	var ids []int
	for _, tok := range strings.FieldsFunc(ui.manualEd.Text(), func(r rune) bool {
		return r == ',' || r == ' '
	}) {
		var n int
		if _, err := fmt.Sscanf(tok, "%d", &n); err == nil && n > 0 {
			ids = append(ids, n)
		}
	}
	if len(ids) == 0 {
		walk.MsgBox(ui.mw, "提示", "请输入对象 ID", walk.MsgBoxIconWarning)
		return
	}
	if walk.MsgBox(ui.mw, "确认",
		fmt.Sprintf("确认跳过零件: %v?\n该操作不可撤销。", ids),
		walk.MsgBoxOKCancel|walk.MsgBoxIconQuestion) != walk.DlgCmdOK {
		return
	}
	ui.sendIDs(ids)
}

// setLabel 设置标签文本并把完整内容放到 ToolTip(长名字不再“显示不全”)
func setLabel(lb *walk.Label, s string) {
	if lb == nil {
		return
	}
	lb.SetText(s)
	lb.SetToolTipText(s)
}
