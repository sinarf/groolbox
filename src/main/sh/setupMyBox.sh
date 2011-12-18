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

echo "Git integration in Nautilus"
sudo add-apt-repository ppa:rabbitvcs/ppa

sudo ./autoUpdate.sh

echo "Added some watch stuff for Dropbox."
sudo sysctl fs.inotify.max_user_watches=100001
echo "Correct the stupid choice to move the button to the left. "
gconftool -s --type string /apps/metacity/general/button_layout ":minimize,maximize,close";


# groovy stuff
groovy ~/Dropbox/dev/groolbox/src/main/groovy/WorkstationSetup.groovy

echo "Install Custom applications"
sudo dpkg -i /home/sinarf/Dropbox/softs/linux/*.deb

sudo update-java-alternatives -s java-1.7.0-openjdk-i386
