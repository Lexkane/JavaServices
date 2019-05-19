package com.flower_shop.factory.builder;

import com.flower_shop.factory.product.Flower;
import com.flower_shop.factory.product.Product;

public interface Builder {

  default Product createProduct() {
    System.out.println("Default method createProduct()");
    return null;
  }


}
