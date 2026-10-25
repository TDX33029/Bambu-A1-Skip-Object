package main

// 打印机 MQTT 客户端(云端/局域网协议一致)。
// 逆向依据(docs/reverse-notes.md §3/§5b):
//   - 连接:tcps://host:8883,TLS 自签不校验,clientId 随机 UUID,MQTT 3.1.1
//   - 局域网:username=bblp, password=设备访问码(BblBrokerConfig.local)
//   - 云端:username=u_<user_id>, password=token(BblBrokerConfig.remote)
//   - topic:device/<SN>/report 订阅;device/<SN>/request 发布
//   - 命令组包(bhp.kt):sequence_id 从 2001 递增;云端额外带 user_id
//   - pushall 触发完整 report;report 分段推送,按字段合并

import (
	"crypto/tls"
	"encoding/json"
	"errors"
	"fmt"
	"strconv"
	"strings"
	"sync"
	"sync/atomic"
	"time"

	mqtt "github.com/eclipse/paho.mqtt.golang"
)

// TLS 自签证书不校验(Bambu 打印机/云 broker 均为自签链)
func mustInsecureTLS() *tls.Config {
	return &tls.Config{InsecureSkipVerify: true}
}

const seqStart = 2001

type Printer struct {
	Mode     string // cloud | lan
	Host     string
	Username string
	Password string
	UserID   string // 云端命令附带 user_id
	SN       string

	seq      atomic.Int64
	client   mqtt.Client
	mu       sync.Mutex
	devices  map[string]map[string]any
	linked   atomic.Bool // on_connect 已触发

	Log func(string) // 事件日志(界面),可为 nil
}

func NewPrinter() *Printer {
	p := &Printer{devices: map[string]map[string]any{}}
	p.seq.Store(seqStart)
	return p
}

func (p *Printer) logf(format string, a ...any) {
	if p.Log != nil {
		p.Log(fmt.Sprintf(format, a...))
	}
}

func (p *Printer) IsConnected() bool {
	p.mu.Lock()
	defer p.mu.Unlock()
	return p.linked.Load() && p.client != nil && p.client.IsConnectionOpen()
}

func (p *Printer) CurrentSN() string {
	if p.SN != "" {
		return p.SN
	}
	p.mu.Lock()
	defer p.mu.Unlock()
	if len(p.devices) == 0 {
		return ""
	}
	if len(p.devices) == 1 {
		for sn := range p.devices {
			return sn
		}
	}
	best, bestTs := "", float64(0)
	for sn, d := range p.devices {
		ts, _ := d["timestamp"].(float64)
		if ts >= bestTs {
			best, bestTs = sn, ts
		}
	}
	return best
}

// SetupCloud / SetupLAN 配置连接参数(BblBrokerConfig.local / remote 的等价实现)
func (p *Printer) SetupCloud(c *Creds, sn string) {
	p.Mode, p.SN = "cloud", sn
	p.Host = c.MQTTHost()
	p.Username, p.Password = "u_"+c.UserID, c.Token
	p.UserID = c.UserID
}

func (p *Printer) SetupLAN(host, accessCode, sn string) {
	p.Mode, p.SN = "lan", sn
	p.Host, p.Username, p.Password = host, "bblp", accessCode
	p.UserID = ""
}

// Connect 建立连接;OnConnect 回调(paho 网络线程)中订阅并上报成功。
func (p *Printer) Connect() error {
	opts := mqtt.NewClientOptions().
		AddBroker("tcps://" + p.Host + ":8883").
		SetClientID(newUUID()).
		SetUsername(p.Username).
		SetPassword(p.Password).
		SetTLSConfig(mustInsecureTLS()).
		SetAutoReconnect(false).
		SetConnectRetry(false).
		SetConnectTimeout(15 * time.Second).
		SetKeepAlive(60 * time.Second).
		SetOrderMatters(true)

	opts.OnConnect = func(c mqtt.Client) {
		p.linked.Store(true)
		topic := "device/+/report"
		if p.SN != "" {
			topic = "device/" + p.SN + "/report" // 云端 broker 拒绝通配订阅,必须精确
		}
		if t := c.Subscribe(topic, 0, nil); t.WaitTimeout(5*time.Second) && t.Error() != nil {
			p.logf("[错误] 订阅 %s 失败: %v", topic, t.Error())
		}
		p.logf("已连接 %s:8883(%s 模式)目标打印机:%s", p.Host, p.Mode, p.SNOrAuto())
	}
	opts.OnConnectionLost = func(_ mqtt.Client, err error) {
		p.linked.Store(false)
		p.logf("连接已断开: %v", err)
	}
	opts.DefaultPublishHandler = p.onMessage

	c := mqtt.NewClient(opts)
	tok := c.Connect()
	if !tok.WaitTimeout(25 * time.Second) {
		return errors.New("连接超时(25 秒未完成 MQTT 握手;若开着代理请把 *.bambulab.com 加入直连规则,或改用局域网模式)")
	}
	if err := tok.Error(); err != nil {
		return fmt.Errorf("MQTT 认证被拒绝: %v", err)
	}
	p.client = c
	return nil
}

