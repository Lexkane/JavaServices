package com.flower_shop.catalog;

import java.util.List;
import java.util.Map;

public class Catalog {

  private static Map<String, List<Storage>> productMap;

  public Catalog() {
  }

  public Catalog(Map<String, List<Storage>> productMap) {
    if (Catalog.productMap == null) {
      Catalog.productMap = productMap;
    }
  }

//    public void updateStorage(String type, Storage storage, boolean updateStatus) {
//        if(updateStatus){
//            List<Storage> storageList = productMap.get(type);
//            int i = storageList.get(storageList.indexOf(storage)).getCount() +storage;
//
//        }else {
//
//        }
//    }

  public Map<String, List<Storage>> getProductMap() {
    return productMap;
  }

  public void setProductMap(Map<String, List<Storage>> productMap) {
    Catalog.productMap = productMap;
  }

  public List<Storage> getProductByType(String type) {
    return productMap.get(type);
  }

  @Override
  public String toString() {
    return "Catalog{" +
        "productMap=" + productMap +
        '}';
  }
}
