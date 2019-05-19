package com.epam.lab.builder;

import com.epam.lab.model.Goods;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface Builder {
  void reset();
  void setName();
  void setPrice();

  default double randomPrice() {
    return ThreadLocalRandom.current().nextDouble(0, 1000);
  }

  Goods getResult();
}
