package com.example.demo.KafkaChat;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, Message> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        // Specify the Kafka broker(s) address
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // Configure the group ID for your consumer
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "your-consumer-group");

        // Configure key and value deserializers
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class.getName());
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());

        // Specify the deserialization exception handler for deserializing JSON messages
        configProps.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.example.demo.Message");

        // Other Kafka consumer configurations (if needed)

        return new DefaultKafkaConsumerFactory<>(configProps);
    }
}
