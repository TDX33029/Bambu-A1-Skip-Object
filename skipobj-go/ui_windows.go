//go:build windows

package main

// 原生 Win32 窗口界面(lxn/walk,无 CGO)。
// 交互模型与 Web 版一致:连接 → 状态轮询(pushall 触发完整 report)→
// 云端任务/3mf 零件列表 → 俯视图点击选零件(遮罩颜色反解 identify_id,
// 零件中心孔走最近像素搜索)→ 发送跳过命令(新/旧协议)。

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

	"github.com/lxn/walk"
	. "github.com/lxn/walk/declarative"
)

type winUI struct {
	mw *walk.MainWindow

	snCB    *walk.ComboBox
	ipEd    *walk.LineEdit
	codeEd  *walk.LineEdit
	connBtn *walk.PushButton
	connLb  *walk.Label

	stState, stTask, stLayer, stPct, stSkip, stTid *walk.Label

	plateCw    *walk.CustomWidget
	objList    *walk.ListBox
	plateCB    *walk.ComboBox
	manualEd   *walk.LineEdit
	legacyCB   *walk.CheckBox
	logView    *walk.TextEdit
	fetchBtn   *walk.PushButton
	sendSelBtn *walk.PushButton
	sendManBtn *walk.PushButton

	printer *Printer
	creds   *Creds
	cloudOK bool

	mu         sync.Mutex
	plates     []Plate
	images     map[int]map[string]image.Image // plateIndex -> pick/top 解码图
	curPlate   int
	selected   map[int]bool
	reported   map[int]bool
	imgKind    string // pick | top
	syncingSel bool
	cloudCreds bool
	logLines    []string
	modeCloudRB *walk.RadioButton
	modeLanRB   *walk.RadioButton
	viewPickRB  *walk.RadioButton
	viewTopRB   *walk.RadioButton
	hasPlates   bool
	bmpCache    map[string]walk.Image
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
		imgKind:  "pick",
	}
	if err := ui.build(); err != nil {
		fmt.Fprintln(os.Stderr, "窗口创建失败:", err)
		RunWebUI("127.0.0.1:8974", true)
		return
	}

	if c, err := LoadCreds(); err != nil {
		ui.cloudCreds = false
		ui.setConnInfo(fmt.Sprintf("凭证: %v → 可用局域网模式", err))
	} else {
		ui.creds = c
		ui.cloudCreds = true
		sns := sortedSNs(c.Printers)
		ui.snCB.SetModel(sns)
		for i, sn := range sns {
			if sn == c.LastSN {
				ui.snCB.SetCurrentIndex(i)
				break
			}
		}
		ui.setConnInfo(fmt.Sprintf("凭证: 已从 Bambu Studio 读取(账号 %s,区域 %s,打印机 %d 台)",
			c.Account, strings.ToUpper(c.Region), len(c.Printers)))
	}
	ui.Log(fmt.Sprintf("跳过对象工具 v%s(Go,原生窗口)", Version))
	ui.Log("步骤:连接 →(打印中)从云端任务获取零件 → 点图/列表选择 → 跳过选中零件")

	go ui.statusLoop()
	go ui.pushLoop()

	ui.mw.Run()
}

