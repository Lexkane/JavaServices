package shop.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import shop.products.interfaces.Bloomable;

public class BloomingPlant extends Plant implements Bloomable {

  private String color;
  private String scent;

  public BloomingPlant(String name, BigDecimal price,
      PlantType plantType, String color, String scent) {
    super(name, price, plantType);
    this.color = color;
    this.scent = scent;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getScent() {
    return scent;
  }

  public void setScent(String scent) {
    this.scent = scent;
  }

  @Override
  public boolean equals(Object obj) {
      if(!(obj instanceof BloomingPlant)){
        return false;
      }

      if(!super.equals(obj)){
        return false;
      }

      if(!((BloomingPlant) obj).getColor().equals(this.getColor()) && !((BloomingPlant) obj).getColor().equals("none")){
        return false;
      }

    if(!((BloomingPlant) obj).getScent().equals(this.getScent()) && !((BloomingPlant) obj).getScent().equals("none")){
      return false;
    }

      return true;
  }

  public List<String> getProperties(){
    List<String> property = new ArrayList<>();
    property.addAll(super.getProperties());
    property.add(this.getColor());
    property.add("blooming");

    if(property.contains("plant")){
      property.remove("plant");
    }

    return property;
  }

  @Override
  public void bloom() {
    System.out.println("Bloooooommm!!!" + scent);
  }

  @Override
  public String toString() {
    return "name = " + name +
        ", color=" + color;
  }
}
