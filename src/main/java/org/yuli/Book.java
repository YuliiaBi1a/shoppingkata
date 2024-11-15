package org.yuli;

public class Book extends Product implements Discountable {
    private String author;
    private String description;
    private double discountPercentage;

    public Book(String name, double price, String author, String description) {
        super(name, price);
        this.author = author;
        this.description = description;
        this.discountPercentage = 0;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public void applyDiscountPercentage(double discountPercentage) {
        if (discountPercentage > 10) {
            throw new IllegalArgumentException("Discount percentage cannot be greater than 10%");
        }
        this.discountPercentage = Math.abs(discountPercentage);
    }

    @Override
    public double getPrice() {
        return super.getPrice() - (super.getPrice() / 100 * this.discountPercentage);
    }
}
