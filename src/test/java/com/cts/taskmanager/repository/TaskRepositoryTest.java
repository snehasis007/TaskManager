package com.cts.taskmanager.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.taskmanager.model.Task;
@RunWith(SpringRunner.class)
@SpringBootTest
class TaskRepositoryTest {
	@Autowired
	TaskRepository repo;
	Task task1,task2,task3;
	@Before
    public void setUp() {

		repo.deleteAll();

		task1 = repo.save(new Task("task1","01/02/2017","03/08/2019",1));
		task2 = repo.save(new Task("task2","01/02/2017","03/08/2019",2));
		task3 = repo.save(new Task("task3","01/02/2017","03/08/2019",3));
    }
	
	@Test
	public final void testFindByTask() {
		Task tk=repo.findByTask("task1");
		assertThat(tk).isNotNull().extracting("task").contains("task1");
	}

}
