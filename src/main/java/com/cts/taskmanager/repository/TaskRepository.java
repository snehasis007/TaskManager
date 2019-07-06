package com.cts.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.taskmanager.model.Task;
@Repository
public interface TaskRepository extends MongoRepository<Task, String>{
	public Task findByTask(String task);
	public Task findByStartDate(String startDate);
	public Task findByEndDate(String endDate);
	public Task findByPriority(Integer priority);
}
