package com.company;

import com.company.pharmacy.Pharmacy;
import com.company.wares.Ware;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Pharmacy pharmacy = new Pharmacy();
    System.out.println("\t\tSearch by diapason price");
    printListInformation(pharmacy.searchByDiapasonPrice(150, 250));
    System.out.println("\t\tSearch by category");
    printListInformation(pharmacy.searchByCategory("toning up"));
    System.out.println("\t\tSort by producer name");
    sortListByProducerName(pharmacy.getWares());
  }

  private static void printListInformation(List<Ware> wares) {
    wares.forEach(System.out::println);
  }

  private static void sortListByProducerName(List<Ware> wares) {
    wares.stream().sorted(Comparator.comparing(Ware::getProducerName)).forEach(System.out::println);
  }

}
