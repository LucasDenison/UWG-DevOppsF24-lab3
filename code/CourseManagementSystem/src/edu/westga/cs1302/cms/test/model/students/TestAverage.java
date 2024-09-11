package edu.westga.cs1302.cms.test.model.students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;
import edu.westga.cs1302.cms.model.Students;

class TestAverage {

	@Test
	void testWhenNoStudents() {
		assertThrows (ArithmeticException.class, ()->{Students students = new Students();
		students.getAverage();
		});
		
	}
	
	@Test
	void testWhenStudentsHasOneStudent() {
		Students students = new Students();
		Student student1 = new Student("mike", 97);
		students.addStudent(student1);
		int result = students.getAverage();
		assertEquals(result, 97);
	}
	
	@Test
	void testWhenStudentsHasMultipleStudents() {
		Students students = new Students();
		Student student1 = new Student("mike", 97);
		students.addStudent(student1);
		Student student2 = new Student("sam", 86);
		students.addStudent(student2);
		int result = students.getAverage();
		assertEquals(result, 91);
	}

}
