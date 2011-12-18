#!/bin/sh
# @author Michel Blavin 
# 
# Auto update script for ubuntu. can be used via crontab : crontab -e 
#  @daily /home/sinarf/Dropbox/dev/groolbox/src/main/sh/autoUpdate.sh
#

echo "Install software" 
sudo apt-get install -y -qq gawk maven2 groovy rar git git-gui openssh-server lm-sensors lame gpodder gparted gimp  chameleon-cursor-theme quicksynergy xsensors conduit screen subversion frozen-bubble wine hplip hplip-gui powertop compizconfig-settings-manager filezilla aspell-fr curl vim-gnome giggle bzr freeplane exuberant-ctags  mercurial remmina startupmanager giggle-personal-details-plugin glipper libxml2-utils gradle gitmagic rabbitvcs-nautilus

echo "Remove useless software: "
sudo apt-get -y -qq remove libreoffice banshee &&\
sudo apt-get -y -qq autoremove 

echo "Update everything" 
sudo apt-get -y -qq update &&\
sudo apt-get -y -qq upgrade


