package com.revature.main;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.ReRequest;
import com.revature.dao.*;

import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		LoginDAO log = new LoginDAOImpl();
		UserDAO using = new UserDAOImpl();
		ReRequestDAO rR = new ReRequestDAOImpl();
		
		rR.editRequestType(3, 1021);
	
		 

		 
	}
}
