package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Inventory {

    public static List<String> getVendingFileData() {
        return vendingFileData;
    }

    private final File vendingFile = new File("vendingmachine.csv");

    private static List<String> vendingFileData = new ArrayList<>();

    public static Map<String, Snack> getSnacks() {
        return snacks;
    }

    private static Map<String, Snack> snacks = new HashMap<>();



    public Inventory() {
    }

    public String InvetoryStock() {

        try {

            Scanner InventoryStock = new Scanner(vendingFile);
            while (InventoryStock.hasNextLine()) {
                String inventoryLine = InventoryStock.nextLine();
                String[] stringsplit = inventoryLine.split("\\|");
                Snack object = new Snack(stringsplit[0], stringsplit[1], Double.parseDouble(stringsplit[2]), stringsplit[3]);
                snacks.put(object.getSlotID(), object);
                vendingFileData.add(stringsplit[0]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found." + e.getMessage());
        }

        return "Inventory Stock.";
    }

    public String displayInventory() {
        for (int i = 0; i < vendingFileData.size(); i++) {
            System.out.println(getSnacks().get(getVendingFileData().get(i)).getSlotID()+ "|" +
                    getSnacks().get(getVendingFileData().get(i)).getName() + "|" +
                    getSnacks().get(getVendingFileData().get(i)).getPrice());

        }
        return "\r\n Back to main menu.";
    }
}
