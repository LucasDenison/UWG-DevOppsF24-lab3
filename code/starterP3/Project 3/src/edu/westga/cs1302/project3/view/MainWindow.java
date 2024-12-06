package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.IOException;

import edu.westga.cs1302.project3.Main;
import edu.westga.cs1302.project3.view.AddTaskWindow;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
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
	    @FXML
	    private MenuItem saveMenuItem;
	    @FXML
	    private Button addTaskButton;
	    
	    
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
	    				this.loadFile();
	    		}
	    	);
	    	
	    	this.saveMenuItem.setOnAction(
	    			(event) -> {
	    				this.saveFile();
	    			}
	    	);
	    	
	    	this.addTaskButton.setOnAction(
	    			(event) -> {
	    				this.displayAddTasksScreen();
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
	    
	    private void saveFile() {
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Choose CS1302 File");
	    	ExtensionFilter filter1 = new ExtensionFilter("CS1302 Files", "*.CS1302");
	    	fileChooser.getExtensionFilters().addAll(filter1);
	    	File selectedFile = fileChooser.showOpenDialog(null);
	    	if (selectedFile != null) {
	    		this.vm.saveTasks(selectedFile, this.tasks.getItems());
	    	}
	    	if (!selectedFile.canWrite()) {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
		    	Window owner = this.guiPane.getScene().getWindow();
				alert.initOwner(owner);
				alert.setTitle("Error");
				alert.setHeaderText("Cannot Save Data");
				alert.setContentText("This file cannot be Saved.");
				alert.showAndWait();
	    	}
	    }
	    
	    private void loadFile() {
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Choose CS1302 File");
	    	ExtensionFilter filter1 = new ExtensionFilter("CS1302 Files", "*.CS1302");
	    	fileChooser.getExtensionFilters().addAll(filter1);
	    	File selectedFile = fileChooser.showOpenDialog(null);
	    	
	    	if (selectedFile != null) {
	    		this.vm.loadTasks(selectedFile);
	    	}
//	    	if (selectedFile) {
//	    		Alert alert = new Alert(Alert.AlertType.ERROR);
//		    	Window owner = this.guiPane.getScene().getWindow();
//				alert.initOwner(owner);
//				alert.setTitle("Error");
//				alert.setHeaderText("Cannot Load Data");
//				alert.setContentText("This file cannot be loaded. Missing components");
//				alert.showAndWait();
//	    	} 
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
	    
	    private void displayAddTasksScreen() {
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.ADD_TASK_WINDOW));
			try {
				loader.load();
				Parent parent = loader.getRoot();
				Scene scene = new Scene(parent);
				Stage setPropertyStage = new Stage();
				setPropertyStage.setTitle(Main.ADD_TASK_TITLE);
				setPropertyStage.setScene(scene);
				setPropertyStage.initModality(Modality.APPLICATION_MODAL);
				setPropertyStage.showAndWait();
				
				AddTaskWindow addTaskWin = (AddTaskWindow) loader.getController();
				addTaskWin.bindToVM(this.vm);
				
			} catch (IOException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to load properties window.");
				alert.showAndWait();
			}
		}
}
