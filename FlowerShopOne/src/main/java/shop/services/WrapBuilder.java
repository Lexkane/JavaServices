package shop.services;

import java.util.ArrayList;
import java.util.List;
import shop.products.Item;

public class WrapBuilder implements AbstractBuilder{

  public static List<Item> buyWrap() {
    List<Item> wraps = new ArrayList<>();

    return wraps;
  }

  @Override
  public List<Item> build() {
    return null;
  }
}
