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

public class ConnectionDaoImpl implements ConnectionDao {
public DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public boolean saveConnection(int userId, int connectionId) {
		Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.SAVE_CONNECTION);
            ps.setInt(1, userId);
            ps.setInt(2, connectionId);
            return ps.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            dataBaseConfig.closePreparedStatement(ps);            
        }
        return false;
	}
	
	public List<Integer> getConnectionsIds(int id) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> result = new ArrayList<>();
        try {
            con = dataBaseConfig.getConnection();
            ps = con.prepareStatement(DBConstants.GET_CONNECTIONS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
            	int connectionId = rs.getInt(1);
            	System.out.println(connectionId);
            	result.add(connectionId);
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

}
