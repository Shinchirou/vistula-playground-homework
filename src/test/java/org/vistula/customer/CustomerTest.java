package org.vistula.customer;

import org.junit.Test;
import org.vistula.basket.BasketItem;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void AdultTest1() {
        Customer customer = new Customer();
        customer.setAge(18);
        assert customer.IfAdult();
    }

    @Test
    public void AdultTest2() {
        Customer customer = new Customer();
        customer.setAge(17);
        assert customer.IfAdult() == false;
    }

    @Test
    public void CountBeskedTotalTest() {
        Customer customer = new Customer();
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));

        customer.setBasket(basket);
        assert customer.TotalBeskedPrice() == 27;
    }

    //Test verifies if Adult can buy product which is not age restricted
    //size od basket shouldn't be incremented
    @Test
    public void AddingNotAgeRestrictedItemTest() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));
        Customer customer = new Customer("Bogdan", "Ostaszewski", 18, basket);

        customer.AddItemToBasket(new BasketItem(2.99f, false));
        assert customer.getBasket().size() == 4;

    }

    //Test verifies if Child can buy product which is not age restricted
    //size od basket shouldn't be incremented
    @Test
    public void AddingNotAgeRestrictedItemTest2() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));
        Customer customer = new Customer("Bogdan", "Ostaszewski", 17, basket);

        customer.AddItemToBasket(new BasketItem(3.99f, false));
        assert customer.getBasket().size() == 4;

    }

    //Test verifies if Child can buy product which is age restricted.
    //size od basket shouldn't be incremented
    @Test
    public void AddingAgeRestrictedItemTest1() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));
        Customer customer = new Customer("Bogdan", "Ostaszewski", 17, basket);

        customer.AddItemToBasket(new BasketItem(4.99f, true));
        assert customer.getBasket().size() == 3;

    }

    //Test verifies if Adult can buy product which is age restricted.
    //size od basket should be incremented
    @Test
    public void AddingAgeRestrictedItemTest() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));
        Customer customer = new Customer("Bogdan", "Ostaszewski", 18, basket);

        customer.AddItemToBasket(new BasketItem(5.99f, true));
        assert customer.getBasket().size() == 4;

    }

    @Test
    public void ShowBasketTest() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        basket.add(new BasketItem(5.99f, false));
        basket.add(new BasketItem(9.99f, true));
        basket.add(new BasketItem(11.02f, false));
        Customer customer = new Customer("Bogdan", "Ostaszewski", 18, basket);

        customer.DisplayBasket();
    }

    // Test test if it is possible to remove item from the basket list
    //size od basket should be decremented
    @Test
    public void RemovingExistingItemTest() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        BasketItem item1 = new BasketItem(5.99f, false);
        BasketItem item2 = new BasketItem(9.99f, true);
        BasketItem item3 = new BasketItem(11.02f, false);
        basket.add(item1);
        basket.add(item2);
        basket.add(item3);
        Customer customer = new Customer("Bogdan", "Ostaszewski", 18, basket);

        customer.RemoveItemFromBasket(item2);
        assert customer.getBasket().size() == 2;

    }


    // Test test how the program handles removing item which does not exist on list (exception handling)
    @Test
    public void RemovingNonexistantItemTest() {
        List<BasketItem> basket = new ArrayList<BasketItem>();
        BasketItem item1 = new BasketItem(5.99f, false);
        BasketItem item2 = new BasketItem(9.99f, true);
        BasketItem item3 = new BasketItem(11.02f, false);
        basket.add(item1);
        basket.add(item3);
        Customer customer = new Customer("Bogdan", "Ostaszewski", 18, basket);

        try {
            customer.RemoveItemFromBasket(item2);
        } catch (Exception e){
            System.out.println(e.getMessage());
            assert e instanceof InvalidParameterException;
        }

    }

}
