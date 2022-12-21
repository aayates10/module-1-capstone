package com.techelevator;



public class Snack {
    /*stores the name of the snack*/
    private String name;
    /*stores the price of the snack*/
    private double price;
    /*stores the slot where the snack is located*/
    private String slotID;
    /*stores the type of snack*/
    private String snackType;
    /*stores the quantity of the snack available*/
    private int qty = 5;


    /*The Snack class has a constructor which takes in four arguments
    and sets the corresponding fields. It also has a PriceInPennies
    method which converts the price of the snack to pennies.*/
    public Snack(String slotID, String name, double price, String snackType) {
        this.slotID = slotID;
        this.name = name;
        this.price = price;
        this.snackType = snackType;
    }

    @Override
    /*returns a string representation of the snack*/
    public String toString() {
        String priceFormat = String.format("%.2f", price);
        return slotID + " | " + name + " | " + priceFormat + " | " + qty;
    }

    /*returns a message based on the type of snack*/
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

    /*decrements the quantity of the snack if it
    is available and has a non-zero quantity
     */
    public int getInventoryTakeAway(boolean available) {
        if (available == true && qty > 0) {
            this.qty = getQty() - 1;
        }
        return this.qty;
    }

    /*returns a string indicating whether the snack is
    sold out or not.
     */
    public String soldOut() {
        int shelfSnack = getQty();
        String shelvedInventory;
        if (shelfSnack == 0) {
            shelvedInventory = "SOLD OUT";
        } else {
            shelvedInventory = "AVAILIBLE";
        }
        return shelvedInventory;
    }


    /*decrements the quantity of the snack by 1*/
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
