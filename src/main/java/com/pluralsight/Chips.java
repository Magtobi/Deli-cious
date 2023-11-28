package com.pluralsight;

public class Chips extends Order{
    private boolean hasChips;

    public Chips(String size, String type, double price, boolean hasChips) {
        super(size, type, price);
        this.hasChips = hasChips;
    }

    public boolean isHasChips() {
        return hasChips;
    }

    public void setHasChips(boolean hasChips) {
        this.hasChips = hasChips;
    }

    @Override
    public double getPrice() {
        if (hasChips) {
            return 1.50;
        } else {
            return 0.00;
        }
    }
}
