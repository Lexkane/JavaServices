package com.flower_shop.factory.builder;

import com.flower_shop.factory.product.Flower;

public interface FlowerBuilder extends Builder {

  Flower createFlower();

  void setName(String name);

  void setPrice(double price);

}
