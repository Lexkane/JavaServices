package com.flower_shop.factory.factoryimpl;

import com.flower_shop.factory.product.Fertilizer;

public interface FertilizerFactory extends Factory {
  Fertilizer createFertilizer();
}
