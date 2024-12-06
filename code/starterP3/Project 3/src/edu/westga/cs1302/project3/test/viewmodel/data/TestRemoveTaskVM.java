package edu.westga.cs1302.project3.test.viewmodel.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestRemoveTaskVM {

	@Test
	void testNullTask() {
		ViewModel vm = new ViewModel();
		vm.getSelectedTask().setValue(null);
		
		
		assertThrows(IllegalArgumentException.class, ()->{vm.removeTask();});
	}

	@Test
	void testNoTaskInList() {
		ViewModel vm = new ViewModel();
		vm.getSelectedTask();
		
		assertThrows(IllegalArgumentException.class, ()->{vm.removeTask();});
	}
	
	@Test
	void testRemoveOneTask() {
		ViewModel vm = new ViewModel();
		
		vm.addTask("1:35", "AM");
		vm.getSelectedTask().setValue(vm.getTasks().getValue().get(0));
		vm.removeTask();
		
		assertEquals(1, vm.getTasks().getSize());
	}
}
