./setupMyBox.sh
sudo apt-get install -y -qq thinkfinger-tools  libpam-thinkfinger  thinkfan &&\
sudo tf-tool --acquire &&\
sudo tf-tool --verify &&\
sudo /usr/lib/pam-thinkfinger/pam-thinkfinger-enable
