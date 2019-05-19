package com.flower_shop;

import com.flower_shop.catalog.Catalog;
import com.flower_shop.catalog.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeniorVoVa {


  private Catalog catalog;

  public SeniorVoVa() {
    init();
  }

  public Catalog getCatalog() {
    return catalog;
  }

  public void init() {
    List<Storage> storages = new ArrayList<>();
    Map<String, List<Storage>> storageMap = new HashMap<>();
    storages.add(new Storage("Rose", 15));
    storages.add(new Storage("Tulip", 16));
    storages.add(new Storage("Chamomile", 5));

    storageMap.put("Flower", storages);

    storages = new ArrayList<>();
    storages.add(new Storage("Green Cactus", 5));

    storageMap.put("Cactus", storages);

    storages = new ArrayList<>();
    storages.add(new Storage("Violets", 7));

    storageMap.put("Flowerpot", storages);

    catalog = new Catalog(storageMap);
  }
}
