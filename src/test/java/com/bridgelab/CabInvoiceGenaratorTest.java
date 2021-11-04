package com.bridgelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGenaratorTest {

    @Test
    void givenDistanceAndTime_whenCalucated_shouldReturnTotalFare() {
        CabInvoiceGenarator cabInvoiceGenarator = new CabInvoiceGenarator();
        double distance = 5;
        int time = 10;
        double fare = cabInvoiceGenarator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 60);
    }

    @Test
    void givenDistanceAndTime_whenCalucated_shouldReturnMinimumFare() {
        CabInvoiceGenarator cabInvoiceGenarator = new CabInvoiceGenarator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenarator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 5);
    }

}
