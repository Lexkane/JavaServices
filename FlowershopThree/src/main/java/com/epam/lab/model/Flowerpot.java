package com.epam.lab.model;

public class Flowerpot extends Goods {
  private int size;

  public Flowerpot() {
  }

  public Flowerpot(int size, String name, double price) {
    super(name, price);
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public String getName() {
    return super.getName() + " Flowerpot ";
  }

  @Override
  public String toString() {
    return super.getName() + " " +
            getSize() + " m " +
            String.format("%.2f", this.getPrice()) + " ₴ " ;
  }
}
