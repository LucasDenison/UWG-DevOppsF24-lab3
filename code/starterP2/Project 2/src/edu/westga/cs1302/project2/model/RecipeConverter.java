package edu.westga.cs1302.project2.model;

/**
 * converts a recipe to a string
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class RecipeConverter {
	
	/**
	 * returns a string that converted a recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param recipe the recipe to be converted
	 * 
	 * @return converted string
	 */
	public static String convert(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("recipe cannot be null");
		}
		String text = recipe.getRecipeName() + System.lineSeparator();
		for (Ingredient ingredient : recipe.getIngredients()) {
			if (ingredient != null) {
				text += ingredient.getName() + ", ";
			}
		}
		text += System.lineSeparator() + System.lineSeparator();
		return text;
	}
}
