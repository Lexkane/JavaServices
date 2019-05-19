package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.manager.Purchaser;
import com.epam.lab.model.Flowerpot;
import com.epam.lab.model.Goods;
import com.epam.lab.view.View;

import java.util.ArrayList;
import java.util.List;

public class FlowerpotEntry implements MenuEntry {
  private KeyReader keyReader;
  private Purchaser purchaser;

  public FlowerpotEntry() {
    keyReader = new KeyReader();
    purchaser = new Purchaser();
  }

  public void run(View view, Assortment assortment) {
    List<Flowerpot> availableFlowerpots = getFlowerPots(assortment);

    if (!availableFlowerpots.isEmpty()) {
      view.showAll(availableFlowerpots);

      int flowerPotNumber = keyReader.readKey(availableFlowerpots.size());
      view.showBoughtGoods(availableFlowerpots.get(flowerPotNumber));
      purchaser.buySingleGoods(flowerPotNumber, availableFlowerpots, assortment);
    } else {
      System.out.println("Sorry, we have no flowerpots left");
    }
  }

  private List<Flowerpot> getFlowerPots(Assortment assortment) {
    return assortment.getFlowerpots();
  }

  @Override
  public String toString() {
    return "Flowerpot";
  }
}
