package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
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
	    
	    private ViewModel vm;
	    
	    @FXML
	    void initialize() {
	    	this.vm = new ViewModel();
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
}
