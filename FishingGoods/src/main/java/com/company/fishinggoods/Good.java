package com.company.fishinggoods;

public abstract class Good {

  private String fishtype;

  private String price;


  public Good(final String fishtype, final String price) {
    this.fishtype = fishtype;
    this.price = price;
  }

  public final String getFishtype() {
    return fishtype;
  }


  public final String getPrice() {
    return price;
  }


  public abstract void showParameters();

  @Override
  public String toString() {
    return " fishtype: " + fishtype
        + ", price: " + price;
  }
}

