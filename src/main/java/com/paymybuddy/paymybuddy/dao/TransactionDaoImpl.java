package com.paymybuddy.paymybuddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.paymybuddy.paymybuddy.config.DataBaseConfig;
import com.paymybuddy.paymybuddy.constants.DBConstants;
import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;

public class TransactionDaoImpl implements TransactionDao {
	public DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public boolean saveTransaction(Transaction transaction) {
		Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.SAVE_TRANSACTION);
            ps.setFloat(1, transaction.getAmount());
            ps.setString(2, transaction.getDescription());
            ps.setInt(3, transaction.getConnectionId());
            return ps.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);            
        }
        return false;
	}
	
	public Transaction getTransaction(int transactionId) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.GET_TRANSACTION);
            ps.setInt(1, transactionId);
            rs = ps.executeQuery();
            rs.next();
            Transaction transaction = new Transaction();
            float amount = rs.getFloat("AMOUNT");
            String description = rs.getString("DESCRIPTION");
            int receiverId = rs.getInt("RECEIVER");
            transaction.setAmount(amount);
            transaction.setDescription(description);
            transaction.setReceiverId(receiverId);
            return transaction;
            
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);  
            dataBaseConfig.closeResultSet(rs);
        }
        return null;
	}
	
	public List<Integer> getReceivedTransactionsIds(int userId) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> result = new ArrayList<>();
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.GET_RECEIVED_TRANSACTIONS_IDS);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()) {
            	int transactionId = rs.getInt(1);
            	result.add(transactionId);
            }

            return result;
            
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);  
            dataBaseConfig.closeResultSet(rs);
        }
        return null;
	}
}
