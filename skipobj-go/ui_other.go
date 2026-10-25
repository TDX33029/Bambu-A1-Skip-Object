//go:build !windows

package main

// 非 Windows 平台回退到 Web UI(原生窗口实现仅支持 Windows)
func runUI() { RunWebUI("127.0.0.1:8974", true) }
