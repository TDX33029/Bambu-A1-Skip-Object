package main

// 打印机 MQTT 客户端(云端/局域网协议一致)。
// 逆向依据(docs/reverse-notes.md §3/§5b):
//   - 连接:tcps://host:8883,TLS 自签不校验,clientId 随机 UUID,MQTT 3.1.1
//   - 局域网:username=bblp, password=设备访问码(BblBrokerConfig.local)
//   - 云端:username=u_<user_id>, password=token(BblBrokerConfig.remote)
//   - topic:device/<SN>/report 订阅;device/<SN>/request 发布
//   - 命令组包(bhp.kt):sequence_id 从 2001 递增;云端额外带 user_id
//   - pushall 触发完整 report;report 分段推送,按字段合并
//
// 打印机对「控制类」命令(print 分类)会做固件级校验:不通过时在 report 回显
// 原命令并附 err_code,同时上报 HMS 0500_0500_0001_0007「MQTT 命令校验失败」。
// 因此本文件把 report 分成两类处理:
//   - 状态推送(push_status / 纯增量字段)→ 合并进状态快照
//   - 命令应答(带 command + err_code/result/reason)→ 单独记录,绝不混入状态
// 旧实现把应答也合并进状态,导致把「被拒绝的回显」误判为「已跳过」。

