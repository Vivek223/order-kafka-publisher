package com.oms.demo;

import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.time.Duration;
import java.util.Collections;

public class KafkaMessageConsumer {
    public static void main(String[] args) {
        // Set Kafka consumer properties
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Change this to your Kafka broker address
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group"); // Change this to your consumer group ID
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        // Create Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to Kafka topic(s)
        consumer.subscribe(Collections.singletonList("vivek1")); // Change this to your Kafka topic name

        // Poll for new messages
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100)); // Adjust poll duration as needed
                records.forEach(record -> {
                    System.out.println("Received message: " + record.value());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close(); // Close the consumer when done
        }
    }
}