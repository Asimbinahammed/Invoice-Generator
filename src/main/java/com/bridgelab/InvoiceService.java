package com.bridgelab;

/**
 * Purpose : To simulate Cab Service
 *
 * @author ASIM AHAMMED
 * @since 04-11-2021
 */
public class InvoiceService {

    private RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository){
        this.rideRepository = new RideRepository();
    }

    /**
     * Purpose : to calculate fare
     *
     * @param rides contins distance and time for each ride
     * @return summary which contains no of rides and total fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides)
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Purpose : add ride into list
     *
     * @param userId
     * @param rides
     */
    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    /**
     * purpose : To find summary by user id
     *
     * @param userId
     * @return summary of rides
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

}
