package com.techelevator;

public class Chips extends Snack {

    private int chipsQty = 5;

    public Chips(String slotLocation, String name, double price, String snackType) {
        super(slotLocation, name, price, snackType);
    }

    public Chips(String name, double price) {
        super(name, price);
    }

    public String getName() {
        return this.getName();
    }

    public double getPrice() {
        return this.getPrice();
    }

}
