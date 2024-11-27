package com.java.challenge.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.challenge.model.Applicant;

public interface JobDao {
	boolean apply(int applicantId, int jobId, String coverLetter) throws SQLException,ClassNotFoundException;
	List<Applicant> getApplicants(int jobId) throws SQLException,ClassNotFoundException;
}
