package com.cts.taskmanager.service;

import java.util.List;

import com.cts.taskmanager.exception.TaskmanagerException;
import com.cts.taskmanager.model.ParentTask;
import com.cts.taskmanager.model.Task;

public interface ITaskmanager {
	void createOrUpdateTask(Task tk)throws TaskmanagerException;
	List<Task> getAllTasks()throws TaskmanagerException;
	Task getTaskByName(String taskName) throws TaskmanagerException;
	List<Task> getTasksByParent(String parentName)throws TaskmanagerException;
	void deleteTask(String id) throws TaskmanagerException;
	public List<ParentTask> getAllParentTasks() throws TaskmanagerException;
}
