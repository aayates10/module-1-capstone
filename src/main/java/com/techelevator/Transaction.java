package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Transaction {

    String keys;

    private String slotID;
    String tempkey;

    public Transaction(){}



    public void Snack(String slotID, String name, double price, String snackType) {
        this.slotID = slotID;
    }

    public String transaction(){

        Scanner userSelect = new Scanner(System.in);
        System.out.print("Please enter key of the item you'd like: ");
        String productKey = userSelect.nextLine();
        System.out.println("You selected: " + productKey.toUpperCase(Locale.ROOT));

        this.tempkey = productKey.toUpperCase(Locale.ROOT);
        return tempkey;
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
    public String getKeys() {
        return keys;
    }

    public String getTempkey() {
        return tempkey;
    }

    public String getSlotID() {
        return slotID;
    }
}






