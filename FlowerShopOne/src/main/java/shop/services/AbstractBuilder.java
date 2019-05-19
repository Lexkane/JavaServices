package shop.services;

import java.util.List;
import shop.exceptions.NoSuchItemsWithTypeException;
import shop.products.Item;

public interface AbstractBuilder {

  List<Item> build() throws NoSuchItemsWithTypeException;

}
