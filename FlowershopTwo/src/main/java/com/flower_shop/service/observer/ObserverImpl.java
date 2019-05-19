package com.flower_shop.service.observer;


import com.flower_shop.catalog.Catalog;
import com.flower_shop.catalog.Storage;
import java.util.Map;

public class ObserverImpl implements Observer {

  private Catalog catalog;

  public ObserverImpl() {
    catalog = new Catalog();
  }


  @Override
  public void update(String type, Map<String, Storage> storageMap) {
    catalog.getProductMap().get(type).forEach(a -> {
      Storage storage = storageMap.get(a.getName());
      if (storage.getCount() == a.getCount() || storage.getCount() <= a.getCount()) {
        a.setCount(a.getCount() - storage.getCount());
      }
    });
  }
}
