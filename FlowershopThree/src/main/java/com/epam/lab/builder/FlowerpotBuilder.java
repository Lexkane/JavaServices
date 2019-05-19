package com.epam.lab.builder;

import com.epam.lab.model.Flowerpot;

import java.util.Random;

public class FlowerpotBuilder implements Builder {
  private Flowerpot flowerpot;
  private Random rand;

  public void reset() {
    rand = new Random();
    flowerpot = new Flowerpot();
  }

  public void setName() {
    String[] flowerpots = {"abelia", "agava", "aglaonema", "adiantum"};

    int flowerpotName = rand.nextInt(flowerpots.length);
    flowerpot.setName(flowerpots[flowerpotName]);
  }

  public void setPrice() {
    flowerpot.setPrice(randomPrice());
  }

  public Flowerpot getResult() {
    return flowerpot;
  }

}
