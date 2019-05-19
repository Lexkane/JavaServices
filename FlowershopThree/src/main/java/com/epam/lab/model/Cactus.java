package com.epam.lab.model;

public class Cactus extends Goods implements Bloommable, Smellable {
  private boolean hasOdour;
  private boolean hasBloom;

  public Cactus(String name, int price, boolean hasBloom, boolean hasOdour) {
    super(name, price);
    this.hasBloom = hasBloom;
    this.hasOdour = hasOdour;
  }

  public Cactus() {

  }

  public String bloom() {
    if (hasBloom) {
      return ("Blooms brightly");
    } else {
      return ("It doesn't bloom");
    }
  }

  public String smell() {
    if (hasOdour) {
      return ("Smells like teen spirit");
    } else {
      return ("It doesn't smell");
    }
  }

  @Override
  public String getName() {
    return super.getName() + " cactus ";
  }

  @Override
  public String toString() {
    return super.getName() + " " +
            this.bloom() +  " " +
            this.smell() + " " +
            String.format("%.2f", this.getPrice()) + " ₴ ";
  }

  public boolean hasOdour() {
    return hasOdour;
  }

  public void setHasOdour(boolean hasOdour) {
    this.hasOdour = hasOdour;
  }

  public boolean hasBloom() {
    return hasBloom;
  }

  public void setHasBloom(boolean hasBloom) {
    this.hasBloom = hasBloom;
  }
}
