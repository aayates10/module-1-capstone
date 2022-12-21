package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Transaction {

    String keys;
    /*stores the slot where the snack is located*/
    private String slotID;
    String tempkey;
    /*stores the user's selected product key.*/
    public Transaction(){}


    /*sets the slotID field*/
    public void Snack(String slotID, String name, double price, String snackType) {
        this.slotID = slotID;
    }
    /*prompts the user to enter a product key
    and stores it in the tempkey field. It returns the tempkey field.
     */
    public String transaction(){

        Scanner userSelect = new Scanner(System.in);
        System.out.print("Please enter key of the item you'd like: ");
        String productKey = userSelect.nextLine();
        System.out.println("You selected: " + productKey.toUpperCase(Locale.ROOT));

        this.tempkey = productKey.toUpperCase(Locale.ROOT);
        return tempkey;
    }
    /*has a getMessage method which returns a
    message based on the type of snack associated
    with the slotID field.
     */
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