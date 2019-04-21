package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.ReRequest;
import com.revature.beans.User;
import com.revature.service.ReRequestService;
import com.revature.service.ReRequestServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Servlet implementation class HolderServlet
 */
public class HolderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private ReRequestService reRequest;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolderServlet() {
        super();
        userService = new UserServiceImpl();
        reRequest = new ReRequestServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				int user = Integer.parseInt(session.getAttribute("user").toString());
				String firstname = session.getAttribute("firstName").toString();
				String lastname = session.getAttribute("lastName").toString();
				String email = session.getAttribute("email").toString();
				int userType = Integer.parseInt(session.getAttribute("userTypeId").toString());
				User u = new User(user, firstname, lastname, email, userType);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(u)); 
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
