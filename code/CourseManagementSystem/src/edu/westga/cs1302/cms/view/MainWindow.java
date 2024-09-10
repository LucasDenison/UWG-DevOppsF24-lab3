package edu.westga.cs1302.cms.view;

import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/** Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
    @FXML private TextField name;
    @FXML private ListView<Student> students;
    @FXML private TextField grade;
    @FXML private TextArea displayGradeArea;

    @FXML
    void addStudent(ActionEvent event) {
    	
    	String studentName = this.name.getText();
    	try {
        	int grade = Integer.parseInt(this.grade.getText());
    		Student student = new Student(studentName, grade);
    		this.students.getItems().add(student);
    	} catch (NumberFormatException errorNum1) {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("Unable to create student: " + errorNum1.getMessage() + ". Please reenter grade and try again");
    		errorPopup.showAndWait();
    	} catch (IllegalArgumentException errorNum2) {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("Unable to create student: " + errorNum2.getMessage() + ". Please reenter name and try again");
    		errorPopup.showAndWait();
    	}  
    }

    @FXML
    void removeStudent(ActionEvent event) {
    	Student student = this.students.getSelectionModel().getSelectedItem();
    	if (student != null) {
    		this.students.getItems().remove(student);
    	} else {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("No student selected. Unable to remove.");
    		errorPopup.showAndWait();
    	}
    }
    
    @FXML
    void displayGrade(ActionEvent event) {
    	Student student = this.students.getSelectionModel().getSelectedItem();
    	if (student != null) {
    		this.displayGradeArea.setText(String.valueOf(student.getGrade()));
    	} else {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("No student selected. Unable to view grade.");
    		errorPopup.showAndWait();
    	}
    }

    @FXML
    void initialize() {
    	assert this.displayGradeArea != null : "fx:id=\"displayGradeArea\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.grade != null : "fx:id=\"grade\" was not injected: check your FXML file 'MainWindow.fxml'.";
    }

}
