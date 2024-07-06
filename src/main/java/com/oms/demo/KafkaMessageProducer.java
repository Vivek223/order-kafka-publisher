package com.oms.demo;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaMessageProducer {
    public static void main(String[] args) {
        // Set Kafka broker properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Change this to your Kafka broker address
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");

        // Create Kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Define topic name
        String topicName = "vivek1"; // Change this to your Kafka topic name

        // Send messages to Kafka topic
        try {
            for (int i = 11; i < 21; i++) {
                String message = "Test message #" + i;
                ProducerRecord<String, String> record = new ProducerRecord<>(topicName, message);
                producer.send(record);
                System.out.println("Sent message: " + message);
                Thread.sleep(1000); // Wait for 1 second between each message
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close(); // Close the producer when done
        }
    }
}