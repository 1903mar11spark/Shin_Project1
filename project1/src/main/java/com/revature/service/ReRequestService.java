package com.revature.service;

import java.sql.Blob;
import java.util.List;

import com.revature.beans.ReRequest;

public interface ReRequestService {
	
	public List<ReRequest> getRequestsByUser(int id);

	public void createRequestWithUserId(int typeId, int status, String text, String reImage, int id);
	
	public List<ReRequest> getRequests();
	
	public void editRequestType(int type, int id);
}
