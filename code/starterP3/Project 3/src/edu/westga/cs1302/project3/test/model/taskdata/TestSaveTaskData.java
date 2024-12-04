package edu.westga.cs1302.project3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TasksDataPersistenceManager;

class TestSaveTaskData {

	@Test
	void testNullTasks() {
		assertThrows(IllegalArgumentException.class, ()->{
			TasksDataPersistenceManager saveData =  new TasksDataPersistenceManager();
			saveData.saveTaskData(null);
		});
	}

	@Test
	void testNoTasks() throws IOException {
		TasksDataPersistenceManager saveData =  new TasksDataPersistenceManager();
		saveData.saveTaskData(new TaskManager());
		
		File inputFile = new File(TasksDataPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine(), "checking that file is empty");
		}
	}
	
	@Test
	void testOneTasks() throws IOException {
		TaskManager tasks = new TaskManager();
		Task task = new Task("scout tf2","grass grows, birds fly, and brotha, I'm a force-a-nature.");
		tasks.addTask(task);
		TasksDataPersistenceManager saveData = new TasksDataPersistenceManager();
		saveData.saveTaskData(tasks);
		
		File inputFile = new File(TasksDataPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("scout tf2: grass grows, birds fly, and brotha, I'm a force-a-nature.", reader.nextLine(), "checking first line.");
			assertFalse(reader.hasNextLine(), "checking that file has one task saved");
		}
	}
	
	@Test
	void testMultipleTasks() throws IOException {
		TaskManager tasks = new TaskManager();
		Task task = new Task("I'm watching charlie brown thanksgiving right now","snoopy a real one.");
		Task task2 = new Task("so is woodstock", "he's underrated");
		tasks.addTask(task);
		tasks.addTask(task2);
		TasksDataPersistenceManager saveData =  new TasksDataPersistenceManager();
		saveData.saveTaskData(tasks);
		
		File inputFile = new File(TasksDataPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("I'm watching charlie brown thanksgiving right now: snoopy a real one.", reader.nextLine(), "checks first line");
			assertEquals("so is woodstock: he's underrated", reader.nextLine(), "checks second line");
			assertFalse(reader.hasNextLine(), "checking that file has multiple tasks saved");
		}
	}
}
