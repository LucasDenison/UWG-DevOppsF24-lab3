package edu.westga.s130c2.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Class PasswordGeneratorViewModel.
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class PasswordGeneratorViewModel {

	private StringProperty passwordProperty;
	private IntegerProperty minProperty;
	private BooleanProperty oneDigitProperty;
	private BooleanProperty lowerCaseProperty;
	private BooleanProperty upperCaseProperty;
	private PasswordGenerator generator;
	
	/**
	 * Initiates a new password
	 */
	public PasswordGeneratorViewModel() { 
		Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
		this.passwordProperty = new SimpleStringProperty();
		this.minProperty = new SimpleIntegerProperty();
		this.oneDigitProperty = new SimpleBooleanProperty();
		this.lowerCaseProperty = new SimpleBooleanProperty();
		this.upperCaseProperty = new SimpleBooleanProperty();
	}
	
	/**
	 * gets the password property
	 * 
	 * @return the password property
	 */
	public StringProperty getPasswordProperty() {
		return this.passwordProperty;
	}
	
	/**
	 * gets the minimum property
	 * 
	 * @return the minimum property
	 */
	public IntegerProperty getMinProperty() {
		return this.minProperty;
	}
	
	/**
	 * gets the one digit property
	 * 
	 * @return if there is at least one digit property
	 */
	public BooleanProperty getOneDigitProperty() {
		return this.oneDigitProperty;
	}
	
	/**
	 * gets the lower case property
	 * 
	 * @return the lower case property
	 */
	public BooleanProperty getLowerCaseProperty() {
		return this.lowerCaseProperty;
	}
	
	/**
	 * gets the upper case property
	 * 
	 * @return the upper case property
	 */
	public BooleanProperty getUpperCaseProperty() {
		return this.upperCaseProperty;
	}
	
	/**
	 * generates the password
	 * 
	 * @precondition none
	 * @postcondition the password to be generated to the TextArea
	 * 
	 */
	public void generatePassword() {
		this.generator.setMinimumLength(this.minProperty.getValue());
		this.generator.setMustHaveAtLeastOneDigit(this.oneDigitProperty.getValue());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.lowerCaseProperty.getValue());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.upperCaseProperty.getValue());
		
		String password = this.generator.generatePassword();
		this.passwordProperty.set(password);
	}
	
}