func (ui *winUI) build() error {
	err := MainWindow{
		AssignTo: &ui.mw,
		Title:    "拓竹跳过对象工具(打印中跳过指定零件)",
		MinSize:  Size{Width: 1010, Height: 840},
		Size:     Size{Width: 1010, Height: 860},
		Layout:   VBox{MarginsZero: false, Margins: Margins{Left: 8, Top: 8, Right: 8, Bottom: 8}, Spacing: 4},
		Children: []Widget{
			GroupBox{Title: "1. 连接", Layout: HBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
				Children: []Widget{
					Label{Text: "打印机:"},
					ComboBox{AssignTo: &ui.snCB, MinSize: Size{Width: 210, Height: 0}},
					RadioButton{AssignTo: &ui.modeCloudRB, Text: "云端"},
					RadioButton{AssignTo: &ui.modeLanRB, Text: "局域网"},
					Label{Text: "IP:"},
					LineEdit{AssignTo: &ui.ipEd, CueBanner: "192.168.x.x", MaxSize: Size{Width: 120, Height: 0}},
					Label{Text: "访问码:"},
					LineEdit{AssignTo: &ui.codeEd, PasswordMode: true, MaxSize: Size{Width: 80, Height: 0}},
					PushButton{AssignTo: &ui.connBtn, Text: "连接", OnClicked: ui.onConnect},
					Label{AssignTo: &ui.connLb, Text: ""},
				}},
			GroupBox{Title: "2. 打印状态", Layout: HBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
				Children: []Widget{
					Label{Text: "状态:"}, Label{AssignTo: &ui.stState, Text: "-"},
					Label{Text: " 任务:"}, Label{AssignTo: &ui.stTask, Text: "-"},
					Label{Text: " 层:"}, Label{AssignTo: &ui.stLayer, Text: "-"},
					Label{Text: " 进度:"}, Label{AssignTo: &ui.stPct, Text: "-"},
					Label{Text: " 已跳过:"}, Label{AssignTo: &ui.stSkip, Text: "-"},
					Label{Text: " 任务ID:"}, Label{AssignTo: &ui.stTid, Text: "-"},
				}},
			GroupBox{Title: "3. 要跳过的零件(俯视图上点击零件即可选中,与右侧列表联动)", Layout: HBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
				Children: []Widget{
					CustomWidget{
						AssignTo: &ui.plateCw,
						MinSize:  Size{Width: 430, Height: 430},
						MaxSize:  Size{Width: 430, Height: 430},
						Paint:    ui.paintPlate,
					},
					Composite{
						Layout: VBox{Margins: Margins{Left: 4, Top: 0, Right: 0, Bottom: 0}, Spacing: 4},
						Children: []Widget{
							Composite{
								Layout: HBox{MarginsZero: true},
								Children: []Widget{
									PushButton{AssignTo: &ui.fetchBtn, Text: "从云端任务获取", Enabled: false,
										OnClicked: ui.onFetch},
									PushButton{Text: "打开切片 3mf…", OnClicked: ui.onOpen3mf},
								},
							},
							Composite{
								Layout: HBox{MarginsZero: true},
								Children: []Widget{
									Label{Text: "盘:"},
									ComboBox{AssignTo: &ui.plateCB, MinSize: Size{Width: 260, Height: 0},
										OnCurrentIndexChanged: ui.onPlateChanged},
								},
							},
							ListBox{AssignTo: &ui.objList, MultiSelection: true,
								OnSelectedIndexesChanged: ui.onListSelChanged},
							Composite{
								Layout: HBox{MarginsZero: true},
								Children: []Widget{
									PushButton{Text: "全选", OnClicked: func() { ui.setAll(true) }},
									PushButton{Text: "清空", OnClicked: func() { ui.setAll(false) }},
								},
							},
							Composite{
								Layout: HBox{MarginsZero: true},
								Children: []Widget{
									RadioButton{AssignTo: &ui.viewPickRB, Text: "选择视图(可点击)",
										OnClicked: func() { ui.setView("pick") }},
									RadioButton{AssignTo: &ui.viewTopRB, Text: "渲染图(预览)",
										OnClicked: func() { ui.setView("top") }},
								},
							},
						},
					},
				}},
			GroupBox{Title: "4. 发送跳过命令", Layout: HBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
				Children: []Widget{
					Label{Text: "手动 ID(逗号分隔):"},
					LineEdit{AssignTo: &ui.manualEd, CueBanner: "如 197,175", MaxSize: Size{Width: 150, Height: 0}},
					CheckBox{AssignTo: &ui.legacyCB, Text: "旧协议(Studio 格式)"},
					PushButton{AssignTo: &ui.sendManBtn, Text: "跳过手动输入", OnClicked: ui.onSendManual},
					PushButton{AssignTo: &ui.sendSelBtn, Text: "跳过选中零件", OnClicked: ui.onSendSelected},
				}},
			GroupBox{Title: "MQTT 日志", Layout: VBox{Margins: Margins{Left: 6, Top: 4, Right: 6, Bottom: 4}},
				Children: []Widget{
					TextEdit{AssignTo: &ui.logView, ReadOnly: true,
						MinSize: Size{Width: 0, Height: 120}},
				}},
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

// ---- 日志(线程安全) ----

func (ui *winUI) Log(s string) {
	f := func() {
		ui.logLines = append(ui.logLines, time.Now().Format("[15:04:05] ")+s)
		if len(ui.logLines) > 500 {
			ui.logLines = ui.logLines[len(ui.logLines)-400:]
		}
		ui.logView.SetText(strings.Join(ui.logLines, "\r\n"))
	}
	if ui.logView != nil {
		ui.mw.Synchronize(f)
	}
}

func (ui *winUI) setConnInfo(s string) {
	if ui.connLb != nil {
		ui.mw.Synchronize(func() { ui.connLb.SetText(s) })
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
			}
		})
	}()
}

