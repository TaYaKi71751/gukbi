# Supabase
## Install
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
echo 'export PATH="${PATH}:/opt/homebrew/bin"' >> ~/.zshrc
echo 'export PATH="${PATH}:/opt/homebrew/bin"' >> ~/.profile
source ~/.zshrc
source ~/.profile
```
```bash
brew install docker
brew install docker-compose
brew install colima
brew install qemu
```
## Config
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