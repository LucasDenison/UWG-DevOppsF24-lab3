package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
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
	void testWhenRecipesHasOneRecipeAndOneIngredient() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		Ingredient ing = new Ingredient("apple","fruit");
		recipe.addIngredient(ing);
		recipes.add(recipe);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator() + "apple, " + System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipesHasOneRecipeAndMultipleIngredient() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		Ingredient ing = new Ingredient("apple","fruit");
		Ingredient ing1 = new Ingredient("banana","fruit");
		recipe.addIngredient(ing);
		recipe.addIngredient(ing1);
		recipes.add(recipe);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator() + "apple, banana, " +System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipesHasMultipleRecipesWithOneIng() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		Recipe recipe1 = new Recipe("name2");
		
		Ingredient ing = new Ingredient("apple","fruit");
		Ingredient ing1 = new Ingredient("banana","fruit");
		
		recipe.addIngredient(ing);
		recipe1.addIngredient(ing1);
		recipes.add(recipe);
		recipes.add(recipe1);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator() + "apple, " + 
			System.lineSeparator() + System.lineSeparator() + "name2" + System.lineSeparator() + "banana, " + System.lineSeparator() + System.lineSeparator());
	}
	
	@Test 
	void testWhenRecipesHasMultipleRecipesWithMultipleIng() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("name");
		Recipe recipe1 = new Recipe("name2");
		
		Ingredient ing = new Ingredient("apple","fruit");
		Ingredient ing1 = new Ingredient("banana","fruit");
		Ingredient ing2 = new Ingredient("bacon","meat");
		Ingredient ing3 = new Ingredient("ham","meat");
		
		recipe.addIngredient(ing);
		recipe.addIngredient(ing2);
		recipe1.addIngredient(ing1);
		recipe1.addIngredient(ing3);
		recipes.add(recipe);
		recipes.add(recipe1);
		
		assertEquals(RecipeConverter.convertRecipes(recipes), "name" + System.lineSeparator() + "apple, bacon, " + System.lineSeparator() +
			System.lineSeparator() + "name2" + System.lineSeparator() + "banana, ham, " + System.lineSeparator() + System.lineSeparator());
	}
}
