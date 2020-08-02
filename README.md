# Spring Boot Kafka Example

This is to demonstrate two simple spring boot microservices which uses kafka to send and receive messages.

## Overview
![GitHub Logo](/Overview.png)

## Project structure:
1. Producer
2. Consumer
3. Docker-compose-files
4. Postman

### Postman
This is collection of postman api's for producer and consumer. Producer can send the messages in string format or json format. ProducerMsg contains sending information via string. ProducerInformation contains informationModel as Json data.

### Docker-compose-files
This contains two docker-compose files
1. only zookeeper and kafka
2. Entire application

### Producer
Here producer uses Apache.kafka library KafkaProducer to send the information. 

#### Note
>If you want to run producer in IDE, please change **kafka.server=localhost:29092** in  **application.properties**. 

### Consumer
Consumer uses Apache kafka library KafkaConsumer to retrive messages from the kafka.
Executors [Thread] is used to read the information from the kafka bus. Upon reading the information, it is placed in internal queue. This used when user try to do get request for messages. Upon performing get operation, messages in the queue are cleared.

#### Note
>If you want to run producer in IDE, please change **kafka.server=localhost:29092** in  **application.properties**. 


## Build procedure
Please pull the latest zookeeper and kafka images

### Pulling zookeeper and kafka images
```
docker pull confluentinc/cp-kafka
docker pull confluentinc/cp-zookeeper
```

### Build producer
Navigate to producer folder
```
./gradlew build -x test
docker build -t producer .
```

### Build consumer
Navigate to consumer folder
```
./gradlew build -x test
docker build -t consumer .
```

### Running End to End Dockers
Navigate to docker-compose-files
```
docker-compose up -d
```

### Stopping docker containers
Navigate to docker-compose-files
```
docker-compose down
```

#### Running only zookeeper and kafka [Only if you want to run producer and consumer in IDE]
Navigate to docker-compose-files
```
docker-compose -f docker-compose-only-kafka-zookeeper.yml up -d
```


