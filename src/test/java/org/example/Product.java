package org.example;
import java.util.ArrayList;

public class Product {
    private static ArrayList<Product> allProducts = new ArrayList<Product>();
    private String productName;
    private String description;
    private int price;
    private String color;
    private String productType;

    public Product(String productName, String description, int price, String color, String productType){
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.color = color;
        this.productType = productType;
        allProducts.add(this);
    }
}
