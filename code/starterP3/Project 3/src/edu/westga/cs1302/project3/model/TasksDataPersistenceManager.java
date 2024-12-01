package edu.westga.cs1302.project3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving and loading task data,
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class TasksDataPersistenceManager {
	public static final String DATA_FILE = "data.txt";
	
	/**
	 * Saves the tasks
	 * 
	 * Writes each task to DATA_FILE Each task is written on a separate line
	 * Each line uses the following format: title, description
	 * 
	 * @precondition tasks != null
	 * @postcondition none
	 * 
	 * @param tasks the set of tasks to save
	 * @throws IOException
	 */
	public void saveTaskData(TaskManager tasks) throws IOException {
		if (tasks == null) {
			throw new IllegalArgumentException("Must provide a valid list tasks");
		}
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			for (Task currTask : tasks.getTasks()) {
				if (currTask != null) {
					writer.write(currTask.getTitle() + ": " + currTask.getDescription() + System.lineSeparator());
				}
			}
		}
	}

	/**
	 * Loads tasks
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format described by
	 * saveTaskData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param file the file to be loaded from
	 * @return the set of tasks loaded
	 * @throws FileNotFoundException file location does not exist
	 * @throws IOException           invalid or missing title/description found when trying
	 *                               to create a task
	 */
	public TaskManager loadTaskData(String file) throws FileNotFoundException, IOException {
		TaskManager tasks = new TaskManager();
		File inputFile = new File(file);
		try (Scanner reader = new Scanner(inputFile)) {
			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String baseLine = reader.nextLine();
				String strippedLine = baseLine.strip();
				String[] parts = strippedLine.split(": ");
				try {
					String title = parts[0];
					String description = parts[1];
					Task nextTask = new Task(title, description);
					tasks.addTask(nextTask);
				} catch (NumberFormatException numError) {
					throw new IOException(
							"Unable to read description on line " + lineNumber + " : " + strippedLine);
				} catch (IndexOutOfBoundsException studentDataError) {
					throw new IOException(
							"Missing either task and/or description on line " + lineNumber + " : " + strippedLine);
				}
			}
		}
		return tasks;
	}
}
