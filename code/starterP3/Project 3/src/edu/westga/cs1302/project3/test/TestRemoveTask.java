package edu.westga.cs1302.project3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestRemoveTask {

	@Test
	void testNullTask() {
		TaskManager taskManager = new TaskManager();
		
		assertThrows(IllegalArgumentException.class, ()->{taskManager.removeTask(null);});
	}
	
	@Test
	void testNoTaskToRemove() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("haha", "hehe");
		
		assertThrows(IllegalArgumentException.class, ()->{taskManager.removeTask(task);});
	}

	@Test
	void testAddOneTask() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Think of a number 1-10", "Was it 7?");
		
		taskManager.addTask(task);
		taskManager.removeTask(task);
		
		assertEquals(0, taskManager.size());
	}
	
	@Test
	void testRemoveMultipleTasks() {
		TaskManager taskManager = new TaskManager();
		Task task = new Task("Was I correct?", "Don't tell me I'm just gonna assume I guessed correctly.");
		Task task1 = new Task("If I guess the correct number, can I get one extra bonus point on this assignment.", "please."); 
		
		taskManager.addTask(task);
		taskManager.addTask(task1);
		taskManager.removeTask(task);
		taskManager.removeTask(task1);
		
		assertEquals(0, taskManager.size());
	}
}
