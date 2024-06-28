package org.model.backend.model;

import java.util.ArrayList;

public class Product {
    public static ArrayList<Product> allProducts = new ArrayList<>();

    private String productName;
    private String description;
    private int price;
    private String color;
    private String productType;
    private String carModel;

    public Product(String productName, String description, int price, String color, String productType, String carModel) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.color = color;
        this.productType = productType;
        this.carModel = carModel;
        allProducts.add(this);
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getProductType() {
        return productType;
    }

    public String getCarModel() {
        return carModel;
    }
}