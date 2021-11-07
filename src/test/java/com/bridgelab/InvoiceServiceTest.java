package com.bridgelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    Ride[] rides = null;
    InvoiceService invoiceService;
    InvoiceSummary expectedInvoiceSummary;
    RideRepository rideRepository;


    @BeforeEach
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository =new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    void givenMultipleRides_whenCalucated_shouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assertions.assertEquals(summary, expectedInvoiceSummary);
    }

    @Test
    void givenMultipleRidesWith2CategoryRides_whenCalucated_shouldReturnEqual() {
        String userId = "asd";
        invoiceService.addRide(userId,rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        Assertions.assertEquals(summary, expectedInvoiceSummary);
    }
}
