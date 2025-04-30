# Supabase
## Install brew
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
echo 'export PATH="${PATH}:/opt/homebrew/bin"' >> ~/.zshrc
echo 'export PATH="${PATH}:/opt/homebrew/bin"' >> ~/.profile
source ~/.zshrc
source ~/.profile
```
## Install docker
```bash
brew install openssl
brew install docker
brew install docker-compose
brew install colima
brew install qemu
```
## Config colima
```bash
cd $HOME
cat >> $HOME/.zshrc << EOF
if ( which colima &> /dev/null );then
    colima start &> /dev/null &
fi
EOF
cat >> $HOME/.profile << EOF
if ( which colima &> /dev/null );then
    colima start &> /dev/null &
fi
EOF
source ~/.zshrc
source ~/.profile
```
## Config Docker (Run once)
```bash
colima start
git clone https://github.com/supabase/supabase.git
cd supabase
sed -i '' 's/\.\/volumes\/db\/data:/supabase_db_data:/g' docker/docker-compose.yml
sed -i '' 's/\.\/volumes\/storage:/supabase_storage:/g' docker/docker-compose.yml
echo "  supabase_db_data:" >> docker/docker-compose.yml
echo "  supabase_storage:" >> docker/docker-compose.yml
cd $HOME
mkdir -p $HOME/supabase-project
cp -rf supabase/docker/* supabase-project
cp supabase/docker/.env.example supabase-project/.env
cd $HOME/supabase-project
docker-compose pull
```
## [Email Sender (resend.com)](https://resend.com)
### Config
```bash
cat >> $HOME/supabase-proejct/.env << EOF
SMTP_ADMIN_EMAIL=여기에_RESEND에_연동한_이메일을_입력하세요
SMTP_HOST=smtp.resend.com
SMTP_PORT=465
SMTP_USER=resend
SMTP_PASS=여기에_RESEND키를_붙여_넣으세요
SMTP_SENDER_NAME=Supabase
EOF
```
## Run
```bash
cd $HOME/supabase-project
docker-compose up -d
```
## Etc
- .env 파일을 수정하여 설정을 변경 할 수 있다.
- 실제로 사용 해야 할 경우 .env 파일에서 POSTGRES_PASSWORD,JWT_SECRET,ANON_KEY,SERVICE_ROLE_KEY,DASHBOARD_USERNAME,DASHBOARD_PASSWORD,SECRET_KEY_BASE,VAULT_ENC_KEY 등을 수정 해야 한다
```
만약 POSTGRES_PASSWORD를 바꾸고 싶다면
```
```bash
docker exec -it supabase-db psql -U supabase_admin
```
```sql
ALTER USER postgres WITH PASSWORD 'NEW_PASSWORD';
```
```
를 실행 해주고 .env파일에서 POSTGRES_PASSWORD를 설정 해주면 된다.
```
```bash
# 입력한 길이만큼의 크기의 랜덤한 base64를 만든다
# JWT_SECRET, ANON_KEY, SERVICE_ROLE_KEY, DASHBOARD_PASSWORD, SECRET_KEY_BASE, VAULT_ENC_KEY 등에 사용 가능
openssl rand -base64 길이
```