package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTip {

	@Test
	void testOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		
		bill.addItem(item1);
		double result = BillCalculator.getTip(bill.getItems());
		
		assertEquals(1.0, result, "Checking the tip of one item");
	}
	
	@Test
	void testTwoItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		BillItem item2 = new BillItem("2", 6);
		
		bill.addItem(item1);
		bill.addItem(item2);
		
		double result = BillCalculator.getTip(bill.getItems());
		
		assertEquals(2.2, result, "Checking the tip of 2 items");
	}

	@Test
	void testThreeItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		BillItem item2 = new BillItem("2", 6);
		BillItem item3 = new BillItem("3", 4);
		
		bill.addItem(item1);
		bill.addItem(item2);
		bill.addItem(item3);
		
		double result = BillCalculator.getTip(bill.getItems());
		
		assertEquals(3.0, result, "Checking the tip of 3 items");
	}
	
	@Test
	void testNoItem() {
		Bill bill = new Bill();
		
		double result = BillCalculator.getTip(bill.getItems());
		
		assertEquals(0, result, "Checking the tip of none item");
	}

}
