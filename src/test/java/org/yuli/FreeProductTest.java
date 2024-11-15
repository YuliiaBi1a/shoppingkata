package org.yuli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FreeProductTest {

    @Test
    @DisplayName("Need to show price 0.0")
    void calcPrice() {
        FreeProduct freeProduct = new FreeProduct("milk");
        assertEquals(0.0, freeProduct.getPrice(), "Need to show price 0.0");
    }
}