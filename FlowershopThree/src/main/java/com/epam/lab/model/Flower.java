package com.epam.lab.model;

public class Flower extends Goods {
  private String color;

  public Flower(String color, String name, double price) {
    super(name, price);
    this.color = color;
  }

  public Flower() {

  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String getName() {
    return super.getName() + " flower ";
  }

  @Override
  public String toString() {
    return this.getColor() + " " +
            super.getName() + " " +
            String.format("%.2f", this.getPrice()) + " ₴ ";
  }
}
