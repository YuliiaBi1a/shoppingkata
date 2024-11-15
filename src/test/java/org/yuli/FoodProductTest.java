package org.yuli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {

    @Test
    @DisplayName("Food product with discount should have discounted price")
    void withDiscount() {
        FoodProduct foodProduct = new FoodProduct("jamon", 120.0);
        foodProduct.applyDiscountPercentage(15);
        assertEquals(120 - (120 * 0.15),
                foodProduct.getPrice(),
                "Expected price after 15% discount on 120.0 to be result of operation 120-(120*0.15) = 102.00"
        );
    }


    @Test
    @DisplayName("Food product with negative value of discount percentage should have discounted price")
    void withNegativeDiscountValue() {
        FoodProduct foodProduct = new FoodProduct("jamon", 120.0);
        foodProduct.applyDiscountPercentage(-15);
        assertEquals(102,
                foodProduct.getPrice(),
                "Expected price 102 after -15% discount, negative need to be converted on positive value"
        );
    }
}