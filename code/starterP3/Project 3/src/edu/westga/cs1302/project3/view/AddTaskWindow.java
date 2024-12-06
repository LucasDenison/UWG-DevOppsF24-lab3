package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/** Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	@FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextArea description;

    @FXML
    private TextField title;
	
    @FXML
    private AnchorPane addTaskPane;
    
	@FXML
	void initialize() {
		this.cancelButton.setOnAction(
				(event) -> {
					((Node) (event.getSource())).getScene().getWindow().hide();
				}
			);
		this.addButton.setOnAction(
				(event) -> {
					((Node) (event.getSource())).getScene().getWindow().hide();
				}
			);
	}
	
	/**binds this page to the VM in the mainWindow
	 * 
	 * @param vm the viewModel
	 */
	public void bindToVM(ViewModel vm) {
		if (this.title.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	Window owner = this.addTaskPane.getScene().getWindow();
			alert.initOwner(owner);
			alert.setTitle("Error");
			alert.setHeaderText("Cannot Add Task");
			alert.setContentText("Title is empty");
			alert.showAndWait();
		} else if (this.title.getText().equals(null)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	Window owner = this.addTaskPane.getScene().getWindow();
			alert.initOwner(owner);
			alert.setTitle("Error");
			alert.setHeaderText("Cannot Add Task");
			alert.setContentText("Title is Null");
			alert.showAndWait();
		} else if (this.description.getText().equals(null)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	Window owner = this.addTaskPane.getScene().getWindow();
			alert.initOwner(owner);
			alert.setTitle("Error");
			alert.setHeaderText("Cannot Add Task");
			alert.setContentText("Description is Null");
			alert.showAndWait();
		} else if (this.description.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	Window owner = this.addTaskPane.getScene().getWindow();
			alert.initOwner(owner);
			alert.setTitle("Error");
			alert.setHeaderText("Cannot Add Task");
			alert.setContentText("Description is Empty");
			alert.showAndWait();
		}
		vm.addTask(this.title.getText(), this.description.getText());
	}
	
}
