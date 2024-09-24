package edu.westga.cs1302.p1.model;

/**Stores and manages information for a single student.
 * 
 * @author ldeniso1
 * 
 * @version Fall 2024
 */
public class FoodItem {
	private String name;
	private String type;
	private int quantity;
	
	/** Create a new food item with the specified name
	 * 
	 * @precondition name != null && name.length() >= 3 && type != null && type.length() >= 3
	 * @postcondition getName() == name
	 * 
	 * @param name the name of the new food item
	 * @param type the type of the new food item
	 */
	public FoodItem(String name, String type) {
		if (name == null) {
			throw new IllegalArgumentException("Name must be provided.");
		}
		if (name.length() < 3) {
			throw new IllegalArgumentException("Name must have at least 3 characters.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Type must be provided.");
		}
		if (type.length() < 3) {
			throw new IllegalArgumentException("Type must have at least 3 characters.");
		}
		
		this.name = name;
		this.type = type;
		this.quantity = 0;
	}
	
	/** Return the name of the food item
	 * 
	 * @return the name of the food item
	 */
	public String getName() {
		return this.name;
	}
	
	/** Return the type of the food item
	 * 
	 * @return the type of the food item
	 */
	public String getType() {
		return this.type;
	}
	
	/** Return the quantity of the food item
	 * 
	 * @return the quantity of the food item
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/** Adds the amount of the food item to the quantity
	 * 
	 * @param amount amount of the food item you want to add
	 */
	public void addQuantity(int amount) {
		this.quantity += amount; 
	}
	
	/** Subtracts the amount of the food item to the quantity
	 * 
	 * @param amount amount of the food item you want to subtract
	 */
	public void subtractQuantity(int amount) {
		this.quantity -= amount; 
	}
	
	/** Sets the amount of the food item to the quantity
	 * 
	 * @precondition amount > 0
	 * 
	 * @param amount amount of the food item you want to set
	 */
	public void setQuantity(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Cannot have an amount less than 1");
		}
		this.quantity = amount;
	}
	
	@Override
	public String toString() {
		return this.name + " - " + this.quantity;
	}
}
