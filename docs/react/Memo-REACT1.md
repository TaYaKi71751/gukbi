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
### eslint
```bash
npx eslint --init
```
### [Example 1](https://github.com/TaYaKi71751/react-01)
#### [Add homepage to package.json](https://github.com/TaYaKi71751/react-01/blob/main/package.json)
#### [Add deploy workflow](https://github.com/TaYaKi71751/react-01/blob/main/.github/workflows/Deploy.yml)
- Go to github repository page
- Click Settings
- Click Actions in Settings
- Click General at Actions in Settings
- Scroll down to 'Workflow permissions'
- Select 'Read and write permissions'
- Click 'Save'
- Create below in to `./.github/workflows/Deploy.yml`
```yaml
name: Build and Deploy

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Build and Deploy React app to GitHub Pages
      uses: omkartapale/react-deployment-gh-pages@v1.0.0
      env:
        CI: false
```
- Commit & Push
- Go to GitHub Repository Settings
- Click Pages
- Select `gh-pages` branch and `/ (root)`
- Click `Save` button
