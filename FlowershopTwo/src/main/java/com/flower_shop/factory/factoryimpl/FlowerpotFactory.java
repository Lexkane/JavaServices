package com.flower_shop.factory.factoryimpl;

import com.flower_shop.factory.product.Flowerpot;

public interface FlowerpotFactory extends Factory {

  Flowerpot createFlowerpot();
}
