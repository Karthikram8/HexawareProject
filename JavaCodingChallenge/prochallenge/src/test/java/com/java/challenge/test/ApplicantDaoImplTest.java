package com.java.challenge.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.java.challenge.dao.ApplicantDaoImpl;

public class ApplicantDaoImplTest {
	

    private ApplicantDaoImpl app;

    @Before
    public void setUp() {
        app = new ApplicantDaoImpl();
    }


	@Test
	public void testCreateProfile() throws SQLException, ClassNotFoundException {
        boolean result = app.createProfile("karthikramprabhakar@gmail.com", "karthikram", "prabhakar", "007", "resume");
        assertTrue(result);
    }

	@Test
    public void testApplyForJob() throws SQLException, ClassNotFoundException {
        boolean result = app.applyForJob(6, 8, "cover");
        assertTrue(result);
    }

}
