package com.epam.lab.model;

public class Goods {
  private String name;
  private double price;

  public Goods(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public Goods() {
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
