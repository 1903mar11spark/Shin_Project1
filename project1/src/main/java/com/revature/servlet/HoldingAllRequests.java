package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReRequest;
import com.revature.beans.User;
import com.revature.service.ReRequestService;
import com.revature.service.ReRequestServiceImpl;

/**
 * Servlet implementation class HoldingAllRequests
 */
public class HoldingAllRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReRequestService allRequests;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoldingAllRequests() {
        super();
        allRequests = new ReRequestServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				List<ReRequest> requests = allRequests.getRequests();
				response.getWriter().write((new ObjectMapper()).writeValueAsString(requests)); 
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
