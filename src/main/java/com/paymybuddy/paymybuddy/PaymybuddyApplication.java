package com.paymybuddy.paymybuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paymybuddy.paymybuddy.dao.UserDao;
import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.TransactionsService;
import com.paymybuddy.paymybuddy.service.UsersService;

@SpringBootApplication
public class PaymybuddyApplication {

	public static void main(String[] args) {
		User user = new User("jforet@gmail.com", "pwd");
		UserDao userDao = new UserDao();
		userDao.create(user);
		/*
		UsersService usersService = new UsersService();
		TransactionsService transactionsService = new TransactionsService();
		User user = new User();
		user.setId(1);
		user.setMail("bseitelbach@gmail.com");
		user.setPassword("password");
		
		
		User user2 = new User();
		user2.setId(2);
		user2.setMail("jforet@gmail.com");
		user2.setPassword("password");
		*/
		/*
		usersService.saveUser(user);
		usersService.saveUser(user2);
		
		usersService.saveConnection(user, user2);
		usersService.saveConnection(user2, user);
		*/
		/*
		Transaction transaction = new Transaction();
		transaction.setId(4);
		transaction.setAmount(30);
		transaction.setDescription("soiree");
		transaction.setReceiver(user2);
				
		transactionsService.saveTransaction(user, transaction);
		*/
		/*
		transactionsService.getReceivedTransactions(user);
		transactionsService.getReceivedTransactions(user2);
		*/
		//usersService.getConnections(user);
		
		SpringApplication.run(PaymybuddyApplication.class, args);
	}

}
