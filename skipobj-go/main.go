package main

// 拓竹打印机「打印中跳过指定零件」PC 端工具(Go 重写版,单文件 exe 零运行时依赖)
// 协议逆向自 Bambu Handy,证据链见 docs/reverse-notes.md

import (
	"crypto/tls"
	"encoding/json"
	"flag"
	"fmt"
	"os"
	"sort"
	"strings"
	"time"

	mqtt "github.com/eclipse/paho.mqtt.golang"
)

const Version = "2.1"

func main() {
	if len(os.Args) > 1 && (os.Args[1] == "--cli" || os.Args[1] == "cli") {
		runCLI(os.Args[2:])
		return
	}
	if len(os.Args) > 1 && os.Args[1] == "--monitor" {
		fs := flag.NewFlagSet("monitor", flag.ExitOnError)
		_ = fs.Parse(os.Args[2:])
		runMonitor(fs.Arg(0))
		return
	}
	web := flag.Bool("web", false, "使用本机 Web 界面(默认原生窗口)")
	addr := flag.String("addr", "127.0.0.1:8974", "本地 UI 监听地址(--web 时)")
	noOpen := flag.Bool("no-browser", false, "不自动打开浏览器(--web 时)")
	flag.Parse()
	if *web {
		RunWebUI(*addr, !*noOpen)
		return
	}
	runUI()
}

func loadCredsOrExit(lan bool) *Creds {
	if lan {
		return nil
	}
	c, err := LoadCreds()
	if err != nil {
		fmt.Println("[!]", err)
		fmt.Println("    或使用 --lan 局域网模式(--ip --code)")
		os.Exit(1)
	}
	fmt.Printf("[*] 云端模式 %s(账号 %s,区域 %s)\n", c.MQTTHost(), c.Account, c.Region)
	return c
}

func pickSN(creds *Creds, sn string) string {
	if sn != "" {
		return sn
	}
	if creds == nil {
		return ""
	}
	if creds.LastSN != "" {
		return creds.LastSN
	}
	if len(creds.Printers) == 1 {
		for k := range creds.Printers {
			return k
		}
	}
	return ""
}

