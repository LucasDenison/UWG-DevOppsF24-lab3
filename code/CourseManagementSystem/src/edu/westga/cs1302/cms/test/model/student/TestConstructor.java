package edu.westga.cs1302.cms.test.model.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Student(null, 87);});
	}

	@Test
	void testNameTooShort() {
		assertThrows(IllegalArgumentException.class, ()->{new Student("12", 87);});
	}
	
	@Test
	void testMinimumLengthNameAndGrade() {
		Student result = new Student("123", 0);
		
		assertEquals("123", result.getName(), "checking the name of the student and grade");
	}
	
	@Test
	void testMinimumLengthNameAndMaximumGrade() {
		Student result = new Student("123", 100);
		
		assertEquals("123", result.getName(), "checking the name of the student and grade");
	}
	
	@Test
	void testGradeLessThanZero() {
		assertThrows(NumberFormatException.class, ()->{new Student("Mike", -10);});
	}
	
	@Test
	void testGradeMoreThan100() {
		assertThrows(NumberFormatException.class, ()->{new Student("Mike", 101);});
	}
}
