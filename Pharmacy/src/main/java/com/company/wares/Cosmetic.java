package com.company.wares;

import com.company.enums.Category;
import com.company.enums.CosmeticType;

public class Cosmetic extends Ware {

  private CosmeticType cosmeticType;
  private double percOfIngredientsNaturalOrigin;
  private double percOfIngredientsOrganicOrigin;

  public Cosmetic(String producerName, double price, Category category, CosmeticType cosmeticType,
      double percOfIngredientsNaturalOrigin, double percOfIngredientsOrganicOrigin) {
    super(producerName, price, category);
    this.cosmeticType = cosmeticType;
    this.percOfIngredientsNaturalOrigin = percOfIngredientsNaturalOrigin;
    this.percOfIngredientsOrganicOrigin = percOfIngredientsOrganicOrigin;
  }

  @Override
  public String toString() {
    return super.toString() + ", cosmetic type = " + cosmeticType.toString().toLowerCase()
        + ", percentage of ingredients of natural origin = " + percOfIngredientsNaturalOrigin
        + ", percentage of ingredients of organic origin = " + percOfIngredientsOrganicOrigin;
  }
}
