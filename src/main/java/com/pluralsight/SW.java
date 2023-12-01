package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.pluralsight.Main.swSize;

public class SW extends Order{
    public static boolean hasSandwich;
    private boolean toasted;
    private double sizePrice;
    private double meatPrice;
    private double cheesePrice;
    private boolean extraMeat;
    private double extraMeatPrice;
    private boolean extraCheese;
    private double extraCheesePrice;
    private boolean hasMeat;
    private boolean hasCheese;
    private List<String> selectedRegularToppings;
    private List<String> selectedPremiumToppings;

    public boolean isHasSandwich() {
        return hasSandwich;
    }

    public void setHasSandwich(boolean hasSandwich) {
        this.hasSandwich = hasSandwich;
    }

    public boolean isHasMeat() {
        return hasMeat;
    }

    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }

    public boolean isHasCheese() {
        return hasCheese;
    }

    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    public void addRegularTopping(String topping) {
        if (regularToppings.contains(topping)) {
            selectedRegularToppings.add(topping);
        }
    }

    public void addPremiumTopping(String topping) {
        if (premiumToppings.contains(topping)) {
            selectedPremiumToppings.add(topping);
        }
    }

    public SW(String size, String type, boolean toasted) {
        super(size, type);
        this.toasted = toasted;
        this.selectedRegularToppings = new ArrayList<>();
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<String> getSelectedRegularToppings() {
        return selectedRegularToppings;
    }

    public void setSelectedRegularToppings(List<String> selectedRegularToppings) {
        this.selectedRegularToppings = selectedRegularToppings;
    }

    public List<String> getSelectedPremiumToppings() {
        return selectedPremiumToppings;
    }

    public void setSelectedPremiumToppings(List<String> selectedPremiumToppings) {
        this.selectedPremiumToppings = selectedPremiumToppings;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }

    public double getSizePrice() {
        if (getSize().equals("4\"")) {
            sizePrice = 5.50;

        } else if (getSize().equals("8\"")) {
            sizePrice = 7.00;

        } else if (getSize().equals("12\"")) {
            sizePrice = 8.50;

        } else {
            System.out.println("Invalid");
        }
        return sizePrice;
    }

    public double getMeatPrice() {
        if(isHasMeat()){
        if (getSize().equals("4\"")) {
            meatPrice = 1.00;
            extraMeatPrice = 0.50;

        } else if (getSize().equals("8\"")) {
            meatPrice = 2.00;
            extraMeatPrice = 1.00;

        } else if (getSize().equals("12\"")) {
            meatPrice = 3.00;
            extraMeatPrice = 1.50;

        } else {
            System.out.println("Invalid");
        }
        if (extraMeat) {
            return meatPrice += extraMeatPrice;
        }}
        else{meatPrice = 0;}
        return meatPrice;
    }

    public double getCheesePrice() {
        if(isHasCheese()){
        if (getSize().equals("4\"")) {
            cheesePrice = 0.75;
            extraCheesePrice = 0.30;

        } else if (getSize().equals("8\"")) {
            cheesePrice = 1.50;
            extraCheesePrice = 0.60;

        } else if (getSize().equals("12\"")) {
            cheesePrice = 2.25;
            extraCheesePrice = 0.90;

        } else {
            System.out.println("Invalid");
        }
        if (extraCheese) {
            return cheesePrice += extraCheesePrice;
        }}else { cheesePrice = 0;}
        return cheesePrice;
    }
    @Override
    public double getPrice () {
        if (isHasSandwich()) {
            price = getSizePrice() + getCheesePrice() + getMeatPrice();
        } else {
            price = 0.00;
        }
        return price;
    }
    public static final List<String> regularToppings = Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers",
            "pickles", "guacamole", "mushrooms"
    );
    public List<String> userRegToppings(String input) {

        List<String> userToppings = Arrays.asList(input.split(","));


        List<String> filteredList = regularToppings.stream()
                .filter(topping -> userToppings.stream().anyMatch(topping::contains))
                .toList();
        setSelectedRegularToppings(filteredList);
        return filteredList;

    }
    public static final List<String> premiumToppings = Arrays.asList(
            "steak", "ham", "salami", "roast beef", "chicken", "bacon",
            "american", "provolone", "cheddar", "swiss"
    );
    public List<String> userPremiumToppings(String input) {

        List<String> userToppings = Arrays.asList(input.split(","));


        List<String> filteredList = premiumToppings.stream()
                .filter(topping -> userToppings.stream().anyMatch(topping::contains))
                .toList();
        return filteredList;

        //System.out.println(filteredList);

    }
}
