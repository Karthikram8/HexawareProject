package com.java.challenge.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.challenge.dao.CompanyDaoImpl;
import com.java.challenge.model.Job;

public class CompanyDaoImpltest {


    CompanyDaoImpl companyDao;

    @Before
    public void setUp() {
        companyDao = new CompanyDaoImpl();
    }

    @Test
    public void testPostJob() throws SQLException, ClassNotFoundException {
        boolean result = companyDao.postJob(1010, "Design Engineer", "System Design", "Coimbatore", 60000.00, "Full-time");
        assertTrue(result);
    }

    @Test
    public void testGetJobs() throws SQLException, ClassNotFoundException {
        List<Job> jobs = companyDao.getJobs();
        assertFalse(jobs.isEmpty());
    }

    @Test
    public void testGetJobsNoJobs() throws SQLException, ClassNotFoundException {
        List<Job> jobs = companyDao.getJobs();
        assertFalse(jobs.isEmpty());
    }

}
