package org.vistula.basket;

import org.junit.Test;

import java.security.InvalidParameterException;

public class BasketItemTest {


    //Testing proper discount
    @Test
    public void PromoItemTest() {

        PromoItem promoItem = new PromoItem(10, false, 20);
        assert promoItem.getPrice() == 8;
    }

    //Testing handling of creating promoItem with discount lower than 0 (exception handling)
    @Test
    public void PromoItemTest2() {

        try {
            BasketItem promoItem = new PromoItem(10, false, -10);
        } catch (Exception e){
            System.out.println(e.getMessage());
            assert e instanceof InvalidParameterException;

        }
    }

    //Testing proper creation of basket item
    @Test
    public void BasketItemCreationTest() {

        BasketItem promoItem = new BasketItem(10, false);
        assert promoItem.getPrice() == 10;
    }

    //Testing proper handling of creating item with price "0" (exception handling)
    @Test
    public void BasketItemCreationNegativeTest() {
        try {
            BasketItem promoItem = new BasketItem(0, false);
        } catch (Exception e){
            System.out.println(e.getMessage());
            assert e instanceof InvalidParameterException;

        }
    }

}
