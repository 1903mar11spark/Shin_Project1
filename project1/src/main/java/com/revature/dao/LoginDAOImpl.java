package com.revature.dao;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public int Login(String username, String password) {
		int userId = 0;
		// try-with-resources... resources will be closed at the end of the block
		// works for all AutoCloseable resources
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT USER_ID " + 
						 "FROM LOGIN L WHERE L.USERNAME = ? AND L.PASS = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setString(1, username);
			stmtGet.setString(2, password);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				userId = rs.getInt("USER_ID");
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
			
		}
		return userId;
	}

	@Override
	public void createLogin(String userName, String password, int userId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO LOGIN " + 
						 "VALUES (?, ? ,?)";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setInt(3, userId);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public void editLoginById(String userName, String pass, int id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "UPDATE LOGIN SET USERNAME = ?, PASS = ? " + 
						 "WHERE USER_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.setString(2, pass);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}
}
