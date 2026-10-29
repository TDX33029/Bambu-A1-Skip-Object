package main

// 云端 IoT 应用证书获取 + MQTT 命令签名(Bambu 2026 固件新增的校验)。
//
// 逆向依据(APK app_zh_release.apk,2026-10-20):
//
//	IotCertManager.fetchAppCertFromNetwork  证书申请流程
//	IotAppCert                              cert_id 由证书 issuer CN + serial 拼出
//	BblCryptoEphemeralAes.exportWrapped     用 APK 内置服务端证书 RSA 包装临时 AES 密钥
//	sn5.Z                                   命令签名:canonical JSON + RSA-SHA256,根级 header
//	b9v.c/d/e                               canonical JSON:对象键排序、紧凑分隔
//	ubv.e                                   security 分类:app_cert_list / app_cert_install
//	bhp.a                                   命令组包:sequence_id/timestamp/user_id,header 附在根
//
// 关键结论:print 分类的控制命令(pushall 除外)固件要求签名;未签名/签名不符时
// 回 err_code=84033543(0x05024007),并上报 HMS 0500_0500_0001_0007。
// 打印机需要先通过 security 分类的 app_cert_install 安装 App 证书(不签名),
// 之后才能验证同 cert_id 的签名命令。

import (
	"bytes"
	"crypto"
	"crypto/aes"
	"crypto/cipher"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha1"
	"crypto/sha256"
	"crypto/x509"
	"encoding/base64"
	"encoding/hex"
	"encoding/json"
	"encoding/pem"
	"errors"
	"fmt"
	"io"
	"math/big"
	"net/http"
	"sort"
	"strconv"
	"strings"
	"time"
)

// Handy 的 App Key(CN/INTL 同一份 secrets)。申请证书时路径参数是
// base64url(AES-GCM("GLOF3813734089-"+appKey)),aes256 参数是 RSA 包装后的 AES 密钥。
const (
	iotAppKeyPrefix = "GLOF3813734089-"
	iotAppKey       = "af70cf3b000006c7d872272593fe"
	appCertTTL      = 10 * time.Minute

	handyVersion     = "4.3.0"
	handyVersionCode = "40300"
)

// APK 内置的证书服务端公钥(CN=service.bambulab.com),用于包装临时 AES 密钥。
// 来源:IotCertManager.exportWrappedAesKey 内联 PEM。
const iotWrapCertPEM = `-----BEGIN CERTIFICATE-----
MIIDeTCCAmGgAwIBAgIUGpX26HEycYnaaCUFwJr8F/UPCZIwDQYJKoZIhvcNAQEL
BQAwKDEmMCQGA1UEAwwdYXBwbGljYXRpb25fcm9vdC5iYW1idWxhYi5jb20wHhcN
MjQwNzI2MDE1MjI3WhcNMzQwNzI0MDE1MjI3WjAfMR0wGwYDVQQDDBRzZXJ2aWNl
LmJhbWJ1bGFiLmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJ2z
wQvNAjA9lQe06o/Vv6JULHLn25NK706myDa4i9lmb3wqARNVi6aSWfxO3Cz9NklC
4dYAdFbgcEUXuJIcJBBZdgPO2GhnaeCUVWz/ucW2GCdPaBAkXZNDK56aPqfYwltI
sNJcUIvq0OmbFsI90l8zKTQzd8/zJcfm8lOBpAberwbEeHCQfDxUWpNyrAuGJlkD
cmxraAjzBXQjAyMT+kK+KPOqhJICu5SXP87WGlzw8sfrdLl7J2vhtXpzRC67vtv6
uD6aqq5f2OaRxHRUyqeDY/adiWE9Qeb9amkRMcQiUJ0IQJZ4wDSMNpZe0guXLkl5
LPdPU249Bu86H5eDf5ECAwEAAaOBozCBoDAJBgNVHRMEAjAAMAsGA1UdDwQEAwID
uDAdBgNVHQ4EFgQUb/FHYnyT++aiAcbhmQsDIMw/C+kwZwYDVR0jBGAwXqFGpEQw
QjELMAkGA1UEBhMCQ04xIjAgBgNVBAoMGUJCTCBUZWNobm9sb2dpZXMgQ28uLCBM
dGQxDzANBgNVBAMMBkJCTCBDQYIUGpX26HEycYnaaCUFwJr8F/UPCYgwDQYJKoZI
hvcNAQELBQADggEBAK3n3LsRPiT9dEKrteCvBhaO/nAhc3Ogpi5iw4yiSB6abIHy
a36oGCA7RDMaMizDxbmWqooasA3xWnWLaf83FPt8KTnG72hmRb/usjc8sqFQQPPX
/VZf8ITAILx7Nrh1yLKI31UtYLMgeGNA8sifQUVJFOLqcwEpqUvII5ZK1YZ/27lM
gmscseUC5s4MTVf+aT5Gxg/v8MI0kgzNKCUELx7HuMfz/Og7+BSS58piZ1vt8Mgq
VvhUVmCS9SnCnvkM57zOumHHlvoSf7u6eq7YQd6spdJBYS1Yf2KGxKG2uooT9VlX
Gq8Fcpo0F9pzYXX3kKeBJo1vl1/R54eAgd82rNg=
-----END CERTIFICATE-----`

