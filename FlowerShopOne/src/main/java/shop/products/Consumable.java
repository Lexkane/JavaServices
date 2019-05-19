package shop.products;

import java.math.BigDecimal;

public class Consumable extends Item{
    private String maker;
    private String type;

    public Consumable(String name, BigDecimal price,
        String maker, String type) {
        super(name, price);
        this.maker = maker;
        this.type = type;
    }
}
