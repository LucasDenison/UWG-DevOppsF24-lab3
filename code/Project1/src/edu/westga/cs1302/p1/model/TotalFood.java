package edu.westga.cs1302.p1.model;

import java.util.List;

/**Stores and gets information on all food in the pantry
 * 
 * 
 * @author ldeniso1
 * 
 * @version Fall 2024
 */
public class TotalFood {

	/**Gets the total amount of food in the pantry
	 * 
	 * @precondition: foods != null
	 * @postcondition: none
	 * 
	 * @param foods the food in the pantry
	 * @return the total amount food in the pantry
	 */
	public static int getTotalFood(List<FoodItem> foods) {		
		if (foods == null) {
			throw new IllegalArgumentException("No foods provided");
		}
		if (foods.size() == 0) {
			throw new IllegalArgumentException("No foods provided");
		}
		int result = 0;
		for (FoodItem food: foods) {
			result += food.getQuantity();
		}
		return result;
	}
}
