package com.cts.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.taskmanager.exception.TaskmanagerException;
import com.cts.taskmanager.model.ParentTask;
import com.cts.taskmanager.model.Task;
import com.cts.taskmanager.repository.ParentTaskRepository;
import com.cts.taskmanager.repository.TaskRepository;
@Service
public class TaskmanagerImpl implements ITaskmanager{

	
	private TaskRepository repository;
	private ParentTaskRepository parentTaskRepository;
	@Autowired
	public TaskmanagerImpl(TaskRepository repository,ParentTaskRepository parentTaskRepository) {
		this.repository=repository;
		this.parentTaskRepository=parentTaskRepository;
	}
	@Override
	public void createOrUpdateTask(Task tk) throws TaskmanagerException{
		try {
			repository.save(tk);
			if(tk.getpTask()!=null && 
					(tk.getpTask().getParentTaskName()!=null && !tk.getpTask().getParentTaskName().trim().equalsIgnoreCase(""))) {
				parentTaskRepository.save(tk.getpTask());
			}
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
	public List<ParentTask> getAllParentTasks() throws TaskmanagerException{
		try {
			List<ParentTask> alltasks=parentTaskRepository.findAll();
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
				if(tsk.getpTask()!=null && tsk.getpTask().getParentTaskName()!=null && tsk.getpTask().getParentTaskName().equalsIgnoreCase(parentName)) {
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
