package edu.westga.cs1302.project2.test.model.ingredient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.TypeComparator;

class TestTypeComparator {

	@Test
	void testWhenCompareSameType() {
		Ingredient oneIng = new Ingredient("Apple", "Fruit");
		Ingredient twoIng = new Ingredient("Apple", "Fruit");
		TypeComparator comparator = new TypeComparator();
		int result = comparator.compare(oneIng, twoIng);
		assertEquals(0, result, "expected to be the same type");
	}
	
	@Test
	void testWhenCompareDifType() {
		Ingredient oneIng = new Ingredient("Apple", "Fruit");
		Ingredient twoIng = new Ingredient("Bacon", "Meat");
		TypeComparator comparator = new TypeComparator();
		int result = comparator.compare(oneIng, twoIng);
		assertEquals(1, result, "expected to be different types");
	}

}
