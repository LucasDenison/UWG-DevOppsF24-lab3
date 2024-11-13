package edu.westga.cs1302.password_generator.test.model.password_generator;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;

class TestGeneratePasswordValid {

	@Test
	void testMinimumLengthIsValid() {
		PasswordGenerator generator = new PasswordGenerator(1);
		generator.setMinimumLength(1);
		int checkLength = generator.getMinimumLength();
		
		boolean result = PasswordGenerator.isValidLength(checkLength);
		assertTrue(result, "checking if length is valid");
	}
}
