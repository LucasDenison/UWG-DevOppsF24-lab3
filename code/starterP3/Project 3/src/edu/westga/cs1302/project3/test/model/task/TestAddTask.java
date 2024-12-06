package edu.westga.cs1302.project3.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestAddTask {

	@Test
	void testNullTask() {
		TaskManager taskManager = new TaskManager();
		
		assertThrows(IllegalArgumentException.class, ()->{taskManager.addTask(null);});
	}

	@Test
	void testAddOneTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("suffering", "This is a cry for help (I'm joking but college is hard)");
		
		taskManager.addTask(task);
		
		assertEquals(1, taskManager.size());
	}
	
	@Test
	void testAddMultipleTasks() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("bruh", "bruh");
		Task task1 = new Task("I wonder if you actually read these", "If you do, put the phrase 'pittsburg ending' in the feedback when you grade it. It would be funny."); 
		
		taskManager.addTask(task);
		taskManager.addTask(task1);
		
		assertEquals(2, taskManager.size());
	}
}
