package shop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import shop.exceptions.NoSuchQuantityException;
import shop.initialization.Initialization;
import shop.products.BloomingPlant;
import shop.products.Item;
import shop.products.Plant;
import shop.products.PlantType;

public class Inventory {
    private static Inventory inventory;
    private Map<Item, Integer> itemsAndQuantity = new HashMap<>();

    public static Inventory getInstance(){
        if(inventory == null){
            inventory = new Inventory();
        }
        return inventory;
    }

    private Inventory() {
        this.itemsAndQuantity.putAll(Initialization.readConsumable("src\\main\\resources\\consumable.txt"));
        this.itemsAndQuantity.putAll(Initialization.readPlant("src\\main\\resources\\plants.txt"));
        this.itemsAndQuantity.putAll(Initialization.readBloomingPlant("src\\main\\resources\\bloomingPlant.txt"));
        this.itemsAndQuantity.putAll(Initialization.readWraps("src\\main\\resources\\wraps.txt"));
    }

    public Map<Item, Integer> getItemsAndQuantity() {
        return itemsAndQuantity;
    }

    public void setItemsAndQuantity(Map<Item, Integer> itemsAndQuantity) {
        this.itemsAndQuantity = itemsAndQuantity;
    }

    public boolean hasQuantity(Item item, Integer quantity) throws NoSuchQuantityException {
        if (itemsAndQuantity.get(item) < quantity) {
            throw new NoSuchQuantityException();
        }
        return true;
    }

//    public void reduceItemQuantity(Item item, Integer quantity)    !to do

    public <T> List<T> getItemsFromInventoryByType(Class<T> tClass) {
        return itemsAndQuantity.keySet()
            .stream()
            .filter(tClass::isInstance)
            .map(tClass::cast)
            .collect(Collectors.toList());
    }

    public List<Plant> getItemsFromInventoryByTypeOfPlant (PlantType plantType) {
        return getItemsFromInventoryByType(Plant.class).stream()
            .filter(i -> i.getPlantType() == plantType)
            .collect(Collectors.toList());
    }

    public List<Item> getItemsFromInventoryByItem(Item proposedItem){
        List<Item> items = new ArrayList<>();
        for(Item item : itemsAndQuantity.keySet()){
            if(item.equals(proposedItem)) {
                items.add(item);
            }
        }
        return items;
    }

    public BigDecimal getItemPrice(Item proposedItem){
        for(Item item : itemsAndQuantity.keySet()){
            if(item.equals(proposedItem)) {
                return item.getPrice();
            }
        }
        return null;
    }

}
