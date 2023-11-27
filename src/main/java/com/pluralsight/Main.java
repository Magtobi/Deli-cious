package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.homeScreen();
    }

    public void homeScreen() {
        String choice;
        do {
            System.out.println("HOME SCREEN");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != "0");
    }

   public void orderScreen() {
       System.out.println("ORDER SCREEN");
        Sandwich sandwich = createSandwich();
        String drink = addDrink();
        String chips = addChips();

//        checkout(sandwich, drink, chips);
   }

    private Sandwich createSandwich() {
        System.out.println("Select your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();

        System.out.println("Select sandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        System.out.print("Enter your choice: ");
        int sizeChoice = scanner.nextInt();

        String breadType = breadType(breadChoice);
        String size = sandwichSize(sizeChoice);

        Sandwich sandwich = new Sandwich(size, breadType);
        customizeSandwich(sandwich);
        return sandwich;
    }

    private String breadType(int choice) {
        switch (choice) {
            case 1:
                return "white";
            case 2:
                return "wheat";
            case 3:
                return "rye";
            case 4:
                return "wrap";
            default:
                return "Invalid option";
        }
    }

    private String sandwichSize(int choice) {
        switch (choice) {
            case 1:
                return "4\"";
            case 2:
                return "8\"";
            case 3:
                return "12\"";
            default:
                return "Invalid option";
        }
    }

    private void customizeSandwich(Sandwich sandwich) {
        boolean addMoreToppings = true;
        do {
            System.out.println("Select toppings:");
            System.out.println("1) Regular Toppings");
            System.out.println("2) Premium Toppings");
            System.out.println("0) Done");

            System.out.print("Enter your choice: ");
            int toppingChoice = scanner.nextInt();

            switch (toppingChoice) {
                case 1:
                    System.out.println("Select regular topping:");
                    // Implement regular toppings selection using Sandwich class methods
                    break;
                case 2:
                    System.out.println("Select premium topping:");
                    // Implement premium toppings selection using Sandwich class methods
                    break;
                case 0:
                    addMoreToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (addMoreToppings);
    }

    private String addDrink() {
        System.out.println("ADD DRINK");
        System.out.println("Select the size of the drink:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Enter your choice: ");
        int drinkSize = scanner.nextInt();

        System.out.println("Select the flavor of the drink:");
        System.out.println("1) Coke");
        System.out.println("2) Pepsi");
        System.out.println("3) Sprite");
        System.out.println("4) Strawberry Fanta");
        System.out.print("Enter your choice: ");
        int drinkFlavor = scanner.nextInt();

        String size = sandwichSize(drinkSize);
        String flavor = flavor(drinkFlavor);

        return size + " " + flavor + " Drink";
    }

    private String flavor(int choice) {
        switch (choice) {
            case 1:
                return "Coke";
            case 2:
                return "Pepsi";
            case 3:
                return "Sprite";
            default:
                return "";
        }
    }

    private String addChips() {
        System.out.println("ADD CHIPS");
        System.out.println("Select the type of chips:");
        System.out.println("1) Plain");
        System.out.println("2) BBQ");
        System.out.println("3) Salt & Vinegar");
        System.out.print("Enter your choice: ");
        int chipChoice = scanner.nextInt();

        return chipType(chipChoice);
    }

    private String chipType(int choice) {
        switch (choice) {
            case 1:
                return "Plain Chips";
            case 2:
                return "BBQ Chips";
            case 3:
                return "Salt & Vinegar Chips";
            default:
                return "";
        }
    }


   private void checkout(Sandwich sandwich, String drink, String chips) {
        System.out.println("CHECKOUT");       System.out.println("Order Details:");
        sandwich.displayOrder();
        System.out.println("Drink: " + drink);
        System.out.println("Chips: " + chips);

        double totalCost = totalCost(sandwich, drink, chips);
        System.out.println("Total Cost: $" + totalCost);

        System.out.println("Confirm or Cancel?");
        System.out.println("1) Confirm");
        System.out.println("2) Cancel");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createReceipt(sandwich, drink, chips, totalCost);
                System.out.println("Order confirmed. Creating receipt...");
                break;
            case 2:
                System.out.println("Order cancelled. Going back to HOME SCREEN.");
                homeScreen();
                break;
            default:
                System.out.println("Invalid choice. Going back to HOME SCREEN.");
                homeScreen();
                break;
        }
    }

    private double totalCost(Sandwich sandwich, String drink, String chips) {
         double sandwichCost = sandwich.getSizePrice();
         double drinkCost = OtherProducts.sizePrice(drink);
        double chipsCost = OtherProducts.

         return sandwichCost + drinkCost;
        return sandwichCost + drinkCost + chipsCost;
     }

 }
