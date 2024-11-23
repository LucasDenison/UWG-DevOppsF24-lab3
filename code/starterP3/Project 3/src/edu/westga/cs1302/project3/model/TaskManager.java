package edu.westga.cs1302.project3.model;

import java.util.ArrayList;

/**
 * Creates a list that contains multiple task
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class TaskManager {
	private ArrayList<Task> taskManager;
	
	/**
	 * Creates a new empty TaskManager
	 */
	public TaskManager() {
		this.taskManager = new ArrayList<Task>();
	}
	
	/**
	 * Adds the task to the task manager
	 * 
	 * @precondition task != null
	 * @postcondition task is added to the list of tasks in the task manager
	 * 
	 * @param task the task to be added to the task manager
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("task cannot be null");
		}
		this.taskManager.add(task);
	}
	
	/**
	 * removes the task to the task manager
	 * 
	 * @precondition task != null
	 * @postcondition task is  to the list of tasks in the task manager
	 * 
	 * @param task the task to be removed to the task manager
	 */
	public void removeTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("task cannot be null");
		}
		if (this.taskManager.isEmpty()) {
			throw new IllegalArgumentException("Cannot remove task because their are none.");
		}
		this.taskManager.remove(task);
	}
	
	/**
	 * gets size of task list
	 * 
	 * @return the number of task inside the task manager
	 */
	public int size() {
		return this.taskManager.size();
	}
}
