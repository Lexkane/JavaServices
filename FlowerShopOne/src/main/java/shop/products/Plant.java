package shop.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Plant extends Item{
  private PlantType plantType;

  public Plant() {
  }

  public Plant(String name, BigDecimal price,
      PlantType plantType) {
    super(name, price);
    this.plantType = plantType;
  }

  public PlantType getPlantType() {
    return plantType;
  }

  public void setPlantType(PlantType plantType) {
    this.plantType = plantType;
  }

  //refactor this
  public List<String> getProperties(){
    List<String> property = new ArrayList<>();
    property.addAll(super.getProperties());
    property.add(String.valueOf(this.getPlantType()).toLowerCase());
    property.add("plant");

    return property;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof Plant)){
      return false;
    }

    if(!super.equals(obj)){
      return false;
    }

    if(!((Plant) obj).getPlantType().equals(this.getPlantType())){
      return false;
    }

    return true;
  }
}
