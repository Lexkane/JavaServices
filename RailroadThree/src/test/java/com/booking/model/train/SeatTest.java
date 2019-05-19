package com.booking.model.train;

//import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SeatTest {

    @Test
    void getSeatId() {
        Seat testSeat = new Seat(1);

//        Assert.assertEquals(1, testSeat.getSeatId());
    }

    @Test
    void setSeatId() {
        Seat testSeat = new Seat(1);

        testSeat.setSeatId(2);

//        Assert.assertEquals(2, testSeat.getSeatId());
    }
}