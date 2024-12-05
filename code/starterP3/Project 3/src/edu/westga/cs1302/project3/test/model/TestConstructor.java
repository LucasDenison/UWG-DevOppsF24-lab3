package edu.westga.cs1302.project3.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

class TestTask {

	@Test
	void testIfTitleNull() {
		assertThrows(IllegalArgumentException.class, ()->{new Task(null,"bruh");});
	}

	@Test
	void testIfTitleEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("","bruh");});
	}
	
	@Test
	void testIfDescriptionNull() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("bruh", null);});
	}
	
	@Test
	void testIfDescriptionEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("bruh", "");});
	}
	
	@Test
	void testIfTaskIsValid() {
		Task task = new Task("bruh", "bruh");
		
		String taskTitle = task.getTitle();
		String taskDescription =  task.getDescription();
		
		assertEquals(taskTitle, "bruh");
		assertEquals(taskDescription, "bruh");
	}
}
