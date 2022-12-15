package com.techelevator;

public class Gum extends Snack {

    private int gumQty = 5;

    public Gum(String slotLocation, String name, double price, String snackType) {
        super(slotLocation, name, price, snackType);
    }
    public Gum(String name, double price) {
        super(name, price);
    }

    public String getName() {
        return this.getName();
    }

    public double getPrice() {
        return this.getPrice();
    }

}