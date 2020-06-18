Start Zookeeper

`zookeeper-server-start.bat config\zookeeper.properties`

Start Kafka Broker

`kafka-server-start.bat config\server.properties`

Kafka console consumer

`kafka-console-consumer.bat --bootrap-server 127.0.0.1:9092 --topic firstTopic --group kafkaFirst`