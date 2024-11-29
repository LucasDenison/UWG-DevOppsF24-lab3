package edu.westga.cs1302.project3.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TasksDataPersistenceManager;

class TestLoadTaskData {

	@Test
	void testEmptyFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("");
		}
		
		TaskManager tasks = new TaskManager();
		TasksDataPersistenceManager load = new TasksDataPersistenceManager();
		tasks = load.loadTaskData();
		assertEquals(tasks.size(), 0);
	}

	@Test
	void testOneTaskInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("Spongebob: Squarepants" + System.lineSeparator());
		}
		
		TaskManager tasks = new TaskManager();
		TasksDataPersistenceManager load = new TasksDataPersistenceManager();
		tasks = load.loadTaskData();
		assertEquals(tasks.size(), 1);
		assertEquals(tasks.getTasks().get(0).getTitle(), "Spongebob");
		assertEquals(tasks.getTasks().get(0).getDescription(), "Squarepants");
	}
	
	@Test
	void testMultipleTaskInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("Spongebob: Squarepants" + System.lineSeparator());
			writer.write("Squidward: Tentacles" + System.lineSeparator());
		}
		
		TaskManager tasks = new TaskManager();
		TasksDataPersistenceManager load = new TasksDataPersistenceManager();
		tasks = load.loadTaskData();
		assertEquals(tasks.size(), 2);
		assertEquals(tasks.getTasks().get(0).getTitle(), "Spongebob");
		assertEquals(tasks.getTasks().get(0).getDescription(), "Squarepants");
		assertEquals(tasks.getTasks().get(1).getTitle(), "Squidward");
		assertEquals(tasks.getTasks().get(1).getDescription(), "Tentacles");
	}
	
	@Test
	void testIncompleteTaskInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("it's currently 9:37 pm" + System.lineSeparator());
		}
		
		
		assertThrows(IOException.class, ()->{
			TaskManager tasks = new TaskManager();
			TasksDataPersistenceManager load = new TasksDataPersistenceManager();
			tasks = load.loadTaskData();
		});
	}
}
