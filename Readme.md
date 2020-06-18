Start Zookeeper

`zookeeper-server-start.bat config\zookeeper.properties`

Start Kafka Broker

`kafka-server-start.bat config\server.properties`

Kafka console consumer

`kafka-console-consumer.bat --bootrap-server 127.0.0.1:9092 --topic firstTopic --group kafkaFirst`

**Java Producer with Keys**

providing keys guarantee same key goes for same partition
 

` ``       final ProducerRecord<String, String> record = new ProducerRecord<String, String>("firstTopic", HERE_KEY "Hello World");
`
**Java Consumer **

`properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
         //producer get the string and serialized in to byte send to consumer hence consumer needs to deserialize the bytes to convert String
         properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
         // value deserializer
         properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
         properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,groupId);`

Kafka `AUTO_OFFSET_RESET_CONFIG`

_earliest_: read from beginning     
_latest_ read from only new messages
_none_ will throw and error if no offest set

    