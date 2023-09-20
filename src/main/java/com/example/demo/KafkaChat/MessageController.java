package com.example.demo.KafkaChat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; // Import the @Autowired annotation
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.UserStuff.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer messageProducer;
    private final UserService userService; // Inject UserService

    @Autowired // Use @Autowired for constructor injection
    public MessageController(MessageProducer messageProducer, UserService userService) {
        this.messageProducer = messageProducer;
        this.userService = userService; // Initialize the userService
    }

    @PostMapping("/{sender}/send/{receiver}")
    public void sendMessage(
        @PathVariable("sender") String senderUsername,
        @PathVariable("receiver") String receiverUsername,
        @RequestBody String content
    ) {
        // Load user information for sender and receiver based on their usernames
        Optional<User> senderOptional = userService.getUserByUsername(senderUsername);
        Optional<User> receiverOptional = userService.getUserByUsername(receiverUsername);

        // Check if sender and receiver exist and perform any necessary validations
        if (senderOptional.isPresent() && receiverOptional.isPresent()) {
            User sender = senderOptional.get();
            User receiver = receiverOptional.get();

            // Create a message and send it to Kafka
            Message message = new Message(sender, receiver, content, LocalDateTime.now().toString());
            messageProducer.sendMessage("messages-topic", message);
        } else {
            // Handle the case where either sender or receiver does not exist
            // You can return an error response or take appropriate action
        }
    }
}


