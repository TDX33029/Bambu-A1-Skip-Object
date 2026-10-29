package main

// 零件列表三来源:云端任务接口 / 切片 3mf / (前端手输)。
// 逆向依据(docs/reverse-notes.md §2/§5d):
//   - 云端:GET {api}/v1/iot-service/api/user/task/{task_id} → context.plates[].objects
//     (identify_id 与切片 obj_id 同源;pick_picture 为颜色编码遮罩图)
//   - 3mf:Metadata/slice_info.config(同源数据)+ Metadata/pick_N.png

import (
	"archive/zip"
	"encoding/json"
	"encoding/xml"
	"errors"
	"fmt"
	"io"
	"net/http"
	"os"
	"strconv"
	"strings"
	"time"
)

const userAgent = "bambu-handry/3.15.5 (Android)"

type SkipObject struct {
	IdentifyID int    `json:"identify_id"`
	ObjectID   int    `json:"object_id"`
	Name       string `json:"name"`
	Skipped    bool   `json:"skipped"`
}

type Plate struct {
	Index   int          `json:"index"`
	Name    string       `json:"name"`
	Source  string       `json:"source"` // cloud | 3mf
	Objects []SkipObject `json:"objects"`
	PickPNG []byte       `json:"-"`
	TopPNG  []byte       `json:"-"`
	HasPick bool         `json:"has_pick"`
	HasTop  bool         `json:"has_top"`
}

// ---- 云端任务 ----

func httpGet(url, token string, timeout time.Duration) ([]byte, error) {
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, err
	}
	if token != "" {
		req.Header.Set("Authorization", "Bearer "+token)
	}
	req.Header.Set("User-Agent", userAgent) // 无移动端 UA 会被网关 403
	req.Header.Set("Accept", "application/json")
	client := &http.Client{Timeout: timeout}
	resp, err := client.Do(req)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()
	if resp.StatusCode != 200 {
		return nil, fmt.Errorf("HTTP %d: %s", resp.StatusCode, url)
	}
	return io.ReadAll(resp.Body)
}

func download(url string, timeout time.Duration) []byte {
	if url == "" {
		return nil
	}
	data, err := httpGet(url, "", 25*time.Second)
	if err != nil {
		return nil
	}
	return data
}

type iotTaskResp struct {
	Name    string `json:"name"`
	Context struct {
		Plates []struct {
			Index   int    `json:"index"`
			Name    string `json:"name"`
			Objects []struct {
				Name       string      `json:"name"`
				IdentifyID json.Number `json:"identify_id"`
				ObjectID   json.Number `json:"object_id"`
				Skipped    bool        `json:"skipped"`
			} `json:"objects"`
			PickPicture *struct {
				URL string `json:"url"`
			} `json:"pick_picture"`
			TopPicture *struct {
				URL string `json:"url"`
			} `json:"top_picture"`
		} `json:"plates"`
	} `json:"context"`
}

// FetchTaskObjects 拉取云端任务对象列表(Handy 同源接口,必须带 /v1 前缀)。
func FetchTaskObjects(taskID string, c *Creds) ([]Plate, string, error) {
	url := fmt.Sprintf("%s/v1/iot-service/api/user/task/%s", c.APIBase(), taskID)
	body, err := httpGet(url, c.Token, 25*time.Second)
	if err != nil {
		return nil, "", err
	}
	var resp iotTaskResp
	if err := json.Unmarshal(body, &resp); err != nil {
		return nil, "", err
	}
	var plates []Plate
	for _, p := range resp.Context.Plates {
		pl := Plate{Index: p.Index, Name: p.Name, Source: "cloud"}
		for _, o := range p.Objects {
			iid, err := strconv.Atoi(strings.TrimSpace(o.IdentifyID.String()))
			if err != nil {
				continue
			}
			oid := iid
			if v, err := strconv.Atoi(strings.TrimSpace(o.ObjectID.String())); err == nil {
				oid = v
			}
			pl.Objects = append(pl.Objects, SkipObject{
				IdentifyID: iid, ObjectID: oid, Name: o.Name, Skipped: o.Skipped,
			})
		}
		if p.PickPicture != nil {
			pl.PickPNG = download(p.PickPicture.URL, 25*time.Second)
			pl.HasPick = len(pl.PickPNG) > 0
		}
		if p.TopPicture != nil {
			pl.TopPNG = download(p.TopPicture.URL, 25*time.Second)
			pl.HasTop = len(pl.TopPNG) > 0
		}
		plates = append(plates, pl)
	}
	return plates, resp.Name, nil
}

