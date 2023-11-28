package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private List<Sandwich> order;
    private double totalCost;
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    public Receipt(List<Sandwich> order, double totalCost) {
        this.order = order;
        this.totalCost = totalCost;
    }

    public void generateReceipt() {
        try {
            File folder = new File("src/main/resources");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = String.valueOf(LocalDate.now());
            String time = fmt.format(LocalTime.now());
            String fileName = dateFormat.format(new Date()) + ".txt";

            File file = new File(folder, fileName);
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file));

            for (Sandwich sandwich : order) {
                bufWriter.write(date + " " + time);
                bufWriter.newLine();
                bufWriter.write("Sandwich:");
                bufWriter.newLine();
                bufWriter.write("Size: " + sandwich.getSize());
                bufWriter.newLine();
                bufWriter.write("Bread Type: " + sandwich.getBreadType());
                bufWriter.newLine();
            }

            bufWriter.write("Total Cost: $" + totalCost);

            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
