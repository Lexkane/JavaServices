package com.epam.lab.model;

public class Fertilizer extends Goods {
  private int weight;

  public Fertilizer(String name, int price, int weight) {
    super(name, price);
    this.weight = weight;
  }

  public Fertilizer() {

  }

  @Override
  public String getName() {
    return super.getName() + " fertilizer ";
  }

  @Override
  public String toString() {
    return super.getName() + " " +
            this.weight + " kg " +
            String.format("%.2f", this.getPrice()) + " ₴ ";
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

}
