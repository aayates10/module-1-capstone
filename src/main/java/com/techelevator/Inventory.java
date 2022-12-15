package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private String fileLocation;
    private File vendingFile;

    private List<String[]> vendingFileData;

    public Inventory(){
        this.fileLocation = "vendingmachine.csv";
        this.vendingFile = new File(fileLocation);
        this.vendingFileData = new ArrayList<>();

    }
    public List<String[]> getVendingFileData() {
        try (Scanner fileScanner = new Scanner(fileLocation)){
    while (fileScanner.hasNextLine()){
        String line = fileScanner.nextLine();
        String[] lineArray = line.split("\\|");
        vendingFileData.add(lineArray);
    }
        }
        return vendingFileData;
    }


}
