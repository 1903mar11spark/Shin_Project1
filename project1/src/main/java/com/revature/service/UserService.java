package com.revature.service;

import java.util.List;

import com.revature.beans.User;

public interface UserService {

	public User getUserById(int id);
	
	public List<User> getUserbyManager(int manId);
	
	public int getUserId(String firstName, String lastName, String email, int userTypeId);
	
	public void createUser(String firstName, String lastName, String email, int userTypeId);
	
	public void updateUserById(String firstName, String lastName, String email, int userId);
	
	public List<User> getUsers();
}
