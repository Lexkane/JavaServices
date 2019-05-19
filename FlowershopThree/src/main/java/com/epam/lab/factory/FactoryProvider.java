package com.epam.lab.factory;

import com.epam.lab.model.*;

public class FactoryProvider {
    public static void getGoods(String name) {
        switch (name) {
            case "Cactus": new Cactus();
            case "Fertilizer": new Fertilizer();
            case "Flower": new Flower();
            case "Flowerpot": new Flowerpot();
            case "Palm": new Palm();
            default:
                System.out.println("Incorrect good's type");
        }
    }
}
