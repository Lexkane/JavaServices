package com.company.wares;

import com.company.enums.Category;

public class DietaryProduct extends Ware {

  private String taste;
  private int caloric;

  public DietaryProduct(String producerName, double price, Category category, String taste, int caloric) {
    super(producerName, price, category);
    this.taste = taste;
    this.caloric = caloric;
  }

  @Override
  public String toString() {
    return super.toString() + ", taste = " + taste + ", caloric = " + caloric;
  }
}
