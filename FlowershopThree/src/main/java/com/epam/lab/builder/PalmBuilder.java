package com.epam.lab.builder;

import com.epam.lab.model.Palm;

import java.util.Random;

public class PalmBuilder implements Builder {
  private Palm palm;
  private Random rand;

  public void reset() {
    rand = new Random();
    palm = new Palm();
  }

  public void setName() {
    String[] palms = {"hamerops", "livistona", "rhapis", "phoenix"};

    int palmName = rand.nextInt(palms.length);
    palm.setName(palms[palmName]);
  }

  public void setPrice() {
    palm.setPrice(randomPrice());
  }

  public Palm getResult() {
    return palm;
  }

}
