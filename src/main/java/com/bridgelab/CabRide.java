package com.bridgelab;

public enum CabRide {
    NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

    private final double costPerKM;
    private final double costPerMin;
    private final int minmumCost;

    CabRide(double costPerKM, double costPerMin, int minmumCost){
        this.costPerKM = costPerKM;
        this.costPerMin = costPerMin;
        this.minmumCost = minmumCost;
    }

    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance*costPerKM + ride.time*costPerMin;
        return Math.max(rideCost, minmumCost);
    }
}
