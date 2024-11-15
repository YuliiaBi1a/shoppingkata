package org.yuli;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    @DisplayName("Book creation with correct name, price, author, and description")
    public void testBookCreation() {
        Book book = new Book("Java", 50.0, "J.B.", "A comprehensive guide to programming in Java");
        assertEquals("Java", book.getName());
        assertEquals(50.0, book.getPrice());
        assertEquals("J.B.", book.getAuthor());
        assertEquals("A comprehensive guide to programming in Java", book.getDescription());
    }

    @Test
    @DisplayName("Apply a discount of 10% successfully and verify the updated price")
    public void testApplyDiscountWithinLimit() {
        Book book = new Book("Clean Code", 40.0, "Robert C. Martin", "A book about writing cleaner code");
        book.applyDiscountPercentage(10);
        assertEquals(36.0, book.getPrice(), 0.01); // Price should be 40 - (40 * 10%) = 36
    }

    @Test
    @DisplayName("Attempt to apply a discount greater than 10% throws IllegalArgumentException")
    public void testApplyDiscountExceedingLimit() {
        Book book = new Book("The Pragmatic Programmer", 30.0, "Andrew Hunt", "A guide to modern software development");
        assertThrows(IllegalArgumentException.class, () -> {
            book.applyDiscountPercentage(15);
        });
    }

    @Test
    @DisplayName("Apply a negative discount, which should be converted to a positive discount")
    public void testApplyNegativeDiscount() {
        Book book = new Book("Refactoring", 60.0, "Martin Fowler", "Improving the design of existing code");
        book.applyDiscountPercentage(-5);
        assertEquals(57.0, book.getPrice(), 0.01); // Price should be 60 - (60 * 5%) = 57
    }

    @Test
    @DisplayName("Verify that the price remains unchanged when no discount is applied")
    public void testNoDiscountApplied() {
        Book book = new Book("Design Patterns", 70.0, "Erich Gamma", "Elements of reusable object-oriented software");
        assertEquals(70.0, book.getPrice());
    }
}
