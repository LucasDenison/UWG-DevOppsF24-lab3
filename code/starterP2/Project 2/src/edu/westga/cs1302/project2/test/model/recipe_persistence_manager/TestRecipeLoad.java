package edu.westga.cs1302.project2.test.model.recipe_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeLoad;

class TestRecipeLoad {

	@Test
	void testWhenFileLocationIsNull()throws IOException, FileNotFoundException {
		assertThrows(IllegalArgumentException.class, ()->{
			RecipeLoad load = new RecipeLoad();
			load.loadRecipeData(null);});
	}
	
	@Test
	void testWhenFileLocationIsEmpty()throws IOException, FileNotFoundException {
		assertThrows(IllegalArgumentException.class, ()->{
			RecipeLoad load = new RecipeLoad();
			load.loadRecipeData(null);});
	}
	
	@Test
	void testEmptyFile()throws IOException, FileNotFoundException {
		try (FileWriter writer = new FileWriter("test.txt")) {
			writer.write("");
		}
		RecipeLoad load = new RecipeLoad();
		Recipe[] result = load.loadRecipeData("test.txt");
		
		assertEquals(0, result.length, "checking number of recipes loaded");
	}
	
	@Test
	void testOneRecipeFile()throws IOException, FileNotFoundException {
		try (FileWriter writer = new FileWriter("test.txt")) {
			writer.write("name" + System.lineSeparator() + "apple, " + System.lineSeparator() + System.lineSeparator());
		}
		RecipeLoad load = new RecipeLoad();
		Recipe[] result = load.loadRecipeData("test.txt");
		
		assertEquals(1, result.length, "checking number of recipes loaded");
		assertEquals("name", result[0].getRecipeName(), "checking name of recipe");
		assertEquals("apple, ", result[0].getIngredients(), "checking ingredients in recipe");
	}
}
