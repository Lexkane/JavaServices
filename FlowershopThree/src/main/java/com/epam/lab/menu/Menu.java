package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.view.View;

import java.util.ArrayList;
import java.util.List;

public class Menu {
  private List<MenuEntry> entries;
  private KeyReader keyReader;
  private View view;
  private Assortment assortment;

  public Menu(View view) {
    keyReader = new KeyReader();
    initializeEntries();
    this.view = view;
    assortment = new Assortment();
  }

  private void initializeEntries() {
    entries = new ArrayList<>();
    entries.add(new FlowersEntry());
    entries.add(new FlowerpotEntry());
    entries.add(new FertilizerEntry());
    entries.add(new CactusEntry());
    entries.add(new PalmEntry());
    entries.add(new ExitEntry());
  }

  public final void showMenu() {
    MenuEntry chosenOption;
    int chosenOptionNumber;

    do {
      System.out.println("\nChoose, what you want to buy:");

      for (int i = 0; i < entries.size(); i++) {
        System.out.println((i + 1) + ") " + entries.get(i));
      }

      chosenOptionNumber = keyReader.readKey(entries.size());

      chosenOption = entries.get(chosenOptionNumber);
      chosenOption.run(view, assortment);

    } while (!(chosenOption instanceof ExitEntry));
  }
}
