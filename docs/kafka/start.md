# Start Kafka 
## windows
### winddows WSL2 setup
```
# See here: https://conduktor.io/kafka/how-to-install-apache-kafka-on-windows

# WSL2 is Windows Subsystem for Linux 2 and provides a Linux environment for your Windows computer that does not require a virtual machine

# You can use most Linux commands on WSL2 which makes your Kafka installation experience closer to the guides provided for Linux & Mac.

# To install WSL2, make sure you're on Windows 10 version 2004 and higher (Build 19041 and higher) or Windows 11 To check your Windows version do Windows logo key + R, type winver, select OK

# Steps are here: https://docs.microsoft.com/en-us/windows/wsl/install 

# In an administrator PowerShell:
wsl --install

# Troubleshooting article here: https://docs.microsoft.com/en-us/windows/wsl/troubleshooting

# Launch WSL2 with Ubuntu (default)



# Install Java JDK 11 (Amazon Corretto 11)
# https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/linux-info.html

# For Ubuntu for example: 
wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add - 
sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
sudo apt-get update; sudo apt-get install -y java-11-amazon-corretto-jdk

# Check the Java version
java -version 
# Should say something like openjdk version "11.0.10" 2021-01-19 LTS


# Download Kafka at https://kafka.apache.org/downloads
wget https://archive.apache.org/dist/kafka/3.1.0/kafka_2.13-3.1.0.tgz

# Extract Kafka
tar -xvf kafka_2.13-3.1.0.tgz

# Move the folder
mv kafka_2.13-3.1.0 ~

# Open the Kafka directory
cd kafka_2.13-3.1.0

# Try out a Kafka command
bin/kafka-topics.sh

# Edit .bashrc
nano ~/.bashrc

# Add PATH="$PATH:/your/path/to/your/kafka/bin"
# Example: PATH="$PATH:~/kafka_2.13-3.1.0/bin"

# Open a new terminal
# Try running the command from any directory:
kafka-topics.sh
```
### windows wsl2 start kafka with zookeeper
```sh
################################
##                            ##
##       WITH ZOOKEEPER       ##
##                            ##
################################

# make a zookeeper data directory
mkdir data
mkdir data/zookeeper

# Edit config/zookeeper.properties
# change line to 
# dataDir=/your/path/to/data/zookeeper
# example
# dataDir=/home/stephane/kafka_2.13-3.1.0/data/zookeeper

# start zookeeper (make sure nothing is running on port 2181)
zookeeper-server-start.sh ~/kafka_2.13-3.1.0/config/zookeeper.properties

# Open a new terminal (we leave zookeeper running in previous terminal)

# create Kafka data directory
mkdir data/kafka
# Edit config/server.properties
# change line to 
# log.dirs=/your/path/to/data/kafka
# example
# log.dirs=/home/stephane/kafka_2.13-3.1.0/data/kafka

# start Kafka
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/server.properties

# Kafka is running! 
# Keep the two terminal windows opened
```

### windows wsl2 start kafka with kraft
```sh
################################
##                            ##
##        NO ZOOKEEPER        ##
##                            ##
################################


# create Kafka data directory
mkdir data/kafka-kraft

# Edit config/kraft/server.properties

# change lines to 
# log.dirs=/your/path/to/data/kafka
# example
# log.dirs=/home/stephane/kafka_2.13-3.1.0/data/kafka-kraft


# generate a Kafka UUID
kafka-storage.sh random-uuid

# This returns a UUID, for example 76BLQI7sT_ql1mBfKsOk9Q
kafka-storage.sh format -t <uuid> -c ~/kafka_2.13-3.1.0/config/kraft/server.properties

# This will format the directory that is in the log.dirs in the config/kraft/server.properties file

# start Kafka
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/kraft/server.properties

# Kafka is running! 
# Keep the terminal window opened
```
## Linux
### linux setup
```sh
#################################
#### DOWNLOAD KAFKA BINARIES ####
#################################

# Install Java JDK 11 (Amazon Corretto 11)
# https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/linux-info.html

# For Ubuntu for example: 
wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add - 
sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
sudo apt-get update; sudo apt-get install -y java-11-amazon-corretto-jdk

# Check the Java version
java -version 
# Should say something like openjdk version "11.0.10" 2021-01-19 LTS


# Download Kafka at https://kafka.apache.org/downloads
wget https://archive.apache.org/dist/kafka/3.1.0/kafka_2.13-3.1.0.tgz

# Extract Kafka
tar -xvf kafka_2.13-3.1.0.tgz

# Move the folder
mv kafka_2.13-3.1.0 ~

# Open the Kafka directory
cd kafka_2.13-3.1.0

# Try out a Kafka command
bin/kafka-topics.sh

# Edit .profile
nano ~/.profile

# Add PATH="$PATH:/your/path/to/your/kafka/bin"
# Example: PATH="$PATH:~/kafka_2.13-3.1.0/bin"
nano ~/.bashrc

# Add at the bottom:
# . ~/.profile

# Open a new terminal
# Try running the command from any directory:
kafka-topics.sh
```

### linux start with zoopkeeper
```sh
################################
##                            ##
##       WITH ZOOKEEPER       ##
##                            ##
################################


# make a zookeeper data directory
mkdir data
mkdir data/zookeeper

# Edit config/zookeeper.properties
# change line to 
# dataDir=/your/path/to/data/zookeeper
# example
# dataDir=/home/stephanemaarek/kafka_2.13-3.1.0/data/zookeeper

# start zookeeper (make sure nothing is running on port 2181)
zookeeper-server-start.sh ~/kafka_2.13-3.1.0/config/zookeeper.properties

# Open a new terminal (we leave zookeeper running in previous terminal)

# create Kafka data directory
mkdir data/kafka
# Edit config/server.properties
# change line to 
# log.dirs=/your/path/to/data/kafka
# example
# log.dirs=/home/stephanemaarek/kafka_2.13-3.1.0/data/kafka

# start Kafka
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/server.properties

# Kafka is running! 
# Keep the two terminal windows opened
```

### linux start with kraft
```sh
################################
##                            ##
##        NO ZOOKEEPER        ##
##                            ##
################################


# create Kafka data directory
mkdir data/kafka-kraft

# Edit config/kraft/server.properties

# change lines to 
# log.dirs=/your/path/to/data/kafka
# example
# log.dirs=/home/stephanemaarek/kafka_2.13-3.1.0/data/kafka-kraft


# generate a Kafka UUID
kafka-storage.sh random-uuid

# This returns a UUID, for example 76BLQI7sT_ql1mBfKsOk9Q
kafka-storage.sh format -t <uuid> -c ~/kafka_2.13-3.1.0/config/kraft/server.properties

# This will format the directory that is in the log.dirs in the config/kraft/server.properties file

# start Kafka
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/kraft/server.properties

# Kafka is running! 
# Keep the terminal window opened
```
