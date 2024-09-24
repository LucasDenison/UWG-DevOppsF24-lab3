package edu.westga.cs1302.p1.test.totalfood;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.p1.model.FoodItem;
import edu.westga.cs1302.p1.model.TotalFood;

public class TestTotalFood {
	
	@Test
	void testNullFoods() {
		assertThrows(IllegalArgumentException.class, ()->{TotalFood.getTotalFood(null);});
	}
	
	@Test
	void testNoFoods() {
		ArrayList<FoodItem> foods = new ArrayList<FoodItem>();
		
		assertThrows(IllegalArgumentException.class, ()->{TotalFood.getTotalFood(foods);});
	}
	
	@Test
	void testOneFoods() {
		ArrayList<FoodItem> foods = new ArrayList<FoodItem>();
		FoodItem food1 = new FoodItem("bacon", "Meat");
		food1.setQuantity(3);
		foods.add(food1);
		
		int result = TotalFood.getTotalFood(foods);
		
		assertEquals(3, result);
	}
	
	@Test
	void testMultipleFoods() {
		ArrayList<FoodItem> foods = new ArrayList<FoodItem>();
		FoodItem food1 = new FoodItem("bacon", "Meat");
		food1.setQuantity(3);
		foods.add(food1);
		FoodItem food2 = new FoodItem("Wheat Bread", "Bread");
		food2.setQuantity(12);
		foods.add(food2);
		
		
		int result = TotalFood.getTotalFood(foods);
		
		assertEquals(15, result);
	}
}
