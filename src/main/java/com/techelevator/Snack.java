package com.techelevator;

public class Snack {

    private String name;
    private double price;
    private String slotID;
    private String snackType;
    private int qty = 5;

    public Snack(String slotID, String name, double price, String snackType) {
        this.slotID = slotID;
        this.name = name;
        this.price = price;
        this.snackType = snackType;
    }

    public Snack(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Snack() {
    }

    public String getMessage() {
        String message = "";
        if (slotID.contains("A")) {
            message = "Crunch Crunch, Yum!";
        } else if (slotID.contains("B")) {
            message = "Munch Munch, Yum!";
        } else if (slotID.contains("C")) {
            message = "Glug Glug, Yum!";
        } else {
            message = "Chew Chew, Yum!";
        }
        return message;
    }

    public void updateQty() {
        qty -= 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getSnackType() {
        return snackType;
    }

    public void setSnackType(String snackType) {
        this.snackType = snackType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
