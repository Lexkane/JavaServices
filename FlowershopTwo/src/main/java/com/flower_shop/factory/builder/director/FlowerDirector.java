package com.flower_shop.factory.builder.director;

import com.flower_shop.factory.builder.FlowerBuilder;
import com.flower_shop.factory.builder.FlowerBuilderImpl;
import com.flower_shop.factory.product.Flower;

public class FlowerDirector {

  public Flower createRose() {
    FlowerBuilder flowerBuilder = new FlowerBuilderImpl();
    flowerBuilder.setName("Rose");
    flowerBuilder.setPrice(20.0);
    return flowerBuilder.createFlower();
  }

  public Flower createChamomile() {
    FlowerBuilder flowerBuilder = new FlowerBuilderImpl();
    flowerBuilder.setName("Chamomile");
    flowerBuilder.setPrice(17.0);
    return flowerBuilder.createFlower();
  }

  public Flower createTulip() {
    FlowerBuilder flowerBuilder = new FlowerBuilderImpl();
    flowerBuilder.setName("Tulip");
    flowerBuilder.setPrice(18.0);
    return flowerBuilder.createFlower();
  }

}
