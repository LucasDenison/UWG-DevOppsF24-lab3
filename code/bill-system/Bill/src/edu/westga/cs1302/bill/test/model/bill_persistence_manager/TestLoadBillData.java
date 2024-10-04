package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestLoadBillData {

	@Test
	void testEmptyFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("");
		}
		
		Bill bill = BillPersistenceManager.loadBillData();
		
		assertEquals(0, bill.getSize(), "checking number of items loaded");
	}
	
	@Test
	void testOneItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("aaa,1.00"+System.lineSeparator());
		}
		
		Bill bill = BillPersistenceManager.loadBillData();
		
		assertEquals(1, bill.getSize(), "checking number of items loaded");
	}
	
	@Test
	void testMultipleItemsInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("aaa,1.00"+System.lineSeparator());
			writer.write("bbb,2.00"+System.lineSeparator());
		}
		
		Bill bill = BillPersistenceManager.loadBillData();
		
		assertEquals(2, bill.getSize(), "checking number of items loaded");
	}
	
	@Test
	void testWhenItemAmountIsInvalid() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("a,-1.00"+System.lineSeparator());
		}
		
		assertThrows(IOException.class, ()->{BillPersistenceManager.loadBillData();});
	}
	
	@Test
	void testWhenItemIsMissingPart() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("a"+System.lineSeparator());
		}
		
		assertThrows(IOException.class, ()->{BillPersistenceManager.loadBillData();});
	}
}
