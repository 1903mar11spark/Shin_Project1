package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

/**
 * Servlet implementation class NewEmployeeServlet
 */
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService uService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeServlet() {
        super();
        uService = new UserServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int user = Integer.parseInt(session.getAttribute("userTypeId").toString());
		
			switch(user) {
			case 3:request.getRequestDispatcher("promote.html").forward(request, response);
				break;
			case 2:request.getRequestDispatcher("selectEmployee.html").forward(request, response);
				break;
				default:
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int user = Integer.parseInt(session.getAttribute("userTypeId").toString());
		int userId = Integer.parseInt(session.getAttribute("user").toString());
		
		
		
			switch(user) {
			case 3: int employeePro = Integer.parseInt(request.getParameter("promoteGuy"));
				uService.updateUserPosition(employeePro);
				request.getRequestDispatcher("promote.html").forward(request, response);
				break;
			case 2: int employeeNew = Integer.parseInt(request.getParameter("newGuy"));
				uService.updateUserManager(employeeNew, userId);
				request.getRequestDispatcher("selectEmployee.html").forward(request, response);
				break;
				default:
			}
	}

}
