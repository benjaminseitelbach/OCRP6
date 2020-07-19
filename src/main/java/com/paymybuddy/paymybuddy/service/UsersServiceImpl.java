package com.paymybuddy.paymybuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paymybuddy.paymybuddy.dao.ConnectionDaoImpl;
import com.paymybuddy.paymybuddy.dao.TransactionDaoImpl;
import com.paymybuddy.paymybuddy.dao.UserDaoImpl;
import com.paymybuddy.paymybuddy.dao.UserTransactionDaoImpl;
import com.paymybuddy.paymybuddy.model.User;

@Repository
public class UsersServiceImpl implements UsersService {
	private UserDaoImpl userDaoImpl;
	private TransactionDaoImpl transactionDaoImpl;
	private UserTransactionDaoImpl usertransactionDaoImpl;
	private ConnectionDaoImpl connectionDaoImpl;
	
	public UsersServiceImpl() {
		userDaoImpl = new UserDaoImpl();
		transactionDaoImpl = new TransactionDaoImpl();
		usertransactionDaoImpl = new UserTransactionDaoImpl();
		connectionDaoImpl = new ConnectionDaoImpl();
	}
	
	public void saveUser(User user) {
		userDaoImpl.saveUser(user);
	}
	
	public void saveConnection(User user, User connection) {
		int userId = user.getId();
		int connectionId = connection.getId();
		connectionDaoImpl.saveConnection(userId, connectionId);
	}
	
	public void getConnections(User user) {
		int userId = user.getId();
		List<Integer> connectionsIds = connectionDaoImpl.getConnectionsIds(userId);
		List<String> connectionsMails = new ArrayList<>();
		for(Integer connectionId : connectionsIds) {
			String connectionMail = userDaoImpl.getMail(connectionId);
			connectionsMails.add(connectionMail);
		}
		System.out.println("Connections of " + user.getMail() + ": " + connectionsMails);
	}
	
	public String getMailById(int userId) {
		return userDaoImpl.getMail(userId);
	}
}
