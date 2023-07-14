# Kafka CLI commands
## Kafka Topics
```sh
# Replace "kafka-topics.sh" 
# by "kafka-topics" or "kafka-topics.bat" based on your system # (or bin/kafka-topics.sh or bin\windows\kafka-topics.bat if you didn't setup PATH / Environment variables)


############################
### CONDUKTOR PLATFORM #####
############################ 

# Create your playground.config file
# with content such as 
security.protocol=SASL_SSL
sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule required username="<your username>" password="<your password>";
sasl.mechanism=PLAIN

# Start running commands
kafka-topics.sh 

kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092

kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --create --topic first_topic

kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --create --topic second_topic --partitions 5

# this will create a topic with an RF of 3 (behaviour of using Conduktor Platform - all topics have the same RF of 3)
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --create --topic third_topic --replication-factor 2

# list topics
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --list

# describe topics
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --describe

# delete topics
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic second_topic --delete



############################
#####     LOCALHOST    #####
############################

kafka-topics.sh 

kafka-topics.sh --bootstrap-server localhost:9092 --list 

kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --create

kafka-topics.sh --bootstrap-server localhost:9092 --topic second_topic --create --partitions 3

kafka-topics.sh --bootstrap-server localhost:9092 --topic third_topic --create --partitions 3 --replication-factor 2

# Create a topic (working)
kafka-topics.sh --bootstrap-server localhost:9092 --topic third_topic --create --partitions 3 --replication-factor 1

# List topics
kafka-topics.sh --bootstrap-server localhost:9092 --list 

# Describe a topic
kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --describe

# Delete a topic 
kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --delete
# (only works if delete.topic.enable=true)

```

## Kafka console producer
```sh
# Replace "kafka-console-producer.sh" 
# by "kafka-console-producer" or "kafka-console-producer.bat" based on your system # (or bin/kafka-console-producer.sh or bin\windows\kafka-console-producer.bat if you didn't setup PATH / Environment variables)

kafka-console-producer.sh 

############################
### CONDUKTOR PLATFORM #####
############################ 


kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --create --partitions 1

# producing
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic 
>Hello World
>My name is Conduktor
>I love Kafka
>^C  (<- Ctrl + C is used to exit the producer)


# producing with properties
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --producer-property acks=all
> some message that is acked
> just for fun
> fun learning!


# producing to a non existing topic
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic new_topic
> hello world!

# if topic auto creation is disabled (by default on playground), then the topic will not appear in the list
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --list

# overall, please create topics with the appropriate number of partitions before producing to them!


# produce with keys
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --property parse.key=true --property key.separator=:
>example key:example value
>name:Stephane



############################
#####     LOCALHOST    #####
############################

kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --create --partitions 1

# producing
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic 
> Hello World
>My name is Conduktor
>I love Kafka
>^C  (<- Ctrl + C is used to exit the producer)


# producing with properties
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic --producer-property acks=all
> some message that is acked
> just for fun
> fun learning!


# producing to a non existing topic
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic new_topic
> hello world!

# our new topic only has 1 partition
kafka-topics.sh --bootstrap-server localhost:9092 --list
kafka-topics.sh --bootstrap-server localhost:9092 --topic new_topic --describe


# edit config/server.properties or config/kraft/server.properties
# num.partitions=3

# produce against a non existing topic again
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic new_topic_2
hello again!

# this time our topic has 3 partitions
kafka-topics.sh --bootstrap-server localhost:9092 --list
kafka-topics.sh --bootstrap-server localhost:9092 --topic new_topic_2 --describe

# overall, please create topics with the appropriate number of partitions before producing to them!


# produce with keys
kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic --property parse.key=true --property key.separator=:
>example key:example value
>name:Stephane
```


## Kafka console consumer
```sh
# Replace "kafka-console-consumer.sh" 
# by "kafka-console-consumer" or "kafka-console-consumer.bat" based on your system # (or bin/kafka-console-consumer.sh or bin\windows\kafka-console-consumer.bat if you didn't setup PATH / Environment variables)

kafka-console-consumer.sh 

############################
### CONDUKTOR PLATFORM #####
############################ 

# create a topic with 3 partitions
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic second_topic --create --partitions 3

# consuming
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic second_topic

# other terminal
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner --topic second_topic

# consuming from beginning
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic second_topic --from-beginning

# display key, values and timestamp in consumer
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic second_topic --formatter kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true --from-beginning



############################
#####     LOCALHOST    #####
############################

# create a topic with 3 partitions
kafka-topics.sh --bootstrap-server localhost:9092 --topic second_topic --create --partitions 3

# consuming
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic

# other terminal
kafka-console-producer.sh --bootstrap-server localhost:9092 --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner --topic second_topic

# consuming from beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic --from-beginning

# display key, values and timestamp in consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second_topic --formatter kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true --from-beginning
```



## Kafka console consumer in groups
```sh
# Replace "kafka-console-consumer.sh" 
# by "kafka-console-consumer" or "kafka-console-consumer.bat" based on your system # (or bin/kafka-console-consumer.sh or bin\windows\kafka-console-consumer.bat if you didn't setup PATH / Environment variables)

############################
### CONDUKTOR PLATFORM #####
############################ 

# create a topic with 3 partitions
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic third_topic --create --partitions 3

# start one consumer
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic third_topic --group my-first-application

# start one producer and start producing
kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner --topic third_topic 

# start another consumer part of the same group. See messages being spread
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic third_topic --group my-first-application

# start another consumer part of a different group from beginning
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic third_topic --group my-second-application --from-beginning


############################
#####     LOCALHOST    #####
############################

# create a topic with 3 partitions
kafka-topics.sh --bootstrap-server localhost:9092 --topic third_topic --create --partitions 3

# start one consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic third_topic --group my-first-application

# start one producer and start producing
kafka-console-producer.sh --bootstrap-server localhost:9092 --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner --topic third_topic

# start another consumer part of the same group. See messages being spread
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic third_topic --group my-first-application

# start another consumer part of a different group from beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic third_topic --group my-second-application --from-beginning
```

## Kafka console consumer groups
```sh
 # Replace "kafka-consumer-groups.sh" 
# by "kafka-consumer-groups" or "kafka-consumer-groups.bat" based on your system # (or bin/kafka-consumer-groups.sh or bin\windows\kafka-consumer-groups.bat if you didn't setup PATH / Environment variables)


############################
### CONDUKTOR PLATFORM #####
############################ 


# documentation for the command 
kafka-consumer-groups.sh 

# list consumer groups
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --list
 
# describe one specific group
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --describe --group my-second-application

# describe another group
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --describe --group my-first-application

# start a consumer
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --group my-first-application

# describe the group now
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --describe --group my-first-application

# describe a console consumer group (change the end number)
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --describe --group console-consumer-10592

# start a console consumer
kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --group my-first-application

# describe the group again
kafka-consumer-groups.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --describe --group my-first-application


############################
#####     LOCALHOST    #####
############################


# documentation for the command 
kafka-consumer-groups.sh 

# list consumer groups
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
 
# describe one specific group
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-second-application

# describe another group
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-application

# start a consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --group my-first-application

# describe the group now
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-application

# describe a console consumer group (change the end number)
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group console-consumer-10592

# start a console consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --group my-first-application

# describe the group again
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-application
```
