package com.socialappbackend.dao;

import java.util.List;

import com.socialappbackend.model.job;

public interface jobdao {
	public boolean addjob(job b);
	public boolean updatejob(job b);
	public boolean deletejob(job b);
	public job getjobbyid(int jobId);
	public List<job> getalljobs();
}
