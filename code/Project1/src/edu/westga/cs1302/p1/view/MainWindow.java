package edu.westga.cs1302.p1.view;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs1302.p1.model.FoodItem;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/** Code behind for the MainWindow of the application
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class MainWindow {
	@FXML private ResourceBundle resources;
	@FXML private URL location;
	@FXML private TextField foodName;
	@FXML private ComboBox<String> foodType;
	@FXML private ListView<FoodItem> pantryList;
	@FXML private TextField foodAmount;
	
	@FXML
    void addFood(ActionEvent event) {
    	
    	String food = this.foodName.getText();
    	try {
    		int amount = Integer.parseInt(this.foodAmount.getText());
        	String type = this.foodType.getValue();
    		FoodItem item = new FoodItem(food, type);
    		item.setQuantity(amount);
    		this.pantryList.getItems().add(item);
    	} catch (IllegalStateException errorNum1) {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("Unable to put in pantry: " + errorNum1.getMessage() + ". Please reenter type and try again");
    		errorPopup.showAndWait();
    	} catch (NumberFormatException errorNum2) {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("Unable to put in pantry: " + errorNum2.getMessage() + ". Please reenter amount and try again");
    		errorPopup.showAndWait();
    	} catch (IllegalArgumentException errorNum3) {
    		Alert errorPopup = new Alert(Alert.AlertType.ERROR);
    		errorPopup.setContentText("Unable to put in pantry: " + errorNum3.getMessage() + ". Please reenter food and try again");
    		errorPopup.showAndWait();
    	}  
    }

	@FXML
	void initialize() {
	    assert this.foodName != null : "fx:id=\"foodName\" was not injected: check your FXML file 'MainWindow.fxml'.";
	    assert this.foodType != null : "fx:id=\"foodType\" was not injected: check your FXML file 'MainWindow.fxml'.";
	    assert this.pantryList != null : "fx:id=\"pantryList\" was not injected: check your FXML file 'MainWindow.fxml'.";
	    this.foodType.setItems(FXCollections.observableArrayList("Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient"));
        assert this.foodAmount != null : "fx:id=\"foodAmount\" was not injected: check your FXML file 'MainWindow.fxml'.";
	    
	}
}
