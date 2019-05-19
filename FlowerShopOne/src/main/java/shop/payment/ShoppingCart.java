package shop.payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import shop.products.Item;

public class ShoppingCart {

  private List<List<Item>> selectedItems;

  public ShoppingCart(){
    selectedItems = new ArrayList<>();
  }

  public List<List<Item>> getSelectedItems() {
    return selectedItems;
  }

  public void addItems(List<Item> items){
    selectedItems.add(items);
  }

  public BigDecimal getTotalPrice(){
    BigDecimal price = new BigDecimal(0.0);
    for(List<Item> list: selectedItems){
      for(Item item:list){
        price = price.add(/*DiscountManager.getInstance().getDiscount(item).multiply(*/item.getPrice());
      }
    }

    return price;
  }
}
