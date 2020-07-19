package com.paymybuddy.paymybuddy.config;

import java.sql.*;

public class DataBaseConfig {
	 public Connection getConnection() throws ClassNotFoundException, SQLException {
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/paymybuddy?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
	        		"root", "rootroot");
	    }

	    public void closeConnection(Connection con){
	        if(con!=null){
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void closePreparedStatement(PreparedStatement ps) {
	        if(ps!=null){
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void closeResultSet(ResultSet rs) {
	        if(rs!=null){
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
