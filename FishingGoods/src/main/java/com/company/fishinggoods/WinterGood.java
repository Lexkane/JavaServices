package com.company.fishinggoods;


public class WinterGood extends Good {

  private int temperature;

  public WinterGood(final String fishtype, final String price,
      final int temperature) {
    super(fishtype, price);
    this.temperature = temperature;
  }

  public final int getTemperature() {
    return temperature;
  }

  @Override
  public final void showParameters() {
    System.out.println(toString());
  }

  @Override
  public final String toString() {
    return "<< WinterGood: " + super.toString()
        + ", temperature=" + temperature + " >>";
  }
}
