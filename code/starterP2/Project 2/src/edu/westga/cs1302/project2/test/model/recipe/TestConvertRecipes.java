package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeConverter;

class TestConvertRecipes {

	@Test
	void testWhenRecipeIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{RecipeConverter.convertRecipes(null);});
	}

	@Test 
	void testWhenRecipesHasNoRecipe() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "");
	}
	
	@Test 
	void testWhenRecipesHasOneRecipe() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		recipes.add(recipe);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipesHasMultipleRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		Recipe recipe1 = new Recipe("name2");
		recipes.add(recipe);
		recipes.add(recipe1);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator()  + System.lineSeparator() + "name2" + System.lineSeparator() + System.lineSeparator());
	}
}
