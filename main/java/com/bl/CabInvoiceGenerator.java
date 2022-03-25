package com.bl;

public class CabInvoiceGenerator 
{

	/**
	 * declaring constants
	 */
	private static final double MINIMUM_COSt_PER_KILOMETER = 10;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * Method to calculate total fare given distance and time,the invoice generator
	 * should return the total fare for the journey
	 * 
	 * @param distance - input for the distance in KM
	 * @param time     - time taken for the ride
	 * @return - returns total fare for the particular ride
	 */
	public double calculateFare(double distance, int time) {

		double totalFare = distance * MINIMUM_COSt_PER_KILOMETER + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		else
			return totalFare;
	}

	public double calculateTotalFare(Ride[] rides) {
		double totalFare =0;
		for (Ride ride : rides) {
           totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
       }
       return totalFare;
	}

}
