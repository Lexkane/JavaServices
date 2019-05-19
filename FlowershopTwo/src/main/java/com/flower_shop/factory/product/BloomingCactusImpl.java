package com.flower_shop.factory.product;

public class BloomingCactusImpl implements Cactus, Bloomable {

    private String name;
    private double price;
    private boolean smells;

    public BloomingCactusImpl(String name, double price, boolean smells) {
        this.name = name;
        this.price = price;
        this.smells = smells;
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

    public boolean isSmells() {
        return smells;
    }

    public void setSmells(boolean smells) {
        this.smells = smells;
    }

    @Override
    public boolean isSmell() {
        return smells;
    }

    @Override
    public String toString() {
        return "BloomingCactusImpl{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", smells=" + smells +
                '}';
    }
}
