package com.revature.service;

import java.sql.Blob;
import java.util.List;

import com.revature.beans.ReRequest;
import com.revature.dao.ReRequestDAO;
import com.revature.dao.ReRequestDAOImpl;

public class ReRequestServiceImpl implements ReRequestService {
	
	ReRequestDAO rR = new ReRequestDAOImpl();
	@Override
	public List<ReRequest> getRequestsByUser(int id) {
		return rR.getRequestsByUser(id);
	}

	@Override
	public void createRequestWithUserId(int typeId, int status, String text, String reImage, int id) {
		rR.createRequestWithUserId(typeId, status, text, reImage, id);
		
	}


}
