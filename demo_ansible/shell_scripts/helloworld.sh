echo "Hellow duniya!"
ssh -o "StrictHostKeyChecking no" -i "/home/jjabbar/Desktop/ssh-keys/JawsDemo.pem" ec2-user@ec2-52-201-234-249.compute-1.amazonaws.com "cd /home/ec2-user/; touch helloWorld"
