package com.company.wares;

import com.company.enums.Category;
import com.company.enums.MedicalForm;

public class Medicine extends Ware {

  private MedicalForm medicalForm;
  private int expirationDate;
  private boolean recipeRequired;

  public Medicine(String producerName, double price, Category category, MedicalForm medicalForm, int expirationDate,
      boolean recipeRequired) {
    super(producerName, price, category);
    this.medicalForm = medicalForm;
    this.expirationDate = expirationDate;
    this.recipeRequired = recipeRequired;
  }

  @Override
  public String toString() {
    return super.toString() + ", medical form = " + medicalForm.toString().toLowerCase() + ", expiration date = "
        + expirationDate + ", recipe required = " + recipeRequired;
  }
}
