package com.revature.service;

import com.revature.dao.*;
public class LoginServiceImpl implements LoginService{

	private LoginDAO ld = new LoginDAOImpl();
	@Override
	public int Login(String username, String password) {
		
		return ld.Login(username, password);
	}
	@Override
	public void createLogin(String userName, String password, int userId) {
		ld.createLogin(userName, password, userId);
		
	}

}
