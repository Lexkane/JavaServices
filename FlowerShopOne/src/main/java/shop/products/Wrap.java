package shop.products;

import java.math.BigDecimal;

public class Wrap extends Item{
    private WrapType type;
    private String material;
    private double size;
    private String color;

    public Wrap(String name, BigDecimal price,
        WrapType type, String material, double size, String color) {
        super(name, price);
        this.type = type;
        this.material = material;
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Wrap)){
            return false;
        }

        return true;
    }
}
