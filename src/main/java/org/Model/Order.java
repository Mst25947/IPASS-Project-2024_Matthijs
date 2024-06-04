package org.Model;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int orderNumber;
    private int customerId;
    private Date orderDate;
    private ArrayList<Product> orderedProducts;
    private int totalAmount;

    public Order(int orderNumber, int customerId, Date orderDate, ArrayList<String> orderedProducts, int totalAmount) {
        this.orderNumber = orderNumber;
        this.customerId = customerId;
        this.orderedProducts = new ArrayList<Product>();
        this.totalAmount = totalAmount;
    }
}
