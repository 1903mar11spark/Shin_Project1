package com.revature.servlet;

import java.io.Console; 
import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

/**
 * Servlet implementation class MainServlet
 */


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginService loginService;
	private UserService userService;
	private ObjectMapper om;
	
    public MainServlet() {
    	userService = new UserServiceImpl();
        loginService = new LoginServiceImpl();
        om = new ObjectMapper();
    }

    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.getRequestDispatcher("main.html").forward(request, response);
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param1 = request.getParameter("n1");
		String param2 = request.getParameter("n2");	
		int userId = loginService.Login(param1, param2);
		
		if (userId == 0) {
			response.sendError(404);
		}
		else {
			HttpSession session = request.getSession();
			User u = userService.getUserById(userId);
			session.setAttribute("user", userId);
			session.setAttribute("firstName", u.getFirstName());
			session.setAttribute("lastName", u.getLastName());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("userTypeId", u.getUserTypeId());
			session.setAttribute("userName", param1);
			session.setAttribute("password", param2);
			if (u.getUserTypeId() == 3) {
				response.sendRedirect("landing");
			}
			else {
				response.sendRedirect("landing");
			}
			
			
		}
		
	
		
//	
//		request.setAttribute("userId", userId);
//
//		RequestDispatcher rd = request.getRequestDispatcher("landing");
//		rd.forward(request, response);
	}

}
