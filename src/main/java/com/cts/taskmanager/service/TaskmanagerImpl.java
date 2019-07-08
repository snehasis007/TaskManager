package com.cts.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.taskmanager.exception.TaskmanagerException;
import com.cts.taskmanager.model.Task;
import com.cts.taskmanager.repository.TaskRepository;

public class TaskmanagerImpl implements ITaskmanager{

	
	private TaskRepository repository;
	@Autowired
	public TaskmanagerImpl(TaskRepository repository) {
		this.repository=repository;
	}
	@Override
	public void createOrUpdateTask(Task tk) throws TaskmanagerException{
		try {
			repository.save(tk);
		}catch(Exception e) {
			TaskmanagerException te=new TaskmanagerException("fail", e);
			throw te;
		}
	}

	@Override
	public List<Task> getAllTasks() throws TaskmanagerException{
		try {
			List<Task> alltasks=repository.findAll();
			return alltasks;
		}catch(Exception e) {
			TaskmanagerException te=new TaskmanagerException("fail", e);
			throw te;
		}
	}

	@Override
	public List<Task> getTasksByParent(String parentName) throws TaskmanagerException{
		try {
			List<Task> alltasks=repository.findAll();
			List<Task> tasks=new ArrayList<>();
			for(Task tsk:alltasks) {
				if(tsk.getpTask()!=null && tsk.getpTask().getTask()!=null && tsk.getpTask().getTask().equalsIgnoreCase("parentTaskName")) {
					tasks.add(tsk);
				}
			}
			return tasks;
		}catch(Exception e) {
			TaskmanagerException te=new TaskmanagerException("fail", e);
			throw te;
		}
	}

	@Override
	public void deleteTask(String id) throws TaskmanagerException{
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			TaskmanagerException te=new TaskmanagerException("fail", e);
			throw te;
		}
	}
	@Override
	public Task getTaskByName(String taskName) {
		try {
			return repository.findByTask(taskName);
		}catch(Exception e) {
			TaskmanagerException te=new TaskmanagerException("fail", e);
			throw te;
		}
	}

}
