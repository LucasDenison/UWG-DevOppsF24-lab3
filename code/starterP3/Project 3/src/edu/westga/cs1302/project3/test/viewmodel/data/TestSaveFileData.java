package edu.westga.cs1302.project3.test.viewmodel.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TasksDataPersistenceManager;
import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestSaveFileData {

	
	@Test
	void testNulltasks() {
		assertThrows(NullPointerException.class, ()->{
			File file = new File(TasksDataPersistenceManager.DATA_FILE);
			ViewModel vm = new ViewModel();
			vm.saveTasks(file, null);
		});
	}
	
	@Test
	void testNullFile() {
		assertThrows(IndexOutOfBoundsException.class, ()->{
			TaskManager tasks = new TaskManager();
			ViewModel vm = new ViewModel();
			vm.saveTasks(null, tasks.getTasks());
		});
	}

	@Test
	void testNoTasks() throws IOException{
		ViewModel vm = new ViewModel();
		File file = new File(TasksDataPersistenceManager.DATA_FILE);
		TaskManager tasks = new TaskManager();
		vm.getTasks();
		vm.saveTasks(file, tasks.getTasks());
		
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
		ViewModel vm = new ViewModel();
		vm.getTasks();
		File file = new File(TasksDataPersistenceManager.DATA_FILE);
		vm.saveTasks(file, tasks.getTasks());
		File inputFile = new File(TasksDataPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("scout tf2: grass grows, birds fly, and brotha, I'm a force-a-nature.", reader.nextLine(), "checking second line.");
			assertFalse(reader.hasNextLine(), "checking that file has one task saved");
		}
	}
	
	@Test
	void testMultTasks() throws IOException {
		TaskManager tasks = new TaskManager();
		Task task = new Task("scout tf2","grass grows, birds fly, and brotha, I'm a force-a-nature.");
		tasks.addTask(task);
		Task task0 = new Task("pandimonium", "fish");
		tasks.addTask(task0);
		ViewModel vm = new ViewModel();
		vm.getTasks();
		File file = new File(TasksDataPersistenceManager.DATA_FILE);
		vm.saveTasks(file, tasks.getTasks());
		File inputFile = new File(TasksDataPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("scout tf2: grass grows, birds fly, and brotha, I'm a force-a-nature.", reader.nextLine(), "checking second line.");
			assertEquals("pandimonium: fish", reader.nextLine(), "checking 3rd line");
			assertFalse(reader.hasNextLine(), "checking that file has one task saved");
		}
	}
}