type appCert struct {
	CertPEM string
	CRL     string
	CertID  string // CN=<issuer CN>:<serialHex>,与固件/Handy 的 cert_id 一致
	Key     *rsa.PrivateKey
	Issuer  string
	Serial  string
	Fetched time.Time
}

// canonicalJSON 复刻 APK b9v.e:对象键升序、紧凑分隔符、org.json 字符串转义。
func canonicalJSON(v any) ([]byte, error) {
	var b bytes.Buffer
	if err := writeCanon(&b, v); err != nil {
		return nil, err
	}
	return b.Bytes(), nil
}

func writeCanon(b *bytes.Buffer, v any) error {
	switch x := v.(type) {
	case nil:
		b.WriteString("null")
	case bool:
		if x {
			b.WriteString("true")
		} else {
			b.WriteString("false")
		}
	case string:
		writeJSONString(b, x)
	case int:
		b.WriteString(strconv.Itoa(x))
	case int32:
		b.WriteString(strconv.FormatInt(int64(x), 10))
	case int64:
		b.WriteString(strconv.FormatInt(x, 10))
	case float64:
		// Java Double.toString 只在科学计数阈值上与 Go 不同;签名载荷里没有浮点
		b.WriteString(strconv.FormatFloat(x, 'g', -1, 64))
	case json.Number:
		b.WriteString(x.String())
	case []int:
		b.WriteByte('[')
		for i, n := range x {
			if i > 0 {
				b.WriteByte(',')
			}
			b.WriteString(strconv.Itoa(n))
		}
		b.WriteByte(']')
	case []string:
		b.WriteByte('[')
		for i, s := range x {
			if i > 0 {
				b.WriteByte(',')
			}
			writeJSONString(b, s)
		}
		b.WriteByte(']')
	case []any:
		b.WriteByte('[')
		for i, e := range x {
			if i > 0 {
				b.WriteByte(',')
			}
			if err := writeCanon(b, e); err != nil {
				return err
			}
		}
		b.WriteByte(']')
	case map[string]any:
		keys := make([]string, 0, len(x))
		for k := range x {
			keys = append(keys, k)
		}
		sort.Strings(keys)
		b.WriteByte('{')
		for i, k := range keys {
			if i > 0 {
				b.WriteByte(',')
			}
			writeJSONString(b, k)
			b.WriteByte(':')
			if err := writeCanon(b, x[k]); err != nil {
				return err
			}
		}
		b.WriteByte('}')
	default:
		raw, err := json.Marshal(v)
		if err != nil {
			return err
		}
		var tmp any
		if err := json.Unmarshal(raw, &tmp); err != nil {
			return err
		}
		return writeCanon(b, tmp)
	}
	return nil
}

// writeJSONString 按 Android org.json 的 JSONObject.quote 规则转义:
// 只转义 " \ 与控制字符;"/" 仅在前一个字符是 '<' 时转义(签名载荷用不到)。
func writeJSONString(b *bytes.Buffer, s string) {
	b.WriteByte('"')
	prev := byte(0)
	for _, r := range s {
		switch r {
		case '"', '\\':
			b.WriteByte('\\')
			b.WriteRune(r)
		case '/':
			if prev == '<' {
				b.WriteByte('\\')
			}
			b.WriteRune(r)
		case '\b':
			b.WriteString(`\b`)
		case '\f':
			b.WriteString(`\f`)
		case '\n':
			b.WriteString(`\n`)
		case '\r':
			b.WriteString(`\r`)
		case '\t':
			b.WriteString(`\t`)
		default:
			if r < 0x20 || (r >= 0x7f && r <= 0x9f) {
				fmt.Fprintf(b, `\u%04x`, r)
			} else {
				b.WriteRune(r)
			}
		}
		prev = byte(r)
	}
	b.WriteByte('"')
}

