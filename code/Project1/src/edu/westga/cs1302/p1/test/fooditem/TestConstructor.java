package edu.westga.cs1302.p1.test.fooditem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.p1.model.FoodItem;

public class TestConstructor {
	
	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new FoodItem(null, "Fruit");});
	}
	
	@Test
	void testNullType() {
		assertThrows(IllegalArgumentException.class, ()->{new FoodItem("Apple", null);});
	}
	
	@Test
	void testShortName() {
		assertThrows(IllegalArgumentException.class, ()->{new FoodItem("ap", "Fruit");});
	}
	
	@Test
	void testShortType() {
		assertThrows(IllegalArgumentException.class, ()->{new FoodItem("Apple", "Fr");});
	}
	
	@Test
	void testMinimumLengthNameAndTypeLength() {
		FoodItem result = new FoodItem("123", "Fru");
		
		assertEquals("123", result.getName(), "checking the name of the food and type");
	}
	
}
