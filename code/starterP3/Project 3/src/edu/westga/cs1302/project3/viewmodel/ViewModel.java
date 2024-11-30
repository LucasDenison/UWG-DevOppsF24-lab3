package edu.westga.cs1302.project3.viewmodel;

import edu.westga.cs1302.project3.model.TaskManager;

import java.util.ArrayList;

import edu.westga.cs1302.project3.model.Task;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class ViewModel {
	private StringProperty title;
	private StringProperty description;
	private ListProperty<Task> tasks;
	private TaskManager taskManager;
	
	/** Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.title = new SimpleStringProperty("");
		this.description = new SimpleStringProperty("");
		this.tasks = new SimpleListProperty<Task>(FXCollections.observableArrayList(new ArrayList<Task>()));
		this.taskManager = new TaskManager();
	}
	
	/**returns the title of the task
	 * 
	 * @return the title of the task
	 */
	public StringProperty getTitleProperty() {
		return this.title;
	}
	
	/**returns the description of the task
	 * 
	 * @return the description of the task
	 */
	public StringProperty getDescriptionProperty() {
		return this.description;
	}
	
	/**returns the tasks
	 * 
	 * @return the tasks
	 */
	public ListProperty getTasks() {
		this.projectTasks();
		return this.tasks;
	}
	
	/** projects investment given the current inputs
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @throws IllegalArgumentException if capital, interest rate, or years is invalid value
	 */
	public void projectTasks() throws IllegalArgumentException {
		Task task = this.createTasks();
		
		this.tasks.getValue().add(task);
	}
	
	/**creates the tasks for the MainWindow
	 * 
	 * @return task0 the task created
	 */
	private Task createTasks() {
		this.title.setValue("Title of task");
		this.description.setValue("Desc");
		Task task0 = new Task(this.title.getValue(), this.description.getValue());

		return task0;
	}
}
