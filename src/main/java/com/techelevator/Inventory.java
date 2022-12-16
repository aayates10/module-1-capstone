package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private String fileLocation;
    private File vendingFile;

    private List<String[]> vendingFileData;

    public Inventory(){
        this.fileLocation = "Capstone 1/module-1-capstone/vendingmachine.csv";
        this.vendingFile = new File(fileLocation);
        this.vendingFileData = new ArrayList<>();

    }
    public List<String[]> getVendingFileData() {
        try (Scanner fileScanner = new Scanner(vendingFile)){
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] lineArray = line.split("\\|");
        vendingFileData.add(lineArray);
    }
        }catch (FileNotFoundException e){

        }
        return vendingFileData;
    }


}
