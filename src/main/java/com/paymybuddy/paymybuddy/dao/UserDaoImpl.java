package com.paymybuddy.paymybuddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.paymybuddy.paymybuddy.config.DataBaseConfig;
import com.paymybuddy.paymybuddy.constants.DBConstants;
import com.paymybuddy.paymybuddy.model.User;

public class UserDaoImpl {

	public DataBaseConfig dataBaseConfig = new DataBaseConfig();

	public boolean saveUser(User user) {
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

	public String getMail(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DBConstants.GET_MAIL);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
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
