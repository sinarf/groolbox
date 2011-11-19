#!/bin/sh
# @author Michel Blavin 
# 
# This script sets up my ubuntu box  after a reinstallation. 
#

zenity --question --text="Did you enable the partner repo and setup Ubuntu One? "
if [ $? -eq 1 ] ; then 
	zenity --info --text="Enable the partner repo first."
	exit 0
fi
sudo ./autoUpdate.sh
sudo update-java-alternatives -s java-1.7.0-openjdk-i386
echo "Added some watch stuff for Dropbox."
sudo sysctl fs.inotify.max_user_watches=100001
echo "Correct the stupid choice to move the button to the left. "
gconftool -s --type string /apps/metacity/general/button_layout ":minimize,maximize,close";

zenity --question --text="Do you want to install the thinkpad stuff? "
if [ $? -eq 1 ] ; then
	echo "thinkpad stuff won't be installed". 
else 
	sudo apt-get install -y -qq thinkfinger-tools  libpam-thinkfinger  thinkfan &&\
	sudo tf-tool --acquire &&\
	sudo tf-tool --verify &&\
	sudo /usr/lib/pam-thinkfinger/pam-thinkfinger-enable
fi
# groovy stuff
groovy ~/Dropbox/dev/groolbox/src/main/groovy/WorkstationSetup.groovy
