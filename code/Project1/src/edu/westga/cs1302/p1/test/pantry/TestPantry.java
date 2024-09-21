package edu.westga.cs1302.p1.test.pantry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.p1.model.FoodItem;
import edu.westga.cs1302.p1.model.Pantry;

public class TestPantry {

	@Test
	void testWhenPantryIsEmpty() {
		Pantry pantry = new Pantry();
		FoodItem[] result = pantry.getFood();
		assertEquals(null, result[0]);	
	}
	
	@Test
	void testWhenPantryHasOneItem() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		pantry.addItem(item, 1);
		FoodItem[] result = pantry.getFood();
		assertEquals("Apple", result[0].getName(), "checking the name of the first food in the pantry");	
		assertEquals("Fruit", result[0].getType(), "checking the type of the first food in the pantry");
	}
	
	@Test
	void testWhenPantryHasTwoItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Orange", "Fruit");
		pantry.addItem(item, 1);
		pantry.addItem(item1, 1);
		FoodItem[] result = pantry.getFood();
		assertEquals("Apple", result[0].getName());	
		assertEquals("Fruit", result[0].getType());
		assertEquals("Orange", result[1].getName());	
		assertEquals("Fruit", result[1].getType());
	}
	
	@Test
	void testWhenPantryHasThreeItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Orange", "Fruit");
		FoodItem item2 = new FoodItem("Carrot", "Vegetable");
		pantry.addItem(item, 1);
		pantry.addItem(item1, 1);
		pantry.addItem(item2, 2);
		FoodItem[] result = pantry.getFood();
		assertEquals("Apple", result[0].getName());	
		assertEquals("Fruit", result[0].getType());
		assertEquals("Orange", result[1].getName());	
		assertEquals("Fruit", result[1].getType());
		assertEquals("Carrot", result[2].getName());	
		assertEquals("Vegetable", result[2].getType());
	}
	
	@Test
	void testWhenPantryHasFourItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Orange", "Fruit");
		FoodItem item2 = new FoodItem("Carrot", "Vegetable");
		FoodItem item3 = new FoodItem("Steak", "Meat");
		pantry.addItem(item, 1);
		pantry.addItem(item1, 1);
		pantry.addItem(item2, 2);
		pantry.addItem(item3, 2);
		FoodItem[] result = pantry.getFood();
		assertEquals("Apple", result[0].getName());	
		assertEquals("Fruit", result[0].getType());
		assertEquals("Orange", result[1].getName());	
		assertEquals("Fruit", result[1].getType());
		assertEquals("Carrot", result[2].getName());	
		assertEquals("Vegetable", result[2].getType());
		assertEquals("Steak", result[3].getName());	
		assertEquals("Meat", result[3].getType());
	}
	
	@Test
	void testWhenPantryHasFiveItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Orange", "Fruit");
		FoodItem item2 = new FoodItem("Carrot", "Vegetable");
		FoodItem item3 = new FoodItem("Steak", "Meat");
		FoodItem item4 = new FoodItem("Basil", "Ingredient");
		pantry.addItem(item, 1);
		pantry.addItem(item1, 1);
		pantry.addItem(item2, 2);
		pantry.addItem(item3, 2);
		pantry.addItem(item4, 5);
		FoodItem[] result = pantry.getFood();
		assertEquals("Apple", result[0].getName());	
		assertEquals("Fruit", result[0].getType());
		assertEquals("Orange", result[1].getName());	
		assertEquals("Fruit", result[1].getType());
		assertEquals("Carrot", result[2].getName());	
		assertEquals("Vegetable", result[2].getType());
		assertEquals("Steak", result[3].getName());	
		assertEquals("Meat", result[3].getType());
		assertEquals("Basil", result[4].getName());	
		assertEquals("Ingredient", result[4].getType());
	}
	
	@Test
	void testWhenPantryHasTooManyItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Orange", "Fruit");
		FoodItem item2 = new FoodItem("Carrot", "Vegetable");
		FoodItem item3 = new FoodItem("Steak", "Meat");
		FoodItem item4 = new FoodItem("Basil", "Ingredient");
		FoodItem item5 = new FoodItem("Chicken", "Meat");
		pantry.addItem(item, 1);
		pantry.addItem(item1, 1);
		pantry.addItem(item2, 2);
		pantry.addItem(item3, 2);
		pantry.addItem(item4, 5);
		
		assertThrows(IllegalStateException.class, ()->{pantry.addItem(item5, 7);}, "checking when the pantry has too many items");
	}
	
	@Test
	void testWhenPantryHasSameItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		FoodItem item1 = new FoodItem("Apple", "Fruit");
		pantry.addItem(item, 1);
		
		assertThrows(IllegalArgumentException.class, ()->{pantry.addItem(item1, 1);}, "Checking when the pantry has the same item");
	}
	
	@Test
	void testWhenPantryHasNullItem() {
		Pantry pantry = new Pantry();
		
		assertThrows(IllegalArgumentException.class, ()->{pantry.addItem(null, 1);}, "checking when the pantry has no items");
	}
	
	@Test
	void testWhenZeroItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		
		assertThrows(NumberFormatException.class, ()->{pantry.addItem(item, 0);}, "Checking when the pantry has the same item");
	}
	
	@Test
	void testWhenLessThanZeroItems() {
		Pantry pantry = new Pantry();
		FoodItem item = new FoodItem("Apple", "Fruit");
		
		assertThrows(NumberFormatException.class, ()->{pantry.addItem(item, -1);}, "Checking when the pantry has the same item");
	}
}
