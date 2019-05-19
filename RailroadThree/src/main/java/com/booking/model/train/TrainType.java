package com.booking.model.train;

public enum TrainType {
  SPEED_TRAIN(200),
  ELECTRIC_TRAIN(50),
  DIESEL_TRAIN(100),
  BASIC_TRAIN(100);


  int basicPrice;

  TrainType(int i) {
    basicPrice = i;
  }

  public int getBasicPrice() {
    return basicPrice;
  }

}
