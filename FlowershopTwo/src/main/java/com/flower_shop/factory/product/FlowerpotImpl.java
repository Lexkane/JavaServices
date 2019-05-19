package com.flower_shop.factory.product;

public class FlowerpotImpl implements Flowerpot {

    private float size;
    private double price;

    public FlowerpotImpl(float size, double price) {
        this.size = size;
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlowerpotImpl{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }
}
