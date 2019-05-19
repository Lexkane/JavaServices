package shop.view;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import shop.exceptions.NoSuchItemsWithTypeException;
import shop.payment.ShoppingCart;
import shop.products.Item;
import shop.services.AbstractBuilder;
import shop.services.ConsumableBuilder;
import shop.services.PlantBuilder;
import shop.services.WrapBuilder;

public class Menu {

  private Scanner inputString = new Scanner(System.in);
  private Map<String, String> menu;
  private Map<String, Printable> menuMethods;
  private Map<String, AbstractBuilder> subMenuMethods;
  private ShoppingCart shoppingCart;

  public Menu() {
    menu = new LinkedHashMap<>();
    menuMethods = new LinkedHashMap<>();
    subMenuMethods = new LinkedHashMap<>();
    shoppingCart = new ShoppingCart();

    menu.put("1", "1  - Add items");
    menu.put("2", "2  - Make order");
    menu.put("Q", "Q  - Exit");

    menu.put("11", "11  - Add plant");
    menu.put("12", "12  - Add wrap");
    menu.put("13", "13  - Add consumer");

    menuMethods.put("2", this::makeOrder);

    subMenuMethods.put("11", new PlantBuilder());
    subMenuMethods.put("12", new WrapBuilder());
    subMenuMethods.put("13", new ConsumableBuilder());
  }

  private void makeOrder() {
    if (shoppingCart.getSelectedItems().isEmpty()) {
      System.out.println("Your cart is empty!!!");
      return;
    }

    BigDecimal price = new BigDecimal(0.0);
    //create receipt/check method
//    for (List<Item> list : shoppingCart.getSelectedItems()) {
//      for (Item item : list) {
//        System.out.println(item.toString());
//        price = price.add(item.getPrice()); // *DiscountManager.get(Item)
//      }
//      System.out.println("Price: " + price + "grn");
//      price = BigDecimal.ZERO;
//    }
    System.out.println("Total price: " + shoppingCart.getTotalPrice());
  }

  private void addItems(String keyMenu){
    try {
      shoppingCart.addItems(subMenuMethods.get(keyMenu).build());
    } catch (NoSuchItemsWithTypeException exception){
      System.out.println(exception.getMessage());
    }
  }

  private void outputMenu() {
    System.out.println("\nMENU:");
    for (String key : menu.keySet()) {
      if (key.length() == 1) {
        System.out.println(menu.get(key));
      }
    }
  }

  private void outputSubMenu(String fig) {

    System.out.println("\nSubMENU:");
    for (String key : menu.keySet()) {
      if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
        System.out.println(menu.get(key));
      }
    }
  }

  public void show(){
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = inputString.nextLine().toUpperCase();

      if (keyMenu.equals("1")) {
        outputSubMenu(keyMenu);
        System.out.println("Please, select menu point.");
        keyMenu = inputString.nextLine().toUpperCase();
        addItems(keyMenu);
      } else {
        menuMethods.get(keyMenu).print();
      }
    } while (!keyMenu.equals("Q"));
  }
}
