package com.epam.lab.builder;

import com.epam.lab.model.Fertilizer;

import java.util.Random;

public class FertilizerBuilder implements Builder {
  private Fertilizer fertilizer;
  private Random rand;

  public void reset() {
    rand = new Random();
    fertilizer = new Fertilizer();
  }

  public void setName() {
    String[] fertilizerNames = {"nutrient", "multinutrient", "binary", "NPK"};

    int fertilizerName = rand.nextInt(fertilizerNames.length);
    fertilizer.setName(fertilizerNames[fertilizerName]);
  }

  public void setPrice() {
    fertilizer.setPrice(randomPrice());
  }

  public Fertilizer getResult() {
    return fertilizer;
  }

}
