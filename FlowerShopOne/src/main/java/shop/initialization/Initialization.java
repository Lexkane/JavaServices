package shop.initialization;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

import shop.products.BloomingPlant;
import shop.products.Consumable;
import shop.products.Plant;
import shop.products.PlantType;
import shop.products.Wrap;
import shop.products.WrapType;

public class Initialization {


  public static Map<Wrap,Integer> readWraps(String file){
    Map<Wrap,Integer> wrapIntegerMap = new HashMap<>();
    try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStream)) {
      while(bufferedReader.ready()){
        wrapIntegerMap.putAll(parseWraps(bufferedReader.readLine()));
        bufferedReader.readLine();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return wrapIntegerMap;
  }

  public static Map<Consumable,Integer> readConsumable(String file){
    Map<Consumable,Integer> consumableIntegerMap = new HashMap<>();
    try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStream)) {
      while(bufferedReader.ready()){
        consumableIntegerMap.putAll(parseConsumable(bufferedReader.readLine()));
        bufferedReader.readLine();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return consumableIntegerMap;
  }

  public static Map<Plant,Integer> readPlant(String file){
    Map<Plant,Integer> plantIntegerMap = new HashMap<>();
    try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStream)) {
      while(bufferedReader.ready()){
        plantIntegerMap.putAll(parsePlant(bufferedReader.readLine()));
        bufferedReader.readLine();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return plantIntegerMap;
  }

  public static Map<BloomingPlant,Integer> readBloomingPlant(String file){
    Map<BloomingPlant,Integer> bloomingPlantIntegerMap = new HashMap<>();
    try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStream)) {
      while(bufferedReader.ready()){
        bloomingPlantIntegerMap.putAll(parseBloomingPlant(bufferedReader.readLine()));
        bufferedReader.readLine();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return bloomingPlantIntegerMap;
  }

  public static Map<Integer, List<String>> readDiscount(String file){
    Map<Integer, List<String>> discountMap = new HashMap<>();
    try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
         BufferedReader bufferedReader = new BufferedReader(inputStream)) {
      while(bufferedReader.ready()){
        discountMap.putAll(parseDiscount(bufferedReader.readLine()));
        bufferedReader.readLine();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return discountMap;
  }

  private static Map<BloomingPlant,Integer> parseBloomingPlant(String plants){
    Map<BloomingPlant,Integer> bloomingPlantMap = new HashMap<>();
    String[] fields = plants.split(" / ");
    BloomingPlant bloomingPlant = new BloomingPlant(fields[0],new BigDecimal(fields[1]),PlantType.valueOf(fields[2]),fields[3],fields[4]);
    bloomingPlantMap.put(bloomingPlant ,Integer.valueOf(fields[5]));
    return bloomingPlantMap;
  }

  private static Map<Plant,Integer> parsePlant(String plants){
    Map<Plant,Integer> plantMap = new HashMap<>();
    String[] fields = plants.split(" / ");
    Plant plant = new Plant(fields[0],new BigDecimal(fields[1]),PlantType.valueOf(fields[2]));
    plantMap.put(plant ,Integer.valueOf(fields[3]));
    return plantMap;
  }

  private static Map<Wrap,Integer> parseWraps(String wraps){
    Map<Wrap,Integer> wrapMap = new HashMap<>();
    String[] fields = wraps.split(" / ");
    Wrap wrap = new Wrap(fields[0],new BigDecimal(fields[1]),WrapType.valueOf(fields[2]), fields[3], Double.valueOf(fields[4]), fields[5]);
    wrapMap.put(wrap ,Integer.valueOf(fields[6]));
    return wrapMap;
  }

  private static Map<Consumable,Integer> parseConsumable(String consumables){
    Map<Consumable,Integer> consumableMap = new HashMap<>();
    String[] fields = consumables.split(" / ");
    Consumable consumable = new Consumable(fields[0], new BigDecimal(fields[1]),fields[2],fields[3]);
    consumableMap.put(consumable ,Integer.valueOf(fields[4]));
    return consumableMap;
  }

  private static Map<Integer, List<String>> parseDiscount(String discount){
    Map<Integer, List<String>> discountMap = new HashMap<>();
    List<String> item = new ArrayList<>();
    item.addAll(Arrays.asList(discount.split(" / ")[1]));
    discountMap.put(Integer.parseInt(discount.split(" / ")[0]), item);

    return discountMap;
  }
}
