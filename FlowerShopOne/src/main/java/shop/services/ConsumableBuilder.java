package shop.services;

import java.util.ArrayList;
import java.util.List;
import shop.products.Item;

public class ConsumableBuilder implements AbstractBuilder{

  public static List<Item> buyConsumable() {
    List<Item> consumers = new ArrayList<>();

    return consumers;
  }

  @Override
  public List<Item> build() {
    return null;
  }
}
