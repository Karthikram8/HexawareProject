package com.java.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.challenge.util.ConnectionHelper;

public class ApplicantDaoImpl implements ApplicantDao {
	
	 Connection con;
	 PreparedStatement pst;

	@Override
	public boolean createProfile(String email, String firstName, String lastName, String phone, String Resume)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 String cmd = "insert into applicants(first_name, last_name, email, phone, resume) values (?, ?, ?, ?, ?)";
	        con = ConnectionHelper.getConnection();
	        pst = con.prepareStatement(cmd);
	        pst.setString(1, firstName);
	        pst.setString(2, lastName);
	        pst.setString(3, email);
	        pst.setString(4, phone);
	        pst.setString(5, Resume);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	}

	@Override
	public boolean applyForJob(int jobId, int applicantId, String coverLetter)
			throws SQLException, ClassNotFoundException {
		 String cmd = "insert into applications(job_id, applicant_id, cover_letter) values (?, ?, ?)";
	        con = ConnectionHelper.getConnection();
	        pst = con.prepareStatement(cmd);
	        pst.setInt(1, jobId);
	        pst.setInt(2, applicantId);
	        pst.setString(3, coverLetter);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	}

}
