package com.pluralsight;

public class OtherProducts {
    private double sizePrice;
    private String drinkSize;
    private String drinkFlavor;
    private String chipType;
    private double chipPrice;
    private boolean hasChips;
    private boolean hasDrink;


    public OtherProducts(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public double getSizePrice(String drinkSize, boolean hasDrink) {
            if (drinkSize.equals("small")) {
                sizePrice = 2.00;

            } else if (drinkSize.equals("medium")) {
                sizePrice = 2.50;

            } else if (drinkSize.equals("large")) {
                sizePrice = 3.00;

            } else {
                System.out.println("Invalid");
            }
            if (!hasDrink) {
                sizePrice = 0.00;
            }
            return sizePrice;
        }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public String getChipType() {
        return chipType;
    }

    public double getChipPrice() {
        if (hasChips) {
            return 1.50;
        } else {
            return 0.00;
        }
    }
}
