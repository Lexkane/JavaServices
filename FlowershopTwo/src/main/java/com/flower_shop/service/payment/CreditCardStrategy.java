package com.flower_shop.service.payment;

public class CreditCardStrategy implements PaymentStrategy {
    public void pay() {
        System.out.println("Pay by credit card.");
    }
}
