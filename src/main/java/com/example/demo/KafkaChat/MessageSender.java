package com.example.demo.KafkaChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    private static final String TOPIC = "messages-topic";

    public void sendMessage(Message message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
