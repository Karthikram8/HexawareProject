-- 5
select * from applications;

select jobs.job_title, count(applications.job_id) as count
from applications
join jobs on applications.job_id=jobs.job_id
group by applications.job_id;

-- 6

select jobs.job_title, companies.company_name,  jobs.job_location, jobs.salary
from jobs
join companies on jobs.company_id= companies.company_id
where jobs.salary between 400000 and 600000;

-- 7

select * from applications;

select  applications.applicant_id, applications.application_date, jobs.job_title, companies.company_name
from jobs
join applications on jobs.job_id=applications.job_id
join companies on jobs.company_id=companies.company_id
where applicant_id ='3076';


-- 8 

select * from jobs;

select avg(salary)
from jobs
where job_title='SWE-L1';


-- 9 

select * from jobs;

select DISTINCT count(jobs.company_id) as count, companies.company_name
from jobs
join companies on jobs.company_id = companies.company_id
group by jobs.company_id ;

-- 11

select DISTINCT jobs.job_title, jobs.salary
from jobs
where jobs.salary between 400000 and 600000;

-- 12 

select distinct jobs.job_id, jobs.job_title
from jobs
left join applications on jobs.job_id=applications.job_id
where applications.job_id IS NULL;

-- 13

select * from applications;

select  applicants.first_name , companies.company_name  , jobs.job_title as position
from applications
join applicants on applications.applicant_id=applicants.applicant_id
join jobs on applications.job_id=jobs.job_id
join companies on companies.company_id=jobs.company_id;



-- 14

select companies.company_name, count(jobs.company_id) as count_of_job
from jobs
join companies on jobs.company_id = companies.company_id
group by jobs.company_id;

-- 15 

select  applicants.first_name , companies.company_name , jobs.job_title
from applications
join applicants on applications.applicant_id=applicants.applicant_id
join jobs on applications.job_id=jobs.job_id
join companies on companies.company_id=jobs.company_id;

-- 16

select * from jobs
where salary > (select avg(salary) from jobs);

-- 17



-- 18
select job_title
from jobs
where job_description like'%Engineer%' OR job_description LIKE '%Designer%';

-- 19

select applicants.first_name, jobs.job_title
from applications
join applicants on applications.applicant_id= applicants.applicant_id
join jobs on applications.job_id=jobs.job_id;









