package com.epam.lab.manager;

import com.epam.lab.builder.*;
import com.epam.lab.model.*;

import java.util.*;

public class Assortment {
  private Map<Goods, Integer> assortmentMap;
  private Director director;
  private Random rand;

  public Assortment() {
    director = new Director();
    assortmentMap = new HashMap<>();
    rand = new Random();
    createAssortment();
  }

  private void createAssortment() {
    createFlowers();
    createFlowerpots();
    createFertilizers();
    createCactus();
    createPalms();
  }

  private void createFlowers() {
    Builder flowerBuilder = new FlowerBuilder();
    Flower flower;

    for (int i = 0; i < 6; i++) {
      flower = director.makeFlower(flowerBuilder);
      assortmentMap.put(flower, rand.nextInt(5));
    }
  }

  private void createFlowerpots() {
    Builder flowerpotBuilder = new FlowerpotBuilder();
    Flowerpot flowerpot;

    for (int i = 0; i < 3; i++) {
      flowerpot = director.makeFlowerpot(flowerpotBuilder);
      assortmentMap.put( flowerpot, rand.nextInt(5) + 1);
    }
  }

  private void createFertilizers() {
    Builder fertilizerBuilder = new FertilizerBuilder();
    Fertilizer fertilizer;

    for (int i = 0; i < 3; i++) {
      fertilizer = director.makeFertilizer(fertilizerBuilder);
      assortmentMap.put( fertilizer, rand.nextInt(5) + 1);
    }
  }

  private void createCactus() {
    Builder cactusBuilder = new CactusBuilder();
    Cactus cactus;

    for (int i = 0; i < 5; i++) {
      cactus = director.makeCactus(cactusBuilder);
      assortmentMap.put( cactus, rand.nextInt(5) + 1);
    }
  }

  private void createPalms() {
    Builder palmBuilder = new PalmBuilder();
    Palm palm;

    for (int i = 0; i < 3; i++) {
      palm = director.makePalm(palmBuilder);
      assortmentMap.put( palm, rand.nextInt(5) + 1);
    }
  }

  public void printAssortment() {
    Object[] amounts = assortmentMap.values().toArray();
    int amountsCounter = 0;

    for (Goods goods : assortmentMap.keySet()) {
      System.out.println(goods + " " + amounts[amountsCounter]);
      amountsCounter++;
    }
  }

  // using this principle, we can get all what we want from the map
  // specific flowers or whatever
  public List<Flower> getFlowers() {
    List<Flower> flowers = new ArrayList<>();

    for (Goods goods : assortmentMap.keySet()) {
      if (goods.getName().contains("flower"))
        flowers.add((Flower) goods);
    }

    return flowers;
  }

  public List<Flowerpot> getFlowerpots() {
    List<Flowerpot> flowerpots = new ArrayList<>();

    for (Goods goods : assortmentMap.keySet()) {
      if (goods.getName().contains("Flowerpot"))
        flowerpots.add((Flowerpot) goods);
    }

    return flowerpots;
  }

  public List<Cactus> getCactus() {
    List<Cactus> cactuses = new ArrayList<>();

    for (Goods goods : assortmentMap.keySet()) {
      if (goods.getName().contains("cactus"))
        cactuses.add((Cactus) goods);
    }

    return cactuses;
  }

  public List<Fertilizer> getFertilizer() {
    List<Fertilizer> fertilizers = new ArrayList<>();

    for (Goods goods : assortmentMap.keySet()) {
      if (goods.getName().contains("fertilizer"))
        fertilizers.add((Fertilizer) goods);
    }

    return fertilizers;
  }

  public List<Palm> getPalms() {
    List<Palm> palms = new ArrayList<>();

    for (Goods goods : assortmentMap.keySet()) {
      if (goods.getName().contains("palm"))
        palms.add((Palm) goods);
    }

    return palms;
  }

  public Map<Goods, Integer> getAssortmentMap() {
    return assortmentMap;
  }
}
