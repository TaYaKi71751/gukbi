# Spring
## Install Spring Tools Suite 3
### [Installation](https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3)
#### For Apple Sillicon Mac
- Install Rosetta2
```bash
softwareupdate --install-rosetta --agree-to-license
```
- Install brew
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```
- Add below to default shell's read command(as like, `/etc/bashrc`, `/etc/zshrc`)
```bash
export PATH="${PATH}:/opt/homebrew/bin"
```
- Install temurin via brew with rosetta2
```bash
arch -x86_64 /bin/bash <<'EOF'
brew install --cask temurin
EOF
```
- Add below to default shell's read command(as like, `/etc/bashrc`, `/etc/zshrc`)
```bash
TEMURIN_JAVA_PATH="$(find /Library/Java/JavaVirtualMachines -type d -maxdepth 1 -name 'temurin-*' | head -n 1)"
if ( ls "${TEMURIN_JAVA_PATH}" &> /dev/null );then
	export JAVA_HOME="${TEMURIN_JAVA_PATH}/Contents/Home"
	export PATH="${JAVA_HOME}/bin:$PATH"
fi
```
