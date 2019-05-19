package com.company.creator;

import com.company.fishinggoods.Good;
import com.company.fishinggoods.LakeGood;
import com.company.fishinggoods.WinterGood;
import java.util.ArrayList;
import java.util.List;

public class GoodsCreator {

  private List<Good> goods;

  public GoodsCreator() {
    this.goods = createGoods();
  }

  public final List<Good> getGoods() {
    return goods;
  }

  private List<Good> createGoods() {
    goods = new ArrayList<Good>();
    goods.add(new LakeGood("russet1", "10", 10));
    goods.add(new LakeGood("russet2", "15", 15));
    goods.add(new LakeGood("russet3", "25", 25));
    goods.add(new LakeGood("russet4", "30", 30));
    goods.add(new WinterGood("bucket1", "15", 25));
    goods.add(new WinterGood("bucket2", "25", 35));
    goods.add(new WinterGood("bucket3", "30", 40));
    goods.add(new WinterGood("bucket4", "30", 45));

    return goods;
  }

}
