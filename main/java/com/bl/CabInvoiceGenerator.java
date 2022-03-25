package com.bl;

public class CabInvoiceGenerator 
{

	/**
	 * declaring constants
	 */
	private static double MINIMUM_COST_PER_KILOMETER = 10;
	private static int COST_PER_MINUTE = 1;
	private static double MINIMUM_FARE = 5;
	
	RideRepository rideRepository;
	

	public CabInvoiceGenerator() {
		rideRepository = new RideRepository();
	}
	/**
	 * Method to calculate total fare given distance and time,the invoice generator
	 * should return the total fare for the journey
	 * 
	 * @param distance - input for the distance in KM
	 * @param time     - time taken for the ride
	 * @return - returns Invoice summary
	 */
	public InvoiceSummary calculateFare(Ride... rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			
			checkRideType(ride.rideType);
			totalFare += ride.getDistance() * MINIMUM_COST_PER_KILOMETER + ride.getTime() * COST_PER_MINUTE;
		}
		if (totalFare < MINIMUM_FARE)
			return new InvoiceSummary(rides.length, MINIMUM_FARE);
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * Method in which given cost for premium and normal ride type 
	 * @param rideType
	 */
	private void checkRideType(String rideType) {
		
		switch (rideType) {
		case "PREMIUM":
			MINIMUM_COST_PER_KILOMETER = 15;
			COST_PER_MINUTE = 2;
			MINIMUM_FARE = 20;
			break;
		case "NORMAL":
			MINIMUM_COST_PER_KILOMETER = 10;
			COST_PER_MINUTE = 1;
			MINIMUM_FARE = 5;
			break;
		}
	}

	public InvoiceSummary invoiceForUser(String userId) {
		return calculateFare(rideRepository.getRidesForUser(userId));
	}

	public int getNumberOfRides(Ride[] rides) {
		return rides.length;
	}

	/**
	 * Method to add ride to RideRepository
	 * 
	 * @param userId
	 * @param rides
	 * @throws InvoiceGeneratorException
	 */
	public void addRideToRepository(String[] userId, Ride[][] rides) throws CabInvoiceGeneratorException {
		for (int i = 0; i < userId.length; i++) {
			rideRepository.addRideForUser(userId[i], rides[i]);
		}
	}

	
}