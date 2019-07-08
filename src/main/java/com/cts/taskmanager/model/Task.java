package com.cts.taskmanager.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends TaskBase{
	@Id
    private String id;
	private ParentTask pTask;
	@JsonProperty("taskName")
	private String task;
	@JsonProperty("startDate")
	private String startDate;
	@JsonProperty("endDate")
	private String endDate;
	@JsonProperty("priority")
	private Integer priority;
	public Task(String taskname,String startdate,String enddate,Integer priority) {
		this.task=taskname;
		this.startDate=startdate;
		this.endDate=enddate;
		this.priority=priority;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ParentTask getpTask() {
		return pTask;
	}
	public void setpTask(ParentTask pTask) {
		this.pTask = pTask;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
