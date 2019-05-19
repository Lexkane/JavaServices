package com.company;

import com.company.menu.Menu;

public final class Main {

  private Main() {
  }

  public static void main(final String[] args) {
    Menu menu = new Menu();
    menu.menu();
  }
}
