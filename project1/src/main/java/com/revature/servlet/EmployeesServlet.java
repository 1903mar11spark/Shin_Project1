package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ReRequestService;
import com.revature.service.ReRequestServiceImpl;

/**
 * Servlet implementation class EmployeesServlet
 */
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ReRequestService rR;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesServlet() {
        super();
        rR = new ReRequestServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		request.getRequestDispatcher("employees.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reNumber = Integer.parseInt(request.getParameter("reNumber"));
		int checked = Integer.parseInt(request.getParameter("checked"));
		System.out.println(reNumber);
		System.out.println(checked);
		rR.editRequestType(checked, reNumber);
		request.getRequestDispatcher("employees.html").forward(request, response);
	}

}
