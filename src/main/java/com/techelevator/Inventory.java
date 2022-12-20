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



   // private static Map<String, Snack> snacks = new HashMap<>();




    public Inventory() {
    }

    public LinkedHashMap<String, Snack> InventoryStock() {
        LinkedHashMap<String, Snack> snacks = new LinkedHashMap<>(); // snacks now display in order
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

        return snacks;
    }

//    public String displayInventory() {
//        for (Snack i : snacks.values()){
//            System.out.println(i.toString());
//        }
//        // look into Linked Hashmap, or Tree Map to order results
//        return "\r\n Back to main menu.";
//    }
}
