package edu.westga.cs1302.cms.model;

import java.util.Comparator;

public class StudentDescendingGradeComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getGrade() < o2.getGrade()) {
			return 1;
		} else if (o1.getGrade() > o2.getGrade()) {
			return -1;
		} else {
			return 0;
		}
	}

}
