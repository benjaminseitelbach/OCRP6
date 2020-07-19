package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.User;

public interface UsersService {
	
	public void saveUser(User user);
	
	public void saveConnection(User user, User connection);
	
	public void getConnections(User user);
	
	public String getMailById(int id);
}
