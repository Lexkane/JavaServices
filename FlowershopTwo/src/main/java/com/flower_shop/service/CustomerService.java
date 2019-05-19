package com.flower_shop.service;

import com.flower_shop.catalog.Catalog;
import com.flower_shop.catalog.Storage;
import com.flower_shop.factory.factoryimpl.Factory;

import com.flower_shop.service.observer.Observer;
import com.flower_shop.service.observer.ObserverImpl;
import java.util.HashMap;
import java.util.Map;

import com.flower_shop.service.payment.CashStrategy;
import com.flower_shop.service.payment.CreditCardStrategy;
import com.flower_shop.service.payment.PaymentStrategy;

import java.util.Scanner;

public class CustomerService implements Service, PaymentService {


  private Catalog catalog;
  private Factory factory;
  private PaymentStrategy paymentStrategy;
  private Observer observer = new ObserverImpl();

  public CustomerService(Catalog catalog) {
    this.catalog = catalog;
  }


  @Override
  public void showAllProducts() {
    catalog.getProductMap().values().forEach(System.out::println);
  }

  @Override
  public void showAllFlowers() {
    catalog.getProductByType("Flower")
        .forEach(System.out::println);
  }

  @Override
  public void showAllServiceOptions() {

  }

  @Override
  public void buy() {
    Map<String, Storage> storageMap = new HashMap<>();
    storageMap.put("Rose", new Storage("Rose", 5));
    storageMap.put("Tulip", new Storage("Tulip", 6));
    storageMap.put("Chamomile", new Storage("Chamomile", 5));

    observer.update("Flower", storageMap);

  }

  @Override
  public void pay() {
    System.out.println("\"Please, select a payment method:\" + \"\\n\" +\n" +
        "\"1 - Cash\" + \"\\n\" +\n" +
        "\"2 - Credit Card\"");
    Scanner in = new Scanner(System.in);
    int i = in.nextInt();
    if (i == 1) {
      paymentStrategy = new CashStrategy();
    } else {
      paymentStrategy = new CreditCardStrategy();
    }
    paymentStrategy.pay();
  }


}
