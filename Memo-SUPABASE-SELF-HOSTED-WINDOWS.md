# Supabase
## Install
```powershell
# ⚡ PowerShell Script for Supabase Setup on Windows (with WSL2)
# Run this script as Administrator

# 1. Install Chocolatey (if not already installed)
if (!(Get-Command choco -ErrorAction SilentlyContinue)) {
    Write-Host "🍫 Installing Chocolatey..."
    Set-ExecutionPolicy Bypass -Scope Process -Force
    [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
    iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
} else {
    Write-Host "✅ Chocolatey is already installed."
}

# 2. Install Git
if (!(Get-Command git -ErrorAction SilentlyContinue)) {
    Write-Host "🐙 Installing Git..."
    choco install git -y
} else {
    Write-Host "✅ Git is already installed."
}

# 3. Install Docker Desktop
if (!(Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "🐳 Installing Docker Desktop..."
    choco install docker-desktop -y
} else {
    Write-Host "✅ Docker Desktop is already installed."
}

# 4. Install WSL and Ubuntu
if (!(Get-Command wsl -ErrorAction SilentlyContinue)) {
    Write-Host "🐧 Installing WSL..."
    choco install wsl -y
} else {
    Write-Host "✅ WSL is already installed."
}
if (!(Get-Command openssl -ErrorAction SilentlyContinue)) {
    Write-Host "🔐 Installing OpenSSL..."
    choco install openssl -y
} else {
    Write-Host "✅ OpenSSL is already installed."
}

Write-Host "🔧 Setting WSL 2 as the default version..."
wsl --set-default-version 2

Write-Host "📦 Downloading and installing WSL2 kernel..."
$wslInstaller = "$env:TEMP\wsl_update.msi"
Invoke-WebRequest -Uri "https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi" -OutFile $wslInstaller
Start-Process msiexec.exe -ArgumentList "/i $wslInstaller /quiet /norestart" -Wait
Remove-Item $wslInstaller

Write-Host "📥 Installing Ubuntu from Microsoft Store..."
wsl --install -d Ubuntu

echo "Reboot System"
shutdown /r /f /t 5
```
## Docker Config (Run Once Only)
```powershell
# 6. Clone Supabase repository
$BaseDir = "C:\supabase-project"
if (!(Test-Path $BaseDir)) {
    New-Item -Path $BaseDir -ItemType Directory
}
Set-Location $BaseDir

Write-Host "📦 Cloning the Supabase repository..."
git clone https://github.com/supabase/supabase.git

# 7. Patch docker-compose.yml for Windows volumes
Write-Host "🛠 Modifying docker-compose.yml for volume compatibility..."
Set-Location "$BaseDir\supabase"

(Get-Content docker\docker-compose.yml) `
    -replace '^\s*- \./volumes/storage:/var/lib/storage:z', '      - supabase_storage:/var/lib/storage' `
    | ForEach-Object { $_ -replace '^\s*- \./volumes/db/data:/var/lib/postgresql/data:Z', '      - supabase_db_data:/var/lib/postgresql/data' } `
    | Set-Content docker\docker-compose.yml

Add-Content docker\docker-compose.yml @"
  supabase_db_data:
  supabase_storage:
"@
```
## Environment Config
```powershell
$BaseDir = "C:\supabase-project"
# 8. Copy project files and prepare environment
Write-Host "📁 Setting up Supabase project directory..."
Set-Location $BaseDir
Copy-Item -Recurse -Force .\supabase\docker\* .\
Copy-Item -Force .\supabase\docker\.env.example .\.env

# 9. Pull Docker images
Write-Host "📥 Pulling Docker images..."
docker-compose pull

# 10. Prompt for SMTP Email Config
$smtpAdminEmail = Read-Host "📧 Enter the admin email for outgoing mail (SMTP_ADMIN_EMAIL)"
$smtpPass = Read-Host "🔑 Enter your Resend SMTP API key (SMTP_PASS)"

@"
SMTP_ADMIN_EMAIL=$smtpAdminEmail
SMTP_HOST=smtp.resend.com
SMTP_PORT=465
SMTP_USER=resend
SMTP_PASS=$smtpPass
SMTP_SENDER_NAME=Supabase
"@ | Add-Content .env
```
## Run
```powershell
$BaseDir = "C:\supabase-project"
Set-Location $BaseDir
# 11. Start Supabase
Write-Host "🚀 Starting Supabase with Docker Compose..."
docker-compose up -d
Write-Host "Visit http://localhost:8000 for dashboard"
Write-Host "DASHBOARD_USERNAME=supabase"
Write-Host "DASHBOARD_PASSWORD=this_password_is_insecure_and_should_be_updated"
```
## Etc
```
.env 파일을 수정하여 설정을 변경 할 수 있다.
postgres 비밀번호는 변경 하려는 경우 .env와 psql을 통해 바꾸어 주어야 한다.
```
```powershell
# 입력한 길이만큼의 크기의 랜덤한 base64를 만든다
# JWT_SECRET, ANON_KEY, SERVICE_ROLE_KEY, DASHBOARD_PASSWORD, SECRET_KEY_BASE, VAULT_ENC_KEY 등에 사용 가능
openssl rand -base64 길이
```