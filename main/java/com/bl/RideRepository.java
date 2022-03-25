package com.bl;
import java.util.HashMap;
import java.util.Map;

public class RideRepository
{
	

		Map<String, Ride[]> userRides = new HashMap<>();

		/**
		 * Adds user ride by its ID in hashmap
		 * 
		 * @param userId
		 * @param rides
		 * @throws InvoiceGeneratorException
		 */
		public void addRideForUser(String userId, Ride[] rides) throws CabInvoiceGeneratorException {
			if (userRides.containsKey(userId))
				throw new CabInvoiceGeneratorException(CabInvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
						"User ID Already Exists!!!");
			else
				userRides.put(userId, rides);
		}

		/**
		 * This method get rides of user by ID
		 * 
		 * @param userId
		 * @return
		 */
		public Ride[] getRidesForUser(String userId) {
			return userRides.get(userId);
		}
	}


