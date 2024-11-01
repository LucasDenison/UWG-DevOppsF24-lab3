package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Supports saving to a file
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class RecipeLoad {
	
	/**
	 * loads the recipes
	 * 
	 * loads all data from file
	 * 
	 * @precondition file !=null && !(file.isEmpty()) 
	 * @postcondition none
	 * 
	 * @param file the file that the recipe will save to
	 * 
	 * @return returns the list of recipes
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Recipe[] loadRecipeData(String file)throws IOException, FileNotFoundException {
		if (file == null) {
			throw new IllegalArgumentException("Must provide a valid file");
		}
		if (file.isEmpty()) {
			throw new IllegalArgumentException("Must provide a valid file");
		}
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		File inputFile = new File(file);
		try (Scanner reader = new Scanner(inputFile)) {
			String baseLine = reader.nextLine();
			String strippedLine = baseLine.strip();
			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				try {
					String name = RecipeConverter.convertRecipes(recipes);
					Recipe recipe = new Recipe(name);
					recipes.add(recipe);
				} catch (IndexOutOfBoundsException studentDataError) {
					throw new IOException(
							"Missing name on line " + lineNumber + " : " + strippedLine);
				}
			}
		}
		return recipes.toArray(new Recipe[recipes.size()]);
	}
	
}
