package org.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {
    public void setUp() {
        Product.allProducts.clear();
    }

    @Test
    public void testProductCreation() {
        Product product = new Product("frontBumper3", "bumper", 250, "green", "frontBumper", "ST25");

        assertEquals("frontBumper3", product.getProductName());
        assertEquals("bumper", product.getDescription());
        assertEquals(250, product.getPrice());
        assertEquals("green", product.getColor());
        assertEquals("frontBumper", product.getProductType());
        assertEquals("ST25", product.getCarModel());
    }

    @Test
    public void testAllProductsList() {
        new Product("frontBumper1", "bumper", 200, "red", "frontBumper", "ST20");
        new Product("frontBumper2", "bumper", 200, "blue", "frontBumper", "ST23");

        assertEquals(2, Product.allProducts.size());

        Product product1 = Product.allProducts.get(0);
        Product product2 = Product.allProducts.get(1);

        assertEquals("frontBumper1", product1.getProductName());
        assertEquals("frontBumper2", product2.getProductName());
    }
}