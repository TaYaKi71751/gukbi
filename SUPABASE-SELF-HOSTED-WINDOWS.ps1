# ⚡ PowerShell Script for Supabase Setup on Windows (No WSL)
# Run this script as Administrator

# 1. Install Chocolatey (if not already installed)
if (!(Get-Command choco -ErrorAction SilentlyContinue)) {
    Write-Host "🍫 Installing Chocolatey..."
    Set-ExecutionPolicy Bypass -Scope Process -Force;
    [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072;
    iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'));
} else {
    Write-Host "✅ Chocolatey is already installed."
}

# 2. Install Git via Chocolatey
if (!(Get-Command git -ErrorAction SilentlyContinue)) {
    Write-Host "🐙 Installing Git..."
    choco install git -y
} else {
    Write-Host "✅ Git is already installed."
}

# 3. Install Docker Desktop via Chocolatey
if (!(Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "🐳 Installing Docker Desktop..."
    choco install docker-desktop -y
} else {
    Write-Host "✅ Docker Desktop is already installed."
}

# 4. Prompt to start Docker Desktop manually
Write-Host "⚙️ Please start Docker Desktop manually and complete the initial setup if needed."
Start-Process "Docker Desktop"
Pause

# 5. Clone Supabase repository
$BaseDir = "C:\supabase-project"

if (!(Test-Path $BaseDir)) {
    New-Item -Path $BaseDir -ItemType Directory
}

Set-Location $BaseDir

Write-Host "📦 Cloning the Supabase repository..."
git clone https://github.com/supabase/supabase.git

# 6. Patch docker-compose.yml for Windows compatibility
Write-Host "🛠 Modifying docker-compose.yml for Windows volumes..."
Set-Location "$BaseDir\supabase"

(Get-Content docker\docker-compose.yml) `
    -replace '^\s*- \./volumes/storage:/var/lib/storage:z', '      - supabase_storage:/var/lib/storage' `
    | ForEach-Object { $_ -replace '^\s*- \./volumes/db/data:/var/lib/postgresql/data:Z', '      - supabase_db_data:/var/lib/postgresql/data' } `
    | Set-Content docker\docker-compose.yml

Add-Content docker\docker-compose.yml @"
volumes:
  supabase_db_data:
  supabase_storage:
"@

# 7. Copy project files
Write-Host "📁 Setting up the Supabase project directory..."
Set-Location $BaseDir
Copy-Item -Recurse -Force .\supabase\docker\* .\
Copy-Item -Force .\supabase\docker\.env.example .\.env

# 8. Pull Docker images
Write-Host "📥 Pulling Docker images..."
docker-compose pull

# 9. Prompt for SMTP Email Configuration
$smtpAdminEmail = Read-Host "📧 Enter the admin email for outgoing mail (SMTP_ADMIN_EMAIL)"
$smtpPass = Read-Host "🔑 Enter your Resend SMTP API key (SMTP_PASS)"

@"
SMTP_ADMIN_EMAIL=$smtpAdminEmail
SMTP_HOST=smtp.resend.com
SMTP_PORT=465
SMTP_USER=resend
SMTP_PASS=$smtpPass
SMTP_SENDER_NAME=Supabase Confirmation
"@ | Add-Content .env

# 10. Start Supabase services
Write-Host "🚀 Starting Supabase with Docker Compose..."
docker-compose up -d

Write-Host "🎉 Supabase setup is complete and running!"
Write-Host "🌐 Access Supabase at: http://localhost:8000"