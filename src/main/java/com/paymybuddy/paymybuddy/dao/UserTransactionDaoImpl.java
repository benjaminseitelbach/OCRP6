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

public class UserTransactionDaoImpl implements UserTransactionDao {
public DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public boolean saveUserTransaction(User user, Transaction transaction) {
		Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.SAVE_USER_TRANSACTION);
            ps.setInt(1, user.getId());
            ps.setInt(2, transaction.getId());
            return ps.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);            
        }
        return false;
	}
	
	public List<Integer> getTransactions(int userId) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> result = new ArrayList<>();
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.GET_TRANSACTIONSIDS_USERTRANSACTION);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()) {
            	int transactionId = rs.getInt(1);
            	result.add(transactionId);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);  
            dataBaseConfig.closeResultSet(rs);
        }
        return result;
	}
	
	public int getUserId(int transactionId) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.GET_USERID_USERTRANSACTION);
            ps.setInt(1, transactionId);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

            
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);  
            dataBaseConfig.closeResultSet(rs);
        }
        return 0;
	}

}
