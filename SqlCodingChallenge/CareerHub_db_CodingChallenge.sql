create database CareerHub;

use careerhub;

create table companies(
Company_ID int PRIMARY KEY,
Company_Name varchar(50) NOT NULL,
Location varchar (50) NOT NULL
);

insert into companies(Company_ID, Company_Name, Location) values(1001 , 'AEY', 'Chennai'),
(1002, 'Ultron' , 'Delhi'),
(1003, 'Zap' , 'Mumbai'),
(1004, 'Techno' , 'Chennai');


create table jobs(
Job_ID int PRIMARY KEY auto_increment,
Company_ID int NOT NULL,
Job_Title varchar(50) NOT NULL,
Job_Description text,
Job_Location varchar(50) NOT NULL,
Salary decimal(10,2) NOT NULL,
Job_Type varchar(50) NOT NULL,
Posted_Date date ,
FOREIGN KEY (Company_ID) REFERENCES Companies(Company_ID)
);

insert into jobs(Job_ID, Company_ID, Job_Title, Job_Description, Job_Location, Salary, Job_Type , Posted_Date) values(2034 , 1001 , 'SWE-L1', 'Softeare Engineer Level 1', 'Chennai' , 450000, 'Full-Time' , '24-11-10'),
(2032 , 1001 , 'SWE-L2', 'Softeare Engineer Level 2', 'Chennai' , 650000, 'Full-Time' , '24-11-10'),
(2023 , 1002 , 'ASWE-L1', 'Assistant Software Engineer Level 1', 'Delhi' , 450000, 'Part-Time' , '24-11-11'),
(2064 , 1002 , 'ASWE-L2', 'Assistant Software Engineer Level 2', 'Delhi' , 650000, 'Contract' , '24-11-11'),
(2075 , 1003 , 'HR', 'Human Resource Manager', 'Mumbai' , 650000, 'Full-Time' , '24-11-12'),
(2076 , 1004 , 'UI Designer', 'User Interface Designer', 'Chennai' , 450000, 'Part-Time' , '24-11-13');


create table applicants(
Applicant_ID int PRIMARY KEY auto_increment,
First_Name varchar(50) NOT NULL,
Last_Name varchar(50) NOT NULL,
Email varchar(50) NOT NULL,
Phone varchar(50) NOT NULL,
Resume text NOT NULL
);

insert into applicants (applicant_id, first_name, last_name, email, phone , resume) values (3012, 'Karthik', 'ram' , 'ram231@gmail.com' , '9876543210' , 'karthikram resume'),
(3098, 'Kiruthik', 'ram' , 'Krming31@gmail.com' , '9876548810' , 'kiruthikram resume'),
(3076, 'Nakshatra', 'Lakshmanan' , 'naksh986@gmail.com' , '6376548810' , 'Nakshatra resume'),
(3054, 'Sathya', 'dev' , 'dev009@gmail.com' , '8876548810' , 'Sathydev resume'),
(3875, 'Gautham', 'menon' , 'gmenon34@gmail.com' , '9976548810' , 'Gautham resume'),
(3035, 'Kumar', 'raja' , 'Kraja69@gmail.com' , '7896548810' , 'kumaraja resume'),
(3100, 'Anushka', 'sharma' , 'Asharma987t@gmail.com' , '7776548780' , 'Anushka resume'),
(3018, 'Virat', 'kholi' , 'Vkholi@gmail.com' , '9999548810' , 'Viratkholi resume'),
(3007, 'Mahi', 'dhoni' , 'Mahi007@gmail.com' , '7776548810' , 'Mahi resume');


create table applications(
Application_ID int PRIMARY KEY auto_increment,
Job_ID int NOT NULL,
Applicant_ID int NOT NULL,
Application_Date date,
Cover_Letter text NOT NULL,
FOREIGN KEY (Job_ID) REFERENCES Jobs(Job_ID)
);


insert into applications (application_id, job_id, applicant_id, application_date, cover_letter) values (0001, 2034 , 3098 , '24-12-01' , 'I Apply'),
(0002, 2034 , 3076 , '24-12-02' , 'I Apply'),
(0003, 2075 , 3035 , '24-12-01' , 'I Apply'),
(0004, 2076 , 3007 , '24-12-03' , 'I Apply'),
(0005, 2064 , 3100 , '24-12-01' , 'I Apply'),
(0006, 2032 , 3012 , '24-12-03' , 'I Apply'),
(0007, 2064 , 3076 , '24-12-02' , 'I Apply'),
(0008, 2034 , 3098 , '24-12-02' , 'I Apply'),
(0009, 2075 , 3075 , '24-12-01' , 'I Apply'),
(0010, 2034 , 3007 , '24-12-03' , 'I Apply');

select * from jobs;
select * from applicants;
select * from applications;


