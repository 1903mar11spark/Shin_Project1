package com.revature.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private LoginService logins;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        userService = new UserServiceImpl();
        logins = new LoginServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("NewForm.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

				String firstName = request.getParameter("fName");	
				String lastName = request.getParameter("lName");	
				String email = request.getParameter("email");
				int userTypeId = 1;
				
				userService.createUser(firstName, lastName, email, userTypeId);
				int user = userService.getUserId(firstName, lastName, email, userTypeId);
				
				System.out.println(user);
				
				String userName = request.getParameter("uName");	
				String pass = request.getParameter("pass");
				
				logins.createLogin(userName, pass, user);
				
				request.getRequestDispatcher("main.html").forward(request, response);


		
	}

}
