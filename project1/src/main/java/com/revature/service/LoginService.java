package com.revature.service;

public interface LoginService {
	
	public int Login(String username, String password); 
	
	public void createLogin (String userName, String password, int userId);
}
