package com.flower_shop.factory.factoryimpl;

import com.flower_shop.factory.product.Cactus;

public interface CactusFactory  extends Factory{
  Cactus createCactus();
}
