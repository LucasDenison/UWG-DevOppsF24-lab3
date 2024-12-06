package edu.westga.cs1302.project3.test.viewmodel.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.TasksDataPersistenceManager;
import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestLoadFileData {

	@Test
	void testOneItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("SpongeBob: SquarePants" + System.lineSeparator());
		}
		
		ViewModel vm = new ViewModel();
		File file = new File(TasksDataPersistenceManager.DATA_FILE);
		vm.loadTasks(file);
		assertEquals(vm.getTasks().getSize(), 2, "one default task is always present. Testing for one task in file");
		assertEquals(vm.getTasks().get(0).toString(), "SpongeBob");
		assertEquals(vm.getTasks().get(1).toString(), "Title of task");
	}
	
	@Test
	void testMultipleItemsInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("SpongeBob: SquarePants"+System.lineSeparator());
			writer.write("EarthBound: Ness"+System.lineSeparator());
			
		}
		
		ViewModel vm = new ViewModel();
		File file = new File(TasksDataPersistenceManager.DATA_FILE);
		vm.loadTasks(file);
		assertEquals(vm.getTasks().getSize(), 3, "one default task is always present. Testing for multiple tasks in file");
		assertEquals(vm.getTasks().get(1).toString(), "EarthBound");
		assertEquals(vm.getTasks().get(0).toString(), "SpongeBob");
		assertEquals(vm.getTasks().get(2).toString(), "Title of task");
	}
	
	@Test
	void testIncompleteItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(TasksDataPersistenceManager.DATA_FILE)) {
			writer.write("SpongeBob: SquarePants"+System.lineSeparator());
			writer.write("EarthBound"+System.lineSeparator());
			
		}
		assertThrows(NullPointerException.class, ()->{
			ViewModel vm = new ViewModel();
			File file = new File(TasksDataPersistenceManager.DATA_FILE);
			vm.loadTasks(file);
		});
	}
}
