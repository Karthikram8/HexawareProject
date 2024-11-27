package com.java.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.challenge.model.Job;
import com.java.challenge.util.ConnectionHelper;

public class CompanyDaoImpl implements CompanyDao{

	  Connection con;
	  PreparedStatement pst;
	  
	  
	@Override
	public boolean postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType) throws ClassNotFoundException, SQLException {
		 String cmd = "insert into jobs(job_title,Company_Id, job_description, job_location, salary, job_type, posted_date) values (?, ?, ?, ?, ?, ?, current_date)";
	        con = ConnectionHelper.getConnection();
	        pst = con.prepareStatement(cmd);
	        pst.setString(1, jobTitle);
	        pst.setInt(2, companyId);
	        pst.setString(3, jobDescription);
	        pst.setString(4, jobLocation);
	        pst.setDouble(5, salary);
	        pst.setString(6, jobType); 
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	}

	@Override
	public List<Job> getJobs() throws ClassNotFoundException, SQLException {
		 List<Job> jobs = new ArrayList<>();
	        String cmd = "select * from jobs";
	        con = ConnectionHelper.getConnection();
	        pst = con.prepareStatement(cmd);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            Job job = new Job();
	            job.setJobId(rs.getInt("Job_Id"));
	            job.setJobTitle(rs.getString("Job_Title"));
	            job.setCompanyId(rs.getInt("Company_Id"));
	            job.setJobDescription(rs.getString("Job_Description"));
	            job.setJobLocation(rs.getString("Job_Location"));
	            job.setSalary(rs.getDouble("Salary"));
	            job.setJobType(rs.getString("Job_Type"));
	            jobs.add(job);
	        }
	        return jobs;
	}

}
