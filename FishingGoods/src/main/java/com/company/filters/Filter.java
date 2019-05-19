package com.company.filters;

import com.company.fishinggoods.Good;
import com.company.fishinggoods.LakeGood;
import com.company.fishinggoods.WinterGood;
import com.company.creator.GoodsCreator;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

  private List<Good> goods;

  private GoodsCreator goodsCreator;

  public final void setGoods(final List<Good> goods) {
    this.goods = goods;
  }

  public Filter() {
    goodsCreator = new GoodsCreator();
  }

  final List<Good> getAllGoods() {
    goods = null;
    return goodsCreator.getGoods();
  }

  public final List<Good> filterByPrice(final String price) {
    if (goods == null) {
      goods = goodsCreator.getGoods().stream().filter(good -> good.getPrice().equals(price))
          .sorted(Comparator.comparing(Good::getPrice)).collect(Collectors.toList());
    } else {
      goods = goods.stream().filter(good -> good.getPrice().equals(price)).sorted(Comparator.comparing(Good::getPrice))
          .collect(Collectors.toList());
    }
    return goods;
  }

  public final List<Good> filterByType(final String type) {
    if (goods == null) {
      switch (type) {
      case "LakeGood":
        goods = goodsCreator.getGoods().stream().filter(good -> good instanceof LakeGood).collect(Collectors.toList());
        break;
      case "WinterGood":
        goods = goodsCreator.getGoods().stream().filter(good -> good instanceof WinterGood)
            .collect(Collectors.toList());
        break;
      default:
        goods = goodsCreator.getGoods().stream().filter(good -> good instanceof LakeGood).collect(Collectors.toList());
        break;
      }
    } else {
      switch (type) {
      case "LakeGood":
        goods = goods.stream().filter(good -> good instanceof LakeGood).collect(Collectors.toList());
        break;
      case "WinterGood":
        goods = goods.stream().filter(good -> good instanceof WinterGood).collect(Collectors.toList());
        break;
      default:
        goods = goods.stream().filter(good -> good instanceof LakeGood).collect(Collectors.toList());
        break;
      }
    }
    return goods;
  }
}
