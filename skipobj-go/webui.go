package main

// 本机 Web UI:Go 标准库 HTTP + 内嵌单页前端(零 CGO/GUI 依赖)。
// 后端持有 MQTT 会话与数据,前端轮询状态、POST 命令;俯视图遮罩
// 的"点图选零件"在前端 canvas 完成(像素→identify_id 反解,逆向 b1v.i)。

import (
	"embed"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"os"
	"os/exec"
	"runtime"
	"sort"
	"strings"
	"sync"
	"time"
)

//go:embed web/index.html
var webFS embed.FS

type LogLine struct {
	Seq  int64  `json:"seq"`
	Time string `json:"time"`
	Text string `json:"text"`
}

type App struct {
	mu        sync.Mutex
	printer   *Printer
	creds     *Creds
	credsErr  string
	plates    []Plate
	logSeq    int64
	logs      []LogLine
	lastError string
}

var app = &App{}

func (a *App) AddLog(format string, args ...any) {
	a.mu.Lock()
	defer a.mu.Unlock()
	a.logSeq++
	a.logs = append(a.logs, LogLine{
		Seq:  a.logSeq,
		Time: time.Now().Format("15:04:05"),
		Text: fmt.Sprintf(format, args...),
	})
	if len(a.logs) > 600 {
		a.logs = a.logs[len(a.logs)-500:]
	}
}

func (a *App) SetError(msg string) {
	a.mu.Lock()
	a.lastError = msg
	a.mu.Unlock()
	a.AddLog("[错误] %s", msg)
}

func sortSNs(m map[string]string) []string {
	out := make([]string, 0, len(m))
	for sn := range m {
		out = append(out, sn)
	}
	sort.Strings(out)
	return out
}

// ---- handlers ----

func handleState(w http.ResponseWriter, _ *http.Request) {
	app.mu.Lock()
	defer app.mu.Unlock()
	st := map[string]any{
		"version": Version,
		"error":   app.lastError,
	}
	if app.creds != nil {
		st["creds"] = map[string]any{
			"ok":       true,
			"account":  app.creds.Account,
			"region":   strings.ToUpper(app.creds.Region),
			"printers": sortSNs(app.creds.Printers),
			"last_sn":  app.creds.LastSN,
		}
	} else {
		st["creds"] = map[string]any{"ok": false, "message": app.credsErr}
	}
	if p := app.printer; p != nil {
		sn, report := p.Report()
		st["connected"] = p.IsConnected()
		st["mode"] = p.Mode
		st["sn"] = sn
		st["report"] = report
	} else {
		st["connected"] = false
	}
	plates := make([]map[string]any, 0, len(app.plates))
	for _, pl := range app.plates {
		plates = append(plates, map[string]any{
			"index":   pl.Index,
			"name":    pl.Name,
			"source":  pl.Source,
			"objects": pl.Objects,
			"has_pick": pl.HasPick,
			"has_top":  pl.HasTop,
		})
	}
	st["plates"] = plates
	w.Header().Set("Content-Type", "application/json")
	_ = json.NewEncoder(w).Encode(st)
}

func handleLogs(w http.ResponseWriter, r *http.Request) {
	since := int64(0)
	fmt.Sscanf(r.URL.Query().Get("since"), "%d", &since)
	app.mu.Lock()
	defer app.mu.Unlock()
	out := []LogLine{}
	for _, l := range app.logs {
		if l.Seq > since {
			out = append(out, l)
		}
	}
	w.Header().Set("Content-Type", "application/json")
	_ = json.NewEncoder(w).Encode(map[string]any{"seq": app.logSeq, "lines": out})
}

