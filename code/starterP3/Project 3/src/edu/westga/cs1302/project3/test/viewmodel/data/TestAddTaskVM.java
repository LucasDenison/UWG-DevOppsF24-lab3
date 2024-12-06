package edu.westga.cs1302.project3.test.viewmodel.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestAddTaskVM {

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, ()->{
			ViewModel vm = new ViewModel();
			vm.addTask(null, "desc");
			}
		);
	}
	
	@Test
	void testNullDesc() {
		assertThrows(IllegalArgumentException.class, ()->{
			ViewModel vm = new ViewModel();
			vm.addTask("water bolt", null);
			}
		);
	}
	
	@Test
	void testEmptyDesc() {
		assertThrows(IllegalArgumentException.class, ()->{
			ViewModel vm = new ViewModel();
			vm.addTask("cursed flames", "");
			}
		);
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, ()->{
			ViewModel vm = new ViewModel();
			vm.addTask("", "spinning");
			}
		);
	}
	
	@Test
	void testValidTask() {
		ViewModel vm = new ViewModel();
		vm.addTask("Dart Monkey", "Funny bloon game");
	}
}
