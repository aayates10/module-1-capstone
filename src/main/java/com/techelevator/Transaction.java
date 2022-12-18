package com.techelevator;

import java.util.Arrays;

public class Transaction {
    private static final double PENNY = .01;
    private static final double NICKEL = .05;
    private static final double DIME = .10;
    private static final double QUARTER = .25;

    public static String coinsReturned() {
        double changeNeeded = 1;
        // changeNeeded needs to be a provided variable.
        double changeGiven = 0;
        int quartersGiven = 0;
        int nickelsGiven = 0;
        int dimesGiven = 0;
        int penniesGiven = 0;
        for (double i = changeNeeded; i != changeGiven;) {
            if (changeNeeded > QUARTER) {changeGiven = changeGiven + QUARTER;
            changeNeeded = changeNeeded - QUARTER;
            quartersGiven++;}
            if (changeNeeded > DIME) {changeGiven = changeGiven + DIME;
            changeNeeded = changeNeeded - DIME;
            dimesGiven++;}
            if (changeNeeded > NICKEL) {changeGiven = changeGiven + NICKEL;
            changeNeeded = changeNeeded - NICKEL;
            nickelsGiven++;}
            else if (changeNeeded > PENNY) {changeGiven = changeGiven + PENNY;
            changeNeeded = changeNeeded - PENNY;
            penniesGiven++;}
        }
        return "Dispensing change in the form of " + quartersGiven + " quarters, " + dimesGiven + " dimes, " + nickelsGiven + " nickels, and " + penniesGiven + " pennies.";
    }
}