func handleImg(w http.ResponseWriter, r *http.Request) {
	var idx, useTop int
	fmt.Sscanf(r.URL.Query().Get("i"), "%d", &idx)
	if r.URL.Query().Get("k") == "top" {
		useTop = 1
	}
	app.mu.Lock()
	defer app.mu.Unlock()
	for _, pl := range app.plates {
		if pl.Index == idx {
			data := pl.PickPNG
			if useTop == 1 {
				data = pl.TopPNG
			}
			if len(data) > 0 {
				w.Header().Set("Content-Type", "image/png")
				_, _ = w.Write(data)
			} else {
				http.NotFound(w, r)
			}
			return
		}
	}
	http.NotFound(w, r)
}

func handleConnect(w http.ResponseWriter, r *http.Request) {
	var req struct {
		Mode string `json:"mode"`
		SN   string `json:"sn"`
		IP   string `json:"ip"`
		Code string `json:"code"`
	}
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, err.Error(), 400)
		return
	}
	app.mu.Lock()
	defer app.mu.Unlock()
	if app.printer != nil && app.printer.IsConnected() {
		app.printer.Disconnect()
	}
	p := NewPrinter()
	p.Log = func(s string) { app.AddLog("%s", s) }
	if app.creds != nil && req.Mode != "lan" {
		if req.SN == "" {
			http.Error(w, "请选择打印机序列号", 400)
			return
		}
		p.SetupCloud(app.creds, req.SN)
	} else {
		if req.IP == "" || req.Code == "" {
			http.Error(w, "请填写打印机 IP 和 8 位访问码", 400)
			return
		}
		p.SetupLAN(strings.TrimSpace(req.IP), strings.TrimSpace(req.Code), req.SN)
	}
	app.printer = p
	app.lastError = ""
	go func() {
		app.AddLog("正在连接 %s:8883 …", p.Host)
		if err := p.Connect(); err != nil {
			app.SetError(err.Error())
		}
	}()
	w.WriteHeader(200)
}

func handleDisconnect(w http.ResponseWriter, _ *http.Request) {
	app.mu.Lock()
	p := app.printer
	app.mu.Unlock()
	if p != nil {
		p.Disconnect()
		app.AddLog("已请求断开连接")
	}
	w.WriteHeader(200)
}

func handleFetch(w http.ResponseWriter, _ *http.Request) {
	app.mu.Lock()
	p := app.printer
	creds := app.creds
	app.mu.Unlock()
	if p == nil || creds == nil {
		http.Error(w, "需要云端凭证与已连接的打印机", 400)
		return
	}
	_, report := p.Report()
	if report == nil {
		http.Error(w, "尚未收到打印机 report", 400)
		return
	}
	taskID := asString(report["task_id"])
	if taskID == "" {
		http.Error(w, "report 中没有任务 ID(需云端任务;本地 SD 打印请上传切片 3mf)", 400)
		return
	}
	plates, name, err := FetchTaskObjects(taskID, creds)
	if err != nil {
		app.SetError("获取云端任务失败: " + err.Error())
		http.Error(w, err.Error(), 500)
		return
	}
	app.mu.Lock()
	app.plates = plates
	app.mu.Unlock()
	app.AddLog("已获取任务 %s《%s》对象列表(%d 盘,%d 零件)",
		taskID, name, len(plates), countObjects(plates))
	w.WriteHeader(200)
}

func handleUpload3mf(w http.ResponseWriter, r *http.Request) {
	if err := r.ParseMultipartForm(256 << 20); err != nil {
		http.Error(w, err.Error(), 400)
		return
	}
	f, _, err := r.FormFile("file")
	if err != nil {
		http.Error(w, err.Error(), 400)
		return
	}
	defer f.Close()
	tmp, err := os.CreateTemp("", "bbl-*.3mf")
	if err != nil {
		http.Error(w, err.Error(), 500)
		return
	}
	tmpPath := tmp.Name()
	defer os.Remove(tmpPath)
	if _, err = io.Copy(tmp, f); err != nil {
		tmp.Close()
		http.Error(w, err.Error(), 500)
		return
	}
	tmp.Close()
	plates, err := Parse3MF(tmpPath)
	if err != nil {
		app.SetError("3mf 解析失败: " + err.Error())
		http.Error(w, err.Error(), 400)
		return
	}
	app.mu.Lock()
	app.plates = plates
	app.mu.Unlock()
	app.AddLog("已加载 3mf(%d 盘,%d 零件,来源: 切片文件)", len(plates), countObjects(plates))
	w.WriteHeader(200)
}

