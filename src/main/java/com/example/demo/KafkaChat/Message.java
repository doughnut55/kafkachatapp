package com.example.demo.KafkaChat;



import com.example.demo.UserStuff.User;

public class Message {
    private User sender;
    private User receiver;
    private String content;
    private String timestamp;
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Message(User sender, User receiver, String content, String timestamp) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.timestamp = timestamp;
	}
	public Message() {
		
	}
    // Constructors, getters, and setters
}
