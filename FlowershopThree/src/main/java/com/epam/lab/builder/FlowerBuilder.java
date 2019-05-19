package com.epam.lab.builder;

import com.epam.lab.model.Flower;

import java.util.Random;

public class FlowerBuilder implements Builder {
  private Flower flower;
  private Random rand;

  public void reset() {
    rand = new Random();
    flower = new Flower();
  }

  public void setName() {
    String[] flowers = {"violet", "rose", "tulip", "chamomile"};

    int flowerName = rand.nextInt(flowers.length);
    flower.setName(flowers[flowerName]);
  }

  public void setPrice() {
    flower.setPrice(randomPrice());
  }

  public Flower getResult() {
    return flower;
  }

}
