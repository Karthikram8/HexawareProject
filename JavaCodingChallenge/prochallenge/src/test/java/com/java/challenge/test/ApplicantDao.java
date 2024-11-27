package com.java.challenge.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.java.challenge.model.Applicant;

public class ApplicantDao {
	
	private Applicant applicant;
	
	 @Before
	 public void setUp() {
	      applicant = new Applicant();
	 }

	 @Test
	 public void testGetterSetter() {
	 applicant.setApplicantId(3111);
	 applicant.setFirstName("John");
	 applicant.setLastName("Lenon");
	 applicant.setEmail("lenon1234@gmail.com");
	 applicant.setPhone("1234567899");

	 assertEquals(1, applicant.getApplicantId());
	 assertEquals("John", applicant.getFirstName());
	 assertEquals("Lenon", applicant.getLastName());
	 assertEquals("lenon1234@gmail.com", applicant.getEmail());
	 assertEquals("1234567899", applicant.getPhone());
	
	 }
	 
	  @Test
	  public void testToString() {
	  applicant.setApplicantId(1);
	  applicant.setFirstName("John");
	  applicant.setLastName("Lenon");
	  applicant.setEmail("lenon1234@gmail.com");
	  applicant.setPhone("1234567899");

	     String expected = "Applicant{applicantId=3111, firstName='"
	     		+ "John', lastName='Lenon', email='lenon1234@gmail.com', phone='1234567899'}";
	        assertEquals(expected, applicant.toString());
	  }

}
