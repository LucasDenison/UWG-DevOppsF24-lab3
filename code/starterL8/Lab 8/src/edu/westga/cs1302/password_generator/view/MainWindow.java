package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private ListView output;
	@FXML
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;

	private ViewModel vm;

	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.vm.getRequireDigits().bindBidirectional(this.mustIncludeDigits.selectedProperty());
		this.vm.getRequireLowercase().bindBidirectional(this.mustIncludeLowerCaseLetters.selectedProperty());
		this.vm.getRequireUppercase().bindBidirectional(this.mustIncludeUpperCaseLetters.selectedProperty());
		this.minimumLength.setText(this.vm.getMinimumLength().getValue());
		
		this.vm.getMinimumLength().bindBidirectional(this.minimumLength.textProperty());
		this.output.setItems(this.vm.getPastPassword());
		this.vm.getSelectedPassword().bind(this.output.getSelectionModel().selectedItemProperty());
		
		this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
		
		this.generatePasswordButton.setOnAction((event) -> {
			this.vm.projectPassword();
		});
		
		this.minimumLength.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d{1, }")) {
				try {
					if (this.vm.verifyLength(Integer.parseInt(newValue))) {
						this.errorTextLabel.setVisible(false);
					} else {
						this.errorTextLabel.setVisible(true);
					}
				} catch (NumberFormatException error) {
					this.errorTextLabel.setVisible(true);
				}
			} else {
				this.errorTextLabel.setVisible(true);
			}
		});
	}
}
