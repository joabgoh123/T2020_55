package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.demo.bean.User;
import com.demo.util.DBUtil;


public class UserDao {

	Locale locale = new Locale("en");
	ResourceBundle dbSQLStatements = ResourceBundle.getBundle("DatabaseSQL", locale);
	
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		Connection conn = null;
		
		try {
			conn = DBUtil.getMySqlConnection();
			PreparedStatement ps = null;
			System.out.println("DebugL: " + conn);
			ps = conn.prepareStatement(dbSQLStatements.getString("SQL_listAllUsers"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User(username, password);
				allUsers.add(user);
			}
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return allUsers;
	}

	public User createUser(String username, String password) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBUtil.getMySqlConnection();
			PreparedStatement ps = null;
			ps = conn.prepareStatement(dbSQLStatements.getString("SQL_createUser"));
			ps.setString(1, username);
			ps.setString(2, password);
			 
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				user = new User(username, password);
			}
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}
	
	public User readUser(String username) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBUtil.getMySqlConnection();
			PreparedStatement ps = null;
			ps = conn.prepareStatement(dbSQLStatements.getString("SQL_readUser"));
			ps.setString(1, username);
			 
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
			    String password = rs.getString("password");
			    user = new User(username, password);
			}
			
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}
	
	public boolean updateUser(String username, String password) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = DBUtil.getMySqlConnection();
			PreparedStatement ps = null;
			ps = conn.prepareStatement(dbSQLStatements.getString("SQL_updateUser"));
			ps.setString(1, username);
			 
			int updated = ps.executeUpdate();
			if (updated > 0) {
				result = true;
			}
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean deleteUser(String username, String password) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = DBUtil.getMySqlConnection();
			PreparedStatement ps = null;
			ps = conn.prepareStatement(dbSQLStatements.getString("SQL_deleteUser"));
			ps.setString(1, username);
			ps.setString(2, password); 
			int deleted = ps.executeUpdate();
			if (deleted > 0) {
				result = true;
			}
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}
}
