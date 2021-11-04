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

    /**
     * Purpose : Calculate fare
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        if (fare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return fare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides)
            totalFare += this.calculateFare(ride.distnce, ride.time);
        return  totalFare;
    }
}
