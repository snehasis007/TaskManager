package com.cts.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.taskmanager.model.ParentTask;

public interface ParentTaskRepository extends MongoRepository<ParentTask,String>{

}
