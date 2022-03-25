package com.bl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest 
{
	CabInvoiceGenerator InvoiceGenerator;

	@Before
	public void setUp() {
		InvoiceGenerator = new CabInvoiceGenerator();
	}

	/**
	 * Test method to calculate total fare of the ride by given distance and time as
	 * the input parameters
	 */
	@Test
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 3.0;
		int time = 7;
		InvoiceSummary invoiceSummary = InvoiceGenerator.calculateFare(new Ride(distance, time, "NORMAL"));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 37);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	/**
	 * Method to calculate minimum fare for the given ride for that minimum fare we
	 * have taken distance as 0.1 and time is 2.
	 */
	@Test
	public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
		double distance = 0.01;
		int time = 1;
		InvoiceSummary invoiceSummary = InvoiceGenerator.calculateFare(new Ride(distance, time, "NORMAL"));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	/**
	 * Method to calculate total fare for multiple rides
	 */
	@Test
	public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 7, "NORMAL"), new Ride(0.01, 1, "NORMAL") };
		InvoiceSummary invoiceSummary = InvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides.length, 38.1);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	/**
	 * when userid given it should return invoice summary of that user
	 * 
	 * @throws InvoiceGeneratorException
	 */
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() throws CabInvoiceGeneratorException {
		String[] userId = { "user1", "user2", "user3" };
		Ride[][] rides = { { new Ride(5.0, 12, "NORMAL"), new Ride(2.5, 6, "NORMAL") },
				{ new Ride(3.0, 5, "NORMAL"), new Ride(0.01, 1, "NORMAL") },
				{ new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "NORMAL") } };
		InvoiceGenerator.addRideToRepository(userId, rides);
		InvoiceSummary summary = InvoiceGenerator.invoiceForUser(userId[2]);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides[2].length, 165.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	/**
	 * here i have given two types od rides such as normal ride and premium ride
	 * then we have to calculate fare according to given ride
	 * 
	 * @throws InvoiceGeneratorException
	 */
	@Test
	public void givenPremiumAndNormalRideForUserId_ShouldReturnInvoiceSummary() throws CabInvoiceGeneratorException {
		String[] userId = { "user1", "user2", "user3" };
		Ride[][] rides = { { new Ride(5.0, 12, "PREMIUM"), new Ride(2.5, 6, "NORMAL") },
				{ new Ride(3.0, 5, "PREMIUM"), new Ride(0.01, 1, "PREMIUM") },
				{ new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "PREMIUM") } };
		InvoiceGenerator.addRideToRepository(userId, rides);
		InvoiceSummary summary = InvoiceGenerator.invoiceForUser(userId[2]);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides[2].length, 205.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}