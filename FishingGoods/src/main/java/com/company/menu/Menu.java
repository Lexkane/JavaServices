package com.company.menu;

import com.company.filters.Service;
import java.util.Scanner;

public class Menu {
  private Service service;

  public Menu() {
    service = new Service();
  }

  public final void menu() {
    boolean check = false;
    Scanner choice = new Scanner(System.in);
    do {
      service.showMenu();
      int show = choice.nextInt();
      switch (show) {
      case 1:
        service.viewAllGoods();
        break;
      case 2:
        service.sortByType();
        break;
      case 3:
        service.sortByPrice();
        break;
      case 4:
        System.exit(0);
        break;
      default:
        break;
      }
    } while (!check);
  }
}
