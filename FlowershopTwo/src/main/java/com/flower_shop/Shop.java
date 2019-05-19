package com.flower_shop;

import com.flower_shop.catalog.Catalog;
import com.flower_shop.factory.factoryimpl.FlowerFactoryImpl;

public class Shop {

  private static Catalog catalog;

  static {
    SeniorVoVa seniorVoVa = new SeniorVoVa();
    seniorVoVa.init();
    catalog = seniorVoVa.getCatalog();
  }

  private FlowerFactoryImpl factory;

  public Shop() {
    factory = new FlowerFactoryImpl();
  }

  public FlowerFactoryImpl getFactory() {
    return factory;
  }

  public void setFactory(FlowerFactoryImpl factory) {
    this.factory = factory;
  }

  public static void main(String[] args) {
    Shop shop = new Shop();

//    Test factory

//    Flower chamomile = shop.getFactory().createChamomile();
//    Flower rose = shop.getFactory().createRose();
//    Flower tulip = shop.getFactory().createTulip();
//
//    System.out.println(chamomile);
//    System.out.println(rose);
//    System.out.println(tulip);
//

//    Test Customer service

//    CustomerService customerService = new CustomerService(catalog);
//    customerService.showAllFlowers();
//    System.out.println();
//    customerService.buy();
//    customerService.showAllFlowers();

//    customerService.showAllProducts();

  }
}
