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

import static com.pluralsight.Main.*;

public class Receipt {

    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Receipt() {

    }

    public void generateReceipt() {
        try {
            File folder = new File("src/main/resources/Receipts");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = String.valueOf(LocalDate.now());
            String time = fmt.format(LocalTime.now());
            String fileName = dateFormat.format(new Date()) + ".txt";

            File file = new File(folder, fileName);
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file));
            bufWriter.write(date + " " + time);

            for (Order o : orders) {
                bufWriter.newLine();
                if (o instanceof SW) {
                    bufWriter.write("Sandwich:");
                    bufWriter.newLine();
                    bufWriter.write("Size: " + o.getSize());
                    bufWriter.newLine();
                    bufWriter.write("Bread Type: " + o.getType());
                    bufWriter.newLine();
                    writeList(bufWriter, "Regular Toppings: ", inputRegToppings);
                    writeList(bufWriter, "Premium Toppings: ", inputPreToppings);
                    writeList(bufWriter, "Sauce: ", userSauceList);
                    bufWriter.newLine();
                    bufWriter.write("Price: $" + o.getPrice());
                    bufWriter.newLine();
                } else if (o instanceof Drink) {
                    bufWriter.write("Drink: " + o.getType());
                    bufWriter.newLine();
                    bufWriter.write("Size: " + o.getSize());
                    bufWriter.newLine();
                    bufWriter.write("Price: $" + o.getPrice());
                    bufWriter.newLine();
                } else if (o instanceof Chips) {
                    bufWriter.write("Chips Flavor: " + o.getType());
                    bufWriter.newLine();
                    bufWriter.write("Price: $" + o.getPrice());
                    bufWriter.newLine();
                }
            }

            bufWriter.newLine();
            for (Order o : orders) {
                totalCost += o.getPrice();
            }
            bufWriter.write("Total Cost: $" + totalCost);

            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }

    }

    private void writeList(BufferedWriter bufWriter, String header, List<String> items) throws IOException {
        bufWriter.write(header);
        if (!items.isEmpty()) {
            for (int i = 0; i < items.size() - 1; i++) {
                bufWriter.write(items.get(i) + ", ");
            }
            bufWriter.write(items.get(items.size() - 1));
        }
        bufWriter.newLine();
    }
}
