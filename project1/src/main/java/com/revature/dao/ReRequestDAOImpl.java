package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReRequest;
import com.revature.util.ConnectionUtil;

public class ReRequestDAOImpl implements ReRequestDAO {

	@Override
	public List<ReRequest> getRequestsByUser(int id) {
		List<ReRequest> rR = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT * " + 
						 "FROM REREQUEST R WHERE R.USE_ID = ?";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			stmtGet.setInt(1, id);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				int reId = rs.getInt("RE_ID");
				int typeId = rs.getInt("TYPE_ID");
				int status = rs.getInt("STATUS");
				String text = rs.getString("TEXT");
				String reImage = rs.getString("RE_IMAGE");
				int useId = rs.getInt("USE_ID");
				
				rR.add(new ReRequest(reId, typeId, status, text, reImage, useId));
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
		return rR;
	}

	@Override
	public void createRequestWithUserId(int typeId, int status, String text, String reImage, int id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "INSERT INTO REREQUEST (TYPE_ID, STATUS, TEXT, RE_IMAGE, USE_ID) " + 
						 "VALUES (?, ?, ?, ?, ?)";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			pstmt.setInt(2, status);
			pstmt.setString(3, text);
			pstmt.setString(4, reImage);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
	

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public List<ReRequest> getRequests() {
		List<ReRequest> rR = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "SELECT * " + 
						 "FROM REREQUEST";
				
			PreparedStatement stmtGet = con.prepareStatement(sql);
			ResultSet rs = stmtGet.executeQuery();
			
			while (rs.next()) {
				int reId = rs.getInt("RE_ID");
				int typeId = rs.getInt("TYPE_ID");
				int status = rs.getInt("STATUS");
				String text = rs.getString("TEXT");
				String reImage = rs.getString("RE_IMAGE");
				int useId = rs.getInt("USE_ID");
				
				rR.add(new ReRequest(reId, typeId, status, text, reImage, useId));
			}

		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
		return rR;
	}

	@Override
	public void editRequestType(int type, int id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// write a join to unify Bear, Cave, and BearType into one ResultSet
			// map the ResultSet onto a list of Bear objects
			String sql = "UPDATE REREQUEST SET STATUS = ? " + 
						 "WHERE RE_ID = ?";
				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, type);
			pstmt.setInt(2, id);

			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}
	

}
