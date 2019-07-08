package com.cts.taskmanager.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.taskmanager.exception.TaskmanagerException;
import com.cts.taskmanager.model.ServiceResult;
import com.cts.taskmanager.model.Task;
import com.cts.taskmanager.repository.TaskRepository;
import com.cts.taskmanager.service.ITaskmanager;


@RestController
@RequestMapping(value = "services/taskservice")
public class TaskController {
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	private ITaskmanager manager;
	@Autowired
	public TaskController(ITaskmanager manager) {
		this.manager=manager;
	}
	@RequestMapping(value = "taskbyname/{taskName}", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<Task>> getTaskByName(@PathVariable String taskName) {
		ServiceResult<Task> result=new ServiceResult<Task>();
		try {
			Task tasks=manager.getTaskByName(taskName);
			result.setData(tasks);
			result.setSuccess(true);
		}catch(TaskmanagerException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "taskbyparent/{parentTaskName}", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<Task>> getTasksByParentTaskName(@PathVariable String parentTaskName) {
		ServiceResult<Task> result=new ServiceResult<Task>();
		try {
			List<Task> tasks=manager.getTasksByParent(parentTaskName);
			result.setDataList(tasks);
			result.setSuccess(true);
		}catch(TaskmanagerException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
		 
	}
	@RequestMapping(value = "savetask",method = RequestMethod.POST)
	public ResponseEntity<ServiceResult<String>> saveOrUpdate(@RequestBody @Valid Task task){
		ServiceResult<String> result=new ServiceResult<String>();
		try {

			manager.createOrUpdateTask(task);
			result.setData("success");
			result.setSuccess(true);
		}catch(TaskmanagerException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