import (
	"crypto/tls"
	"encoding/json"
	"errors"
	"fmt"
	"sort"
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

// Ack 打印机对一条请求命令的应答(固件在 report 主题回显)
type Ack struct {
	Command string
	Seq     string
	ErrCode int
	Result  string
	Reason  string
	Raw     string
	At      time.Time
}

func (a Ack) Failed() bool {
	return a.ErrCode != 0 || strings.EqualFold(a.Result, "fail") || strings.EqualFold(a.Result, "failed")
}

// SkipResult 跳过命令的执行结果(由打印机应答判定,不看本地猜测)
type SkipResult struct {
	Accepted bool
	Variant  string
	Seq      string
	Ack      *Ack
	Note     string
	IDs      []int
}

type Printer struct {
	Mode     string // cloud | lan
	Host     string
	Username string
	Password string
	UserID   string // 云端命令附带 user_id
	SN       string // 目标序列号(空 = 局域网自动发现)

	seq     atomic.Int64
	client  mqtt.Client
	mu      sync.Mutex
	devices map[string]map[string]any
	acks    map[string]Ack
	lastAck Ack
	hasAck  bool
	linked  atomic.Bool // on_connect 已触发

	Log    func(string) // 事件日志(界面),可为 nil
	rawMu  sync.Mutex
	rawLog func(string) // 原始报文(调试),可为 nil

	// 云端 App 证书(命令签名用);cred 仅云端模式持有
	cred          *Creds
	certMu        sync.Mutex
	cert          *appCert
	certInstalled string // 已安装到本机打印机的 cert_id(连接内缓存)

	lastStatusLog time.Time
}

func NewPrinter() *Printer {
	p := &Printer{devices: map[string]map[string]any{}, acks: map[string]Ack{}}
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

func (p *Printer) clientOrNil() mqtt.Client {
	p.mu.Lock()
	defer p.mu.Unlock()
	return p.client
}

// CurrentSN 目标序列号;局域网未指定时取最近上报的设备
func (p *Printer) CurrentSN() string {
	p.mu.Lock()
	defer p.mu.Unlock()
	return p.currentSNLocked()
}

func (p *Printer) currentSNLocked() string {
	if p.SN != "" {
		return p.SN
	}
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
	p.cred = c
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
		p.mu.Lock()
		p.linked.Store(true)
		topic := "device/+/report"
		if p.SN != "" {
			topic = "device/" + p.SN + "/report" // 云端 broker 拒绝通配订阅,必须精确
		}
		sn := p.SN
		p.mu.Unlock()
		if t := c.Subscribe(topic, 0, nil); t.WaitTimeout(5*time.Second) && t.Error() != nil {
			p.logf("[错误] 订阅 %s 失败: %v", topic, t.Error())
		}
		if sn == "" {
			sn = "(待发现)"
		}
		p.logf("已连接 %s:8883(%s 模式)目标打印机:%s", p.Host, p.Mode, sn)
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
	p.mu.Lock()
	p.client = c
	p.mu.Unlock()
	return nil
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

// isAck 是否为命令应答(而不是状态推送)
func isAck(prt map[string]any) bool {
	cmd := asString(prt["command"])
	if cmd == "" || cmd == "push_status" {
		return false
	}
	if _, ok := prt["err_code"]; ok {
		return true
	}
	if _, ok := prt["result"]; ok {
		return true
	}
	_, ok := prt["reason"]
	return ok
}

func (p *Printer) parseAck(prt map[string]any) Ack {
	a := Ack{
		Command: asString(prt["command"]),
		Seq:     asString(prt["sequence_id"]),
		Result:  asString(prt["result"]),
		Reason:  asString(prt["reason"]),
		At:      time.Now(),
	}
	switch v := prt["err_code"].(type) {
	case float64:
		a.ErrCode = int(v)
	case string:
		a.ErrCode, _ = strconv.Atoi(v)
	}
	if raw, err := json.Marshal(prt); err == nil {
		a.Raw = string(raw)
	}
	return a
}

// SetRawLog 设置原始报文回调(nil 关闭)。回调可能在 MQTT 线程执行。
func (p *Printer) SetRawLog(fn func(string)) {
	p.rawMu.Lock()
	p.rawLog = fn
	p.rawMu.Unlock()
}

func (p *Printer) emitRaw(s string) {
	p.rawMu.Lock()
	fn := p.rawLog
	p.rawMu.Unlock()
	if fn != nil {
		fn(s)
	}
}

func (p *Printer) onMessage(_ mqtt.Client, m mqtt.Message) {
	p.emitRaw(string(m.Payload()))
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

	if isAck(prt) {
		ack := p.parseAck(prt)
		p.mu.Lock()
		if ack.Seq != "" {
			p.acks[ack.Seq] = ack
		}
		p.lastAck, p.hasAck = ack, true
		if p.SN == "" && p.Mode == "lan" {
			p.SN = sn
		}
		p.mu.Unlock()
		p.logf("[命令应答] %s seq=%s %s", ack.Command, ack.Seq, ackSummary(ack))
		return
	}

	p.mu.Lock()
	if p.SN == "" && p.Mode == "lan" {
		p.SN = sn
	}
	cur := p.devices[sn]
	if cur == nil {
		cur = map[string]any{}
		p.devices[sn] = cur
	}
	for k, v := range prt { // 分段推送:按字段合并
		cur[k] = v
	}
	state := asString(cur["gcode_state"])
	n := len(prt)
	quiet := time.Since(p.lastStatusLog) < 10*time.Second
	if !quiet {
		p.lastStatusLog = time.Now()
	}
	p.mu.Unlock()
	if !quiet {
		p.logf("收到打印机 report(状态 %s,字段 %d 项)", stateText(state), n)
	}
}

// Report 返回状态快照(深拷贝,避免调用方遍历时被 MQTT 线程并发写入)
func (p *Printer) Report() (string, map[string]any) {
	p.mu.Lock()
	defer p.mu.Unlock()
	sn := p.currentSNLocked()
	if sn == "" {
		return "", nil
	}
	return sn, cloneMap(p.devices[sn])
}

func cloneMap(m map[string]any) map[string]any {
	if m == nil {
		return nil
	}
	out := make(map[string]any, len(m))
	for k, v := range m {
		out[k] = cloneValue(v)
	}
	return out
}

func cloneValue(v any) any {
	switch x := v.(type) {
	case map[string]any:
		return cloneMap(x)
	case []any:
		out := make([]any, len(x))
		for i, it := range x {
			out[i] = cloneValue(it)
		}
		return out
	default:
		return v
	}
}

// WaitAck 等待指定 sequence_id 的应答;超时返回 nil
func (p *Printer) WaitAck(seq string, timeout time.Duration) *Ack {
	deadline := time.Now().Add(timeout)
	for {
		p.mu.Lock()
		if a, ok := p.acks[seq]; ok {
			delete(p.acks, seq)
			p.mu.Unlock()
			return &a
		}
		p.mu.Unlock()
		if time.Now().After(deadline) {
			return nil
		}
		time.Sleep(100 * time.Millisecond)
	}
}

// LastAck 最近一条命令应答(UI 展示)
func (p *Printer) LastAck() (Ack, bool) {
	p.mu.Lock()
	defer p.mu.Unlock()
	return p.lastAck, p.hasAck
}

// publishPrint 组包并发布(等价 bhp.kt 的 a());返回 sequence_id。
// print 分类的控制命令固件要求签名,这里统一走签名路径。
func (p *Printer) publishPrint(category string, body map[string]any, qos byte) (string, error) {
	return p.publish(category, body, qos, true)
}

// publishSecurity 发送 security 分类命令(app_cert_install 等),按 Handy 实现不签名。
func (p *Printer) publishSecurity(body map[string]any, qos byte) (string, error) {
	return p.publish("security", body, qos, false)
}

// publish 组包:根级 user_id + 分类对象(sequence_id/timestamp/...);sign=true 时
// 对不含 header 的 canonical JSON 签名,并把 header 附在根末尾(逆向 bhp.a/sn5.Z)。
func (p *Printer) publish(category string, body map[string]any, qos byte, sign bool) (string, error) {
	if !p.IsConnected() {
		return "", errors.New("未连接打印机")
	}
	var ac *appCert
	if sign {
		var err error
		if ac, err = p.ensureAppCert(); err != nil {
			return "", err
		}
	}
	p.mu.Lock()
	sn := p.currentSNLocked()
	c := p.client
	p.mu.Unlock()
	if sn == "" {
		return "", errors.New("尚未发现打印机(等待 report 或手动指定序列号)")
	}
	if c == nil {
		return "", errors.New("未连接打印机")
	}
	seq := p.seq.Add(1)
	seqStr := strconv.FormatInt(seq, 10)
	body["sequence_id"] = seqStr
	if _, ok := body["timestamp"]; !ok {
		body["timestamp"] = time.Now().UnixMilli()
	}
	root := map[string]any{}
	if p.UserID != "" {
		root["user_id"] = p.UserID // 云端模式(逆向 bhp.kt:userId 非空时附加)
	}
	root[category] = body
	var raw []byte
	var err error
	if sign {
		canon, cerr := canonicalJSON(root)
		if cerr != nil {
			return "", cerr
		}
		raw, err = ac.signCanonical(canon)
	} else {
		raw, err = json.Marshal(root)
	}
	if err != nil {
		return "", err
	}
	topic := "device/" + sn + "/request"
	tok := c.Publish(topic, qos, false, raw)
	if !tok.WaitTimeout(5 * time.Second) {
		return "", errors.New("发布超时")
	}
	if err := tok.Error(); err != nil {
		return "", err
	}
	p.logf(">>> %s\n    %s", topic, elide(string(raw), 240))
	return seqStr, nil
}

// ensureAppCert 返回当前 App 证书(10 分钟内复用,与 Handy APP_CERT_CACHE_TTL_MS 一致)。
func (p *Printer) ensureAppCert() (*appCert, error) {
	if p.Mode != "cloud" {
		return nil, errors.New("命令签名需要云端账号证书;局域网模式暂不支持")
	}
	p.certMu.Lock()
	defer p.certMu.Unlock()
	if p.cert != nil && time.Since(p.cert.Fetched) < appCertTTL {
		return p.cert, nil
	}
	ac, err := fetchAppCert(p.cred, p.logf)
	if err != nil {
		return nil, fmt.Errorf("获取签名证书失败: %w", err)
	}
	p.cert = ac
	p.logf("[+] 已获取云端 App 证书: %s", ac.CertID)
	return ac, nil
}

// EnsureCertInstalled 把 App 证书(含 CRL)安装到打印机。A1 等安全机型缺 CRL 时
// 会继续回 0x05024007,因此 CRL 一并下发。
func (p *Printer) EnsureCertInstalled() error {
	if p.Mode != "cloud" {
		return errors.New("局域网模式不需要(也不支持)安装云端证书")
	}
	ac, err := p.ensureAppCert()
	if err != nil {
		return err
	}
	p.certMu.Lock()
	done := p.certInstalled == ac.CertID
	p.certMu.Unlock()
	if done {
		return nil
	}
	body := map[string]any{
		"command":  "app_cert_install",
		"app_cert": ac.CertPEM,
	}
	if ac.CRL != "" {
		body["crl"] = ac.CRL
	}
	seq, err := p.publishSecurity(body, 1)
	if err != nil {
		return err
	}
	ack := p.WaitAck(seq, 2*time.Second)
	if ack != nil && ack.Failed() {
		return fmt.Errorf("打印机拒绝安装证书: %s", ackSummary(*ack))
	}
	if ack == nil {
		p.logf("[*] app_cert_install 无回显(该命令通常不回应答),继续")
	} else {
		p.logf("[+] 打印机已确认安装 App 证书")
	}
	p.certMu.Lock()
	p.certInstalled = ac.CertID
	p.certMu.Unlock()
	return nil
}

// SkipObjects 跳过指定零件。
//
// 流程:先申请云端 App 证书并 app_cert_install 安装到打印机(security 分类,不签名),
// 再发送签名的 skip_objects(print 分类)。固件用 cert_id 查已安装证书验证
// RSA-SHA256 签名;缺签名/换行错位都会回 err_code=84033543 + HMS 0500_0500_0001_0007。
// 是否成功只看打印机应答(err_code/result),其次看 s_obj 是否上报目标 id,
// 不再把回显当状态,避免误报。
func (p *Printer) SkipObjects(ids []int) (*SkipResult, error) {
	clean := ids[:0:0]
	seen := map[int]bool{}
	for _, id := range ids {
		if id != 0 && !seen[id] {
			seen[id] = true
			clean = append(clean, id)
		}
	}
	if len(clean) == 0 {
		return nil, errors.New("未选择任何对象")
	}
	_, rep := p.Report()
	state := asString(rep["gcode_state"])
	if state != "RUNNING" && state != "PAUSE" {
		return nil, fmt.Errorf("打印机当前是「%s」,只有打印中/暂停才能跳过", stateText(state))
	}
	if have := skippedIDs(rep); len(have) > 0 {
		for _, id := range clean {
			if have[id] {
				return nil, fmt.Errorf("零件 %d 已在跳过列表中", id)
			}
		}
	}

	// 首次调用会申请证书 + 安装(安装结果按 cert_id 缓存)
	if err := p.EnsureCertInstalled(); err != nil {
		return &SkipResult{Accepted: false, IDs: clean,
			Note: "签名准备失败: " + err.Error()}, nil
	}

	body := map[string]any{"command": "skip_objects", "obj_list": clean}
	seq, err := p.publishPrint("print", body, 1)
	if err != nil {
		return nil, err
	}
	ack := p.WaitAck(seq, 5*time.Second)
	if ack != nil && ack.ErrCode == errCodeMQTTVerify {
		// 证书可能因打印机重启/过期而失效:强制重装后重试一次
		p.certMu.Lock()
		p.certInstalled = ""
		p.certMu.Unlock()
		if err := p.EnsureCertInstalled(); err == nil {
			if seq2, err2 := p.publishPrint("print", body, 1); err2 == nil {
				seq = seq2
				ack = p.WaitAck(seq, 5*time.Second)
			}
		}
	}
	if ack != nil {
		if !ack.Failed() {
			return &SkipResult{Accepted: true, Variant: "skip_objects(签名)", Seq: seq, Ack: ack, IDs: clean,
				Note: "打印机已确认"}, nil
		}
		note := ackSummary(*ack)
		if ack.ErrCode == errCodeMQTTVerify {
			note = "打印机拒绝了命令:MQTT 签名校验失败(证书已安装仍被拒,可能是 cert_id/签名格式不匹配)"
		}
		return &SkipResult{Accepted: false, Variant: "skip_objects(签名)", Seq: seq, Ack: ack, IDs: clean,
			Note: note}, nil
	}
	// 无应答:给状态推送一点时间,以 s_obj 为准
	time.Sleep(800 * time.Millisecond)
	if _, rr := p.Report(); containsAll(skippedIDs(rr), clean) {
		return &SkipResult{Accepted: true, Variant: "skip_objects(签名)", Seq: seq, IDs: clean,
			Note: "打印机已在 s_obj 中上报跳过"}, nil
	}
	return &SkipResult{Accepted: false, Seq: seq, IDs: clean,
		Note: "5 秒内没有收到打印机应答"}, nil
}

func containsAll(have map[int]bool, want []int) bool {
	if len(want) == 0 {
		return false
	}
	for _, id := range want {
		if !have[id] {
			return false
		}
	}
	return true
}

// skippedIDs 已跳过零件集合:
//   - A1/P1 固件在状态推送里用 s_obj(整数数组)
//   - 部分固件/旧协议用 skip_objects(逗号分隔字符串)
func skippedIDs(r map[string]any) map[int]bool {
	out := map[int]bool{}
	add := func(n int) {
		if n > 0 {
			out[n] = true
		}
	}
	switch v := r["s_obj"].(type) {
	case []any:
		for _, it := range v {
			switch x := it.(type) {
			case float64:
				add(int(x))
			case string:
				if n, err := strconv.Atoi(strings.TrimSpace(x)); err == nil {
					add(n)
				}
			}
		}
	case string:
		for _, tok := range strings.Split(v, ",") {
			if n, err := strconv.Atoi(strings.TrimSpace(tok)); err == nil {
				add(n)
			}
		}
	}
	for _, tok := range strings.Split(asString(r["skip_objects"]), ",") {
		if n, err := strconv.Atoi(strings.TrimSpace(tok)); err == nil {
			add(n)
		}
	}
	return out
}

func skippedIDList(r map[string]any) []int {
	set := skippedIDs(r)
	out := make([]int, 0, len(set))
	for id := range set {
		out = append(out, id)
	}
	sort.Ints(out)
	return out
}

// RequestPush 请求打印机推送完整 report(社区通用 pushall 命令)
func (p *Printer) RequestPush() {
	if !p.IsConnected() {
		return
	}
	p.mu.Lock()
	sn := p.currentSNLocked()
	c := p.client
	p.mu.Unlock()
	if sn == "" || c == nil {
		return
	}
	seq := p.seq.Add(1)
	body := map[string]any{"sequence_id": strconv.FormatInt(seq, 10), "command": "pushall"}
	raw, _ := json.Marshal(map[string]any{"pushing": body})
	_ = c.Publish("device/"+sn+"/request", 0, false, raw).Error()
}

// validTaskID task_id 为空或 "0" 表示当前没有可查询的云端任务
func validTaskID(r map[string]any) string {
	id := strings.TrimSpace(asString(r["task_id"]))
	if id == "0" || id == "null" {
		return ""
	}
	return id
}

func asString(v any) string {
	if s, ok := v.(string); ok {
		return s
	}
	return ""
}

// ---- 命令错误码(固件拒绝命令时回显的 err_code)----

const errCodeMQTTVerify = 84033543 // 0x05024007:控制命令被拒,配套 HMS 0500_0500_0001_0007

var errCodeTexts = map[int]string{
	84033543: "MQTT 命令校验失败(固件要求客户端签名)",
	84033540: "AMS 尚未标定完成,不能发起打印",
	84033541: "当前耗材会在此次打印任务中使用,不允许设置",
	84033542: "打印机正在打印中,无法执行该操作",
	84033544: "设备不支持该功能",
	84033545: "AMS 尚未标定完成",
	84033546: "检测到未知模块",
	84033549: "进退料尚未完成,无法发起新任务",
	84033550: "喷嘴冷拔维护尚未完成,无法发起新任务",
}

func errCodeText(code int) string {
	if t, ok := errCodeTexts[code]; ok {
		return t
	}
	return ""
}

func ackSummary(a Ack) string {
	var b strings.Builder
	switch {
	case a.ErrCode != 0:
		fmt.Fprintf(&b, "err_code=%d(0x%X)", a.ErrCode, a.ErrCode)
		if t := errCodeText(a.ErrCode); t != "" {
			b.WriteString(" " + t)
		}
	case strings.EqualFold(a.Result, "success"):
		b.WriteString("result=success")
	case a.Result != "":
		b.WriteString("result=" + a.Result)
	case strings.EqualFold(a.Reason, "success"):
		b.WriteString("已接受")
	}
	if a.Reason != "" && !strings.EqualFold(a.Reason, "success") {
		b.WriteString(" reason=" + a.Reason)
	}
	if b.Len() == 0 {
		b.WriteString("已接受")
	}
	return b.String()
}

// hmsText 把 report.hms 里的 (attr, code) 转成可读文本(仅收录已知的关键项)
func hmsText(attr, code int64) string {
	full := fmt.Sprintf("%04X%04X%04X%04X", (attr>>16)&0xFFFF, attr&0xFFFF, (code>>16)&0xFFFF, code&0xFFFF)
	switch full {
	case "0500050000010007":
		return "MQTT 命令校验失败(控制命令需要签名)"
	}
	return ""
}

// HMSNotices 解析状态里的 HMS 列表,返回可读描述
func HMSNotices(r map[string]any) []string {
	list, _ := r["hms"].([]any)
	var out []string
	for _, it := range list {
		m, ok := it.(map[string]any)
		if !ok {
			continue
		}
		attr, _ := m["attr"].(float64)
		code, _ := m["code"].(float64)
		if t := hmsText(int64(attr), int64(code)); t != "" {
			out = append(out, t)
		}
	}
	return out
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

// pctText 把 report 里的百分比字段转成文本
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

// elide 按字符数截断(用于窄标签),完整内容由调用方放进 ToolTip
func elide(s string, n int) string {
	r := []rune(s)
	if n <= 0 || len(r) <= n {
		return s
	}
	return string(r[:n-1]) + "…"
}