func runCLI(args []string) {
	fs := flag.NewFlagSet("cli", flag.ExitOnError)
	lan := fs.Bool("lan", false, "局域网模式(默认云端)")
	ip := fs.String("ip", "", "打印机 IP(局域网)")
	code := fs.String("code", "", "设备访问码 8 位(局域网)")
	sn := fs.String("sn", "", "打印机序列号(云端多台时必填)")
	ids := fs.String("ids", "", "要跳过的对象 ID,逗号分隔")
	dump := fs.Bool("dump", false, "打印完整 report(诊断)")
	list := fs.Bool("list", false, "只列出当前任务零件,不发送")
	certOnly := fs.Bool("cert", false, "只申请云端签名证书(打印 cert_id 等信息)")
	installCert := fs.Bool("install-cert", false, "申请证书并安装到打印机(不跳过零件)")
	probe := fs.Bool("probe", false, "诊断:查询已装证书,并对比签名/未签名 pause 命令的应答")
	timeout := fs.Int("timeout", 40, "等待打印状态的最长秒数")
	_ = fs.Parse(args)

	creds := loadCredsOrExit(*lan)

	if *certOnly {
		ac, err := fetchAppCert(creds, func(f string, a ...any) { fmt.Printf("    "+f+"\n", a...) })
		if err != nil {
			fmt.Println("[!] 证书申请失败:", err)
			os.Exit(1)
		}
		fmt.Println("[+] 证书申请成功")
		fmt.Println("    cert_id:", ac.CertID)
		fmt.Println("    issuer :", ac.Issuer, " serial:", ac.Serial)
		fmt.Println("    私钥   :", ac.Key.PublicKey.N.BitLen(), "bit, CRL", len(ac.CRL), "字节")
		return
	}

	p := NewPrinter()
	p.Log = func(s string) { fmt.Println("   ", s) }

	if *lan {
		if *ip == "" || *code == "" {
			fmt.Println("局域网模式需要 --ip 和 --code(打印机屏幕:设置→无线→局域网)")
			os.Exit(1)
		}
		p.SetupLAN(*ip, *code, *sn)
		fmt.Printf("[*] 局域网模式 %s:8883 (bblp)\n", *ip)
	} else {
		target := pickSN(creds, *sn)
		if target == "" {
			fmt.Println("无法确定打印机序列号,请用 --sn 指定。已知:", strings.Join(printerList(creds.Printers), ", "))
			os.Exit(1)
		}
		p.SetupCloud(creds, target)
		fmt.Println("[*] 目标打印机:", target)
	}

	var pending []int
	for _, tok := range strings.FieldsFunc(*ids, func(r rune) bool { return r == ',' || r == ' ' }) {
		var n int
		if _, err := fmt.Sscanf(tok, "%d", &n); err == nil && n > 0 {
			pending = append(pending, n)
		}
	}

	if err := p.Connect(); err != nil {
		fmt.Println("[!] 连接失败:", err)
		os.Exit(1)
	}
	fmt.Println("[+] MQTT 已连接,等待 report …")
	if *installCert {
		if err := p.EnsureCertInstalled(); err != nil {
			fmt.Println("[!] 安装证书失败:", err)
			os.Exit(1)
		}
		ac, _ := p.ensureAppCert()
		if ac != nil {
			fmt.Println("[+] 证书已安装:", ac.CertID)
		}
		return
	}
	if *probe {
		if err := p.EnsureCertInstalled(); err != nil {
			fmt.Println("[!] 准备签名证书失败:", err)
			os.Exit(1)
		}
		p.publishSecurity(map[string]any{"command": "app_cert_list", "app": "app"}, 1)
		time.Sleep(2 * time.Second)
		_, rep := p.Report()
		if sec, ok := rep["security"]; ok {
			b, _ := json.Marshal(sec)
			fmt.Println("[*] security 上报:", string(b))
		} else {
			fmt.Println("[*] report 中没有 security 字段(app_cert_list 可能无应答)")
		}
		if seqS, err := p.publishPrint("print", map[string]any{"command": "pause"}, 1); err != nil {
			fmt.Println("[!] 发送签名命令失败:", err)
		} else if ack := p.WaitAck(seqS, 6*time.Second); ack != nil {
			fmt.Println("[签名] pause ->", ackSummary(*ack))
			fmt.Println("        raw:", elide(ack.Raw, 400))
		} else {
			fmt.Println("[签名] pause -> 6 秒无应答")
		}
		time.Sleep(time.Second)
		if seqU, err := p.publish("print", map[string]any{"command": "pause"}, 1, false); err != nil {
			fmt.Println("[!] 发送未签名命令失败:", err)
		} else if ack := p.WaitAck(seqU, 6*time.Second); ack != nil {
			fmt.Println("[未签名] pause ->", ackSummary(*ack))
			fmt.Println("        raw:", elide(ack.Raw, 400))
		} else {
			fmt.Println("[未签名] pause -> 6 秒无应答")
		}
		return
	}

	// 等待 report 分段合并(至少收到 task_id;本地打印任务可无 task_id,8 秒后放行)
	var report map[string]any
	pushed := false
	startedAt := time.Now()
	deadline := startedAt.Add(time.Duration(*timeout) * time.Second)
	for time.Now().Before(deadline) {
		if _, report = p.Report(); report != nil {
			if asString(report["task_id"]) != "" || time.Since(startedAt) > 8*time.Second {
				break
			}
		}
		if !pushed {
			p.RequestPush()
			pushed = true
		}
		time.Sleep(700 * time.Millisecond)
	}
	if report == nil {
		fmt.Println("[!] 未收到 report(打印机离线/序列号选错/代理拦截)")
		p.Disconnect()
		os.Exit(1)
	}
	p.RequestPush()
	time.Sleep(800 * time.Millisecond)
	_, report = p.Report()

	printStatus := func(r map[string]any) {
		fmt.Printf("[%s] %s  层 %v/%v  进度 %v%%  任务 %v  已跳过 %v\n", p.CurrentSN(),
			stateText(asString(r["gcode_state"])),
			orDash(r["layer_num"]), orDash(r["total_layer_num"]), pctText(r["mc_percent"]),
			orDash(r["subtask_name"]), orDash(skippedIDList(r)))
		for _, n := range HMSNotices(r) {
			fmt.Println("    [HMS]", n)
		}
	}
	printStatus(report)

	if *dump {
		b, _ := json.MarshalIndent(report, "", "  ")
		fmt.Println(string(b))
	}

	// 对象列表(云端任务接口,Handy 同源)
	if len(pending) == 0 || *list {
		tid := validTaskID(report)
		if tid != "" && creds != nil {
			plates, name, err := FetchTaskObjects(tid, creds)
			if err != nil {
				fmt.Println("[!] 获取云端对象列表失败:", err)
			} else if len(plates) > 0 {
				fmt.Printf("[*] 云端任务 %s《%s》对象:\n", tid, name)
				for _, pl := range plates {
					for _, o := range pl.Objects {
						tag := ""
						if o.Skipped {
							tag = " [已跳过]"
						}
						fmt.Printf("    盘%d  #%d  %s%s\n", pl.Index, o.IdentifyID, o.Name, tag)
					}
				}
			}
		} else {
			fmt.Println("[*] report 无任务 ID(本地打印?)请用 3mf 或手动 --ids")
		}
	}
	if *list || len(pending) == 0 {
		p.Disconnect()
		return
	}

	res, err := p.SkipObjects(pending)
	if err != nil {
		fmt.Println("[!] 未发送:", err)
		p.Disconnect()
		os.Exit(1)
	}
	if res.Accepted {
		fmt.Printf("[+] 跳过成功(%s):%v —— %s\n", res.Variant, res.IDs, res.Note)
	} else {
		fmt.Printf("[!] 跳过失败(%s):%s\n", res.Variant, res.Note)
		if res.Ack != nil {
			fmt.Printf("    打印机应答:%s\n", res.Ack.Raw)
		}
	}
	time.Sleep(1500 * time.Millisecond)
	if _, r := p.Report(); r != nil {
		fmt.Printf("[*] 打印机当前已跳过: %v\n", orDash(skippedIDList(r)))
	}
	p.Disconnect()
}

