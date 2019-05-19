package com.flower_shop.factory.product;

public class CactusImpl implements Cactus {

    private String name;
    private double price;

    public CactusImpl(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CactusImpl{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
