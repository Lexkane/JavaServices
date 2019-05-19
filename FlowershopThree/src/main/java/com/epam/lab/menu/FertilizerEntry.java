package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.manager.Purchaser;
import com.epam.lab.model.Fertilizer;
import com.epam.lab.view.View;

import java.util.List;

public class FertilizerEntry implements MenuEntry {
  private KeyReader keyReader;
  private Purchaser purchaser;

  public FertilizerEntry() {
    keyReader = new KeyReader();
    purchaser = new Purchaser();
  }

  public void run(View view, Assortment assortment) {
    List<Fertilizer> availableFertilizers = getFertilizers(assortment);

    if (!availableFertilizers.isEmpty()) {
      view.showAll(availableFertilizers);

      int fertilizerNum = keyReader.readKey(availableFertilizers.size());
      view.showBoughtGoods(availableFertilizers.get(fertilizerNum));
      purchaser.buySingleGoods(fertilizerNum, availableFertilizers, assortment);
    } else {
      System.out.println("Sorry, we have no fertilizers left");
    }
  }

  public List<Fertilizer> getFertilizers(Assortment assortment) {

    return assortment.getFertilizer();
  }

  @Override
  public String toString() {
    return "Fertilizer";
  }
}
