package com.paymybuddy.paymybuddy.model;

import java.util.List;

public class User {
	private int id;
	private String mail;
	private String password;
	private List<User> connections;
	//private List<Transaction> transactions;
	
	
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
	
	public User(int id, String mail, String password) {
		this.id = id;
		this.mail = mail;
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getPassword() {
		return password;
	}
}
