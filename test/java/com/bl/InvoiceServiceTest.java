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
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		CabInvoiceGenerator CIG = new CabInvoiceGenerator();
		double totalFare = CIG.calculateFare(distance, time);
		Assert.assertEquals(25, totalFare, 0.0);
	}

	/**
	 * Method to calculate minimum fare for the given ride for that minimum fare we
	 * have taken distance as 0.1 and time is 2.
	 */
	@Test
	public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		CabInvoiceGenerator CIG = new CabInvoiceGenerator();

		double fare = CIG.calculateFare(distance, time);
		System.out.println("Minimum Fare = " + fare);
		Assert.assertEquals(5, fare, 0.0);
	}
	/**
	 * Method to calculate total fare for multiple rides
	 */
	@Test
	public void whenGivenMultipleRidesShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		CabInvoiceGenerator CIG = new CabInvoiceGenerator();
		double totalFare = CIG.calculateTotalFare(rides);
		Assert.assertEquals(30, totalFare, 0.0);
	}

	@Test
    public void givenMultipleRides_shouldReturnSizeAndAverageFare(){
        CabInvoiceGenerator CIG = new CabInvoiceGenerator();

        Ride[] rides = { new Ride(20.0,4),
                         new Ride(45.0,1),
                         new Ride(75.0,1),
                         new Ride(45.5,1)};

        double totalFare = CIG.calculateTotalFare(rides);
        int numberOfRides = CIG.getNumberOfRides(rides);
        double averageTotalFare = CIG.calculateAverageRideCost(rides);

        System.out.println("Total Fare = " +totalFare);
        System.out.println("Number of ride = " +numberOfRides);
        System.out.println("Average Total Fare " +averageTotalFare);

        Assert.assertEquals(1862,totalFare,0.0);
        Assert.assertEquals(4,numberOfRides);
        Assert.assertEquals(465,averageTotalFare,0.5);
	}
}