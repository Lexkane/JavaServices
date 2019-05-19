package com.flower_shop.factory.builder;

import com.flower_shop.factory.product.Flower;
import com.flower_shop.factory.product.FlowerImpl;

public class FlowerBuilderImpl implements FlowerBuilder {

  private String name;
  private double price;

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public Flower createFlower() {
    return new FlowerImpl(name, price);
  }

}
