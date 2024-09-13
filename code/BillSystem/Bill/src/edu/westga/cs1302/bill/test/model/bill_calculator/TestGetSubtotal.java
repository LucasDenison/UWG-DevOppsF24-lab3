package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	void testOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		
		bill.addItem(item1);
		double result = BillCalculator.getSubTotal(bill.getItems());
		
		assertEquals(5, result, "Checking the subtotal of one item");
	}
	
	@Test
	void testTwoItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		BillItem item2 = new BillItem("2", 6);
		
		bill.addItem(item1);
		bill.addItem(item2);
		
		double result = BillCalculator.getSubTotal(bill.getItems());
		
		assertEquals(11, result, "Checking the subtotal of 2 items");
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
		
		double result = BillCalculator.getSubTotal(bill.getItems());
		
		assertEquals(15, result, "Checking the subtotal of 3 items");
	}
	
	@Test
	void testNoItem() {
		Bill bill = new Bill();
		
		double result = BillCalculator.getSubTotal(bill.getItems());
		
		assertEquals(0, result, "Checking the subtotal of none item");
	}
}
