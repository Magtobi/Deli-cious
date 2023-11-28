package com.pluralsight;

import java.util.Arrays;
import java.util.List;

public class SW extends Order{
    private boolean toasted;
    private double sizePrice;
    private double meatPrice;
    private double cheesePrice;
    private boolean extraMeat;
    private double extraMeatPrice;
    private boolean extraCheese;
    private double extraCheesePrice;

    public SW(String size, String type, double price, boolean toasted) {
        super(size, type, price);
        this.toasted = toasted;
    }

    public double getSizePrice(String size) {
        if (size.equals("4")) {
            sizePrice = 5.50;

        } else if (size.equals("8")) {
            sizePrice = 7.00;

        } else if (size.equals("12")) {
            sizePrice = 8.50;

        } else {
            System.out.println("Invalid");
        }
        return sizePrice;
    }

    public double getMeatPrice(String size, boolean extraMeat, double extraMeatPrice) {
        if (size.equals("4")) {
            meatPrice = 1.00;
            extraMeatPrice = 0.50;

        } else if (size.equals("8")) {
            meatPrice = 2.00;
            extraMeatPrice = 1.00;

        } else if (size.equals("12")) {
            meatPrice = 3.00;
            extraMeatPrice = 1.50;

        } else {
            System.out.println("Invalid");
        }
        if (extraMeat) {
            return meatPrice += extraMeatPrice;
        }
        return meatPrice;
    }

    public double getCheesePrice(String size, boolean extraCheese, double extraCheesePrice) {
        if (size.equals("4")) {
            cheesePrice = 0.75;
            extraCheesePrice = 0.30;

        } else if (size.equals("8")) {
            cheesePrice = 1.50;
            extraCheesePrice = 0.60;

        } else if (size.equals("12")) {
            cheesePrice = 2.25;
            extraCheesePrice = 0.90;

        } else {
            System.out.println("Invalid");
        }
        if (extraCheese) {
            return cheesePrice += extraCheesePrice;
        }
        return cheesePrice;
    }
    @Override
    public double getPrice () {
        price = getSizePrice(size) + getCheesePrice(size, extraCheese, extraCheesePrice) + getMeatPrice(size, extraMeat, extraMeatPrice);
        return price;
    }
    public static final List<String> regularToppings = Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers",
            "pickles", "guacamole", "mushrooms"
    );
    public void userRegToppings(String input) {

        List<String> userToppings = Arrays.asList(input.split(","));


        List<String> filteredList = regularToppings.stream()
                .filter(topping -> userToppings.stream().anyMatch(topping::contains))
                .toList();
        System.out.println(filteredList);

    }
    public static final List<String> premiumToppings = Arrays.asList(
            "steak", "ham", "salami", "roast beef", "chicken", "bacon",
            "american", "provolone", "cheddar", "swiss"
    );
    public void userPremiumToppings(String input) {

        List<String> userToppings = Arrays.asList(input.split(","));


        List<String> filteredList = premiumToppings.stream()
                .filter(topping -> userToppings.stream().anyMatch(topping::contains))
                .toList();
        System.out.println(filteredList);

    }
}
