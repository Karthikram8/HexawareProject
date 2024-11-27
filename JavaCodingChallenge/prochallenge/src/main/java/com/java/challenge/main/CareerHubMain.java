package com.java.challenge.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.challenge.dao.ApplicantDao;
import com.java.challenge.dao.ApplicantDaoImpl;
import com.java.challenge.dao.CompanyDao;
import com.java.challenge.dao.CompanyDaoImpl;
import com.java.challenge.dao.JobDao;
import com.java.challenge.dao.JobDaoImpl;
import com.java.challenge.exceptions.InvalidEmailException;
import com.java.challenge.exceptions.NegativeSalaryException;
import com.java.challenge.model.Applicant;
import com.java.challenge.model.Job;

public class CareerHubMain {

	static Scanner sc = new Scanner(System.in);
	static CompanyDao companyDao = new CompanyDaoImpl();
	static ApplicantDao applicantDao = new ApplicantDaoImpl();
	static JobDao jobDao = new JobDaoImpl();
	
	
	 public static void getJobs() throws SQLException, ClassNotFoundException {
	        List<Job> jobList = companyDao.getJobs();
	        if (jobList.isEmpty()) {
	        	System.out.println("----------------------------------");
	            System.out.println("No jobs available."); 
	        } 
	        else {
	            for (Job job : jobList) {
	                System.out.println(job);
	            }
	        }
	    }
	 
	 public static void postJob() throws SQLException, ClassNotFoundException, NegativeSalaryException {
	        System.out.print("ComapnyId: ");
	        int companyId = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Job Title: ");
	        String jobTitle = sc.nextLine();
	        System.out.print("Job Description: ");
	        String jobDescription = sc.nextLine();
	        System.out.print("Job Location: ");
	        String jobLocation = sc.nextLine();
	        System.out.print("Salary: ");
	        double salary = sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Job Type (Full-time/Part-time/Contract): ");
	        String jobType = sc.nextLine();

	        boolean success = companyDao.postJob(companyId,jobTitle, jobDescription, jobLocation, salary, jobType);
	        if (success) {
	        	System.out.println("----------------------------------");
	            System.out.println("Job posted!");
	        } 
	        else {
	        	System.out.println("----------------------------------");
	            System.out.println("Failed.");
	        }
	    }
	 
	  public static void createProfile() throws SQLException, ClassNotFoundException, InvalidEmailException {
	        System.out.println("Enter Applicant Details:");
	        System.out.print("Email: ");
	        String email = sc.nextLine();
	        System.out.print("First Name: ");
	        String firstName = sc.nextLine();
	        System.out.print("Last Name: ");
	        String lastName = sc.nextLine();
	        System.out.print("Phone: ");
	        String phone = sc.nextLine();
	        System.out.print("Resume: ");
	        String Resume=sc.nextLine();

	        boolean success = applicantDao.createProfile(email, firstName, lastName, phone, Resume);
	        if (success) {
	        	System.out.println("----------------------------------");
	            System.out.println("Profile created!");
	        } 
	        else {
	        	System.out.println("----------------------------------");
	            System.out.println("Failed.");
	        }
	    }

	  
	    public static void applyForJob() throws SQLException, ClassNotFoundException {
	        System.out.print("Enter Applicant ID: ");
	        int applicantId = sc.nextInt();
	        System.out.print("Enter Job ID: ");
	        int jobId = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Cover Letter: ");
	        String coverLetter = sc.nextLine();

	        boolean success = jobDao.apply(applicantId, jobId, coverLetter);
	        if (success) {
	        	System.out.println("----------------------------------");
	            System.out.println("Application submitted!");
	        } 
	        else {
	        	System.out.println("----------------------------------");
	            System.out.println("Failed.");
	        }
	    }
	 
	    public static void getApplicants() throws SQLException, ClassNotFoundException {
	        System.out.print("Enter Job ID to view applicants: ");
	        int jobId = sc.nextInt();
	        sc.nextLine();

	        List<Applicant> applicants = jobDao.getApplicants(jobId);
	        if (applicants.isEmpty()) {
	        	System.out.println("----------------------------------");
	            System.out.println("No applicants.");
	        } 
	        else {
	            for (Applicant applicant : applicants) {
	                System.out.println(applicant);
	            }
	        }
	    }
	    
	    public static void applyForJobFromApplicant() throws SQLException, ClassNotFoundException {
	        System.out.print("Enter Applicant ID: ");
	        int applicantId = sc.nextInt();
	        System.out.print("Enter Job ID: ");
	        int jobId = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Cover Letter: ");
	        String coverLetter = sc.nextLine();

	        boolean success = jobDao.apply(applicantId, jobId, coverLetter);
	        if (success) {
	        	System.out.println("----------------------------------");
	            System.out.println("Application submitted!");
	        } 
	        else {
	        	System.out.println("----------------------------------");
	            System.out.println("Failed.");
	        }
	    }
	 
	    public static void main(String[] args) {
	        int choice;
	        do {

	            System.out.println("----------------------------------");
	            System.out.println("1. Show Jobs");
	            System.out.println("2. Post Job");
	            System.out.println("3. Create Profile");
	            System.out.println("4. Apply Job (Job)");
	            System.out.println("5. View Applicants of Job");
	            System.out.println("6. Apply Job (Applicant)");
	            System.out.println("----------------------------------");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            try {
	                switch (choice) {
	                    case 1:
	                        getJobs();
	                        break;
	                    case 2:
	                        postJob();
	                        break;
	                    case 3:
	                        createProfile();
	                        break;
	                    case 4:
	                        applyForJob();
	                        break;
	                    case 5:
	                        getApplicants();
	                        break;
	                    case 6:
	                        applyForJobFromApplicant();
	                        break;
	                    case 0:
	                        break;
	                    default:
	                        System.out.println("Enter Valid Choice");
	                }
	            } catch (NegativeSalaryException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (InvalidEmailException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (SQLException | ClassNotFoundException e) {
	                e.printStackTrace();
	            }
	        } while (choice != 0);
	    }
	  
	 
	 
}
