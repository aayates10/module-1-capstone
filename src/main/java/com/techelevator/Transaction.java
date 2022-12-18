package com.techelevator;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Transaction {
    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;
    private static int balance;

    public static String coinsReturned() {
        int quartersGiven = 0;
        int dimesGiven = 0;
        int nickelsGiven = 0;
        quartersGiven = (balance / QUARTER);
        balance %= QUARTER;
        dimesGiven = (balance / DIME);
        balance %= DIME;
        nickelsGiven = (balance / NICKEL);
        balance %= NICKEL;
        return "Dispensing change in the form of " + quartersGiven + " quarters, " + dimesGiven + " dimes, and " + nickelsGiven + " nickels";
    }
    public static void feedMoney() {
        System.out.println("\r\nHow much money would you like to add to your balance in whole dollar amounts?");
        Scanner userFeed = new Scanner(System.in);
        int fedMoney = userFeed.nextInt();
        balance = (balance + fedMoney) * 100;
        //balance stored as pennies
        System.out.println("Your new balance is: " + (balance/100) + " dollars.");
    }

}



