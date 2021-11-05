package com.bridgelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGenaratorTest {
    Ride[] rides = null;
    CabInvoiceGenarator cabInvoiceGenarator;
    InvoiceSummary expectedInvoiceSummary;
    RideRepository rideRepository;


    @BeforeEach
    public void setUp() throws Exception {
        cabInvoiceGenarator = new CabInvoiceGenarator();
        rideRepository = new RideRepository();
        cabInvoiceGenarator.setRideRepository(rideRepository);
    }

    @Test
    void givenDistanceAndTime_whenCalucated_shouldReturnTotalFare() {
        double distance = 5;
        int time = 10;
        double fare = cabInvoiceGenarator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 60);
    }

    @Test
    void givenDistanceAndTime_whenCalucated_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenarator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 5);
    }

    @Test
    void givenMultipleRides_whenCalucated_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 5.0, 10),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceGenarator.calculateFare(rides);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }

    @Test
    void givenMultipleRidesWith2CategoryRides_whenCalucated_shouldReturnEqual() {
        String userId = "asd";
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        cabInvoiceGenarator.addRide(userId,rides);
        InvoiceSummary summary = cabInvoiceGenarator.getInvoiceSummary(userId);
        Assertions.assertEquals(summary, expectedInvoiceSummary);
    }
}
