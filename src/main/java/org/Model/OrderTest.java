package org.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

public class OrderTest {

    private ArrayList<Product> orderedProducts;

    @BeforeEach
    public void setUp() {
        orderedProducts = new ArrayList<>();
        orderedProducts.add(new Product("frontBumper1", "bumper", 200, "red", "frontBumper", "ST20"));
        orderedProducts.add(new Product("frontBumper2", "bumper", 200, "blue", "frontBumper", "ST23"));
    }

    @Test
    public void testOrderCreation() {
        Date orderDate = new Date();
        Order order = new Order(1, 123, orderDate, orderedProducts, 400);

        assertEquals(1, order.getOrderNumber());
        assertEquals(123, order.getCustomerId());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(2, order.getOrderedProducts().size());
        assertEquals("frontBumper1", order.getOrderedProducts().get(0).getProductName());
        assertEquals("frontBumper2", order.getOrderedProducts().get(1).getProductName());
        assertEquals(400, order.getTotalAmount());
    }

    @Test
    public void testOrderFieldsNotNull() {
        Date orderDate = new Date();
        Order order = new Order(2, 456, orderDate, orderedProducts, 500);

        assertNotNull(order.getOrderNumber());
        assertNotNull(order.getCustomerId());
        assertNotNull(order.getOrderDate());
        assertNotNull(order.getOrderedProducts());
        assertNotNull(order.getTotalAmount());
    }
}