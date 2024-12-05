package edu.westga.cs1302.project3.view;

import java.io.File;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	 	@FXML
	    private MenuItem aboutHelpMenuItem;
	    @FXML
	    private MenuItem closeFileMenuItem;
	    @FXML
	    private ListView tasks;
	    @FXML
	    private AnchorPane guiPane;
	    @FXML
	    private MenuItem loadMenuItem;
	    
	    private ViewModel vm;
	    
	    @FXML
	    void initialize() {
	    	this.vm = new ViewModel();
	    	this.tasks.setItems(this.vm.getDefaultTasks());
	    	this.tasks.setItems(this.vm.getTasks());
	    	
	    	this.closeFileMenuItem.setOnAction(
	    			(event) -> {
	    				Stage stage = (Stage)
	    						this.guiPane.getScene().getWindow();
	    				stage.close();
	    			}
	    		);
	    	this.aboutHelpMenuItem.setOnAction(
	    			(event) -> {
	    				this.showAbout();
	    			}
	    	);
	    	
	    	this.loadMenuItem.setOnAction(
	    			(event) -> {
	    				this.chooseFile();
	    		}
	    	);
	    }
	    
	    private void showAbout() {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	Window owner = this.guiPane.getScene().getWindow();
			alert.initOwner(owner);
			alert.setTitle("About");
			alert.setHeaderText("About");
			alert.setContentText("Author: Lucas Denison. \n"
					+ "Purpose: To create a UI that helps manage all your tasks.");
			alert.showAndWait();
	    }
	    
	    private void chooseFile() {
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Choose Text File");
	    	fileChooser.getExtensionFilters().addAll(
	    	new ExtensionFilter("Text Files", "*.txt"), new ExtensionFilter("All Files", "*.*"));
	    	File selectedFile = fileChooser.showOpenDialog(null);
	    	if (selectedFile != null) {
	    		this.vm.loadTasks(selectedFile);
	    	}
	    	if (!"*.txt".equals(selectedFile.getName())) {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
		    	Window owner = this.guiPane.getScene().getWindow();
				alert.initOwner(owner);
				alert.setTitle("Error");
				alert.setHeaderText("Cannot Load Data");
				alert.setContentText("This file cannot be loaded. Can only accept .txt files.");
				alert.showAndWait();
	    	} 
	    	if (selectedFile.getTotalSpace() == 0) {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
		    	Window owner = this.guiPane.getScene().getWindow();
				alert.initOwner(owner);
				alert.setTitle("Error");
				alert.setHeaderText("Cannot Load Data");
				alert.setContentText("This file cannot be loaded. File is Empty.");
				alert.showAndWait();
	    	}
	    }
}
