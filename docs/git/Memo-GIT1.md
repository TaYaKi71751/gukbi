# Git
## [clone](https://git-scm.com/docs/git-clone)
```bash
# This clones from remote to local in directory named 'Repository'
git clone https://github.com/UserName/Repository.git
```
## [init](https://git-scm.com/docs/git-init)
```bash
# This creates init files for git in current directory with branch named 'main'
git init --initial-branch=main
```
## [commit](https://git-scm.com/docs/git-commit)
```bash
# This creates commit with staged files
git commit -m 'Commit Message'
# This edits current commit
git commit --amend
```
## [remote](https://git-scm.com/docs/git-remote)
### add
```bash
# This adds remote named 'origin' with url
git remote add origin https://github.com/UserName/Repository.git
```
### set-url
```bash
# This sets url of remote named 'origin'
git remote set-url origin https://github.com/UserName/Repository.git
```
## [rebase](https://git-scm.com/docs/git-rebase)
```bash
# Usage
git rebase -i HEAD~5
```
## [pull](https://git-scm.com/docs/git-pull)
```bash
# This pulls from remote
# WARNING : somehow remote and local edit any same files, it occurrs conflicts
git pull
```
### --rebase
```bash
# This can pull when you commited early than remote and you want to pull
# WARNING : somehow remote and local edit any same files, it occurrs conflicts
git pull --rebase
```
## [fetch](https://git-scm.com/docs/git-fetch)
## [merge](https://git-scm.com/docs/git-merge)
## [branch](https://git-scm.com/docs/git-branch)
```bash
# Creates branch named 'sub' force-fully from HEAD
git branch -f sub
```
## [checkout](https://git-scm.com/docs/git-checkout)
```bash
# This goes in to branch named 'sub'
git checkout sub
```