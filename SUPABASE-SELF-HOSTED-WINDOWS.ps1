# ⚡ PowerShell 스크립트 시작
# 관리자 권한으로 실행할 것!

# 1. Chocolatey 설치 (이미 있으면 건너뜀)
if (!(Get-Command choco -ErrorAction SilentlyContinue)) {
    Write-Host "🍫 Chocolatey를 설치합니다..."
    Set-ExecutionPolicy Bypass -Scope Process -Force;
    [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072;
    iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'));
} else {
    Write-Host "✅ Chocolatey가 이미 설치되어 있습니다."
}

# 2. Git 설치 (choco)
if (!(Get-Command git -ErrorAction SilentlyContinue)) {
    Write-Host "🐙 Git을 설치합니다..."
    choco install git -y
} else {
    Write-Host "✅ Git이 이미 설치되어 있습니다."
}

# 3. Docker Desktop 설치 (choco)
if (!(Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "🐳 Docker Desktop을 설치합니다..."
    choco install docker-desktop -y
} else {
    Write-Host "✅ Docker Desktop이 이미 설치되어 있습니다."
}

# 4. Docker Desktop 실행 안내
Write-Host "⚙️ Docker Desktop을 수동으로 실행하고 초기 설정을 완료해주세요."
Start-Process "Docker Desktop"
Pause

# 5. Supabase 저장소 클론
$BaseDir = "C:\supabase-project"

if (!(Test-Path $BaseDir)) {
    New-Item -Path $BaseDir -ItemType Directory
}

Set-Location $BaseDir

Write-Host "📦 Supabase 저장소를 복제합니다..."
git clone https://github.com/supabase/supabase.git

# 6. docker-compose.yml 수정
Write-Host "🛠 docker-compose.yml 파일을 수정합니다..."
Set-Location "$BaseDir\supabase"

# 볼륨 경로 수정
(Get-Content docker\docker-compose.yml) `
    -replace '^\s*- \./volumes/storage:/var/lib/storage:z', '      - supabase_storage:/var/lib/storage' `
    | ForEach-Object { $_ -replace '^\s*- \./volumes/db/data:/var/lib/postgresql/data:Z', '      - supabase_db_data:/var/lib/postgresql/data' } `
    | Set-Content docker\docker-compose.yml

# named volumes 추가
Add-Content docker\docker-compose.yml @"
volumes:
  supabase_db_data:
  supabase_storage:
"@

# 7. Supabase 프로젝트 구조 구성
Write-Host "📁 Supabase 프로젝트 디렉토리를 구성합니다..."
Set-Location $BaseDir
Copy-Item -Recurse -Force .\supabase\docker\* .\
Copy-Item -Force .\supabase\docker\.env.example .\.env

# 8. Docker Compose 이미지 pull
Write-Host "📥 Docker 이미지들을 가져옵니다..."
docker-compose pull

# 9. Email SMTP 설정 추가
$smtpAdminEmail = Read-Host "📧 SMTP 관리용 이메일 주소를 입력하세요 (SMTP_ADMIN_EMAIL)"
$smtpPass = Read-Host "🔑 Resend SMTP API 키를 입력하세요 (SMTP_PASS)"

@"
SMTP_ADMIN_EMAIL=$smtpAdminEmail
SMTP_HOST=smtp.resend.com
SMTP_PORT=465
SMTP_USER=resend
SMTP_PASS=$smtpPass
SMTP_SENDER_NAME=Supabase Confirmation
"@ | Add-Content .env

# 10. Supabase 서버 실행
Write-Host "🚀 Supabase 서버를 시작합니다..."
docker-compose up -d

Write-Host "🎉 Supabase 설치 및 실행 완료!"
Write-Host "🔗 Supabase 대시보드에 접속하려면 http://localhost:8000 에 접속하세요."