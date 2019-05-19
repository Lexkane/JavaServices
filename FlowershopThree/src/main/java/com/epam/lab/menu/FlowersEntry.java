package com.epam.lab.menu;

import com.epam.lab.manager.Assortment;
import com.epam.lab.manager.Purchaser;
import com.epam.lab.model.Flower;
import com.epam.lab.view.View;

import java.util.List;

public class FlowersEntry implements MenuEntry {
  private KeyReader keyReader;
  private Purchaser purchaser;


   FlowersEntry() {
    keyReader = new KeyReader();
    purchaser = new Purchaser();
  }

  public void run(View view, Assortment assortment) {
    view.showFlowersAmountOptions();

    int flowersAmount = keyReader.readKey(2);
    switch (flowersAmount) {
      case 0:
        buySingleFlower(view, assortment);
        break;
      case 1:
        buyBouquet(view, assortment);
        break;
    }
  }

  private void buySingleFlower(View view, Assortment assortment) {
    List<Flower> availableFlowers = getFlowers(assortment);

    if (!availableFlowers.isEmpty()) {
      view.showAll(availableFlowers);

      int flowerNumber = keyReader.readKey(availableFlowers.size());
      view.showBoughtGoods(availableFlowers.get(flowerNumber));
      purchaser.buySingleGoods(flowerNumber, availableFlowers, assortment);
    } else {
      System.out.println("Sorry, we have no flowers left");
    }
  }

  private void buyBouquet(View view, Assortment assortment) {
    view.showBouquetOptions();
    int bouquetOption = keyReader.readKey(2);
    switch (bouquetOption) {
      case 0:
        if (assortment.getFlowers().size()>=3) {
          purchaser.buyRandomBouquet(assortment, view);
        }
        else {
          System.out.println("Sorry, we don't have enough flowers for making bouquet");
        }
        break;
      case 1:
        view.showBouquetFlowersAmountChoice();
        int flowersAmount = keyReader.readKey(getFlowers(assortment).size()) + 1;
        for (int i = 0; i < flowersAmount; i++) {
          buySingleFlower(view, assortment);
        }
    }
  }

  private List<Flower> getFlowers(Assortment assortment) {
   return assortment.getFlowers();
  }

  @Override
  public String toString() {
    return "Flowers";
  }
}
