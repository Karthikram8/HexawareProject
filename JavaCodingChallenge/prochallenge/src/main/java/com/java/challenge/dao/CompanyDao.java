package com.java.challenge.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.challenge.model.Job;

public interface CompanyDao {

	boolean postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) throws ClassNotFoundException,SQLException;
    List<Job> getJobs() throws ClassNotFoundException,SQLException;
}
