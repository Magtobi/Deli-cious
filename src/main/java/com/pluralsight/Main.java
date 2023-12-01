package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

import static com.pluralsight.SW.hasSandwich;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static double totalCost;
    private static SW sandwich;
    private static Drink drink;
    private static Chips chips;
    public static List<String> inputRegToppings;
    public static List<String> inputPreToppings;
    public static List<Order> orders;
    public static List<String> userSauceList;
    public static String swSize;

    public static void main(String[] args) {
        orders = new ArrayList<>();

        homeScreen();
    }

    public static void homeScreen() {
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

    public static void orderScreen() {
//       SW sandwich = createSandwich();
//       Drink drink = wantsDrink();
//       Chips chips = addChips();
        System.out.println("ORDER SCREEN");
        System.out.println("1) Would you like a Sandwich?");
        System.out.println("2) Would you like a drink? ");
        System.out.println("3) Would you like a bag of chips? ");
        System.out.println("4) Checkout");
        System.out.println("5) Exit");
        String choice = scanner.next().trim().toLowerCase();

        switch (choice) {
            case "1":
                createSandwich();
//               sandwich = createSandwich();
                System.out.println(sandwich.getSize());
                break;
            case "2":
                wantsDrink();
                break;
            case "3":
                addChips();
                break;
            case "4":
                checkout();
                break;
            case "5":
                System.exit(0);
                break;

        }

    }


    public static SW createSandwich() {
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
        boolean isToasted = true;
        if (option.equalsIgnoreCase("y")) {
            isToasted = true;
        } else if (option.equalsIgnoreCase("n")) {
            isToasted = false;
        } else {
            System.out.println("Invalid response.");
        }

        String breadType = breadType(breadChoice);
        swSize = sandwichSize(sizeChoice);

        sandwich = new SW(swSize, breadType, isToasted);
        customizeSandwich(sandwich);

        sandwich.setHasSandwich(true);
        sandwich.setSize(swSize);

        orders.add(sandwich);
        //System.out.println(orders.size());
        System.out.println("Would you like to add anything else? (Y/N)");
        String answer = scanner.next().toUpperCase();
        if (answer.equals("Y")) {
            orderScreen();
        }

        else if (answer.equals("N")) {
            checkout();
        }
            return sandwich;


        }

        private static String breadType ( int choice){
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

        private static String sandwichSize ( int choice){
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

        private static void customizeSandwich (SW sandwich){


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
                        preTopping();

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
                        sauces();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (addMoreToppings);
        }

        public static List<String> regTopping () {
            Scanner scan = new Scanner(System.in);
            SW sw = new SW("", "", true);


            System.out.println("Available regular toppings:\n Lettuce, Peppers ,Onions, Tomatoes \n Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms");
            System.out.println("List the regular toppings you want: (comma-separated)");


            String input = scan.nextLine(); // to remove all whitespaces
             inputRegToppings = sandwich.userRegToppings(input.toLowerCase().replaceAll("\\s+", ""));


            return inputRegToppings;

            //inputRegToppings.forEach(System.out::println);// way of listing
        }
    public static List<String> preTopping () {
        Scanner scan = new Scanner(System.in);


        System.out.println("Available meat toppings:\n Steak, Ham ,Salami, Roast Beef, Chicken, Bacon,");
        System.out.println("Available cheese toppings:\n American, Provolone ,Cheddar, Swiss");
        System.out.println("List the premium toppings you want: (comma-separated)");


        String input = scan.nextLine(); // to remove all whitespaces
        inputPreToppings = sandwich.userPremiumToppings(input.toLowerCase().replaceAll("\\s+", ""));


        return inputPreToppings;

        //inputRegToppings.forEach(System.out::println);// way of listing
    }
        public static List<String> sauces() {
        Scanner myScanner = new Scanner(System.in);
            System.out.println("Would you like any sauces? (Y/N)");
            String userSauceChoice = myScanner.next().trim().toUpperCase();
            List<String> sauceList = Arrays.asList(
                    "mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette"
            );
            if (userSauceChoice.equals("Y")) {
//                ArrayList<String> sauceList = new ArrayList<>();
//                sauceList.add("Mayo");
//                sauceList.add("Mustard");
//                sauceList.add("Ketchup");
//                sauceList.add("Ranch");
//                sauceList.add("Thousand Island");
//                sauceList.add("Vinaigrette");

                System.out.println("Here's our sauce list: " + sauceList);
                System.out.println("What sauces would you like to add?");
                System.out.println("Enter sauce choice: (comma-separated) ");
                String userSauceInput = myScanner.next().trim().toLowerCase().replaceAll("\\s+", "");

                List<String> userSauces = Arrays.asList(userSauceInput.split(","));


                userSauceList = sauceList.stream()
                        .filter(sauces -> userSauces.stream().anyMatch(sauces::contains))
                        .toList();


            }
            return userSauceList;
        }



        public static Drink wantsDrink () {
            System.out.println("Select the flavor of the drink:");
            System.out.println("  Coke");
            System.out.println("  Pepsi");
            System.out.println("  Sprite");
            System.out.print("Enter your choice: ");
            String drinkFlavor = scanner.next().trim().toLowerCase();

            System.out.println("Select the size of the drink:");
            System.out.println("  Small");
            System.out.println("  Medium");
            System.out.println("  Large");
            System.out.print("Enter your choice: ");
            String drinkSize = scanner.next().trim().toLowerCase();

            drink = new Drink(drinkSize, drinkFlavor, true);
            drink.setHasDrink(true);

            orders.add(drink);

//        String size = sandwichSize(drinkSize);
//        String flavor = flavor(drinkFlavor);
//
//        return size + " " + flavor + " Drink";
            System.out.println("Would you like to add anything else? (Y/N)");
            String answer = scanner.next().toUpperCase();
            if (answer.equals("Y")) {
                orderScreen();
            }

            else if (answer.equals("N")) {
                checkout();
            }
            return drink;
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

        public static Chips addChips () {
            System.out.println("ADD CHIPS");
            System.out.println("Select the type of chips:");
            System.out.println("  Plain");
            System.out.println("  BBQ");
            System.out.println("  Salt & Vinegar");
//        System.out.println("  No chips");
            System.out.print("Enter your choice: ");
            String chipChoice = scanner.next().trim().toLowerCase();

            chips = new Chips("", chipChoice, false);
            chips.setHasChips(true);

            orders.add(chips);

            System.out.println("Would you like to add anything else? (Y/N)");
            String answer = scanner.next().toUpperCase();
            if (answer.equals("Y")) {
                orderScreen();
            }

            else if (answer.equals("N")) {
                checkout();
            }
            return chips;
        }



    public static void checkout() {
        System.out.println("CHECKOUT");

        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }

        System.out.println("Order Details:");

        for (Order order : orders) {
            if (order instanceof SW && ((SW) order).isHasSandwich()) {
                System.out.println("Sandwich Details:");
                System.out.println("Bread Type: " + order.getType());
                System.out.println("Toasted: " + ((SW) order).isToasted());
                System.out.println("Size: " + order.getSize());
                System.out.println("Regular Toppings: " + inputRegToppings);
                System.out.println("Premium Toppings: " + inputPreToppings);
                System.out.println("Sauce: " + userSauceList);
                System.out.println("Price: $" + order.getPrice());

            } else if (order instanceof Drink && ((Drink) order).isHasDrink()) {
                System.out.println("Drink Details:");
                System.out.println("Type: " + order.getType());
                System.out.println("Size: " + order.getSize());
                System.out.println("Price: $" + order.getPrice());

            } else if (order instanceof Chips && ((Chips) order).isHasChips()) {
                System.out.println("Chips Details:");
                System.out.println("Type: " + order.getType());
                System.out.println("Price: $" + order.getPrice());
            }
        }

        //double totalCost = calculateTotalCost(orders);
        //System.out.println("Total Cost: $" + totalCost);

        System.out.println("Confirm or Cancel?");
        System.out.println("1) Confirm");
        System.out.println("2) Cancel");
        System.out.print("Enter your choice: ");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                createReceipt();
                System.out.println("Order confirmed. Creating receipt...");
                break;
            case "2":
                System.out.println("Order cancelled. Going back to HOME SCREEN.");
                homeScreen();
                break;
            default:
                System.out.println("Invalid choice. Going back to HOME SCREEN.");
                homeScreen();
                break;
        }
    }

//        public static void totalCost () {
//            for (Order o : orders) {
//                totalCost += o.getPrice();
////            double sandwichCost = sandwich.getPrice();
////            double drinkCost = drink.getPrice();
////            double chipsCost = chips.getPrice();
////
//////         return sandwichCost + drinkCost;
//////         return sandwichCost + drinkCost + chipsCost;
//////
////            totalCost =  sandwichCost + drinkCost + chipsCost;
////            return totalCost;
//            }
//        }
        public static void createReceipt () {
//            orderList.add(sandwich);
//            orderList.add(drink);
//            orderList.add(chips);


            Receipt receipt = new Receipt();
            receipt.generateReceipt();

            System.out.println("Receipt created.");
            System.out.println("Thanks, I guess");
            System.exit(0);
        }

    }




