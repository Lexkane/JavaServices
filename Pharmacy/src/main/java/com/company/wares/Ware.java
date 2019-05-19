package com.company.wares;

import com.company.enums.Category;

public abstract class Ware {

  private String producerName;
  private double price;
  private Category category;

  public Ware(String producerName, double price, Category category) {
    this.producerName = producerName;
    this.price = price;
    this.category = category;
  }

  public String getProducerName() {
    return producerName;
  }

  public double getPrice() {
    return price;
  }

  public Category getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " Producer name = " + producerName + ", price = " + price + ", category = "
        + category.toString().replace('_', ' ').toLowerCase();
  }
}
