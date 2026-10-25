package main

// 凭证:从本机 Bambu Studio 配置读取账号 token 与打印机访问码。
// 逆向依据(docs/reverse-notes.md §5b):
//   - BambuStudio.conf          明文 JSON(尾部有 "# MD5 checksum" 行,需只解第一个 JSON 值)
//   - BambuNetworkEngine.conf   AES-128-ECB,固定密钥 i4crL3LESLnWapLS(社区公开)
//   - 区域由 user.avatar 域名(含 .cn → cn)判断

import (
	"bytes"
	"crypto/aes"
	"crypto/rand"
	"encoding/hex"
	"encoding/json"
	"errors"
	"fmt"
	"os"
	"path/filepath"
	"strings"
)

const networkKey = "i4crL3LESLnWapLS" // 公开已知的 Studio 网络插件固定密钥

type Creds struct {
	UserID   string            `json:"user_id"`
	Token    string            `json:"token"`
	Account  string            `json:"account"`
	Region   string            `json:"region"` // cn | us
	Printers map[string]string `json:"-"`      // sn -> access_code
	LastSN   string            `json:"-"`
}

func (c *Creds) MQTTHost() string {
	if c.Region == "cn" {
		return "cn.mqtt.bambulab.com"
	}
	return "us.mqtt.bambulab.com"
}

func (c *Creds) APIBase() string {
	if c.Region == "cn" {
		return "https://api.bambulab.cn"
	}
	return "https://api.bambulab.com"
}

func studioDir() string {
	if dir := os.Getenv("APPDATA"); dir != "" {
		return filepath.Join(dir, "BambuStudio")
	}
	home, _ := os.UserHomeDir()
	return filepath.Join(home, "Library", "Application Support", "BambuStudio")
}

// decryptECB 标准库无 ECB 模式,按块手写解密(密文长度向上不齐则截断)。
func decryptECB(ciphertext, key []byte) []byte {
	block, err := aes.NewCipher(key)
	if err != nil {
		return nil
	}
	bs := block.BlockSize()
	n := len(ciphertext) / bs * bs
	out := make([]byte, n)
	for i := 0; i < n; i += bs {
		block.Decrypt(out[i:i+bs], ciphertext[i:i+bs])
	}
	return out
}

// jsonHead 解析缓冲中第一个完整 JSON 值,忽略尾部杂散行(如 "# MD5 checksum ...")
func jsonHead(data []byte, v any) error {
	dec := json.NewDecoder(bytes.NewReader(data))
	return dec.Decode(v)
}

type studioConf struct {
	AccessCodes map[string]string `json:"access_code"`
	LastMachine string            `json:"user_last_selected_machine"`
}

type networkConf struct {
	LastMachine string `json:"last_monitor_machine"`
	User        struct {
		Account string `json:"account"`
		Token   string `json:"token"`
		UserID  string `json:"user_id"`
		Avatar  string `json:"avatar"`
	} `json:"user"`
}

func LoadCreds() (*Creds, error) {
	dir := studioDir()
	raw, err := os.ReadFile(filepath.Join(dir, "BambuNetworkEngine.conf"))
	if err != nil {
		return nil, errors.New("未找到 Bambu Studio 配置(请先在本机登录 Bambu Studio)")
	}
	dec := decryptECB(raw, []byte(networkKey))
	dec = bytes.TrimRight(dec, "\x00\r\n\t ")
	var net networkConf
	if err := jsonHead(dec, &net); err != nil {
		return nil, fmt.Errorf("解密 BambuNetworkEngine.conf 失败: %w", err)
	}
	if net.User.Token == "" || net.User.UserID == "" {
		return nil, errors.New("Bambu Studio 凭证中没有有效的 token(未登录?)")
	}
	c := &Creds{
		UserID:   net.User.UserID,
		Token:    net.User.Token,
		Account:  net.User.Account,
		Region:   "us",
		Printers: map[string]string{},
	}
	if strings.Contains(net.User.Avatar, ".cn") {
		c.Region = "cn"
	}
	if stRaw, err := os.ReadFile(filepath.Join(dir, "BambuStudio.conf")); err == nil {
		var st studioConf
		if jsonHead(stRaw, &st) == nil {
			for sn, code := range st.AccessCodes {
				c.Printers[sn] = code
			}
			c.LastSN = st.LastMachine
		}
	}
	// 上次在本工具中成功连接的打印机优先
	if cache := loadCache(); len(cache) > 0 {
		if sn, ok := cache["last_ok_sn"].(string); ok && sn != "" {
			if _, known := c.Printers[sn]; known {
				c.LastSN = sn
			}
		}
	}
	return c, nil
}

func cachePath() string {
	exe, err := os.Executable()
	if err == nil {
		return filepath.Join(filepath.Dir(exe), ".bbl_skip_cache.json")
	}
	return ".bbl_skip_cache.json"
}

func loadCache() map[string]any {
	data, err := os.ReadFile(cachePath())
	if err != nil {
		return map[string]any{}
	}
	var m map[string]any
	if json.Unmarshal(data, &m) != nil {
		return map[string]any{}
	}
	return m
}

func SaveLastSN(sn string) {
	m := loadCache()
	m["last_ok_sn"] = sn
	if data, err := json.MarshalIndent(m, "", "  "); err == nil {
		_ = os.WriteFile(cachePath(), data, 0o644)
	}
}

func newUUID() string {
	b := make([]byte, 16)
	_, _ = rand.Read(b)
	return hex.EncodeToString(b)
}
