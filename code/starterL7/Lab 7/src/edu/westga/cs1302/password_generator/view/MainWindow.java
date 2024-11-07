package edu.westga.cs1302.password_generator.view;

import edu.westga.s130c2.password_generator.viewmodel.PasswordGeneratorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

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
    
    private PasswordGeneratorViewModel viewModel;
    
    /**
	* Instantiates a new password info code behind.
	* 
	* @precondition none
	* @precondition none
	*/
	public MainWindow() {
		this.viewModel = new PasswordGeneratorViewModel();
	}

    @FXML
    void initialize() {
        this.bindControlsToViewModel();
    }
    
    private void bindControlsToViewModel() {
    	this.mustIncludeDigits.allowIndeterminateProperty().bind(this.viewModel.getOneDigitProperty());
    	this.mustIncludeLowerCaseLetters.allowIndeterminateProperty().bind(this.viewModel.getLowerCaseProperty());
    	this.mustIncludeUpperCaseLetters.allowIndeterminateProperty().bind(this.viewModel.getUpperCaseProperty());
    	this.minimumLength.textProperty().bindBidirectional(this.viewModel.getMinProperty(), new NumberStringConverter());
    	this.output.textProperty().bind(this.viewModel.getPasswordProperty());
    }
    
    @FXML
    private void handleGeneratePassword() {
    	this.viewModel.generatePassword();
    }
}
