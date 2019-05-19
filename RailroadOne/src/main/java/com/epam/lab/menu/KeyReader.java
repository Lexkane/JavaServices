package com.epam.lab.menu;

import java.util.Scanner;

public class KeyReader {

  public int readKey(int limit) {
    int chosenOptionNumber;
    Scanner scanner = new Scanner(System.in, "UTF-8");

    do {
      System.out.print("\nPlease enter a valid option: ");

      while (!scanner.hasNextInt()) {
        scanner.next();
        System.out.print("\nPlease enter a valid option: ");
      }

      chosenOptionNumber = scanner.nextInt();
    } while (chosenOptionNumber > limit);

    return chosenOptionNumber - 1;
  }
}
