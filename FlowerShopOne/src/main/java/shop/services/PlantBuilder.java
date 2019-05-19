package shop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import shop.exceptions.NoSuchItemsWithTypeException;
import shop.products.BloomingPlant;
import shop.products.Item;
import shop.products.Plant;
import shop.products.PlantType;

public class PlantBuilder implements AbstractBuilder{

  private static Map<String, String> plantTypes;
  private static Map<String, String> plantName;
  private static Map<String, String> plantColor;
  private static Scanner input = new Scanner(System.in);


  public PlantBuilder() {
    plantTypes = new HashMap<>();

    plantTypes.put("1", "flower");
    plantTypes.put("2", "plant");
    plantTypes.put("3", "bush");
    plantTypes.put("4", "tree");
  }

  private static List<Item> buildPlant() throws NoSuchItemsWithTypeException {
    boolean canWrap = true;
    List<Item> bouquet = new ArrayList<>();

    while (true) {
      Item newItem;

      System.out.println("Input plant's features:");
      outputPlantType();
      String type = plantTypes.get(input.next()).toUpperCase();
      boolean isBlooming = type.equals("FLOWER");
      if (!isBlooming) {
        canWrap = false;
        System.out.println("Is your plant blooming (true - yes, false - no): ");
        isBlooming = Boolean.parseBoolean(input.next());
      }
      outputPlantKind(type);
      String kind = plantName.get(input.next());
      String color = "";
      if (isBlooming) {
        outputPlantColor(type, kind);
        color = plantColor.get(input.next());
      }

      //review price method
      if (isBlooming) {
        newItem = new BloomingPlant(kind, new BigDecimal(0.0), PlantType.valueOf(type), color, "none");
        newItem.setPrice(Inventory.getInstance().getItemPrice(newItem));
      } else {
        //bug show also blooming plants
        newItem = new Plant(kind, new BigDecimal(0.0), PlantType.valueOf(type));
        newItem.setPrice(Inventory.getInstance().getItemPrice(newItem));
      }

      System.out.print("Choose quantity: ");
      int quantity = input.nextInt();
      // Check > 0 !!!

      System.out.println("\nChoose option:");
      System.out.println("1. Add new flower");
      //if there no bush or tree and no wrap
      System.out.println("2. Wrap");
      //System.out.println("3. Checkout");
      int optionChoose = input.nextInt();

      if (optionChoose == 3 || optionChoose == 2) {
        //wrap then break
        for(int i = 0; i < quantity; i++) {
          bouquet.add(newItem);
        }
        return bouquet;
        //break;
      }
      if (optionChoose == 1) {
        //wrap then break
        continue;
      }
    }
  }

  private static void outputPlantType() {
    System.out.println("Input plant type:");
    for (String key : plantTypes.keySet()) {
      if (key.length() == 1) {
        System.out.println(key + " - " + plantTypes.get(key));
      }
    }
  }

  private static void outputPlantKind(String type)
      throws NoSuchItemsWithTypeException {
    plantName = new HashMap<>();
    List<Plant> plants = Inventory.getInstance()
        .getItemsFromInventoryByTypeOfPlant(PlantType.valueOf(type));

    if (plants.isEmpty()) {
      throw new NoSuchItemsWithTypeException(
          "We don't have plant of this type - " + type + " now!!!");
    }
    System.out.println("Input kind: ");
    List<String> list = plants.stream().map(Item::getName).distinct()
        .collect(Collectors.toList());
    for (int i = 1; i <= list.size(); i++) {
      System.out.println(i + " - " + list.get(i - 1));
      plantName.put(String.valueOf(i), list.get(i - 1));
    }
  }

  private static void outputPlantColor(String type, String kind)
      throws NoSuchItemsWithTypeException {
    plantColor = new HashMap<>();
    List<BloomingPlant> plants = Inventory.getInstance()
        .getItemsFromInventoryByType(BloomingPlant.class);
    if (plants.isEmpty()) {
      throw new NoSuchItemsWithTypeException(
          "We don't have plant of this type - " + type + " now!!!");
    }
    System.out.println("Input color: "); // flower 1 rose none good
    List<String> colors = plants.stream()
        .filter(x -> x.getPlantType().equals(PlantType.valueOf(type)))
        .filter(x -> x.getName().equals(kind)).map(BloomingPlant::getColor)
        .distinct().collect(Collectors.toList());
    for (int i = 1; i <= colors.size(); i++) {
      System.out.println(i + " - " + colors.get(i - 1));
      plantColor.put(String.valueOf(i), colors.get(i - 1));
    }
  }

  @Override
  public List<Item> build() throws NoSuchItemsWithTypeException {
    return buildPlant();
  }
}
