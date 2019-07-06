package com.cts.taskmanager.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.taskmanager.model.Task;
import com.cts.taskmanager.repository.TaskRepository;


@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	private TaskRepository repository;
	@Autowired
	public TaskController(TaskRepository repository) {
		this.repository=repository;
	}
	@RequestMapping(value = "/{taskName}", method = RequestMethod.GET)
	public Task getTaskByName(@PathVariable String taskName) {
		return repository.findByTask(taskName);
	}
	@RequestMapping(value = "/{parentTaskName}", method = RequestMethod.GET)
	public List<Task> getTasksByParentTaskName(@PathVariable String parentTaskName) {
		List<Task> alltasks=repository.findAll();
		List<Task> tasks=new ArrayList<>();
		for(Task tsk:alltasks) {
			if(tsk.getpTask()!=null && tsk.getpTask().getTask()!=null && tsk.getpTask().getTask().equalsIgnoreCase("parentTaskName")) {
				tasks.add(tsk);
			}
		}
		return tasks;
	}
}
