package com.example.demo.KafkaChat;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @KafkaListener(topics = "messages-topic", groupId = "my-group")
    public void receiveMessage(Message message) {
        // Check if the message is intended for this recipient
        if (message.getReceiver().equals("current-username")) {
            // Process and handle received messages
            System.out.println("Received message from " + message.getSender() + ": " + message.getContent());
        }
    }
}
