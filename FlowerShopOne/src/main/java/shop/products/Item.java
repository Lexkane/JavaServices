package shop.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {
    protected String name;
    protected BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return name + " " + price.toString();
    }

    public List<String> getProperties(){
        List<String> property = new ArrayList<>();
        property.add(this.getName());

        return property;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Item)){
            return false;
        }

        if(!((Item) obj).getName().equals(this.getName()) && !((Item) obj).getName().equals("none")){
            return false;
        }

        if(!((Item) obj).getPrice().equals(this.getPrice()) && !((Item) obj).getPrice().equals(new BigDecimal(0.0))){
            return false;
        }

        return true;
    }


}
