# SpringBoot
## MacOS
```bash
# cd to project then run
./gradlew bootRun
```
### Auto restart
#### Installation
```bash
brew install watchexec
```
#### Run
```bash
watchexec -r -e java,xml,jsp,html,css,js,properties,gradle -i '.gradle' -i '.idea' -i 'out' -- ./gradlew clean bootRun
```