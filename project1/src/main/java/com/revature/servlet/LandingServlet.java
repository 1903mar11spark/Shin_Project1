package com.revature.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.service.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.sql.Blob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Servlet implementation class LandingServlet
 */
public class LandingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private ObjectMapper om;
	private UserService userService;
	private ReRequestService reRequestService;	
	public LandingServlet() {
		reRequestService = new ReRequestServiceImpl();
		userService = new UserServiceImpl();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher("landing.html").forward(request, response);

	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
//		if (userId == 0) {
//			response.sendError(404);
//		}
//		else {
//			HttpSession session = request.getSession();
//			User u = userService.getUserById(userId);
//			session.setAttribute("user", userId);
//			session.setAttribute("firstName", u.getFirstName());
//			session.setAttribute("lastName", u.getLastName());
//			session.setAttribute("email", u.getEmail());
//			session.setAttribute("userTypeId", u.getUserTypeId());
//			response.sendRedirect("landing");
//		}
		if (session != null) {
			try {
				int typeId = Integer.parseInt(request.getParameter("reTypeId"));
				int status = 1;
				String text = request.getParameter("reText");	
				String image = request.getParameter("reImage");
				int user = Integer.parseInt(session.getAttribute("user").toString());
				
				
				reRequestService.createRequestWithUserId(typeId, status, text, image, user);
				request.getRequestDispatcher("landing.html").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
		
	}

}

//	
//	private static final long serialVersionUID = 1L;
//       
//	private ObjectMapper om;
//	
//	private LoginService loginService;
//	
//	public LandingServlet() {
//		loginService = new LoginServiceImpl();
//		om = new ObjectMapper();
//		om.registerModule(new JavaTimeModule());
//		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
//	}
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("main.html").forward(request, response);
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//			Enumeration<String> atts = request.getAttributeNames();
//			while(atts.hasMoreElements()) {
//				String s = atts.nextElement();
//				System.out.println(s + " : " + request.getAttribute(s));
//			}
//			String error = (String) request.getAttribute("error");
//			PrintWriter pw = response.getWriter();
//	}

