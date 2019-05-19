package com.flower_shop.factory.factoryimpl;


import com.flower_shop.factory.builder.director.FlowerDirector;
import com.flower_shop.factory.product.Flower;


public class FlowerFactoryImpl implements FlowerFactory {

  private static FlowerDirector director = new FlowerDirector();

  @Override
  public Flower createRose() {
    return director.createRose();
  }

  @Override
  public Flower createChamomile() {
    return director.createChamomile();
  }

  @Override
  public Flower createTulip() {
    return director.createTulip();
  }
}
