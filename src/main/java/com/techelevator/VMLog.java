package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VMLog {

    /*
    TODO: code to log transactions
     - first $ amount deposited, spent, or given change; second is new balance

                   01/01/2019 12:00:00 PM FEED MONEY: $5.00 $5.00
                   01/01/2019 12:00:15 PM FEED MONEY: $5.00 $10.00
                   01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25
                   01/01/2019 12:01:25 PM Cowtales B2 $1.50 $6.75
                   01/01/2019 12:01:35 PM GIVE CHANGE: $6.75 $0.00
     */

    public static void logTransactions(String message) throws FileNotFoundException {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MM-dd-yyy hh:mm:ss");
        String timeStamp = dateTime.format(dateTimeFormat);

        File logFile = new File("Log.txt");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.println(timeStamp + " " + message);
        }
    }

}
