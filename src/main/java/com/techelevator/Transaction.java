package com.techelevator;

import java.util.Scanner;

public class Transaction {

    String keys;


    String tempkey;

    public Transaction(){}


    public String transaction(){

        Scanner userinput = new Scanner(System.in);
        System.out.println("Please enter key of the item you'd like:");
        String key = userinput.nextLine();
        System.out.println("you selected:" + key.toUpperCase());

        this.tempkey = key.toUpperCase();
        return tempkey;
    }

    public String getKeys() {
        return keys;
    }

    public String getTempkey() {
        return tempkey;
    }

}






