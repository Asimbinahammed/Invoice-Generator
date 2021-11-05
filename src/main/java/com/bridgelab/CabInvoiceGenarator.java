package com.bridgelab;

/**
 * Purpose : To simulate Cab Service
 *
 * @author ASIM AHAMMED
 * @since 04-11-2021
 */
public class CabInvoiceGenarator {

    private static final int COST_PER_MINUTE = 1;
    private static final int COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5.0;
    private final RideRepository rideRepository;

    public CabInvoiceGenarator(){
        this.rideRepository = new RideRepository();
    }

    /**
     * Purpose : Calculate fare
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(fare, MINIMUM_FARE);
    }

    /**
     * Purpose : to calculate fare
     * @param rides contins distance and time for each ride
     * @return summary which contains no of rides and total fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides)
            totalFare += this.calculateFare(ride.distance, ride.time);
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Purpose : add ride into list
     * @param userId
     * @param rides
     */
    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    /**
     * purpose : To find summary by user id
     * @param userId
     * @return summary of rides
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
