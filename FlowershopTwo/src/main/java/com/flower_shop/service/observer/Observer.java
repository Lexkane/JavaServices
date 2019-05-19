package com.flower_shop.service.observer;

import com.flower_shop.catalog.Storage;
import java.util.Map;

public interface Observer {

  void update(String type, Map<String, Storage> storageMap);

}
