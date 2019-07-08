package com.cts.taskmanager.service;

import java.util.List;

import com.cts.taskmanager.model.Task;

public interface ITaskmanager {
	void createOrUpdateTask(Task tk);
	List<Task> getAllTasks();
	Task getTaskByName(String taskName);
	List<Task> getTasksByParent(String parentName);
	void deleteTask(String id);
}
