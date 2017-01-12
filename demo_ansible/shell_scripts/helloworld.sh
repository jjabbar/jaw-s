echo "Hellow duniya!"
currentPath=`pwd`
echo "current path [$currentPath]"
pwd
chmod 400 JawsDemo.pem
ssh -o "StrictHostKeyChecking no" -i "JawsDemo.pem" ec2-user@ec2-52-201-234-249.compute-1.amazonaws.com "cd /home/ec2-user/; touch helloWorld"
