package com.paymybuddy.paymybuddy.constants;

public class DBConstants {
	public static final String SAVE_USER = "insert into user(MAIL, PASSWORD) values(?,?)";
	public static final String SAVE_TRANSACTION = "insert into transaction(AMOUNT, DESCRIPTION, RECEIVER) values(?,?,?)";
	public static final String SAVE_USER_TRANSACTION = "insert into user_transaction(user_ID, transaction_ID) values(?,?)";
	public static final String SAVE_CONNECTION = "insert into connection(user_ID, user_ID1) values(?,?)";
	public static final String GET_CONNECTIONS = "select user_ID1 from connection where user_ID = ?";
	public static final String GET_MAIL = "select MAIL from user where ID = ?";
	public static final String GET_TRANSACTIONSIDS_USERTRANSACTION = "select transaction_ID from user_transaction where user_ID = ?";
	public static final String GET_TRANSACTION = "select AMOUNT, DESCRIPTION, RECEIVER from transaction where id = ?";
	public static final String GET_RECEIVED_TRANSACTIONS_IDS = "select ID from transaction where receiver = ?";
	public static final String GET_USERID_USERTRANSACTION = "select user_ID from user_transaction where transaction_ID = ?";
}
