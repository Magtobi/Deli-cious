package com.pluralsight;

public class Drink extends Order{
    private boolean hasDrink;

    public Drink(String size, String type, boolean hasDrink) {
        super(size, type);
        this.hasDrink = hasDrink;
    }

    public boolean isHasDrink() {
        return hasDrink;
    }

    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }
    public double getPrice(){
        switch (getSize()) {
            case "small" -> price = 2.00;
            case "medium" -> price = 2.50;
            case "large" -> price = 3.00;
            default -> System.out.println("Invalid");
        }
        if (!hasDrink) {
            price = 0.00;
        }
        return price;
    }
}
