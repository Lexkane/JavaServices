package com.flower_shop.factory.factoryimpl;

import com.flower_shop.factory.product.Flower;

public interface FlowerFactory extends Factory {

  Flower createRose();

  Flower createChamomile();

  Flower createTulip();
}
