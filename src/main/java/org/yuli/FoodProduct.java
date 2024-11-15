package org.yuli;

public class FoodProduct extends Product implements Discountable {

    private double discountPercentage;

    public FoodProduct(String name, double price) {
        super(name, price);
        this.discountPercentage = 0;
    }

    @Override
    public void applyDiscountPercentage(double discountPercentage) {
        this.discountPercentage = Math.abs(discountPercentage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() - (super.getPrice() / 100 * this.discountPercentage);
    }

    @Override
    public String toString() {
        return "FoodProduct{name: " + super.getName() +
                ", price=" + super.getPrice() +
                ", percentage of discount=" + discountPercentage +
                "%}";
    }
}
