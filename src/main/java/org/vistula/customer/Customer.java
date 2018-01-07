package org.vistula.customer;

import org.vistula.basket.BasketItem;

import java.security.InvalidParameterException;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private int age;
    private List<BasketItem> basket;

    public Customer(String firstName, String lastName, int age, List<BasketItem> basket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.basket = basket;
    }

    public Customer (){}

    public boolean IfAdult(){
        if(age >= 18){
            return true;
        }
        return false;
    }

    public float TotalBeskedPrice(){
        float totalPrice = 0;
        for (int i = 0; i < basket.size(); i++) {
        totalPrice += basket.get(i).getPrice();
        }
        return totalPrice;
    }

    public void AddItemToBasket(BasketItem item){
        if (IfAdult()){
            basket.add(item);
            System.out.println("Product with price " + item.getPrice() + " was added to Basket");
        } else {
        if(!item.isAgeRestrictedItem()){
            basket.add(item);
            System.out.println("Product with price " + item.getPrice() + " was added to Basket");
        } else {
            System.out.println("Sorry you are too young to buy this product :)");
        }
        }
    }

    public void RemoveItemFromBasket(BasketItem item){
        if(basket.contains(item)){
        basket.remove(item);
            System.out.println("Item with price " + item.getPrice() + " was removed from basket.");
        } else {
            System.out.println("This item does not exist in the Basket. Cannot remove it");
            throw new InvalidParameterException("This item does not exist in the Basket. I cannot remove it");
        }
    }

    public void DisplayBasket(){
        System.out.println("Current Basket contents: ");
        int j = 1;
        for (int i = 0; i < basket.size(); i++){
            System.out.println("Product number " + j + " price: " + basket.get(i).getPrice());
            j++;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BasketItem> getBasket() {
        return basket;
    }

    public void setBasket(List<BasketItem> basket) {
        this.basket = basket;
    }
}
