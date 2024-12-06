package edu.westga.cs1302.project3.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

/** Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	@FXML
    private Button cancelButton;
	
	@FXML
	void initialize() {
		this.cancelButton.setOnAction(
				(event) -> {
					((Node) (event.getSource())).getScene().getWindow().hide();
				}
			);
	}

}
