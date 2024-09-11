package edu.westga.cs1302.cms.model;

import java.util.ArrayList;

/**Stores and gets information on all students in the class
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class Students {
	private ArrayList<Student> students;
	private int averageGrade;
	
	/**Creates a new list of students
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Students() {
		this.students = new ArrayList<Student>();
	}
	
	/** Adds the students to the class
	 * 
	 * @precondition student != null
	 * @postcondition student is added to the list of students in the class
	 * 
	 * @param student the student to be added to the class
	 */
	public void addStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("student must not be null.");
		}
		this.students.add(student);
	}
	
	/**
	 * Gets all students in the class
	 * 
	 * @return the students in the class
	 */
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	
	/**
	 * gets the average number of the students grades
	 * 
	 * @precondition totalGrade != 0
	 * 
	 * @return the average grade of the class
	 */
	public int getAverage() {
		int totalGrade = 0;
		for (Student currentStudent: this.students) {
			totalGrade = totalGrade + currentStudent.getGrade();
		}
		if (totalGrade == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		this.averageGrade = totalGrade / this.students.size();
		return this.averageGrade;
	}
}
