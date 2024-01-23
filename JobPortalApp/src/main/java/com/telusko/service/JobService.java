package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.model.JobPost;
import com.telusko.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobRepo;
	

	
	//secured
	//adding a new job
	public JobPost addJob(JobPost jobPost) {
	return jobRepo.save(jobPost);
		
	}
	
	//secured
	//getting all jobs
	public List<JobPost> getAllJobs(){
		return jobRepo.findAll();
	}
	
	//secured
	//getting a job by id
	public JobPost getJob(int id) {
		return jobRepo.findById(id).get();
		}
	
	//secured
	//deleting a job by id
	public String deleteJob(int id) {
		jobRepo.deleteById(id);
		return "deleted successfully";
	}
	
	
}
