package com.teamtreehouse.vending;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	private VendingMachine machine;
	
	public class NotifierSub implements Notifier{

		@Override
		public void onSale(Item item) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Before
	public void setUp() throws Exception {
		Notifier notifier = new NotifierSub();
		machine = new VendingMachine(notifier, 10,10,10);
		machine.restock("A1", "Twinkies", 10, 30, 75);
	}

	@Test
	public void vendingWhenStockedReturnsItem() throws Exception {
		machine.addMoney(75);
		
		Item item = machine.vend("A1");
		
		assertEquals("Twinkies", item.getName());
	}
	
	 @Test 
	 public void salesTotalIncrementedAfterSuccessfulVending() throws Exception {
		 machine.addMoney(75);
      
		 Item item = machine.vend("A1");
      
		 assertEquals(item.getRetailPrice(), machine.getRunningSalesTotal());
	 }

}
