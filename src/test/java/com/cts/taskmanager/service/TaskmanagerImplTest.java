package com.cts.taskmanager.service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.taskmanager.model.Task;
import com.cts.taskmanager.repository.TaskRepository;
@RunWith(MockitoJUnitRunner.class)
public class TaskmanagerImplTest {
	@InjectMocks
	TaskmanagerImpl taskmanagerImpl;
	@Mock
	TaskRepository repository;
	
	
	@Test
    public void createOrUpdateTask()  {
        Task tk=new Task("test", "01/03/2014", "04/09/2017", 1);
        try {
        	taskmanagerImpl.createOrUpdateTask(tk);
        	assertTrue(true);
        }catch(Exception e) {
        	assertTrue(false);
        }
        
    }
	@Test
    public void deleteTask()  {
		Task tk=new Task("test", "01/03/2014", "04/09/2017", 1);
		tk.setId("DF24223");
		try {
			taskmanagerImpl.deleteTask(tk.getId());
        	assertTrue(true);
        }catch(Exception e) {
        	assertTrue(false);
        }
		
    }
	@Test
	public void getAllTask() {
		Task tk=new Task("test", "01/03/2014", "04/09/2017", 1);
		List<Task> tasks=new ArrayList<Task>();
		when(taskmanagerImpl.getAllTasks()).thenReturn(tasks);
		List<Task> taskre=taskmanagerImpl.getAllTasks();
		assertNotNull(taskre);
		assertArrayEquals(tasks.toArray(), taskre.toArray());
	}
}
