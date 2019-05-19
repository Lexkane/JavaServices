package com.epam.lab.builder;

import com.epam.lab.model.*;

import java.util.Random;

public class Director {
  private Random rand;

  public Director() {
    rand = new Random();
  }
  public Flower makeFlower(Builder builder) {
    builder.reset();
    builder.setName();
    builder.setPrice();

    Flower result = (Flower) builder.getResult();

    String[] colors = {"violet", "blue", "red", "black"};

    int flowerName = rand.nextInt(colors.length);
    result.setColor(colors[flowerName]);

    return result;
  }

  public Flowerpot makeFlowerpot(Builder builder) {
    builder.reset();
    builder.setName();
    builder.setPrice();

    Flowerpot pot = (Flowerpot) builder.getResult();
    pot.setSize(rand.nextInt(100));

    return pot;
  }

  public Cactus makeCactus(Builder builder) {
    builder.reset();
    builder.setName();
    builder.setPrice();

    Cactus cactus = (Cactus) builder.getResult();
    cactus.setHasBloom(rand.nextBoolean());
    cactus.setHasOdour(rand.nextBoolean());

    return cactus;
  }

  public Fertilizer makeFertilizer(Builder builder) {
    builder.reset();
    builder.setName();
    builder.setPrice();

    Fertilizer fertilizer = (Fertilizer) builder.getResult();
    fertilizer.setWeight(rand.nextInt(100));

    return fertilizer;
  }

  public Palm makePalm(Builder builder) {
    builder.reset();
    builder.setName();
    builder.setPrice();

    Palm palm = (Palm) builder.getResult();
    palm.setHeight(rand.nextInt(5));

    return palm;
  }
}