// signCanonical 对 canonical JSON 做 RSA-PKCS1v15-SHA256 签名,并把 header 附到根对象末尾。
// 等价 sn5.Z + bhp.a:签名覆盖不含 header 的规范化 JSON。
func (ac *appCert) signCanonical(body []byte) ([]byte, error) {
	if ac == nil || ac.Key == nil {
		return nil, errors.New("没有可用的 App 私钥,无法签名")
	}
	sum := sha256.Sum256(body)
	sig, err := rsa.SignPKCS1v15(rand.Reader, ac.Key, crypto.SHA256, sum[:])
	if err != nil {
		return nil, fmt.Errorf("RSA-SHA256 签名失败: %w", err)
	}
	header := map[string]any{
		"sign_ver":    "v1.0",
		"sign_alg":    "RSA_SHA256",
		"sign_string": base64.StdEncoding.EncodeToString(sig),
		"cert_id":     ac.CertID,
		"payload_len": len(body),
	}
	hdr, err := canonicalJSON(header)
	if err != nil {
		return nil, err
	}
	if len(body) == 0 || body[len(body)-1] != '}' {
		return nil, errors.New("签名载荷格式异常")
	}
	out := make([]byte, 0, len(body)+len(hdr)+16)
	out = append(out, body[:len(body)-1]...)
	out = append(out, `,"header":`...)
	out = append(out, hdr...)
	out = append(out, '}')
	return out, nil
}

// appKeyParam = base64url(AES-GCM(明文 App Key)),不含 padding。
func encryptAppKey() (string, []byte, error) {
	aesKey := make([]byte, 32)
	iv := make([]byte, 12)
	if _, err := rand.Read(aesKey); err != nil {
		return "", nil, err
	}
	if _, err := rand.Read(iv); err != nil {
		return "", nil, err
	}
	block, err := aes.NewCipher(aesKey)
	if err != nil {
		return "", nil, err
	}
	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return "", nil, err
	}
	sealed := gcm.Seal(nil, iv, []byte(iotAppKeyPrefix+iotAppKey), nil) // iv || ciphertext || tag
	// 服务端要求 URL-safe base64 且保留 "=" 补齐(实测缺 padding 会回 code=101
	// 「该软件已过期失效」,极易被误判为版本问题)。
	return base64.URLEncoding.EncodeToString(append(iv, sealed...)), aesKey, nil
}

func rsaWrap(pub *rsa.PublicKey, key []byte, mode string) ([]byte, error) {
	switch mode {
	case "pkcs1":
		return rsa.EncryptPKCS1v15(rand.Reader, pub, key)
	case "oaep-sha256":
		return rsa.EncryptOAEP(sha256.New(), rand.Reader, pub, key, nil)
	case "oaep-sha1":
		return rsa.EncryptOAEP(sha1.New(), rand.Reader, pub, key, nil)
	}
	return nil, fmt.Errorf("未知包装方式 %s", mode)
}

var cachedDeviceID string

func deviceID() string {
	if cachedDeviceID == "" {
		cachedDeviceID = newUUID()
	}
	return cachedDeviceID
}

func iotGet(rawURL, token string) (int, []byte, error) {
	req, err := http.NewRequest("GET", rawURL, nil)
	if err != nil {
		return 0, nil, err
	}
	req.Header.Set("Authorization", "Bearer "+token)
	// 与 Handy 4.3.0 的 BblHeaderInterceptor 一致;缺版本头会回 code=101
	// 「This application is outdated」。
	req.Header.Set("User-Agent", "Handy/"+handyVersion)
	req.Header.Set("Accept", "application/json")
	req.Header.Set("X-BBL-Client-Type", "app")
	req.Header.Set("X-BBL-Client-Name", "BambuHandy")
	req.Header.Set("X-BBL-Client-Version", handyVersion)
	req.Header.Set("X-BBL-Client-Release-Code", handyVersionCode)
	req.Header.Set("X-BBL-OS-Type", "Android")
	req.Header.Set("X-BBL-OS-Version", "14")
	req.Header.Set("X-BBL-Device-Brand", "samsung")
	req.Header.Set("X-BBL-Device-Model", "SM-G991B")
	req.Header.Set("X-BBL-Language", "zh-Hans")
	req.Header.Set("X-BBL-Device-ID", deviceID())
	client := &http.Client{Timeout: 25 * time.Second}
	resp, err := client.Do(req)
	if err != nil {
		return 0, nil, err
	}
	defer resp.Body.Close()
	body, _ := io.ReadAll(resp.Body)
	return resp.StatusCode, body, nil
}

