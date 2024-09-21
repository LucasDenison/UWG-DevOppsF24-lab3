package edu.westga.cs1302.p1.model;

/**Stores and gets information on all food in the pantry
 * 
 * 
 * @author ldeniso1
 * 
 * @version Fall 2024
 */
public class Pantry {
	private FoodItem[] items;
	
	/**Creates a new list of Food Items
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public Pantry() {
		this.items = new FoodItem[5];

	}
	
	/** Adds the items to the pantry
	 * 
	 * @precondition food != null
	 * @postcondition food is added to the list of items in the pantry
	 * 
	 * @param food the food to be added to the pantry
	 * @param amount the amount of the food item to add
	 * 
	 */
	public void addItem(FoodItem food, int amount) {
		if (food == null) {
			throw new IllegalArgumentException("food must not be null.");
		}
		if (amount <= 0) {
			throw new NumberFormatException("amount cannot be 0 or less");
		}
		int index = 0;
		for (; index < this.items.length; index++) {
			if (this.items[index] == null) {
				this.items[index] = food;
				this.items[index].setQuantity(amount);
				break;
			} else if (this.items[index].getName().equals(food.getName())) {
				throw new IllegalArgumentException("Item slot is the same");
			}
		}
		if (index == this.items.length) {
			throw new IllegalStateException("Cannot have more than 5 items");
		}
	}
	
	/**
	 * Gets all items in the pantry
	 * 
	 * @return the items in the pantry
	 */
	public FoodItem[] getFood() {
		return this.items;
	}
	
}
