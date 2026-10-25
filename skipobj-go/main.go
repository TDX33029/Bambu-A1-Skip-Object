package main

// 拓竹打印机「打印中跳过指定零件」PC 端工具(Go 重写版,单文件 exe 零运行时依赖)
// 协议逆向自 Bambu Handy,证据链见 docs/reverse-notes.md

import (
	"crypto/tls"
	"flag"
	"fmt"
	"os"
	"strings"
	"time"

	mqtt "github.com/eclipse/paho.mqtt.golang"
)

const Version = "2.0"

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

func runCLI(args []string) {
	fs := flag.NewFlagSet("cli", flag.ExitOnError)
	lan := fs.Bool("lan", false, "局域网模式(默认云端)")
	ip := fs.String("ip", "", "打印机 IP(局域网)")
	code := fs.String("code", "", "设备访问码 8 位(局域网)")
	sn := fs.String("sn", "", "打印机序列号(云端多台时必填)")
	ids := fs.String("ids", "", "要跳过的对象 ID,逗号分隔")
	testPayload := fs.String("test-payload", "", "调试:对 175 依次测试 int/string/legacy 三种格式")
	monitor := fs.String("monitor", "", "监听模式:订阅指定 SN 的 report+request 全部消息")
	legacy := fs.Bool("legacy", false, "旧协议(Studio 格式)")
	_ = fs.Parse(args)

	var creds *Creds
	if !*lan {
		c, err := LoadCreds()
		if err != nil {
			fmt.Println("[!]", err)
			fmt.Println("    或使用 --lan 局域网模式(--ip --code)")
			os.Exit(1)
		}
		creds = c
		fmt.Printf("[*] 云端模式 %s(账号 %s,区域 %s)\n", c.MQTTHost(), c.Account, c.Region)
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
		target := *sn
		if target == "" {
			target = creds.LastSN
		}
		if target == "" && len(creds.Printers) == 1 {
			for k := range creds.Printers {
				target = k
			}
		}
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

	// 等待 report 分段合并(至少收到 task_id;本地打印任务可无 task_id,8 秒后放行)
	var report map[string]any
	pushed := false
	startedAt := time.Now()
	deadline := startedAt.Add(25 * time.Second)
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
		fmt.Println("[!] 25 秒内未收到 report(打印机离线/序列号选错/代理拦截)")
		p.Disconnect()
		os.Exit(1)
	}

	// 未指定 --ids:自动列出云端任务对象(Handy 同源接口)
	if len(pending) == 0 {
		tid := asString(report["task_id"])
		if tid != "" && creds != nil {
			plates, name, err := FetchTaskObjects(tid, creds)
			if err != nil {
				fmt.Println("[!] 获取云端对象列表失败:", err)
			} else if len(plates) > 0 {
				var all []string
				for _, pl := range plates {
					for _, o := range pl.Objects {
						tag := ""
						if o.Skipped {
							tag = "[已跳过]"
						}
						all = append(all, fmt.Sprintf("%d:%s%s", o.IdentifyID, o.Name, tag))
					}
				}
				fmt.Printf("[*] 云端任务 %s《%s》对象: %v\n", tid, name, all)
				fmt.Println("[*] CLI 未指定 --ids,不发送。示例: --ids 197,175")
			}
		} else {
			fmt.Println("[*] report 无任务 ID(本地打印?)请用 3mf 或手动 --ids")
		}
	}

	if *testPayload != "" {
		runPayloadTest(p)
		p.Disconnect()
		return
	}
	if *monitor != "" {
		runMonitor(*monitor)
		return
	}

	if len(pending) > 0 {
		sentFlag := false
		deadline = time.Now().Add(30 * time.Second)
		for time.Now().Before(deadline) && !sentFlag {
			_, report = p.Report()
			state := asString(report["gcode_state"])
			fmt.Printf("[%s] %s  层 %v/%v  任务 %v  已跳过 %v\n", p.CurrentSN(),
				stateText(state),
				orDash(report["layer_num"]), orDash(report["total_layer_num"]),
				orDash(report["subtask_name"]), orDash(report["skip_objects"]))
			if state == "RUNNING" || state == "PAUSE" {
				time.Sleep(600 * time.Millisecond)
				if err := p.SkipObjects(pending, *legacy); err != nil {
					fmt.Println("[!] 发送失败:", err)
					os.Exit(1)
				}
				fmt.Printf("[+] 已发送跳过命令: %v\n", pending)
				sentFlag = true
				break
			}
			p.RequestPush()
			time.Sleep(2500 * time.Millisecond)
		}
		if !sentFlag {
			fmt.Println("[!] 30 秒内未能发送(打印机未处于打印中?)")
		} else {
			time.Sleep(9 * time.Second)   // 等待自动降级(5s)完成后再确认
			if _, rp := p.Report(); rp != nil {
				fmt.Printf("[*] 打印机当前已跳过: %v\n", orDash(rp["skip_objects"]))
			}
		}
	}
	p.Disconnect()
	fmt.Println("完成。")
}

