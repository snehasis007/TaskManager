package com.cts.taskmanager.exception;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.cts.taskmanager.model.TaskError;
public class TaskmanagerException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5537866808874125010L;
	private TaskError error;

    {
        error=new TaskError();
    }
    public TaskmanagerException() {
        //super();
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public TaskmanagerException(String message) {
        super(message);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public TaskmanagerException(String message, Throwable cause) {
        super(message, cause);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public TaskmanagerException(Throwable cause) {
        super(cause);
        error.setMessage(getMessage());
        error.setStackTrace(getStackTraceMessage());
    }

    public TaskError getError() {
        return error;
    }

    public void setError(TaskError error) {
        this.error = error;
    }

    String getStackTraceMessage(){

        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        printStackTrace(pw);
        return sw.toString();
    }
}
