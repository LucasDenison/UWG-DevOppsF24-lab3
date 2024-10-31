package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/** Store information for a single recipe
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class Recipe {
	private String recipeName;
	private ArrayList<Ingredient> ingredients;
	
	/**
	 * creates a Recipe with a name
	 * 
	 * @param name name of the recipe
	 *  @precondition: name != null && name != ""
	 */
	public Recipe(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty.");
		}
		
		this.recipeName = name;
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	/**
	 * returns the name of the recipe
	 * 
	 * @return the name of the recipe
	 */
	public String getRecipeName() {
		return this.recipeName;
	}
	
	/**
	 * adds an ingredient to the recipe
	 * 
	 * @precondition ingredient != null
	 * @postcondition ingredient is added to the list of ingredients in the recipe
	 * 
	 * @param ingredient the ingredient to be added to the recipe
	 */
	public void addIngredient(Ingredient ingredient) {
		if (ingredient == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		
		this.ingredients.add(ingredient);
	}
	
	/**
	 * returns the ingredients in the recipe
	 * 
	 * @return the ingredients in the recipe
	 */
	public Ingredient[] getIngredients() {
		return this.ingredients.toArray(new Ingredient[this.ingredients.size()]);
	}
	
	/**
	 * returns the size of the ingredient list
	 * 
	 * @return the size of the ingredient list
	 */
	public int getSize() {
		return this.ingredients.size();
	}
}