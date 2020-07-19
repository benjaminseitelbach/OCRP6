package com.paymybuddy.paymybuddy.dao;

import com.paymybuddy.paymybuddy.model.User;

public interface UserDao {
	public boolean saveUser(User user);
	
	public String getMail(int userId);
	
}
