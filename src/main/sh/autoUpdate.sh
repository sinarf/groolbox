#!/bin/sh
# @author Michel Blavin 
# 
# Auto update script for ubuntu. can be used via crontab : crontab -e 
#  @daily /home/sinarf/Dropbox/dev/groolbox/src/main/sh/autoUpdate.sh
#


echo "Remove useless software: "
sudo apt-get -y -qq remove libreoffice banshee &&\
sudo apt-get -y -qq autoremove &&\

echo "Update everything"
sudo apt-get -y -qq update &&\
sudo apt-get -y -qq upgrade &&\

echo "Install software"
sudo apt-get install -y -qq gawk maven2 groovy rar git git-gui openssh-server lm-sensors lame gpodder gparted gimp  chameleon-cursor-theme quicksynergy xsensors conduit screen subversion frozen-bubble wine hplip hplip-gui powertop compizconfig-settings-manager filezilla tasque  xubuntu-restricted-extras quicksynergy openjdk-7-jdk aspell-fr curl vim-gnome giggle bzr freeplane exuberant-ctags  mercurial remmina startupmanager   glipper &&\

echo "Install Custom applications"
sudo dpkg -i /home/sinarf/Dropbox/softs/linux/*.deb


sudo update-java-alternatives -s java-6-sun
