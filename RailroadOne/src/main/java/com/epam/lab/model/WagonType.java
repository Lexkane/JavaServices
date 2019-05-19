package com.epam.lab.model;

public enum WagonType {
  PLAZKART(1.0, 8),
  KUPE(1.5, 5),
  LUX(3.0, 5);

  private double coefficient;
  private int seatsNumber;

  WagonType(double coefficient, int seatsNumber) {
    this.coefficient = coefficient;
    this.seatsNumber = seatsNumber;
  }

  public double getCoefficient() {
    return coefficient;
  }

  public int getSeatsNumber() {
    return seatsNumber;
  }

  @Override
  public String toString() {
    return " {" +
        "\ncoefficient=" + coefficient +
        "\nseatsNumber=" + seatsNumber +
        '}';
  }
}
