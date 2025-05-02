# React
## Create Project
### JavaScript
```bash
npx create-react-app react01
```
### TypeScript
```bash
npx create-react-app react01 --template typescript
```
### npx Error on Windows
```powershell
Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
# Then type Y and Enter
```
### npx Error on macos
```
npx create-react-app react01
npm error code EACCES
npm error syscall open
npm error path /Users/tayaki71751/.npm/_cacache/tmp/2ca2ba2d
npm error errno EACCES
npm error
npm error Your cache folder contains root-owned files, due to a bug in
npm error previous versions of npm which has since been addressed.
npm error
npm error To permanently fix this problem, please run:
npm error   sudo chown -R 501:20 "/Users/tayaki71751/.npm"
npm error Log files were not written due to an error writing to the directory: /Users/tayaki71751/.npm/_logs
npm error You can rerun the command with `--loglevel=verbose` to see the logs in your terminal
```
```bash
# Run
sudo chown -R 501:20 "$HOME/.npm"
```