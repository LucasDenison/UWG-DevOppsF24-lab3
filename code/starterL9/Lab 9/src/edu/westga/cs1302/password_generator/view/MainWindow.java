package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    @FXML private Label errorTextLabel;
    @FXML private Button generatePasswordButton;
    @FXML private MenuItem aboutMenuItem; 
    @FXML private MenuItem closeMenuItem;
    @FXML private AnchorPane guiPane;
    
    private ViewModel vm;
	
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.output.textProperty().bind(this.vm.getPassword());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.setupEnablingOfControls();
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.closeMenuItem.setOnAction(
    			(event) -> {
    				Stage stage = (Stage)
    						this.guiPane.getScene().getWindow();
    				stage.close();
    			}
    		);
    	this.aboutMenuItem.setOnAction(
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
				+ "Purpose: To create a password based off the critea selected.");
		alert.showAndWait();
    }
    
    private void setupEnablingOfControls() {
    	BooleanBinding lengthFieldEmpty = this.minimumLength.textProperty().isEmpty();
    	this.generatePasswordButton.disableProperty().bind(lengthFieldEmpty);
    	
    	BooleanBinding lengthFieldInvalid = this.minimumLength.textProperty().lessThan("1");
    	this.generatePasswordButton.disableProperty().bind(lengthFieldInvalid);
    }
    
}
