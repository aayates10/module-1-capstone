package com.techelevator;

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

        Scanner userinput = new Scanner(System.in);
        System.out.println("Please enter key of the item you'd like:");
        String key = userinput.nextLine();
        System.out.println("You bought: " + key.toUpperCase() + " " + getMessage().toString());

        this.tempkey = key.toUpperCase();
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






