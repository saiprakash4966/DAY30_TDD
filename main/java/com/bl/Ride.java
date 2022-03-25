package com.bl;

public class Ride
{
		
		private double distance;
		private final int time;
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		public int getTime() {
			return time;
		}
		public Ride(double distance, int time) {
			super();
			this.distance = distance;
			this.time = time;
		}
}

