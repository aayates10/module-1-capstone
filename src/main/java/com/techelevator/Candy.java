package com.techelevator;

public class Candy extends Snack {

    private int candyQty = 5;

    public Candy(String slotLocation, String name, double price, String snackType) {
        super(slotLocation, name, price, snackType);
    }

    public Candy(String name, double price) {
        super(name, price);
    }

    public String getName() {
        return this.getName();
    }

    public double getPrice() {
        return this.getPrice();
    }

}
