package com.java.challenge.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.java.challenge.model.Company;

public class CompanyTest {

	  private Company company;

	    @Before
	    public void setUp() {
	        company = new Company(1010, "TechAwen", "Coimbatore");
	    }

	    @Test
	    public void testGetterSetter() {
	        company.setCompanyId(1010);
	        company.setCompanyName("TechAwen");
	        company.setLocation("Coimbatore");

	        assertEquals(1010, company.getCompanyId());
	        assertEquals("TechAwen", company.getCompanyName());
	        assertEquals("Coimbatore", company.getLocation());
	    }

	    @Test
	    public void testConstructor() {
	        Company company = new Company(1010, "TechAwen", "Coimbatore");
	        assertEquals(1010, company.getCompanyId());
	        assertEquals("TechAwen", company.getCompanyName());
	        assertEquals("Coimbatore", company.getLocation());
	    }

	    @Test
	    public void testToString() {
	        company.setCompanyId(1010);
	        company.setCompanyName("TechAwen");
	        company.setLocation("Coimbatore");

	        String expected = "Company [companyId=1010, companyName=TechAwen, location=Coimbatore]";
	        assertEquals(expected, company.toString());
	    }

}