func (p *Printer) SNOrAuto() string {
	if p.SN != "" {
		return p.SN
	}
	return "(待发现)"
}

// Disconnect 立即返回;后台 goroutine 强拆(paho 在半死连接上可能阻塞,不能在调用方等待)。
func (p *Printer) Disconnect() {
	p.mu.Lock()
	c := p.client
	p.client = nil
	p.mu.Unlock()
	p.linked.Store(false)
	if c == nil {
		return
	}
	go func() {
		defer func() { _ = recover() }()
		c.Disconnect(100)
	}()
}

func (p *Printer) onMessage(_ mqtt.Client, m mqtt.Message) {
	parts := strings.Split(m.Topic(), "/")
	if len(parts) < 3 {
		return
	}
	sn := parts[1]
	var top map[string]any
	if err := json.Unmarshal(m.Payload(), &top); err != nil {
		return
	}
	prt, ok := top["print"].(map[string]any)
	if !ok {
		return
	}
	p.mu.Lock()
	cur := p.devices[sn]
	if cur == nil {
		cur = map[string]any{}
		p.devices[sn] = cur
	}
	for k, v := range prt { // 分段推送:按字段合并
		cur[k] = v
	}
	merged := cur
	p.mu.Unlock()

	if p.SN == "" && p.Mode == "lan" {
		p.SN = sn
	}
	p.logf("收到打印机 report(状态 %s,字段 %d 项)", stateText(asString(merged["gcode_state"])), len(prt))
}

func (p *Printer) Report() (string, map[string]any) {
	sn := p.CurrentSN()
	p.mu.Lock()
	defer p.mu.Unlock()
	if sn == "" {
		return "", nil
	}
	return sn, p.devices[sn]
}

// publishPrint 组包并发布(等价 bhp.kt 的 a())
func (p *Printer) publishPrint(category string, body map[string]any) error {
	if !p.IsConnected() {
		return errors.New("未连接打印机")
	}
	sn := p.CurrentSN()
	if sn == "" {
		return errors.New("尚未发现打印机(等待 report 或手动指定序列号)")
	}
	seq := p.seq.Add(1)
	body["sequence_id"] = strconv.FormatInt(seq, 10)
	if _, ok := body["timestamp"]; !ok {
		body["timestamp"] = time.Now().UnixMilli()
	}
	root := map[string]any{}
	if p.UserID != "" {
		root["user_id"] = p.UserID // 云端模式(逆向 bhp.kt:userId 非空时附加)
	}
	root[category] = body
	raw, err := json.Marshal(root)
	if err != nil {
		return err
	}
	topic := "device/" + sn + "/request"
	tok := p.client.Publish(topic, 0, false, raw)
	if !tok.WaitTimeout(5 * time.Second) {
		return errors.New("发布超时")
	}
	if err := tok.Error(); err != nil {
		return err
	}
	p.logf(">>> %s\n    %s", topic, string(raw))
	return nil
}

// SkipObjects 跳过指定零件。
// 新协议(Handy):{"print":{"command":"skip_objects","obj_list":[...],...}}
// 旧协议(Studio):{"print":{"skip_objects":"1,2",...}}
func (p *Printer) SkipObjects(ids []int, legacy bool) error {
	clean := ids[:0:0]
	seen := map[int]bool{}
	for _, id := range ids {
		if id != 0 && !seen[id] {
			seen[id] = true
			clean = append(clean, id)
		}
	}
	if len(clean) == 0 {
		return errors.New("未选择任何对象")
	}
	if legacy {
		ss := make([]string, len(clean))
		for i, id := range clean {
			ss[i] = strconv.Itoa(id)
		}
		return p.publishPrint("print", map[string]any{"skip_objects": strings.Join(ss, ",")})
	}
	return p.publishPrint("print", map[string]any{"command": "skip_objects", "obj_list": clean})
}

// RequestPush 请求打印机推送完整 report(社区通用 pushall 命令)
func (p *Printer) RequestPush() {
	if !p.IsConnected() {
		return
	}
	sn := p.CurrentSN()
	if sn == "" {
		return
	}
	seq := p.seq.Add(1)
	body := map[string]any{"sequence_id": strconv.FormatInt(seq, 10), "command": "pushall"}
	raw, _ := json.Marshal(map[string]any{"pushing": body})
	_ = p.client.Publish("device/"+sn+"/request", 0, false, raw).Error()
}

func asString(v any) string {
	if s, ok := v.(string); ok {
		return s
	}
	return ""
}

var stateTexts = map[string]string{
	"IDLE": "空闲", "RUNNING": "打印中", "PAUSE": "已暂停", "FINISH": "已完成",
	"FAILED": "已失败", "SLICING": "切片中", "SYSLAYER": "首层扫描",
	"PREPARE": "准备中", "CHANGE_FILAMENT": "换料中", "M600_PAUSE": "换料暂停",
	"HAIR_LINE": "调平扫线", "SKIRT": "打印裙边",
}

func stateText(s string) string {
	if t, ok := stateTexts[s]; ok {
		return t
	}
	if s == "" {
		return "-"
	}
	return s
}
