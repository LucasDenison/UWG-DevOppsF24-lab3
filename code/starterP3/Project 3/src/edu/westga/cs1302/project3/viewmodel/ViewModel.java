package edu.westga.cs1302.project3.viewmodel;

import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TasksDataPersistenceManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.westga.cs1302.project3.model.Task;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
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
	private ObjectProperty<File> selectedFile;
	private StringProperty fileName;
	
	/** Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.title = new SimpleStringProperty("");
		this.description = new SimpleStringProperty("");
		this.tasks = new SimpleListProperty<Task>(FXCollections.observableArrayList(new ArrayList<Task>()));
		this.taskManager = new TaskManager();
		this.fileName = new SimpleStringProperty("");
		this.selectedFile = new SimpleObjectProperty<File>(null);
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
	
	/**returns the selected file
	 * 
	 * @return the selected file
	 */
	public ObjectProperty getSelectedFile() {
		return this.selectedFile;
	}
	
	/**returns the name of the selected file
	 * 
	 * @return the name of the selected file
	 */
	public StringProperty getFileName() {
		return this.fileName;
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
	
	public void loadTasks() {
		TasksDataPersistenceManager load = new TasksDataPersistenceManager();
		File file = this.selectedFile.getValue();
		String name = file.getName();
		try {
			load.loadTaskData(name);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Could not find file");
		} catch (IOException e) {
			throw new NullPointerException("could not load file due to missing elements");
		}
		
		
	}
}
