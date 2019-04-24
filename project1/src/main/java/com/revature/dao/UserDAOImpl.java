package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUserById(int id) {
		List<User> u = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT FIRSTNAME, LASTNAME, EMAIL, USR_TYPE_ID " + 
						 "FROM USR U WHERE USR_ID = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, id);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int userTypeId = rs.getInt("USR_TYPE_ID");
				
				u.add(new User(firstName,lastName,email,userTypeId));
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		for (int i = 0; i < u.size(); i++) {
		}
		User thisGuy = u.get(0);
		return thisGuy;
	}

	@Override
	public List<User> getUserbyManager(int manId) {
		List<User> u = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT FIRSTNAME, LASTNAME, EMAIL, USR_TYPE_ID " + 
						 "FROM USR U WHERE U.MANAGER_ID = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, manId);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int userTypeId = rs.getInt("USR_TYPE_ID");
				
				u.add(new User(firstName,lastName,email,userTypeId));
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		return u;
	}

	@Override
	public void createUser(String firstName, String lastName, String email, int userTypeId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO USR (FIRSTNAME, LASTNAME, EMAIL, USR_TYPE_ID) " + 
						 "VALUES (?, ? ,? ,?)";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);
			pstmt.setInt(4, userTypeId);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public int getUserId(String firstName, String lastName, String email, int userTypeId) {
		int u = 0 ;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT USR_ID " + 
						 "FROM USR U WHERE U.FIRSTNAME = ? AND U.LASTNAME = ?  AND U.EMAIL = ? AND U.USR_TYPE_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);
			pstmt.setInt(4, userTypeId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				u = rs.getInt("USR_ID");

			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		return u;
	}

	@Override
	public void updateUserById(String firstName, String lastName, String email, int userId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "UPDATE USR SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? " + 
						 "WHERE USR_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);
			pstmt.setInt(4, userId);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public List<User> getUsers() {
		List<User> u = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT USR_ID, FIRSTNAME, LASTNAME, EMAIL, USR_TYPE_ID, MANAGER_ID " + 
						 "FROM USR U";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt("USR_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int userTypeId = rs.getInt("USR_TYPE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				
				u.add(new User(userId,firstName,lastName,email,userTypeId,managerId));
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		return u;
	}

	@Override
	public void updateUserManager(int id, int manId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "UPDATE USR SET MANAGER_ID = ? " + 
						 "WHERE USR_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, manId);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public void updateUserPosition(int id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "UPDATE USR SET USR_TYPE_ID = 2 " + 
						 "WHERE USR_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

}
