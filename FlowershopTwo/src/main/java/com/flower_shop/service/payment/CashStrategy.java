package com.flower_shop.service.payment;

public class CashStrategy implements PaymentStrategy {

  public void pay() {
    System.out.println("Pay by cash.");
  }
}
