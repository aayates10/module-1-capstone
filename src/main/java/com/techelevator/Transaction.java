package com.techelevator;

import java.awt.*;
import java.util.Arrays;

public class Transaction {
    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;

    public static String coinsReturned(double changeNeeded) {
        // changeNeeded needs to be a provided variable.
        int changeGiven = (int ) Math.ceil(changeNeeded * 100);
        int quartersGiven = 0;
        int dimesGiven = 0;
        int nickelsGiven = 0;
        quartersGiven = (changeGiven / QUARTER);
        changeGiven %= QUARTER;
        dimesGiven = (changeGiven / DIME);
        changeGiven %= DIME;
        nickelsGiven = (changeGiven / NICKEL);
        changeGiven %= NICKEL;
        return "Dispensing change in the form of " + quartersGiven + " quarters, " + dimesGiven + " dimes, and " + nickelsGiven + " nickels";
    }
}
