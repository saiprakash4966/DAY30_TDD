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
		return Math.max(totalFare, MINIMUM_FARE);
	}
	/**
	 * Method to calculate totalfare for given multiple rides
	 * @param rides - input number of rides
	 * @return - total fare
	 */
	public double calculateTotalFare(Ride[] rides) {
		double totalFare =0;
		for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
	}
	/**
	 * method to get number of rides
	 * @param rides - array of rides as input
	 * @return - returns number of rides
	 */
	public int getNumberOfRides(Ride[] rides) {
		
		return rides.length;
	}
	/**
	 * here im calculated average Fare per ride
	 * @param rides - input array of rides
	 * @return - it returns average  fare of total rides
	 */
	public double calculateAverageRideCost(Ride[] rides) {
		double totalFare=0;
		for(Ride ride:rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare / rides.length;
	}

}