package com.revature.beans;

public class User {
	
	private int usrId;
	private String firstName;
	private String lastName;
	private String email;
	private int userTypeId;
	private int managerId;
	
	
	public User() {

	}
	
	public User(int usrId, String firstName, String lastName, String email, int userTypeId, int managerId) {
		super();
		this.usrId = usrId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userTypeId = userTypeId;
		this.managerId = managerId;
	}
	
	public User(int usrId, String firstName, String lastName, String email, int userTypeId) {
		super();
		this.usrId = usrId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userTypeId = userTypeId;
	}
	
	public User(String firstName, String lastName, String email, int userTypeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userTypeId = userTypeId;
	}

	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userTypeId=" + userTypeId + "]";
	}
	
	
	
}
