package edu.westga.cs1302.project2.test.model.recipe_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeSave;

class TestRecipeSave {

	@Test
	void testWhenRecipeIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{RecipeSave save = new RecipeSave();
		save.saveRecipeData(null, "test.txt");});
	}
	
	@Test
	void testWhenFileIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{
			Recipe recipe = new Recipe("name");
			RecipeSave save = new RecipeSave();
			save.saveRecipeData(recipe, null);});
	}
	
	@Test
	void testWhenFileIsEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{
			Recipe recipe = new Recipe("name");
			RecipeSave save = new RecipeSave();
			save.saveRecipeData(recipe, "");});
	}
	
	@Test
	void testNoIngredient() throws IOException{
		Recipe recipe = new Recipe("name");
		RecipeSave save = new RecipeSave();
		save.saveRecipeData(recipe, "test.txt");
		
		File inputFile = new File("test.txt");
		try (Scanner reader = new Scanner(inputFile);) {
			assertEquals("name", reader.nextLine(), "check first line");
			assertEquals("", reader.nextLine(), "check second line");
			assertEquals("", reader.nextLine(), "check third line");
			assertFalse(reader.hasNextLine(), "checking that the file has no ingredients");
		}
	}

	@Test
	void testOneIngredient() throws IOException{
		Recipe recipe = new Recipe("name3");
		Ingredient ing1 = new Ingredient("ham", "meat");
		recipe.addIngredient(ing1);
		RecipeSave save = new RecipeSave();
		save.saveRecipeData(recipe, "test.txt");
		
		File inputFile = new File("test.txt");
		try (Scanner reader = new Scanner(inputFile);) {
			assertEquals("name3", reader.nextLine(), "check first line");
			assertEquals("ham, ", reader.nextLine(), "check second line");
			assertEquals("", reader.nextLine(), "check third line");
			assertFalse(reader.hasNextLine(), "checking that we are at the end of the file");
		}
	}
	
	@Test
	void testMultipleIngredients() throws IOException{
		Recipe recipe = new Recipe("name2");
		Ingredient ing1 = new Ingredient("ham", "meat");
		Ingredient ing2 = new Ingredient("wheat","bread");
		recipe.addIngredient(ing1);
		recipe.addIngredient(ing2);
		RecipeSave save = new RecipeSave();
		save.saveRecipeData(recipe, "test.txt");
		
		File inputFile = new File("test.txt");
		try (Scanner reader = new Scanner(inputFile);) {
			assertEquals("name2", reader.nextLine(), "check first line");
			assertEquals("ham, wheat, ", reader.nextLine(), "check second line");
			assertEquals("", reader.nextLine(), "check third line");
			assertFalse(reader.hasNextLine(), "checking that we are at the end of the file");
		}
	}
	
	@Test
	void testWhenRecipeAlreadyExist() {
		assertThrows(IllegalArgumentException.class, ()->{
			Recipe recipe = new Recipe("name");
			Recipe recipe1 = new Recipe("name");
		
			RecipeSave save = new RecipeSave();
			save.saveRecipeData(recipe, "test.txt");
			save.saveRecipeData(recipe1, "test.txt");
		});
	}
	
}
