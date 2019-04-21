package com.revature.beans;

public class Login {
	private String userName;
	private String password;
	private int userId;
	
	public Login() {

	}
	
	public Login(String userName, String password, int userId) {
		super();
		this.userName = userName;
		this.password = password;
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", userId=" + userId + "]";
	}
	
	
	
}
