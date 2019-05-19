package com.flower_shop.factory.product;

public class FlowerImpl implements Flower {

  private String name;
  private double price;

  public FlowerImpl() {
  }

  public FlowerImpl(String name) {
    this.name = name;
  }

  public FlowerImpl(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public Flower createFlower() {
    return new FlowerImpl("FlowerImpl");
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return name + " " + price;
  }

}
