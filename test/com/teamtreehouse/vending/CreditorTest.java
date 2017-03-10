package com.teamtreehouse.vending;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreditorTest {
	
	private Creditor creditor;
	
	@Before 
	public void setUP() throws Exception {
		creditor = new Creditor();
	}

	@Test
	public void addingFundsIncrementsAvailableFunds() throws Exception {
		// Arrange
		
		// Act
		creditor.addFunds(25);
		creditor.addFunds(25);
		
		// Assert
		assertEquals(50, creditor.getAvailableFunds());
		
	}
	
	@Test
	public void refundingReturnAllAvailableFunds() throws Exception {
		creditor.addFunds(10);
		
		int refund = creditor.refund();
		
		assertEquals(10, refund);
	}
	
	@Test
	public void refundingResetsAvailableFundsToZero() throws Exception {
		creditor.addFunds(10);
		
		int refund = creditor.refund();
		
		assertEquals(0, creditor.getAvailableFunds());

	}
	
	

}
