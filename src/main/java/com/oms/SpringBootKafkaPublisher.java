package com.oms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaPublisher {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootKafkaPublisher.class);
    public static void main(String[] args) {
        logger.info("Starting Order Kafka Publisher..");
        SpringApplication.run(SpringBootKafkaPublisher.class, args);
        logger.info("started successfully.");

    }
}
