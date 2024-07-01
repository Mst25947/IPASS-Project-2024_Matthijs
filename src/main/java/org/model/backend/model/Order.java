package org.model.backend.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private String customerEmail;
    private int orderId;
    private List<Product> orderedProducts;
    private float totalPrice;
    private static List<Order> allOrders = new ArrayList<>();
    public Order(String name, String email, float totalPrice, List<Product> products){
    }

    public Order(String customerName, String customerEmail, int orderId, List<Product> orderedProducts, float totalPrice) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderId = orderId;
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        allOrders.add(this);
    }

    public static List<Order> getAllOrders() {
        return allOrders;
    }

    public static void setAllOrders(List<Order> allOrders) {
        Order.allOrders = allOrders;
    }

    public static void addOrder(Order order) {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderId=" + orderId +
                ", orderedProducts=" + orderedProducts +
                ", totalPrice=" + totalPrice +
                '}';
    }
}