package com.example.demo.KafkaChat;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "messages-topic", groupId = "my-group")
    public void consumeMessage(Message message) {
        // Process the received message
        // You can implement logic here to send the message to the intended user
    }
}
