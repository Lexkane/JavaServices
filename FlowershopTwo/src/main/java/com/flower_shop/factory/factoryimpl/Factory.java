package com.flower_shop.factory.factoryimpl;

import com.flower_shop.factory.product.Product;

public interface Factory {

  default Product createProduct(){
    System.out.println("Default method for createProduct()");
    return null;
  }
}
