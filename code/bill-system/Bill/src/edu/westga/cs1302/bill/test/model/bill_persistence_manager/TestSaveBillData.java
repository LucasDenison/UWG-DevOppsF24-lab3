package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestSaveBillData {

	@Test
	void testNullBill() {
		assertThrows(IllegalArgumentException.class, ()-> {BillPersistenceManager.saveBillData(null);});
	}
	
	@Test
	void testNoItems() throws IOException{
		BillPersistenceManager.saveBillData(new Bill());
		
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine(), "checking that file is empty.");
		}
	}
	
	@Test
	void testOneItem() throws IOException {
		Bill bill = new Bill();
		BillItem item = new BillItem("aaa", 1.00);
		bill.addItem(item);
		BillPersistenceManager.saveBillData(bill);
		
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("aaa,1.0", reader.nextLine(), "check first line");
			assertFalse(reader.hasNextLine(), "checking that it is the end of the file");
		}
	}

	@Test
	void testBillHasMultipleItem() throws IOException {
		Bill bill = new Bill();
		BillItem item = new BillItem("aaa", 1.00);
		bill.addItem(item);
		BillItem item2 = new BillItem("bbb", 2.00);
		bill.addItem(item2);
		BillPersistenceManager.saveBillData(bill);
		
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("aaa,1.0", reader.nextLine(), "check first line");
			assertEquals("bbb,2.0", reader.nextLine(), "check second line");
			assertFalse(reader.hasNextLine(), "checking that it is the end of the file");
		}
	}
}