func (ui *winUI) currentPrinter() *Printer {
	ui.mu.Lock()
	defer ui.mu.Unlock()
	return ui.printer
}

func (ui *winUI) setPrinter(p *Printer) {
	ui.mu.Lock()
	ui.printer = p
	ui.mu.Unlock()
}

// ---- 轮询与 pushall ----

func (ui *winUI) statusLoop() {
	reportedOnce := false
	pushedOnce := false
	for {
		time.Sleep(1500 * time.Millisecond)
		p := ui.currentPrinter()
		if p == nil || !p.IsConnected() {
			reportedOnce, pushedOnce = false, false
			continue
		}
		p.RequestPush()
		if !pushedOnce {
			pushedOnce = true
			ui.Log("已请求打印机上报完整状态(pushall)…")
		}
		sn, report := p.Report()
		if report == nil {
			continue
		}
		tid := asString(report["task_id"])
		gcode := asString(report["gcode_state"])
		ui.mw.Synchronize(func() {
			ui.stState.SetText(stateText(gcode))
			ui.stTask.SetText(orDash(report["subtask_name"]))
			ui.stLayer.SetText(orDash(report["layer_num"]) + "/" + orDash(report["total_layer_num"]))
			ui.stPct.SetText(pctText(report["print_percent"]))
			ui.stSkip.SetText(orDash(report["skip_objects"]))
			ui.stTid.SetText(orDash(report["task_id"]))
			printing := gcode == "RUNNING" || gcode == "PAUSE"
			ui.sendSelBtn.SetEnabled(printing)
			ui.sendManBtn.SetEnabled(printing)
			ui.fetchBtn.SetEnabled(tid != "" && ui.cloudCreds)
			if !reportedOnce && tid != "" {
				reportedOnce = true
				SaveLastSN(sn)
				ui.Log(fmt.Sprintf("已解析打印状态:%v(任务 %s,%s/%s 层)→ 可从云端任务获取零件",
					orDash(report["subtask_name"]), tid,
					orDash(report["layer_num"]), orDash(report["total_layer_num"])))
			}
		})
	}
}

