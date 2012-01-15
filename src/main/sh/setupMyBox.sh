#!/bin/sh
# @author Michel Blavin 
# 
# This script sets up my ubuntu box  after a reinstallation. 
#

# zenity --question --text="Did you enable the partner repo and setup Ubuntu One? "
# if [ $? -eq 1 ] ; then 
# 	zenity --info --text="Enable the partner repo first."
# 	exit 0
# fi

echo "Git integration in Nautilus"
sudo add-apt-repository ppa:rabbitvcs/ppa


echo "installing groovy"
sudo apt-get install -yy groovy 

sudo groovy autoUpdate.groovy
# groovy stuff
groovy ~/Dropbox/dev/groolbox/src/main/groovy/WorkstationSetup.groovy

