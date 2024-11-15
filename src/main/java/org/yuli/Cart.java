package org.yuli;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product)) {
            this.productList.add(product);
        }
    }

    public void deleteByName(String name) {
        productList.removeIf(product -> product.getName().equals(name));
    }

    public double totalPrice() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productList=" + productList +
                '}';
    }
}