// b64Tolerant 兼容标准/URL-safe、有无 padding 的 base64(服务端字段混用两种)。
func b64Tolerant(s string) []byte {
	s = strings.TrimSpace(s)
	for _, enc := range []*base64.Encoding{
		base64.StdEncoding, base64.RawStdEncoding,
		base64.URLEncoding, base64.RawURLEncoding,
	} {
		if b, err := enc.DecodeString(s); err == nil {
			return b
		}
	}
	return nil
}

func parsePrivateKey(raw []byte) (*rsa.PrivateKey, error) {
	if blk, _ := pem.Decode(raw); blk != nil {
		raw = blk.Bytes
	}
	if k, err := x509.ParsePKCS1PrivateKey(raw); err == nil {
		return k, nil
	}
	if k, err := x509.ParsePKCS8PrivateKey(raw); err == nil {
		if rk, ok := k.(*rsa.PrivateKey); ok {
			return rk, nil
		}
	}
	return nil, errors.New("无法解析私钥(PKCS1/PKCS8 均失败)")
}

// decryptPrivateKeyBlob 尝试 GCM 的各种 IV/tag 排列;服务端返回 base64(iv||ct||tag)。
func decryptPrivateKeyBlob(blob []byte, aesKey []byte) (*rsa.PrivateKey, string, error) {
	block, err := aes.NewCipher(aesKey)
	if err != nil {
		return nil, "", err
	}
	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return nil, "", err
	}
	if len(blob) < 12+16+1 {
		return nil, "", fmt.Errorf("私钥密文长度异常: %d", len(blob))
	}
	type layout struct {
		name   string
		iv, ct []byte
	}
	try := []layout{
		{"iv||ct||tag", blob[:12], blob[12:]},
		{"iv||tag||ct", blob[:12], append(append([]byte{}, blob[28:]...), blob[12:28]...)},
		{"tag||iv||ct", blob[16:28], blob[28:]},
	}
	var lastErr error
	for _, l := range try {
		pt, err := gcm.Open(nil, l.iv, l.ct, nil)
		if err != nil {
			lastErr = err
			continue
		}
		key, err := parsePrivateKey(pt)
		if err != nil {
			lastErr = fmt.Errorf("%s 解密成功但私钥解析失败: %w", l.name, err)
			continue
		}
		return key, l.name, nil
	}
	return nil, "", fmt.Errorf("私钥解密失败: %v", lastErr)
}

type iotCertResp struct {
	Code    json.RawMessage `json:"code"`
	Cert    string          `json:"cert"`
	Key     string          `json:"key"`
	CRL     json.RawMessage `json:"crl"`
	Error   string          `json:"error"`
	Msg     string          `json:"msg"`
	Message string          `json:"message"`
}

func (r *iotCertResp) code() int {
	raw := strings.Trim(strings.TrimSpace(string(r.Code)), `"`)
	if raw == "" || raw == "null" {
		return -1
	}
	if n, err := strconv.Atoi(raw); err == nil {
		return n
	}
	return -1
}

func (r *iotCertResp) errText() string {
	for _, s := range []string{r.Error, r.Msg, r.Message} {
		if strings.TrimSpace(s) != "" {
			return s
		}
	}
	return ""
}

// joinCRL 还原 IotAppCertCrl.joinCrlPems:JSON 数组,逐项 trim,空项丢弃,"\n" 连接。
func joinCRL(raw json.RawMessage) string {
	if len(raw) == 0 {
		return ""
	}
	var arr []string
	if err := json.Unmarshal(raw, &arr); err == nil {
		out := make([]string, 0, len(arr))
		for _, s := range arr {
			if s = strings.TrimSpace(s); s != "" {
				out = append(out, s)
			}
		}
		return strings.Join(out, "\n")
	}
	var s string
	if err := json.Unmarshal(raw, &s); err == nil {
		return strings.TrimSpace(s)
	}
	return ""
}

func serialHex(n *big.Int) string {
	b := n.Bytes() // 去掉前导 0,与 OpenSSL i2s_ASN1_INTEGER 一致
	return strings.ToUpper(hex.EncodeToString(b))
}

