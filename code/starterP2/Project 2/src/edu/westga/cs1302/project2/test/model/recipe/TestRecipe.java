package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

class TestRecipe {

	@Test
	void testWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{new Recipe(null);});
	}
	
	@Test
	void testWhenNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{new Recipe("");});
	}
	
	@Test
	void testWhenNoIngredientsInTheList() {
		Recipe recipe = new Recipe("Ziti");
		
		assertEquals(recipe.getSize(), 0, "checking the size of the recipe");
	}
	
	@Test
	void testWhenOneIngredientInTheList() {
		Recipe recipe = new Recipe("Ziti");
		
		Ingredient ing1 = new Ingredient("sausage", "meat");
		
		recipe.addIngredient(ing1);
		
		assertEquals(recipe.getSize(), 1, "checking the size of the recipe");
	}
	
	@Test
	void testWhenMultipleIngredientsInTheList() {
		Recipe recipe = new Recipe("Ziti");
		
		Ingredient ing1 = new Ingredient("sausage", "meat");
		Ingredient ing2 = new Ingredient("bell pepper", "fruit");
		
		recipe.addIngredient(ing1);
		recipe.addIngredient(ing2);
		
		assertEquals(recipe.getSize(), 2, "checking the size of the recipe");
	}
	
}
