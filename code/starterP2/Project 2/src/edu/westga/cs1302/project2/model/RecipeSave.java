package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving to a file
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class RecipeSave {

	public static final String DATA_FILE = "data.txt";
	
	/**
	 * Saves the recipe
	 * 
	 * Writes all data to data.txt
	 * 
	 * @precondition bill != null && file !=null && !(file.isEmpty()) 
	 * @postcondition none
	 * 
	 * @param recipe the recipe to save
	 * @param file the file that the recipe will save to
	 * 
	 * @throws IOException
	 */
	public void saveRecipeData(Recipe recipe, String file)throws IOException {
		if (recipe == null) {
			throw new IllegalArgumentException("Must provide a valid recipe");
		}
		if (file == null) {
			throw new IllegalArgumentException("Must provide a valid file");
		}
		if (file.isEmpty()) {
			throw new IllegalArgumentException("Must provide a valid file");
		}
		
		File inputFile = new File(file);
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				if (reader.nextLine().equals(recipe.getRecipeName())) {
					throw new IllegalArgumentException("Can not have repeating recipes");
				}
			}
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(RecipeConverter.convert(recipe));
			}
		}
	}
	
}
