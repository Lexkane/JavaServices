package shop.payment;

import shop.initialization.Initialization;
import shop.products.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class DiscountManager {
    private static DiscountManager discountManager;

    private Map<Integer, List<String>> saleMap;

    private DiscountManager(String file){
        this.saleMap = Initialization.readDiscount(file);
    }

    public static DiscountManager getInstance(){
        if(discountManager == null){
            discountManager = new DiscountManager("src\\main\\resources\\discountManager.txt");
        }

        return discountManager;
    }

    public BigDecimal getDiscount(Item item){
        int result = 0;
        for(Integer discount: saleMap.keySet()){
            for(String property: item.getProperties()){
                if(saleMap.get(discount).contains(property) && discount > result){
                    result = discount;
                }
            }
        }

        return new BigDecimal(1 - result / 100);
    }
}
