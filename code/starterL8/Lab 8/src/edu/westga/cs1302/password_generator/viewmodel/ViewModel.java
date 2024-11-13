package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class ViewModel {
	private StringProperty minimumLength;
	private BooleanProperty requireDigits;
	private BooleanProperty requireLowercase;
	private BooleanProperty requireUppercase;
	
	private StringProperty password;
	private StringProperty errorText;
	
    private PasswordGenerator generator;
    
    private ListProperty<String> pastPasswords;
    private ObjectProperty<PasswordGenerator> selectedPassword;
	
	/** Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.minimumLength = new SimpleStringProperty("1");
		this.requireDigits = new SimpleBooleanProperty(false);
		this.requireLowercase = new SimpleBooleanProperty(false);
		this.requireUppercase = new SimpleBooleanProperty(false);
		
		this.password = new SimpleStringProperty("");
		this.errorText = new SimpleStringProperty("");
		this.pastPasswords = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));

        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
        this.selectedPassword = new SimpleObjectProperty<PasswordGenerator>(null);
		this.selectedPassword.addListener((observable, oldValue, newValue)-> {
			this.loadSelectedPassword();
			} 
		);
	}
	
	/**return the selected password
	 * 
	 * @return the selected password
	 */
	public ObjectProperty<PasswordGenerator> getSelectedPassword() {
		return this.selectedPassword;
	}
	
	/**returns the past passwords
	 * 
	 * @return return past passwords
	 */
	public ListProperty getPastPassword() {
		return this.pastPasswords;
	}
	
	/** Verify that length value provided is valid
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param lengthValue the value to check
	 * @return true if value is valid
	 */
	public boolean verifyLength(int lengthValue) {
		return PasswordGenerator.isValidLength(lengthValue);
	}
	
	/** Return the minimum length property
	 * 
	 * @return the minimum length property
	 */
	public StringProperty getMinimumLength() {
		return this.minimumLength;
	}

	/** Return the require digits property
	 * 
	 * @return the require digits property
	 */
	public BooleanProperty getRequireDigits() {
		return this.requireDigits;
	}

	/** Return the require upper case property
	 * 
	 * @return the require upper case property
	 */
	public BooleanProperty getRequireUppercase() {
		return this.requireUppercase;
	}

	/** Return the require lower case property
	 * 
	 * @return the require lower case property
	 */
	public BooleanProperty getRequireLowercase() {
		return this.requireLowercase;
	}

	/** Return the password property
	 * 
	 * @return the password property
	 */
	public StringProperty getPassword() {
		return this.password;
	}

	/** Return the error text property
	 * 
	 * @return the error text property
	 */
	public StringProperty getErrorText() {
		return this.errorText;
	}
	
	/** projects password given the current inputs
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @throws IllegalArgumentException if minlegnth, upper case, lower case, or one digit is invalid value
	 */
	public void projectPassword() throws IllegalArgumentException {
		String password = this.generatePassword().getValue();
		
		this.pastPasswords.getValue().add(password);
	}

	/** Generates a password using the minimum length, require digit, require lower case, and require upper case property values.
	 * 
	 * If a password is successfully generated, the error text property is set to empty string and the password property is set to the password generated.
	 * 
	 * If an error is encountered, the password property is set to empty, and the error text property is populated with a message describing the problem.
	 *
	 * @return return the generated password
	 */
	public StringProperty generatePassword() {
    	int minimumLength = -1;
    	this.password.setValue("");
    	try {
    		minimumLength = Integer.parseInt(this.minimumLength.getValue());
    	} catch (NumberFormatException numberError) {
    		this.errorText.setValue("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getValue());
    		return null;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		this.errorText.setValue("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		return null;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.requireDigits.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.requireLowercase.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.requireUppercase.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.password.setValue(password);
    	return this.password;
    }
	
	/**
	 * loads a selected password
	 */
	public void loadSelectedPassword() {
		PasswordGenerator password = this.selectedPassword.get();
		if (password != null) {
			this.minimumLength.setValue(Integer.toString(password.getMinimumLength()));
			this.requireDigits.setValue(password.getMustHaveAtLeastOneDigit());
			this.requireLowercase.setValue(password.getMustHaveAtLeastOneLowerCaseLetter());
			this.requireUppercase.setValue(password.getMustHaveAtLeastOneUpperCaseLetter());
			this.generatePassword();
		}
	}
}
