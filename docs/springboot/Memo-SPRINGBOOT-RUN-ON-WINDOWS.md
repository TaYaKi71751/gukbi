# SpringBoot
## Windows
```powershell
# cd to project then run
gradlew.bat bootRun
```
### Auto restart
#### Installation
```powershell
# RUN AS ADMINISTRATOR
choco install watchexec
```
```powershell
watchexec -r -e java,xml,jsp,html,css,js,properties,gradle -i '.gradle' -i '.idea' -i 'out' -- gradlew.bat clean bootRun
```