package com.cts.taskmanager.model;

import java.util.List;

public class ServiceResult<T> extends TaskBase{
	private T data;
	private List<T> dataList;
    boolean success;
    private TaskError error;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TaskError getError() {
        return error;
    }

    public void setError(TaskError error) {
        this.error = error;
    }

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
    
}
