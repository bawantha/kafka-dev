package com.github.bawantha.kafka.tuto1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithCallBacks {


    public static void main(String[] args) {
        String bootstrapServer = "127.0.0.1:9092";
        final Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallBacks.class);
        //create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //create a producer record

        final ProducerRecord<String, String> record = new ProducerRecord<String, String>("firstTopic", "Hello World");


        //send data
        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                //execute every time if record is successfully send of an execption is thowen

                if (e == null) {
                    logger.info("Received New Meta Data \n" + "Topic: " + recordMetadata.topic() + "\nPartition: " + recordMetadata.partition() + "\n" + "Offset: " + recordMetadata.offset() + "\nTimestamp: " + recordMetadata.timestamp());

                } else {
                    e.printStackTrace();
                }
            }
        });

        // flush data
        producer.flush();
        // flush and close
        producer.close();

    }
}
