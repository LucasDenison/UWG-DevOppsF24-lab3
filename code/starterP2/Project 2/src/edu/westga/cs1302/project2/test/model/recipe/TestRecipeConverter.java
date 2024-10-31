package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeConverter;

class TestRecipeConverter {

	@Test
	void testWhenRecipeIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{RecipeConverter.convert(null);});
	}

	@Test 
	void testWhenRecipeHasNoIngredients() {
		Recipe recipe = new Recipe("name");
		
		assertEquals(RecipeConverter.convert(recipe), "name" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipeHasOneIngredients() {
		Recipe recipe = new Recipe("name");
		Ingredient ing1 = new Ingredient("ham", "meat");
		recipe.addIngredient(ing1);
		
		assertEquals(RecipeConverter.convert(recipe), "name" + System.lineSeparator() + "ham, " + System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipeHasMultipleIngredients() {
		Recipe recipe = new Recipe("name");
		Ingredient ing1 = new Ingredient("ham", "meat");
		recipe.addIngredient(ing1);
		Ingredient ing2 = new Ingredient("lettuce", "vegatable");
		recipe.addIngredient(ing2);
		
		assertEquals(RecipeConverter.convert(recipe), "name" + System.lineSeparator() + "ham, lettuce, " + System.lineSeparator() + System.lineSeparator());
	}
}