// fetchAppCert 向云端申请 App 证书并解出私钥。依次尝试 RSA 包装的三种填充,
// 只有服务端成功解出 AES 密钥并返回 code=0 才算成功。
func fetchAppCert(c *Creds, logf func(string, ...any)) (*appCert, error) {
	if c == nil || strings.TrimSpace(c.Token) == "" {
		return nil, errors.New("云端证书需要账号 token(当前没有可用凭证)")
	}
	blk, _ := pem.Decode([]byte(iotWrapCertPEM))
	if blk == nil {
		return nil, errors.New("内置证书解析失败")
	}
	wrapCert, err := x509.ParseCertificate(blk.Bytes)
	if err != nil {
		return nil, err
	}
	pub, ok := wrapCert.PublicKey.(*rsa.PublicKey)
	if !ok {
		return nil, errors.New("内置证书不是 RSA 公钥")
	}

	var lastErr error
	// 实测只有 RSA PKCS#1 v1.5 + 带 padding 的 URL-safe base64 组合能通过;
	// OAEP 会被服务端当成无法解密的请求,统一回 code=101。
	for _, mode := range []string{"pkcs1"} {
		appKeyParam, aesKey, err := encryptAppKey()
		if err != nil {
			return nil, err
		}
		wrapped, err := rsaWrap(pub, aesKey, mode)
		if err != nil {
			lastErr = err
			continue
		}
		u := fmt.Sprintf("%s/v1/iot-service/api/user/applications/%s/cert?aes256=%s",
			c.APIBase(), appKeyParam, base64.URLEncoding.EncodeToString(wrapped))
		status, body, err := iotGet(u, c.Token)
		if err != nil {
			lastErr = err
			continue
		}
		var resp iotCertResp
		if err := json.Unmarshal(body, &resp); err != nil {
			lastErr = fmt.Errorf("证书接口返回非 JSON(HTTP %d): %s", status, elide(string(body), 200))
			continue
		}
		if resp.code() != 0 || resp.Cert == "" || resp.Key == "" {
			lastErr = fmt.Errorf("证书申请被拒(HTTP %d, 包装=%s): code=%s %s",
				status, mode, strings.TrimSpace(string(resp.Code)), resp.errText())
			if logf != nil {
				logf("[cert] 尝试 %s -> HTTP %d code=%s msg=%s body=%s", mode, status,
					strings.TrimSpace(string(resp.Code)), resp.errText(), elide(string(body), 240))
			}
			continue
		}
		blob := b64Tolerant(resp.Key)
		if len(blob) == 0 {
			lastErr = fmt.Errorf("证书接口 key 字段不是 base64(%s)", mode)
			continue
		}
		key, layout, err := decryptPrivateKeyBlob(blob, aesKey)
		if err != nil {
			lastErr = fmt.Errorf("%s: %w", mode, err)
			continue
		}
		certBlk, _ := pem.Decode(mustPEM(resp.Cert))
		if certBlk == nil {
			lastErr = errors.New("证书 PEM 解码失败")
			continue
		}
		ck, err := x509.ParseCertificate(certBlk.Bytes)
		if err != nil {
			lastErr = fmt.Errorf("证书解析失败: %w", err)
			continue
		}
		sn := serialHex(ck.SerialNumber)
		issuer := ck.Issuer.CommonName
		ac := &appCert{
			CertPEM: strings.TrimSpace(resp.Cert),
			CRL:     joinCRL(resp.CRL),
			CertID:  "CN=" + issuer + ":" + sn,
			Key:     key,
			Issuer:  issuer,
			Serial:  sn,
			Fetched: time.Now(),
		}
		// 本地自检:签名能用证书公钥验回
		test := []byte(`{"self":"check"}`)
		sum := sha256.Sum256(test)
		sig, err := rsa.SignPKCS1v15(rand.Reader, ac.Key, crypto.SHA256, sum[:])
		if err != nil {
			lastErr = fmt.Errorf("签名自检失败: %w", err)
			continue
		}
		pubKey, _ := ck.PublicKey.(*rsa.PublicKey)
		if pubKey == nil || rsa.VerifyPKCS1v15(pubKey, crypto.SHA256, sum[:], sig) != nil {
			lastErr = errors.New("签名自检失败: 证书公钥验签不通过")
			continue
		}
		ac.Key.Precompute()
		if logf != nil {
			logf("证书获取成功: 包装=%s 私钥布局=%s cert_id=%s crl=%d 字节", mode, layout, ac.CertID, len(ac.CRL))
		}
		return ac, nil
	}
	if lastErr == nil {
		lastErr = errors.New("未知错误")
	}
	return nil, lastErr
}

func mustPEM(cert string) []byte {
	cert = strings.TrimSpace(cert)
	if strings.Contains(cert, "BEGIN CERTIFICATE") {
		return []byte(cert)
	}
	// 少数环境返回裸 base64(证书 body),补上 PEM 头
	return pem.EncodeToMemory(&pem.Block{Type: "CERTIFICATE", Bytes: b64Tolerant(cert)})
}
