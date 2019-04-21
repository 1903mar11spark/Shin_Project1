package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserService userService;
	LoginService loginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        userService = new UserServiceImpl();
        loginService = new LoginServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		request.getRequestDispatcher("profile.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			try {
				String firstName = request.getParameter("fName");	
				String lastName = request.getParameter("lName");	
				String email = request.getParameter("email");
				int user = Integer.parseInt(session.getAttribute("user").toString());
				String userName = request.getParameter("uName");
				String password = request.getParameter("pass");

				
				userService.updateUserById(firstName, lastName, email, user);
				loginService.editLoginById(userName, password, user);
				
				request.getRequestDispatcher("main.html").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}

}
