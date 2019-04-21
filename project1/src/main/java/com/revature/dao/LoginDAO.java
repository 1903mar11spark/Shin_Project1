package com.revature.dao;


public interface LoginDAO {
	public int Login(String username, String password); 
	
	public void createLogin (String userName, String password, int userId);
}
