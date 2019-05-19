package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.view.View;

public class ExitEntry implements MenuEntry {
  public void run(View view, Assortment assortment) {
    view.showSuccessfulExit();
    System.exit(0);
  }

  @Override
  public String toString() {
    return "Exit";
  }
}
