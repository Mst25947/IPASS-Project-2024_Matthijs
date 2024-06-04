package org.Model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int orderNumber;
    private int customerId;
    private Date orderDate;
    private ArrayList<Product> orderedProducts;
    private int totalAmount;

    public Order(int orderNumber, int customerId, Date orderDate, ArrayList<Product> orderedProducts, int totalAmount) {
        this.orderNumber = orderNumber;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderedProducts = new ArrayList<>(orderedProducts);
        this.totalAmount = totalAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public ArrayList<Product> getOrderedProducts() {
        return new ArrayList<>(orderedProducts);
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}