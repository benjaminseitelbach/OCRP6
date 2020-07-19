package com.paymybuddy.paymybuddy.model;

public class Transaction {
	private int id;
	private float amount;
	private String description;
	private int receiverId;
	private User receiver;
	private User transmitter;
	private int connectionId;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public void setTransmitter(User transmitter) {
		this.transmitter = transmitter;
	}
	
	public void setConnexionId(int connectionId) {
		this.connectionId = connectionId;
	}
	
	public int getId() {
		return id;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getReceiverId() {
		return receiverId;
	}
	
	public User getReceiver() {
		return receiver;
	}
	
	public User getTransmitter() {
		return transmitter;
	}
	
	public int getConnectionId() {
		return connectionId;
	}
}