func handleSkip(w http.ResponseWriter, r *http.Request) {
	var req struct {
		IDs    []int `json:"ids"`
		Legacy bool  `json:"legacy"`
	}
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, err.Error(), 400)
		return
	}
	app.mu.Lock()
	p := app.printer
	app.mu.Unlock()
	if p == nil {
		http.Error(w, "未连接打印机", 400)
		return
	}
	if err := p.SkipObjects(req.IDs, req.Legacy); err != nil {
		app.SetError("发送失败: " + err.Error())
		http.Error(w, err.Error(), 400)
		return
	}
	w.WriteHeader(200)
}

func countObjects(plates []Plate) int {
	n := 0
	for _, p := range plates {
		n += len(p.Objects)
	}
	return n
}

// ---- server ----

func RunWebUI(addr string, openBrowser bool) {
	app.mu.Lock()
	c, err := LoadCreds()
	if err != nil {
		app.creds, app.credsErr = nil, err.Error()
	} else {
		app.creds, app.credsErr = c, ""
	}
	app.mu.Unlock()

	http.HandleFunc("/", func(w http.ResponseWriter, _ *http.Request) {
		data, _ := webFS.ReadFile("web/index.html")
		w.Header().Set("Content-Type", "text/html; charset=utf-8")
		_, _ = w.Write(data)
	})
	http.HandleFunc("/api/state", handleState)
	http.HandleFunc("/api/logs", handleLogs)
	http.HandleFunc("/api/img", handleImg)
	http.HandleFunc("/api/connect", handleConnect)
	http.HandleFunc("/api/disconnect", handleDisconnect)
	http.HandleFunc("/api/fetch", handleFetch)
	http.HandleFunc("/api/3mf", handleUpload3mf)
	http.HandleFunc("/api/skip", handleSkip)

	url := "http://" + addr
	app.AddLog("跳过对象工具 v%s (Go) — %s", Version, url)
	if app.creds != nil {
		app.AddLog("凭证: 已从 Bambu Studio 读取(账号 %s,区域 %s,打印机 %d 台)",
			app.creds.Account, strings.ToUpper(app.creds.Region), len(app.creds.Printers))
	} else {
		app.AddLog("凭证: %s(可使用局域网模式:打印机 IP + 访问码)", app.credsErr)
	}

	if openBrowser {
		go func() {
			time.Sleep(600 * time.Millisecond)
			var cmd *exec.Cmd
			if runtime.GOOS == "windows" {
				cmd = exec.Command("rundll32", "url.dll,FileProtocolHandler", url)
			} else if runtime.GOOS == "darwin" {
				cmd = exec.Command("open", url)
			} else {
				cmd = exec.Command("xdg-open", url)
			}
			_ = cmd.Start()
		}()
	}

	// 周期 pushall 触发完整 report(打印机自身只推小分段;CLI 版同款逻辑)
	go func() {
		pushedOnce := false
		for {
			time.Sleep(3 * time.Second)
			app.mu.Lock()
			p := app.printer
			app.mu.Unlock()
			if p == nil || !p.IsConnected() {
				pushedOnce = false
				continue
			}
			p.RequestPush()
			if !pushedOnce {
				pushedOnce = true
				app.AddLog("已请求打印机上报完整状态(pushall)…")
			}
		}
	}()

	app.AddLog("步骤:连接 →(打印中)从云端任务获取零件 → 勾选/点图选择 → 跳过选中零件")
	if err := http.ListenAndServe(addr, nil); err != nil {
		fmt.Fprintln(os.Stderr, "HTTP 服务失败:", err)
		app.AddLog("[错误] HTTP 服务失败: %v", err)
		time.Sleep(3 * time.Second)
		os.Exit(1)
	}
}
