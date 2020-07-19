package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;

public interface TransactionsService {

	public void saveTransaction(User user, Transaction transaction);
	
	public void getTransactions(User user);
	
	public void getReceivedTransactions(User user);
}
