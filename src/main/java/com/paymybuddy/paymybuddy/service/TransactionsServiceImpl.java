package com.paymybuddy.paymybuddy.service;

import java.util.ArrayList;
import java.util.List;

import com.paymybuddy.paymybuddy.dao.TransactionDaoImpl;
import com.paymybuddy.paymybuddy.dao.UserDaoImpl;
import com.paymybuddy.paymybuddy.dao.UserTransactionDaoImpl;
import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;

public class TransactionsServiceImpl implements TransactionsService {
	private UserDaoImpl userDaoImpl;
	private TransactionDaoImpl transactionDaoImpl;
	private UserTransactionDaoImpl userTransactionDaoImplImpl;
	
	public TransactionsServiceImpl() {
		userDaoImpl = new UserDaoImpl();
		transactionDaoImpl = new TransactionDaoImpl();
		userTransactionDaoImplImpl = new UserTransactionDaoImpl();
	}

	public void saveTransaction(User user, Transaction transaction) {
		transactionDaoImpl.saveTransaction(transaction);
		userTransactionDaoImplImpl.saveUserTransaction(user, transaction);
	}
	
	public void getTransactions(User user) {
		int userId = user.getId();
		List<Integer> transactionsIds = userTransactionDaoImplImpl.getTransactions(userId);
		List<Transaction> transactions = new ArrayList<>();
		for(Integer transactionId : transactionsIds) {
			Transaction transaction = transactionDaoImpl.getTransaction(transactionId);
			int receiverId = transaction.getReceiverId();
			String receiverMail = userDaoImpl.getMail(receiverId);
			User receiver = new User();
			receiver.setMail(receiverMail);
			transaction.setReceiver(receiver);
			transactions.add(transaction);
		}
		System.out.println("Transactions de " + user.getMail() + ":");
		for(Transaction transaction : transactions) {
			System.out.println(transaction.getAmount() + "€ de " + transaction.getDescription() + " pour " + 
					transaction.getReceiver().getMail() );
		}
	}
	
	public void getReceivedTransactions(User user) {
		List<Integer> transactionsIds = transactionDaoImpl.getReceivedTransactionsIds(user.getId());
		List<Transaction> transactions = new ArrayList<>();
		for(Integer transactionId : transactionsIds) {
			Transaction transaction = transactionDaoImpl.getTransaction(transactionId);
			int transmitterId = userTransactionDaoImplImpl.getUserId(transactionId);
			String transmitterMail = userDaoImpl.getMail(transmitterId);
			User transmitter = new User();
			transmitter.setMail(transmitterMail);
			transaction.setTransmitter(transmitter);
			transactions.add(transaction);			
		}
		System.out.println("Transactions reçues de " + user.getMail() + ":");
		for(Transaction transaction : transactions) {
			System.out.println(transaction.getAmount() + "€ de " + transaction.getDescription() + " par " + 
					transaction.getTransmitter().getMail() );
		}
		
	}
}
