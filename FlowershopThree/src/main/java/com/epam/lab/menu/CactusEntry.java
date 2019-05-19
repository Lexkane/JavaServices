package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.manager.Purchaser;
import com.epam.lab.model.Cactus;
import com.epam.lab.view.View;

import java.util.List;
import java.util.stream.Collectors;

public class CactusEntry implements MenuEntry {
  private KeyReader keyReader;
  private Purchaser purchaser;

   CactusEntry() {
    keyReader = new KeyReader();
    purchaser = new Purchaser();
  }

  public void run(View view, Assortment assortment) {
    view.showAll(getAvailableCactus(assortment));
    view.showCactusOptions();
    boolean hasOdour = keyReader.readBooleanKey();
    boolean hasBloom = keyReader.readBooleanKey();

    List<Cactus> availableCactus = getCactus(hasOdour, hasBloom, assortment);

    if (!availableCactus.isEmpty()) {
      view.showAll(availableCactus);

      int cactusNum = keyReader.readKey(availableCactus.size());
      view.showBoughtGoods(availableCactus.get(cactusNum));
      purchaser.buySingleGoods(cactusNum, availableCactus, assortment);
    } else {
      System.out.println("Sorry, we have no cactus that you want");
    }
  }

  private List<Cactus> getAvailableCactus(Assortment assortment) {
     return assortment.getCactus();
  }

  private List<Cactus> getCactus(boolean hasOdour, boolean hasBloom, Assortment assortment) {
    List<Cactus> cactuses = assortment.getCactus();
    return cactuses.stream().
            filter((c) -> c.hasBloom() == (hasBloom))
            .filter((c) -> c.hasOdour() == hasOdour)
            .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "Cactus";
  }
}
