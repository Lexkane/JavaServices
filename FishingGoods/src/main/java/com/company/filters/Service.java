package com.vertsimaha.filters;

import com.company.fishinggoods.Good;
import java.util.Scanner;

public class Service {

  private Filter filter;

  public Service() {
    filter = new Filter();
  }

  public final void showMenu() {
    System.out.print("1. View all fishing goods.\n"
        + "2. Sort fishing goods by type.\n"
        + "3. Sort fishing goods by price.\n"
        + "4. Exit\n"
        + "Make your choice: ");
  }

  public final void viewAllGoods() {
    for (Good good : filter.getAllGoods()) {
      System.out.println(good);
    }
  }

  public final void sortByType() {
    System.out.print("\nEnter type of fishing good:\n"
        + "1. LakeGood\n"
        + "2. WinterGood\n");
    Scanner choice = new Scanner(System.in);
    int typeNumber = choice.nextInt();
    switch (typeNumber) {
      case 1:
        for (Good good : filter.filterByType("LakeGood")) {
          System.out.println(good);
        }
        break;
      case 2:
        for (Good good : filter.filterByType("WinterGood")) {
          System.out.println(good);
        }
        break;
      default:
        for (Good good : filter.filterByType("LakeGood")) {
          System.out.println(good);
        }
        break;
    }
  }

  public final void sortByPrice() {
    System.out.print("\nChoose price of fishing good:\n"
        + "1. For 10$\n"
        + "2. For 15$\n"
        + "3. For 25$\n"
        + "4. For 30$\n");
    Scanner choice = new Scanner(System.in);
    int priceNumber = choice.nextInt();
    switch (priceNumber) {
      case 1:
        for (Good good : filter.filterByPrice("10")) {
          System.out.println(good);
        }
        break;
      case 2:
        for (Good good : filter.filterByPrice("15")) {
          System.out.println(good);
        }
        break;
      case 3:
        for (Good good : filter.filterByPrice("25")) {
          System.out.println(good);
        }
        break;
      case 4:
        for (Good good : filter.filterByPrice("30")) {
          System.out.println(good);
        }
        break;
      default:
        System.out.println("There are no goods with this price!");
        break;
    }
  }
}
