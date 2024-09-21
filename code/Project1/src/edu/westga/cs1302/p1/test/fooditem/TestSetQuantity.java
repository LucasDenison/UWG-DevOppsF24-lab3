package edu.westga.cs1302.p1.test.fooditem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.p1.model.FoodItem;

class TestSetQuantity {

	@Test
	void testNegativeAmount() {
		FoodItem item= new FoodItem("Apple", "Fruit");
		assertThrows(IllegalArgumentException.class, ()->{item.setQuantity(-1);});
	}
	
	@Test
	void testZeroAmount() {
		FoodItem item= new FoodItem("Apple", "Fruit");
		assertThrows(IllegalArgumentException.class, ()->{item.setQuantity(0);});
	}

	@Test
	void testValidAmount() {
		FoodItem item= new FoodItem("Apple", "Fruit");
		item.setQuantity(2);
		int result = item.getQuantity();
		assertEquals(2, result);
	}
}
