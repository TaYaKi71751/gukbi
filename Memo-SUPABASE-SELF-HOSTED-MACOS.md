# Supabase
## Install
```bash
brew install docker
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
cat >> $HOME/.bashrc << EOF
if ( which colima &> /dev/null );then
    colima start &> /dev/null &
fi
EOF
colima start
git clone https://github.com/supabase/supabase.git
cd supabase
patch -p1 docker/docker-compose.yml <<EOF
237c237
<       - ./volumes/storage:/var/lib/storage:z
---
>       - supabase_storage:/var/lib/storage
400c400
<       - ./volumes/db/data:/var/lib/postgresql/data:Z
---
>       - supabase_db_data:/var/lib/postgresql/data
528a529,530
>   supabase_db_data:
>   supabase_storage:
EOF
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