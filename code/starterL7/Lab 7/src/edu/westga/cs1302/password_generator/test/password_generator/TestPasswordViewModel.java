package edu.westga.cs1302.password_generator.test.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.s130c2.password_generator.viewmodel.PasswordGeneratorViewModel;

class TestPasswordViewModel {

	@Test
	void testWhenOneMinLengthAndNoOtherRestrictions() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(1);
		viewModel.getUpperCaseProperty().setValue(false);
		viewModel.getLowerCaseProperty().setValue(false);
		viewModel.getOneDigitProperty().setValue(false);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(1 <= result.length(), "checking length of generated password");
	}

	@Test
	void testWhen3MinLengthAndNoOtherRestrictions() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(false);
		viewModel.getLowerCaseProperty().setValue(false);
		viewModel.getOneDigitProperty().setValue(false);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndUpperCaseRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(true);
		viewModel.getLowerCaseProperty().setValue(false);
		viewModel.getOneDigitProperty().setValue(false);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndLowerCaseRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(false);
		viewModel.getLowerCaseProperty().setValue(true);
		viewModel.getOneDigitProperty().setValue(false);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndOneDigitRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(false);
		viewModel.getLowerCaseProperty().setValue(false);
		viewModel.getOneDigitProperty().setValue(true);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndLowerCaseAndUpperCaseRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(true);
		viewModel.getLowerCaseProperty().setValue(true);
		viewModel.getOneDigitProperty().setValue(false);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndUpperCaseAndOneDigitRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(true);
		viewModel.getLowerCaseProperty().setValue(false);
		viewModel.getOneDigitProperty().setValue(true);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndLowerCaseAndOneDigitRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(false);
		viewModel.getLowerCaseProperty().setValue(true);
		viewModel.getOneDigitProperty().setValue(true);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
	
	@Test
	void testWhen3MinLengthAndAllRestrictions() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		PasswordGenerator generator = new PasswordGenerator(1);
		
		viewModel.getMinProperty().setValue(3);
		viewModel.getUpperCaseProperty().setValue(true);
		viewModel.getLowerCaseProperty().setValue(true);
		viewModel.getOneDigitProperty().setValue(true);
		
		generator.setMinimumLength(viewModel.getMinProperty().getValue());
		generator.setMustHaveAtLeastOneUpperCaseLetter(viewModel.getUpperCaseProperty().getValue());
		generator.setMustHaveAtLeastOneLowerCaseLetter(viewModel.getLowerCaseProperty().getValue());
		generator.setMustHaveAtLeastOneDigit(viewModel.getOneDigitProperty().getValue());
		
		String result = generator.generatePassword();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}
}
