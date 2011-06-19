#!/bin/sh
# @author Michel Blavin 
# 
# This script sets up my ubuntu box  after a reinstallation. 
#



echo "Remove useless software"
sudo apt-get -y -qq remove libreoffice firefox banshee &&\
sudo apt-get -y -qq autoremove &&\

echo "Update everything"
sudo apt-get -y -qq update &&\
sudo apt-get -y -qq upgrade &&\

echo "Install software"
sudo apt-get install -y -qq maven2 groovy rar git git-gui openssh-server lm-sensors lame hddtemp gpodder gparted gimp  chameleon-cursor-theme quicksynergy xsensors conduit screen subversion frozen-bubble wine hplip hplip-gui powertop compizconfig-settings-manager filezilla tasque monodevelop sun-java6-jdk sun-java6-plugin quicksynergy gnome-do tomboy-blogposter playonlinux aspell-fr curl vim-gnome giggle docky bzr freeplane exuberant-ctags  thunderbird-gnome-support xul-ext-lightning mercurial &&\

sudo update-java-alternatives -s java-6-sun
echo "Correct the stupid choice to move the button to the left. "
gconftool -s --type string /apps/metacity/general/button_layout ":minimize,maximize,close";

# TODO add the possiblity to install thinkpad finger reader and configure it. 
zenity --question --text="Do you want to install the thinkpad stuff? "
if [ $? -eq 1 ] ; then
	echo "thinkpad stuff won't be installed". 
else 
	sudo apt-get install -y -qq thinkfinger-tools  libpam-thinkfinger  thinkfan &&\
	sudo tf-tool --acquire &&\
	sudo tf-tool --verify &&\
	sudo /usr/lib/pam-thinkfinger/pam-thinkfinger-enable
fi
