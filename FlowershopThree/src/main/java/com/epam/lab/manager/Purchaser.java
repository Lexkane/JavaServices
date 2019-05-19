package com.epam.lab.manager;

import com.epam.lab.model.Flower;
import com.epam.lab.model.Goods;
import com.epam.lab.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Purchaser {

    public void buyRandomBouquet(Assortment assortment, View view) {
        List<Flower> bouquet = new ArrayList<>(); // it's a bouquet. maybe we don't need it
        int newValue;
        double totalPrice = 0;
        for (int i = 0; i < 3; i++) {
            int random = new Random().nextInt(assortment.getFlowers().size());
            bouquet.add(assortment.getFlowers().get(random));
            newValue = assortment.getAssortmentMap().get(assortment.getFlowers().get(random)) - 1;
            assortment.getAssortmentMap().replace(assortment.getFlowers().get(random), newValue);
            totalPrice += bouquet.get(i).getPrice();
        }

        totalPrice = getDiscount(totalPrice);

        view.showBouquet(bouquet, totalPrice);
    }

    public void buySingleGoods(int goodsNumber, List<? extends Goods> goods, Assortment assortment) {
        int newValue = assortment.getAssortmentMap().get(goods.get(goodsNumber)) - 1;
        assortment.getAssortmentMap().replace(goods.get(goodsNumber), newValue);
    }

    private double getDiscount(double price) {
        if (price >= 1200 && price <= 2000) {
            System.out.println("Congratulations, you've got 12% discount");
            return (price * 88.0) / 100.0;
        } else if (price > 2000) {
            System.out.println("Congratulations, you've got 20% discount");
            return (price * 80.0) / 100.0;
        } else {
            return price;
        }
    }
}
