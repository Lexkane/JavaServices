package com.booking.model.train;

public enum CoachType {
    DELUXE(50),
    COMPT(100),
    BERTH(150);

    int basicPrice;

    CoachType(int i) {
        basicPrice = i;
    }

    public int getBasicPrice() {
        return basicPrice;
    }
}
