package com.bridgelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGenaratorTest {
    CabInvoiceGenarator cabInvoiceGenarator = null;

    @BeforeEach
    public void setUp() throws Exception {
        cabInvoiceGenarator = new CabInvoiceGenarator();
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
        Ride[] rides = {new Ride(5.0, 10),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceGenarator.calculateFare(rides);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }

    @Test
    void givenMultipleRidesAndUserId_whenCalucated_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(5.0, 10),
                new Ride(0.1, 1)
        };
        String userId = "1";
        cabInvoiceGenarator.addRide(userId,rides);
        InvoiceSummary summary = cabInvoiceGenarator.getInvoiceSummary(userId);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }
}
