package edu.westga.cs1302.project3.model;

/**
 * The Task Class represents the title and description of the task.
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class Task {
	private String title;
	private String description;
	
	/**
	 * Creates a new Task object with the specified title and description.
	 * 
	 * @precondition title != null && title.lenth() > 0 && description != null &&
	 *               description.lenth() > 
	 * @postcondition this.getTitle()==title && this.getdescription()==description
	 * 
	 * @param title
	 *            the title of the task
	 * @param description
	 *            the description of the task
	 */
	public Task(String title, String description) {
		if (title == null) {
			throw new IllegalArgumentException("title cannot be null");
		}
		if (title.isEmpty()) {
			throw new IllegalArgumentException("title cannot be empty");
		}
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException("description cannot be empty");
		}
		
		this.title = title;
		this.description = description;
	}
	
	/**
	 * gets title of task
	 * 
	 * @return title of task
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * gets description of task
	 * 
	 * @return description of task
	 */
	public String getDescription() {
		return this.description;
	}
}
