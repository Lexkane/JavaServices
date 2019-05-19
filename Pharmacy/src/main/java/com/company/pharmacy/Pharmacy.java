package com.company.pharmacy;

import com.company.enums.Category;
import com.company.enums.CosmeticType;
import com.company.enums.MedicalForm;
import com.company.wares.Cosmetic;
import com.company.wares.DietaryProduct;
import com.company.wares.Medicine;
import com.company.wares.Ware;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pharmacy {

  private List<Ware> wares;

  public Pharmacy() {
    wares = fillListByWares();
  }

  public List<Ware> getWares() {
    return wares;
  }

  public List<Ware> searchByDiapasonPrice(double lowerDiapason, double upperDiapason) {
    return wares.stream().filter(ware -> isPriceInDiapason(ware.getPrice(), lowerDiapason, upperDiapason))
        .collect(Collectors.toList());
  }

  public List<Ware> searchByCategory(String category) {
    return wares.stream().filter(ware -> ware.getCategory().toString().equals(category.replace(' ', '_').toUpperCase()))
        .collect(Collectors.toList());
  }

  private boolean isPriceInDiapason(double price, double lowerDiapason, double upperDiapason) {
    if ((price >= lowerDiapason) && (price <= upperDiapason)) {
      return true;
    } else {
      return false;
    }
  }

  private List<Ware> fillListByWares() {
    List<Ware> ware = new ArrayList<>();

    ware.add(new Cosmetic("Loreal", 150.25, Category.TONING_UP, CosmeticType.CREAM, 25.05, 70));
    ware.add(new DietaryProduct("Nescwik", 250, Category.EMACIATION, "Apple", 220));
    ware.add(new Medicine("Alona", 200.75, Category.ANTI_ALLERGENIC, MedicalForm.PILL, 5, true));

    return ware;
  }
}
