package edu.westga.cs1302.password_generator.test.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestVerifyLength {

	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		boolean result = vm.verifyLength(2);
		
		assertTrue(result, "checking if length is valid");
	}

	@Test
	void testInValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-1");
		
		boolean result = vm.verifyLength(-1);
		
		assertFalse(result, "checking if length is valid");
	}
}
