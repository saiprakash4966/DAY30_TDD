package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest 
{
	/**
	 * Test method to calculate total fare of the ride by given distance and time as
	 * the input parameters
	 */
	@Test
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() 
	{
		double distance = 2.0;
		int time = 5;
		CabInvoiceGenerator CIG =new CabInvoiceGenerator();
		double totalFare = CIG.calculateFare(distance, time);
		System.out.println("Total Fare is:"+totalFare);
		Assert.assertEquals(25, totalFare, 0.0);
	}

}
