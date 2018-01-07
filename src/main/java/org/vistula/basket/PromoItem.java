package org.vistula.basket;

import java.security.InvalidParameterException;

public class PromoItem extends BasketItem {

    private float discount;

    public PromoItem(float price, boolean ageRestrictedItem, float discount) {
        super(price, ageRestrictedItem);
        if(discount >= 0){
            this.discount = discount;
        } else {
            throw new InvalidParameterException("Discount cannot be lower than 0");
        }
        setPrice(ApplyDiscount());
    }

    public float ApplyDiscount(){
        return getPrice() - (getPrice() * discount/100);
    }



    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        if(discount >= 0){
            this.discount = discount;
        } else {
            throw new InvalidParameterException("Discount cannot be lower than 0");
        }
    }
}
