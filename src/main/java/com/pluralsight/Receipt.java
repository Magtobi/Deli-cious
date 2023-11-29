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

import static com.pluralsight.Main.regTopping;

public class Receipt {
    private List<Order> order;
    private double totalCost;
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    public Receipt(List<Order> order, double totalCost) {
        this.order = order;
        this.totalCost = totalCost;
    }

    public void generateReceipt(List <String> whatever) {
        try {
            File folder = new File("src/main/resources/Receipts");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = String.valueOf(LocalDate.now());
            String time = fmt.format(LocalTime.now());
            String fileName = dateFormat.format(new Date()) + ".txt";

            File file = new File(folder, fileName);
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file));

            for (Order sandwich : order) {
                bufWriter.write(date + " " + time);
                bufWriter.newLine();
                bufWriter.write("Sandwich:");
                bufWriter.newLine();
                bufWriter.write("Size: " + sandwich.getSize());
                bufWriter.newLine();
                bufWriter.write("Bread Type: " + sandwich.getType());
                bufWriter.newLine();
                bufWriter.write("Regular Toppings: ");
                for (String s : whatever) {
                    bufWriter.write(s + ",");
                }
                bufWriter.newLine();
            }
            for (Order drink : order) {
                if(drink instanceof Drink){
                bufWriter.write("Drink: " + drink.getType() + drink.getSize());}
                //    bufWriter.newLine();
                //  bufWriter.write("Size: " + drink.getSize());
            }



            bufWriter.write("Total Cost: $" + totalCost);

            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
