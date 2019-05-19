package com.epam.lab.view;

import com.epam.lab.menu.Menu;
import com.epam.lab.model.Fertilizer;
import com.epam.lab.model.Flower;
import com.epam.lab.model.Goods;

import java.util.List;

public class View {
  public void showSuccessfulExit() {
    System.out.println("Successfully quited! Good bye! ");
  }

  public void showFlowersAmountOptions() {
    System.out.println("How many flowers do you want?\n" +
            "1. Single\n" +
            "2. Bouquet\n");
  }

  public void showAll(List<? extends Goods> goods) {
    for (int i = 0; i < goods.size(); i++) {
      System.out.println((i + 1) + ") " + goods.get(i));
    }
  }

  public void showBouquetOptions() {
    System.out.println("How do you want to build your bouquet?\n" +
            "1. By florist\n" +
            "2. By yourself");
  }

  public void showBouquetFlowersAmountChoice() {
    System.out.println("How many flowers would you like in your bouquet?");
  }

  public void showCactusOptions() {
    System.out.println("Would you like cactus to have" +
            " odour (1) and bloom (2)");
  }

  public void showMainMenu() {
    Menu menu = new Menu(this);
    menu.showMenu();
  }

  public void showBouquet(List<Flower> bouquet, double totalPrice) {
    System.out.println("Your bouquet: ");
    bouquet.forEach(System.out::println);
    System.out.println(String.format("%.2f", totalPrice) + " ₴ ");
  }

  public void showBoughtGoods(Goods goods) {
    System.out.println("You've successfully bought " + goods);
  }
}
