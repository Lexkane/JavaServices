package shop.products;

public enum PlantType {
  FLOWER, TREE, BUSH, PLANT;

  public static PlantType getType(String type){
    switch (type){
      case "Flower": return FLOWER;
      case "Plant" : return PLANT;
      case "Bush" : return BUSH;
      case "Tree": return TREE;
      default: return null;
    }
  }
}
