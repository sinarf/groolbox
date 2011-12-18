cd ~/.ssh/
ssh-keygen -t rsa -C "michel@blavin.fr"
echo "Goto https://github.com/account/ssh and paste the following "
echo "********************************************************************************"
cat ~/.ssh/id_rsa.pub
echo "********************************************************************************"
google-chrome https://github.com/account/ssh
