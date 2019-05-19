package com.epam.lab.builder;

import com.epam.lab.model.Cactus;

import java.util.Random;

public class CactusBuilder implements Builder {
  private Cactus cactus;
  private Random rand;

  public void reset() {
    rand = new Random();
    cactus = new Cactus();
  }

  public void setName() {
    String[] cactusNames = {"havortia", "lanata", "succulent", "opuntia"};

    int cactusName = rand.nextInt(cactusNames.length);
    cactus.setName(cactusNames[cactusName]);
  }

  public void setPrice() {
    cactus.setPrice(randomPrice());
  }

  public Cactus getResult() {
    return cactus;
  }

}
