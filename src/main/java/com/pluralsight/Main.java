package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

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
//                default:
//                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

   public static void orderScreen() {
        System.out.println("ORDER SCREEN");
        System.out.println("1) Would you like a Sandwich?");
        System.out.println("2) Would you like a drink? ");
        System.out.println("3) Would you like a bag of chips? ");
        System.out.println("4) Exit");
        String choice = scanner.next().trim().toLowerCase();

       switch (choice) {
           case "1":
               createSandwich();
           case "2":
               addDrink();
           case "3":
               addChips();
           case "4":
               break;

       }

//        checkout(sandwich, drink, chips);
   }


    private static SW createSandwich() {
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

        System.out.println("Would you like the bread toasted? (Y/N)");
        String option = scanner.next();
        boolean isToasted= true;
        if (option.equalsIgnoreCase("y")){
            isToasted = true;
        }else if(option.equalsIgnoreCase("n")){
            isToasted = false;
        }else {
            System.out.println("Invalid response.");
        }

        String breadType = breadType(breadChoice);
        String size = sandwichSize(sizeChoice);

        SW sandwich = new SW(size, breadType,isToasted);
        customizeSandwich(sandwich);

        //Receipt receipt= new Receipt()
        System.out.println("Would you like to complete your order? (Y/N)");
        String answer = scanner.next().toUpperCase();
        if(answer.equals("Y")){
            // complete order
           // Receipt.generateReceipt();
        } else if (answer.equals("N")) {
            orderScreen();
        }
        return sandwich;



    }

    private static String breadType(int choice) {
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

    private static String sandwichSize(int choice) {
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

    private static void customizeSandwich(SW sandwich) {



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
                    regTopping();
//                    SW sw= new SW("","", true);
//
//
//                    System.out.println("Available regular toppings:\n Lettuce, Peppers ,Onions, Tomatoes \n Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms");
//                    System.out.println("List the regular toppings you want: (comma-separated)");
//
//
//                    String input = scan.nextLine(); // to remove all whitespaces
//                    List<String> inputRegToppings= sw.userRegToppings(input.toLowerCase().replaceAll("\\s+", ""));
//                    // new scanner fixed it idk why
//                    inputRegToppings.forEach(System.out::println);// way of listing


                    // Implement regular toppings selection using Sandwich class methods
                    break;
                case 2:
//                    SW sw1= new SW("","", true);
//                    System.out.println("Available regular toppings:\n Meats: Steak, Ham, Salami, Roast Beef, Chicken, Bacon \n Cheeses: American, Provolone, Cheddar, Swiss");
//
//                    System.out.println("List the premium toppings you want: (comma-separated)");
//                    String userInput = scan.nextLine(); // to remove all whitespaces
//                    List<String> inputPreToppings= sw1.userPremiumToppings(userInput.toLowerCase().replaceAll("\\s+", ""));
//
//                    inputPreToppings.forEach(System.out::println);// way of listing


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

    public static List<String> regTopping(){
        Scanner scan = new Scanner(System.in);
        SW sw = createSandwich();


        System.out.println("Available regular toppings:\n Lettuce, Peppers ,Onions, Tomatoes \n Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms");
        System.out.println("List the regular toppings you want: (comma-separated)");


        String input = scan.nextLine(); // to remove all whitespaces
        List<String> inputRegToppings= sw.userRegToppings(input.toLowerCase().replaceAll("\\s+", ""));

        return inputRegToppings;
                //inputRegToppings.forEach(System.out::println);// way of listing

    }

    private static String addDrink() {
        System.out.println("ADD DRINK");
        System.out.println("Select the flavor of the drink:");
        System.out.println("  Coke");
        System.out.println("  Pepsi");
        System.out.println("  Sprite");
        System.out.println("  No bev");
        System.out.print("Enter your choice: ");
        String drinkFlavor = scanner.next().trim().toLowerCase();

        System.out.println("Select the size of the drink:");
        System.out.println("  Small");
        System.out.println("  Medium");
        System.out.println("  Large");
        System.out.print("Enter your choice: ");
        String drinkSize = scanner.next().trim().toLowerCase();



//        String size = sandwichSize(drinkSize);
//        String flavor = flavor(drinkFlavor);
//
//        return size + " " + flavor + " Drink";
        return drinkSize + " " + drinkFlavor + "Drink";
    }

//    private String flavor(int choice) {
//        switch (choice) {
//            case 1:
//                return "Coke";
//            case 2:
//                return "Pepsi";
//            case 3:
//                return "Sprite";
//            case 4:
//                return "No bev";
//            default:
//                return "";
//        }
//    }

    private static String addChips() {
        System.out.println("ADD CHIPS");
        System.out.println("Select the type of chips:");
        System.out.println("  Plain");
        System.out.println("  BBQ");
        System.out.println("  Salt & Vinegar");
        System.out.println("  No chips");
        System.out.print("Enter your choice: ");
        String chipChoice = scanner.next().trim().toLowerCase();

        return chipChoice;
    }

//    private String chipType(int choice) {
//        switch (choice) {
//            case 1:
//                return "Plain Chips";
//            case 2:
//                return "BBQ Chips";
//            case 3:
//                return "Salt & Vinegar Chips";
//            case 4:
//                return "No chips";
//            default:
//                return "";
//        }
//    }


   private void checkout(SW sandwich, String drink, String chips) {
        System.out.println("CHECKOUT");
        System.out.println("Order Details:");
        sandwich.getPrice();
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

    private double totalCost(SW sandwich, String drink, String chips) {
        OtherProducts otherProducts = new OtherProducts(drink);
         double sandwichCost = sandwich.getPrice();
//         double drinkCost = otherProducts.getSizePrice();
         double chipsCost;

//         return sandwichCost + drinkCost;
//         return sandwichCost + drinkCost + chipsCost;
//
        return sandwichCost;
    }
    private void createReceipt(SW sandwich, String drink, String chips, double totalCost) {
        List<SW> orderList = new ArrayList<>();
        orderList.add(sandwich);

        Receipt receipt = new Receipt(orderList, totalCost);
        receipt.generateReceipt();

        System.out.println("Receipt created.");
        homeScreen();
    }
//    public static void displayOrder() {
//        System.out.println("Sandwich size: " + size);
//        System.out.println("Bread type: " + breadType);
//        System.out.println("Regular toppings: " + regularToppings);
//        System.out.println("Premium toppings: " + premiumToppings);
//    }

}



