#!/bin/sh
# @author sinarf
# this script sets up the git aliases. 

# I started this script from this post 
# http://superuser.com/questions/169695/what-are-your-favorite-git-aliases

##
# Abbreviations
git config --global alias.st status
git config --global alias.co checkout
git config --global alias.ci commit
git config --global alias.br branch

##
# Pimp-out log:
# From: http://www.jukie.net/bart/blog/pimping-out-git-log
git config --global alias.lg "log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit --date=relative"

##
# Quickly Commit / Uncommit Work-In-Progress
# By David Gageot (http://gist.github.com/492227): 
git config --global alias.wip "git add -A; git ls-files --deleted -z | xargs -0 git rm; git commit -m \"wip\""
git config --global alias.unwip "git log -n 1 | grep -q -c wip && git reset HEAD~1"

## 
# commit + sign
git config --global alias.cs "commit -s"

