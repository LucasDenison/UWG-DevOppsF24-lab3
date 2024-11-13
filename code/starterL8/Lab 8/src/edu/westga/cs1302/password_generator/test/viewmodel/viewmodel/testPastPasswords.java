package edu.westga.cs1302.password_generator.test.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class testPastPasswords {

	@Test
	void testNoPastPasswords() {
		ViewModel vm = new ViewModel();
		vm.getPastPassword();
		
		assertEquals(vm.getPastPassword().getSize(), 0, "checking size of list");
	}

	@Test
	void testOnePastPasswords() {
		ViewModel vm = new ViewModel();
		
		vm.getMinimumLength().setValue("2");
		vm.generatePassword();
		
		vm.projectPassword();
		vm.getPastPassword();
		
		assertEquals(vm.getPastPassword().getSize(), 1, "checking size of list");
	}
	
	@Test
	void testMultiplePastPasswords() {
		ViewModel vm = new ViewModel();
		
		vm.getMinimumLength().setValue("2");
		vm.generatePassword();
		vm.projectPassword();
		
		vm.getMinimumLength().setValue("4");
		vm.generatePassword();
		vm.projectPassword();
		
		vm.getPastPassword();
		
		assertEquals(vm.getPastPassword().getSize(), 2, "checking size of list");
	}
}
