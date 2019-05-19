package com.epam.lab.model;

public class Palm extends Goods {
  private int height;

  public Palm(String name, int price, int height) {
    super(name, price);
    this.height = height;

  }
  public Palm() {

  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String getName() {
    return super.getName() + " palm ";
  }

  @Override
  public String toString() {
    return super.getName() + " " +
            this.getHeight() + " m " +
            String.format("%.2f", this.getPrice()) + " ₴ ";
  }
}
