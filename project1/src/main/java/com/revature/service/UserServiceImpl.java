package com.revature.service;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {
	private UserDAO ud = new UserDAOImpl();
	
	@Override
	public User getUserById(int id) {
		
		return ud.getUserById(id);
	}

	@Override
	public List<User> getUserbyManager(int manId) {
		
		return ud.getUserbyManager(manId);
	}

	@Override
	public void createUser(String firstName, String lastName, String email, int userTypeId) {
		ud.createUser(firstName, lastName, email, userTypeId);
		
	}

	@Override
	public int getUserId(String firstName, String lastName, String email, int userTypeId) {
		return ud.getUserId(firstName, lastName, email, userTypeId);
	}

	@Override
	public void updateUserById(String firstName, String lastName, String email, int userId) {
		ud.updateUserById(firstName, lastName, email, userId);
		
	}

	@Override
	public List<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public void updateUserManager(int id, int manId) {
		ud.updateUserManager(id, manId);
		
	}

	@Override
	public void updateUserPosition(int id) {
		ud.updateUserPosition(id);
		
	}

}
