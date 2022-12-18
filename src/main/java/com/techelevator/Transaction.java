package com.techelevator;

import java.awt.*;
import java.util.Arrays;

public class Transaction {
    private static final double NICKEL = 0.05;
    private static final double DIME = 0.10;
    private static final double QUARTER = 0.25;

    public static String coinsReturned(double changeNeeded) {
        // changeNeeded needs to be a provided variable.
        double changeGiven = 0;
        int quartersGiven = 0;
        int dimesGiven = 0;
        int nickelsGiven = 0;
        while ((changeNeeded - changeGiven) >= QUARTER) {
            changeGiven = changeGiven + QUARTER;
            quartersGiven++;
        }
        while ((changeNeeded - changeGiven) >= DIME) {
            changeGiven = changeGiven + DIME;
            dimesGiven++;
        }
       while ((changeNeeded - changeGiven) >= NICKEL) {
            changeGiven = changeGiven + NICKEL;
            nickelsGiven++;
        }
        return "Dispensing change in the form of " + quartersGiven + " quarters, " + dimesGiven + " dimes, and " + nickelsGiven + " nickels";
    }
}