func (ui *winUI) pushLoop() {
	for {
		time.Sleep(3 * time.Second)
		if p := ui.currentPrinter(); p != nil && p.IsConnected() {
			p.RequestPush()
		}
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
	tid := asString(report["task_id"])
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
	ui.hasPlates = len(plates) > 0
	for _, pl := range plates {
		if ui.images[pl.Index] == nil {
			ui.images[pl.Index] = map[string]image.Image{}
		}
		m := ui.images[pl.Index]
		dec := func(data []byte, key string) {
			if data == nil || m[key] != nil {
				return
			}
			if im, _, err := image.Decode(strings.NewReader(string(data))); err == nil {
				m[key] = im
			}
		}
		dec(pl.PickPNG, "pick")
		dec(pl.TopPNG, "top")
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

// rebuildObjectListLocked:UI 线程
func (ui *winUI) rebuildObjectListLocked() {
	if ui.curPlate >= len(ui.plates) {
		ui.objList.SetModel([]string{})
		return
	}
	pl := ui.plates[ui.curPlate]
	var items []string
	for _, o := range pl.Objects {
		if o.Skipped {
			ui.reported[o.IdentifyID] = true
			ui.selected[o.IdentifyID] = true
		}
		items = append(items, fmt.Sprintf("#%d  %s", o.IdentifyID, o.Name))
	}
	ui.objList.SetModel(items)
	ui.syncSelectionToListLocked()
}

// selected → ListBox 选中态(UI 线程)
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
	if ui.syncingSel || !ui.hasPlates {
		return
	}
	ui.mu.Lock()
	defer ui.mu.Unlock()
	if ui.curPlate >= len(ui.plates) {
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
	ui.mu.Unlock()
	ui.mw.Synchronize(func() {
		ui.mu.Lock()
		ui.rebuildObjectListLocked()
		ui.mu.Unlock()
		ui.plateCw.Invalidate()
	})
}

func (ui *winUI) setAll(v bool) {
	ui.mu.Lock()
	if ui.curPlate >= len(ui.plates) {
		ui.mu.Unlock()
		return
	}
	for _, o := range ui.plates[ui.curPlate].Objects {
		if !o.Skipped {
			ui.selected[o.IdentifyID] = v
		}
	}
	ui.mu.Unlock()
	ui.mw.Synchronize(func() {
		ui.mu.Lock()
		ui.syncSelectionToListLocked()
		ui.mu.Unlock()
		ui.plateCw.Invalidate()
	})
}

func (ui *winUI) setView(kind string) {
	ui.mu.Lock()
	ui.imgKind = kind
	ui.mu.Unlock()
	ui.mw.Synchronize(func() { ui.plateCw.Invalidate() })
}

// ---- 俯视图绘制(Paint 在 UI 线程) ----

func (ui *winUI) currentPlateImage() image.Image {
	ui.mu.Lock()
	defer ui.mu.Unlock()
	if ui.curPlate >= len(ui.plates) {
		return nil
	}
	pl := ui.plates[ui.curPlate]
	m, ok := ui.images[pl.Index]
	if !ok {
		return nil
	}
	if im := m[ui.imgKind]; im != nil {
		return im
	}
	if ui.imgKind == "pick" {
		return m["top"] // 无遮罩图时退化为渲染预览
	}
	return nil
}

func (ui *winUI) paintPlate(canvas *walk.Canvas, updateBounds walk.Rectangle) error {
	if brushBG, err := walk.NewSolidColorBrush(walk.RGB(10, 10, 10)); err == nil {
		defer brushBG.Dispose()
		canvas.FillRectangle(brushBG, updateBounds)
	}
	ui.mu.Lock()
	var pl *Plate
	var img image.Image
	if ui.curPlate < len(ui.plates) {
		pl = &ui.plates[ui.curPlate]
		m := ui.images[pl.Index]
		img = m[ui.imgKind]
		if img == nil && ui.imgKind == "pick" {
			img = m["top"]
		}
	}
	sel := map[int]bool{}
	for k, v := range ui.selected {
		sel[k] = v
	}
	kind := ui.imgKind
	ui.mu.Unlock()

	if pl == nil {
		ui.drawText(canvas, updateBounds, "尚未加载零件列表")
		return nil
	}
	if img == nil {
		ui.drawText(canvas, updateBounds, "无俯视图,可直接在右侧列表勾选")
		return nil
	}
	cb := updateBounds
	iw, ih := float64(img.Bounds().Dx()), float64(img.Bounds().Dy())
	s := float64(cb.Width) / iw
	if s > float64(cb.Height)/ih {
		s = float64(cb.Height) / ih
	}
	if s > 1 {
		s = 1
	}
	w, h := int(iw*s), int(ih*s)
	ox, oy := (cb.Width-w)/2, (cb.Height-h)/2

	bmpKey := fmt.Sprintf("%d:%s:%d", pl.Index, kind, w)
	bmp, ok := ui.bmpCache[bmpKey]
	if !ok {
		b, err := walk.NewBitmapFromImageForDPI(img, 96)
		if err != nil {
			return nil
		}
		bmp = b
		ui.bmpCache[bmpKey] = bmp
	}
	canvas.DrawImageStretched(bmp, walk.Rectangle{X: ox, Y: oy, Width: w, Height: h})

	// 选中标记:该 id 遮罩像素包围盒中心画绿圈(包围盒不受零件中心孔影响)
	if greenPen, err := walk.NewCosmeticPen(walk.PenSolid, walk.RGB(0, 230, 118)); err == nil {
		defer greenPen.Dispose()
		for iid, on := range sel {
			if !on {
				continue
			}
			if cx, cy, hit := ui.objPixelCenter(img, iid, w, h, ox, oy); hit {
				r := 14
				canvas.DrawEllipse(greenPen, walk.Rectangle{X: cx - r, Y: cy - r, Width: 2 * r, Height: 2 * r})
			}
		}
	}
	return nil
}

func (ui *winUI) drawText(canvas *walk.Canvas, cb walk.Rectangle, text string) {
	canvas.DrawText(text, ui.mw.Font(), walk.RGB(136, 136, 136),
		walk.Rectangle{X: cb.Width/2 - 130, Y: cb.Height/2 - 10, Width: 260, Height: 20}, 0)
}

// objPixelCenter:该 id 遮罩色像素包围盒中心(包围盒不受零件中心孔影响)
func (ui *winUI) objPixelCenter(img image.Image, iid int, w, h, ox, oy int) (int, int, bool) {
	b := img.Bounds()
	iw, ih := float64(b.Dx()), float64(b.Dy())
	sx, sy := iw/float64(w), ih/float64(h)
	minx, miny, maxx, maxy, n := 0, 0, 0, 0, 0
	for dy := 0; dy < h; dy += 2 {
		for dx := 0; dx < w; dx += 2 {
			ix := b.Min.X + int(float64(dx)*sx)
			iy := b.Min.Y + int(float64(dy)*sy)
			if ix >= b.Max.X || iy >= b.Max.Y {
				continue
			}
			r, g, bl, _ := img.At(ix, iy).RGBA()
			id := int(uint8(r>>8)) + int(uint8(g>>8))*256 + int(uint8(bl>>8))*65536
			if id == iid {
				if n == 0 {
					minx, miny, maxx, maxy = dx, dy, dx, dy
				} else {
					if dx < minx {
						minx = dx
					}
					if dy < miny {
						miny = dy
					}
					if dx > maxx {
						maxx = dx
					}
					if dy > maxy {
						maxy = dy
					}
				}
				n++
			}
		}
	}
	if n == 0 {
		return 0, 0, false
	}
	return ox + (minx+maxx)/2, oy + (miny+maxy)/2, true
}

// onPlateClick:控件坐标 → 图像坐标 → 遮罩色反解 identify_id
func (ui *winUI) onPlateClick(mx, my int) {
	ui.mu.Lock()
	if ui.curPlate >= len(ui.plates) {
		ui.mu.Unlock()
		return
	}
	pl := &ui.plates[ui.curPlate]
	m := ui.images[pl.Index]
	img := m[ui.imgKind]
	if img == nil && ui.imgKind == "pick" {
		img = m["top"]
	}
	ui.mu.Unlock()
	if img == nil {
		return
	}
	cb := ui.plateCw.ClientBounds()
	iw, ih := float64(img.Bounds().Dx()), float64(img.Bounds().Dy())
	s := float64(cb.Width) / iw
	if s > float64(cb.Height)/ih {
		s = float64(cb.Height) / ih
	}
	if s > 1 {
		s = 1
	}
	w, h := int(iw*s), int(ih*s)
	ox, oy := (cb.Width-w)/2, (cb.Height-h)/2
	if mx < ox || my < oy || mx >= ox+w || my >= oy+h {
		return
	}
	b := img.Bounds()
	ix := b.Min.X + int(float64(mx-ox)/s)
	iy := b.Min.Y + int(float64(my-oy)/s)
	dec := func(x, y int) int {
		if x < b.Min.X || y < b.Min.Y || x >= b.Max.X || y >= b.Max.Y {
			return 0
		}
		r, g, bl, _ := img.At(x, y).RGBA()
		return int(uint8(r>>8)) + int(uint8(g>>8))*256 + int(uint8(bl>>8))*65536
	}
	valid := map[int]bool{}
	for _, o := range pl.Objects {
		valid[o.IdentifyID] = true
		valid[o.ObjectID] = true
	}
	iid := dec(ix, iy)
	if !valid[iid] {
		// 零件中心孔等镂空区域:环形搜索最近有效遮罩色
		best, bestD := 0, 1<<30
		for r := 3; r <= 70; r += 3 {
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
	if ui.selected[iid] {
		delete(ui.selected, iid)
	} else {
		ui.selected[iid] = true
	}
	ui.syncSelectionToListLocked()
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

func (ui *winUI) sendIDs(ids []int) {
	p := ui.currentPrinter()
	if p == nil {
		return
	}
	if err := p.SkipObjects(ids, ui.legacyCB.Checked()); err != nil {
		walk.MsgBox(ui.mw, "发送失败", err.Error(), walk.MsgBoxIconError)
		return
	}
	ui.Log(fmt.Sprintf("[+] 已发送跳过命令: %v", ids))
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

func pctText(v any) string {
	f, ok := v.(float64)
	if !ok {
		return "-"
	}
	p := int(f)
	if p < 0 || p > 100 {
		return "-"
	}
	return fmt.Sprintf("%d%%", p)
}
