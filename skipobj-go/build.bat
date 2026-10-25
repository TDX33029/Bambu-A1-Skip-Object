@echo off
REM 构建拓竹跳过对象工具(Go 版):桌面双击版 + 控制台 CLI 版
cd /d "%~dp0"
go build -trimpath -ldflags "-s -w -H windowsgui" -o BambuSkipObjects.exe .
go build -trimpath -ldflags "-s -w" -o bbl-skip-cli.exe .
echo.
echo 构建完成:
dir /b *.exe