func printerList(m map[string]string) []string {
	out := []string{}
	for k := range m {
		out = append(out, k)
	}
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
	return fmt.Sprintf("%v", v)
}


// runPayloadTest 调试:同一零件(175)用三种 payload 格式发送,观察 report 的 skip_objects 反应。
func runPayloadTest(p *Printer) {
	_, r := p.Report()
	before := asString(r["skip_objects"])
	fmt.Println("[before] skip_objects=" + before + " 状态=" + stateText(asString(r["gcode_state"])) + " 层=" + orDash(r["layer_num"]))

	tests := []struct {
		name string
		body map[string]any
	}{
		{"A 新协议 obj_list 整数", map[string]any{"command": "skip_objects", "obj_list": []int{175}}},
		{"B 新协议 obj_list 字符串", map[string]any{"command": "skip_objects", "obj_list": []string{"175"}}},
		{"C 旧协议(Studio 字符串)", map[string]any{"skip_objects": "175"}},
	}
	for _, tt := range tests {
		fmt.Println("=== 发送 " + tt.name)
		if err := p.publishPrint("print", tt.body); err != nil {
			fmt.Println("    发送失败: " + err.Error())
			continue
		}
		deadline := time.Now().Add(15 * time.Second)
		last := before
		changed := ""
		for time.Now().Before(deadline) {
			p.RequestPush()
			time.Sleep(1500 * time.Millisecond)
			if _, rr := p.Report(); rr != nil {
				cur := asString(rr["skip_objects"])
				if cur != last {
					fmt.Println("    [变化] skip_objects=" + cur + " 层=" + orDash(rr["layer_num"]) + " 状态=" + stateText(asString(rr["gcode_state"])))
					last = cur
					changed = cur
				}
			}
		}
		fmt.Println("    [结果] " + tt.name + " -> skip_objects=" + changed)
	}
	_, r = p.Report()
	fmt.Println("[after] skip_objects=" + asString(r["skip_objects"]) + " 状态=" + stateText(asString(r["gcode_state"])) + " 层=" + orDash(r["layer_num"]))
}


// runMonitor 监听模式:同时订阅 report(打印机→)与 request(→打印机)两个方向。
// 用途:在 Handy 上执行跳过时,抓取 Handy 发送的真实命令 JSON 做协议对比。
func runMonitor(sn string) {
	creds, err := LoadCreds()
	if err != nil {
		fmt.Println("[!]", err)
		os.Exit(1)
	}
	fmt.Println("[*] 监听 " + creds.MQTTHost() + "(云端 " + creds.Region + ")SN=" + sn)
	fmt.Println("[*] 请现在在手机 Handy 上执行跳过操作,所有消息将被记录…")
	c := mqtt.NewClient(mqtt.NewClientOptions().
		AddBroker("tcps://"+creds.MQTTHost()+":8883").
		SetClientID(newUUID()).
		SetUsername("u_"+creds.UserID).
		SetPassword(creds.Token).
		SetTLSConfig(&tls.Config{InsecureSkipVerify: true}).
		SetDefaultPublishHandler(func(_ mqtt.Client, m mqtt.Message) {
			ts := time.Now().Format("15:04:05.000")
			payload := string(m.Payload())
			if len(payload) > 1200 {
				payload = payload[:1200] + "…(截断)"
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
