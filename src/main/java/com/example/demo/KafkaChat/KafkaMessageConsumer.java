package com.example.demo.KafkaChat;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {

    private final SimpMessagingTemplate messagingTemplate;

    public KafkaMessageConsumer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "messages-topic")
    public void consumeMessage(Message message) {
        // Process the incoming Kafka message
        // You can add logic here to transform the message if needed

        // Send the message to connected WebSocket clients
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
