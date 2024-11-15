package org.yuli;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    @DisplayName("Add product to the cart")
    void canAddProductToList() {
        Cart cart = new Cart();
        Product product = new FreeProduct("Parsley");
        cart.addProduct(product);

        assertEquals(1, cart.getProductList().size(), "Expected cart to have one product after adding a product");
        assertTrue(cart.getProductList().contains(product), "Expected product to be in the cart after adding");
    }

    @Test
    @DisplayName("Not add repeat product to the cart")
    void notAddRepeatProductToList() {
        Cart cart = new Cart();
        Product popcorn = new FreeProduct("PopCorn");
        Product jamon = new FreeProduct("Jamon");
        cart.addProduct(popcorn);
        cart.addProduct(jamon);
        cart.addProduct(popcorn);

        assertEquals(2, cart.getProductList().size(), "Expected cart to have two products after adding a popcorn and jamon");
    }


    @Test
    @DisplayName("Need to show only one product in the card")
    void canDeleteProductFromList() {
        Cart cart = new Cart();
        FoodProduct foodProduct = new FoodProduct("Pizza", 10);
        FreeProduct freeProduct = new FreeProduct("Perejil");
        cart.addProduct(foodProduct);
        cart.addProduct(freeProduct);

        List<Product> products = cart.getProductList();

        cart.deleteByName("Perejil");
        assertEquals(1, products.size());
        assertEquals(foodProduct, products.getFirst());
    }

    @Test
    @DisplayName("Need to show the total price (with discount o without) of all products that have been added to the cart")
    void calcTotalPriceOfProducts() {
        Cart cart = new Cart();
        FoodProduct pizza = new FoodProduct("Pizza", 10);
        Product sushi = new FoodProduct("Sushi", 10);
        Product perejil = new FreeProduct("Perejil");

        pizza.applyDiscountPercentage(50);

        cart.addProduct(pizza);
        cart.addProduct(sushi);
        cart.addProduct(perejil);

        assertEquals(15, cart.totalPrice());
    }
}


