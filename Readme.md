Start Zookeeper

`zookeeper-server-start.bat config\zookeeper.properties`

Start Kafka Broker

`kafka-server-start.bat config\server.properties`

Kafka console consumer

`kafka-console-consumer.bat --bootrap-server 127.0.0.1:9092 --topic firstTopic --group kafkaFirst`

**Java Producer with Keys**

providing keys guarantee same key goes for same partition


`        final ProducerRecord<String, String> record = new ProducerRecord<String, String>("firstTopic", HERE_KEY "Hello World");
`
