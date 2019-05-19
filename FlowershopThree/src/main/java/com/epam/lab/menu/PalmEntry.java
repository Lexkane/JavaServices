package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.manager.Purchaser;
import com.epam.lab.model.Palm;
import com.epam.lab.view.View;

import java.util.List;

public class PalmEntry implements MenuEntry {
  private KeyReader keyReader;
  private Purchaser purchaser;

   PalmEntry() {
    keyReader = new KeyReader();
    purchaser = new Purchaser();
  }

  public void run(View view, Assortment assortment) {
    List<Palm> availablePalms = getPalms(assortment);

    if (!availablePalms.isEmpty()) {
      view.showAll(availablePalms);

      int palmNum = keyReader.readKey(availablePalms.size());
      view.showBoughtGoods(availablePalms.get(palmNum));
      purchaser.buySingleGoods(palmNum, availablePalms, assortment);
    } else {
      System.out.println("Sorry, we have no palms left");
    }
  }

  private List<Palm> getPalms(Assortment assortment) {
    return assortment.getPalms();
  }

  @Override
  public String toString() {
    return "Palm";
  }
}