func printerList(m map[string]string) []string {
	out := []string{}
	for k := range m {
		out = append(out, k)
	}
	sort.Strings(out)
	return out
}

func orDash(v any) string {
	if v == nil {
		return "-"
	}
	if s, ok := v.(string); ok {
		if s == "" {
			return "-"
		}
		return s
	}
	if f, ok := v.(float64); ok {
		return fmt.Sprintf("%v", int64(f))
	}
	if a, ok := v.([]int); ok {
		if len(a) == 0 {
			return "-"
		}
		ss := make([]string, len(a))
		for i, n := range a {
			ss[i] = fmt.Sprint(n)
		}
		return strings.Join(ss, ",")
	}
	return fmt.Sprintf("%v", v)
}

// runMonitor 监听模式:同时订阅 report 与 request。
// 用途:对比官方客户端(Handy/Studio)发出的报文,尤其是 header 签名部分。
func runMonitor(sn string) {
	creds, err := LoadCreds()
	if err != nil {
		fmt.Println("[!]", err)
		os.Exit(1)
	}
	if sn == "" {
		sn = pickSN(creds, "")
	}
	fmt.Println("[*] 监听 " + creds.MQTTHost() + "(云端 " + creds.Region + ")SN=" + sn)
	fmt.Println("[*] 现在在 Handy/Studio 上执行操作,所有报文将被记录…")
	c := mqtt.NewClient(mqtt.NewClientOptions().
		AddBroker("tcps://" + creds.MQTTHost() + ":8883").
		SetClientID(newUUID()).
		SetUsername("u_" + creds.UserID).
		SetPassword(creds.Token).
		SetTLSConfig(&tls.Config{InsecureSkipVerify: true}).
		SetDefaultPublishHandler(func(_ mqtt.Client, m mqtt.Message) {
			ts := time.Now().Format("15:04:05.000")
			payload := string(m.Payload())
			if len(payload) > 4000 {
				payload = payload[:4000] + "…(截断)"
			}
			fmt.Printf("[%s] %s\n    %s\n", ts, m.Topic(), payload)
		}))
	tok := c.Connect()
	if !tok.WaitTimeout(20*time.Second) || tok.Error() != nil {
		fmt.Println("[!] 连接失败")
		os.Exit(1)
	}
	for _, topic := range []string{"device/" + sn + "/report", "device/" + sn + "/request"} {
		t := c.Subscribe(topic, 0, nil)
		t.WaitTimeout(5 * time.Second)
		fmt.Println("[+] 订阅 " + topic)
	}
	fmt.Println("[*] 监听中,Ctrl+C 退出")
	select {}
}
