package org.yuli;

public class FreeProduct extends Product{

    public FreeProduct(String name) {
        super(name, 0.0);
    }

    @Override
    public String toString() {
        return "FoodProduct{name: " + super.getName() +
                ", price=" + super.getPrice() +
                "%}";
    }
}
