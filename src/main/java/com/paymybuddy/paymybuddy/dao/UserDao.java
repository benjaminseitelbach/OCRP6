package com.paymybuddy.paymybuddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.paymybuddy.paymybuddy.config.DataBaseConfig;
import com.paymybuddy.paymybuddy.constants.DBConstants;
import com.paymybuddy.paymybuddy.model.User;

//@Repository
public class UserDao extends DAO<User> {
	public DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public boolean create(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DBConstants.SAVE_USER);
			ps.setString(1, user.getMail());
			ps.setString(2, user.getPassword());
			return ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			dataBaseConfig.closeConnection(con);
			dataBaseConfig.closePreparedStatement(ps);
		}
		return false;
	}
	
	public boolean delete(User user) {
		return false;
	}
	
	public boolean update(User user) {
		return false;
	}
	
	public User find(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DBConstants.GET_USER);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			String mail = rs.getString(1);
			String password = rs.getString(2);
			User user = new User(id, mail, password);
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			dataBaseConfig.closeConnection(con);
			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeResultSet(rs);
		}
		return null;
		
	}
	
}
