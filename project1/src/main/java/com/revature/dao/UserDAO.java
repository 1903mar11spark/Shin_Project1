package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	public User getUserById(int id);
	
	public int getUserId(String firstName, String lastName, String email, int userTypeId);
	
	public List<User> getUserbyManager(int manId);
	
	public void createUser(String firstName, String lastName, String email, int userTypeId);
	
	public void updateUserById(String firstName, String lastName, String email, int userId);
	
	public List<User> getUsers();
	
	public void updateUserManager(int id, int manId);
	
	public void updateUserPosition(int id);
	
}
