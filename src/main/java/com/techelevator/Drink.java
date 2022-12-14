package com.techelevator;

public class Drink extends Snack {

    private int drinkQty = 5;

    public Drink(String slotLocation, String name, double price, String snackType) {
        super(slotLocation, name, price, snackType);
    }

    public Drink(String name, double price) {
        super(name, price);
    }


    public String getName() {
        return this.getName();
    }

    public double getPrice() {
        return this.getPrice();
    }

}