// ---- 3mf ----

type xmlMeta struct {
	Key   string `xml:"key,attr"`
	Value string `xml:"value,attr"`
}

type xmlObject struct {
	IdentifyID string `xml:"identify_id,attr"`
	ObjectID   string `xml:"object_id,attr"`
	Name       string `xml:"name,attr"`
	Skipped    string `xml:"skipped,attr"`
}

type xmlPlate struct {
	Metadata []xmlMeta   `xml:"metadata"`
	Objects  []xmlObject `xml:"object"`
}

type sliceInfo struct {
	Plates []xmlPlate `xml:"plate"`
}

// Parse3MF 从切片 3mf 解析对象与 pick/top 遮罩图。
func Parse3MF(path string) ([]Plate, error) {
	zr, err := zip.OpenReader(path)
	if err != nil {
		return nil, err
	}
	defer zr.Close()

	byname := map[string]*zip.File{}
	for _, f := range zr.File {
		byname[f.Name] = f
	}
	var raw []byte
	for _, cand := range []string{"Metadata/slice_info.config", "metadata/slice_info.config"} {
		if f, ok := byname[cand]; ok {
			rc, e := f.Open()
			if e != nil {
				return nil, e
			}
			raw, _ = io.ReadAll(rc)
			rc.Close()
			break
		}
	}
	if raw == nil {
		return nil, errors.New("该 3mf 未包含切片信息(Metadata/slice_info.config);请在 Bambu Studio 切片后导出")
	}
	var si sliceInfo
	if err := xml.Unmarshal(raw, &si); err != nil {
		return nil, fmt.Errorf("解析 slice_info.config 失败: %w", err)
	}
	var plates []Plate
	for _, p := range si.Plates {
		idx, name := 0, ""
		for _, m := range p.Metadata {
			switch m.Key {
			case "index":
				idx, _ = strconv.Atoi(strings.TrimSpace(m.Value))
			case "name":
				name = m.Value
			}
		}
		pl := Plate{Index: idx, Name: name, Source: "3mf"}
		for _, o := range p.Objects {
			iid, err := strconv.Atoi(strings.TrimSpace(o.IdentifyID))
			if err != nil {
				continue
			}
			oid := iid
			if v, err := strconv.Atoi(strings.TrimSpace(o.ObjectID)); err == nil {
				oid = v
			}
			pl.Objects = append(pl.Objects, SkipObject{
				IdentifyID: iid, ObjectID: oid, Name: o.Name,
				Skipped: strings.EqualFold(o.Skipped, "true"),
			})
		}
		for _, pair := range []struct {
			pre string
			dst *[]byte
		}{
			{"pick", &pl.PickPNG}, {"top", &pl.TopPNG},
		} {
			for _, cand := range []string{
				fmt.Sprintf("Metadata/%s_%d.png", pair.pre, idx),
				fmt.Sprintf("metadata/%s_%d.png", pair.pre, idx),
			} {
				if f, ok := byname[cand]; ok {
					rc, e := f.Open()
					if e == nil {
						data, _ := io.ReadAll(rc)
						rc.Close()
						*pair.dst = data
					}
					break
				}
			}
		}
		pl.HasPick = len(pl.PickPNG) > 0
		pl.HasTop = len(pl.TopPNG) > 0
		plates = append(plates, pl)
	}
	return plates, nil
}

func fileExists(p string) bool {
	_, err := os.Stat(p)
	return err == nil
}
