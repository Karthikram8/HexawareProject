package com.java.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.challenge.model.Applicant;
import com.java.challenge.util.ConnectionHelper;

public class JobDaoImpl implements JobDao {
	
    Connection con;
    PreparedStatement pst;
    
	@Override
	public boolean apply(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException {
		String cmd = "insert into applications(job_id, applicant_id, cover_letter, application_date) values (?, ?, ?,current_date)";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(cmd);
        pst.setInt(1, jobId);
        pst.setInt(2, applicantId);
        pst.setString(3, coverLetter);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0; 
	}

	@Override
	public List<Applicant> getApplicants(int jobId) throws SQLException, ClassNotFoundException {
        List<Applicant> applicants = new ArrayList<>();
        String cmd = "select a.applicant_id, a.first_name, a.last_name, a.email, a.phone from applicants a " +
                       "join applications app on a.applicant_id = app.applicant_id where app.job_id = ?";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(cmd);
        pst.setInt(1, jobId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Applicant applicant = new Applicant();
            applicant.setApplicantId(rs.getInt("applicant_Id"));
            applicant.setFirstName(rs.getString("first_Name"));
            applicant.setLastName(rs.getString("last_Name"));
            applicant.setEmail(rs.getString("email"));
            applicant.setPhone(rs.getString("phone"));
            applicants.add(applicant);
        }
        return applicants;

	}

}
