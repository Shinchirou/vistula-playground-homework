package org.vistula.basket;

import java.security.InvalidParameterException;

public class BasketItem {

    private float price;
    boolean ageRestrictedItem;

    public BasketItem() {}

    public BasketItem(float price, boolean ageRestrictedItem) {
        if(price > 0){
        this.price = price;
        this.ageRestrictedItem = ageRestrictedItem;
        } else {
            throw new InvalidParameterException("Price cannot be 0 or lower than 0! It's a shop not charity!");
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price > 0){
         this.price = price;
        } else {
            throw new InvalidParameterException("Price cannot be 0 or lower than 0! It's a shop not charity!");
        }
    }

    public boolean isAgeRestrictedItem() {
        return ageRestrictedItem;
    }

    public void setAgeRestrictedItem(boolean ageRestrictedItem) {
        this.ageRestrictedItem = ageRestrictedItem;
    }
}
