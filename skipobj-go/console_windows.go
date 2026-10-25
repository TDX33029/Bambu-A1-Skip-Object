//go:build windows

package main

import "golang.org/x/sys/windows"

func init() {
	// Windows 控制台默认 GBK 代码页,切到 UTF-8 保证中文输出
	_ = windows.SetConsoleOutputCP(65001)
}
