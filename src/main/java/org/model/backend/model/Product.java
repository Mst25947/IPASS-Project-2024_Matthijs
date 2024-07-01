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
    public Product() {
    }

    public Product(String productName, String description, int price, String color, String productType, String carModel) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productType = productType;
        this.carModel = carModel;
        allProducts.add(this);
    }

    // Static om producten te initialiseren die de gebruiker kan selecteren op de webpagina.
    static {
        // Front bumpers:
        new Product("Varis Front Bumper", "High quality varis front bumper", 500, "Black", "frontBumper", "Celica ST20");
        new Product("c-one Front Bumper", "High quality c-one front bumper", 450, "Black", "frontBumper", "Celica ST20");
        new Product("Veilside Front Bumper", "High quality veilside front bumper", 350, "Black", "frontBumper", "Celica ST20");
        new Product("gt-4 Front Bumper", "High quality gt-4 front bumper", 750, "Black", "frontBumper", "Celica ST20");
        // Rear bumpers:
        new Product("c-one rear lip", "c-one rear lip", 210, "Blue", "rearBumper", "Celica ST20");
        new Product("TRD rear spats", "Official TRD rear spats", 115, "Blue", "rearBumper", "Celica ST20");
        new Product("Varis rear bumper", "Varis styled rear bumper", 300, "Blue", "rearBumper", "Celica ST20");
        // Sideskirts:
        new Product("TRD Side Skirts", "TRD Aerodynamic side skirts", 330, "White", "sideSkirt", "Celica ST20");
        new Product("c-one Side Skirts", "c-one side skirts", 320, "White", "sideSkirt", "Celica ST20");
        new Product("Mafanja Side Skirts", "Mafanja side skirts", 180, "White", "sideSkirt", "Celica ST20");
        new Product("Varis Side Skirts", "Varis side skirts", 280, "White", "sideSkirt", "Celica ST20");
        new Product("Zapt Side Skirts", "Zapt wide-body side skirts", 350, "White", "sideSkirt", "Celica ST20");
        new Product("OEM Side Skirts", "OEM+ side skirts", 220, "White", "sideSkirt", "Celica ST20");
        // Spoilers:
        new Product("TRD Spoiler", "TRD Enhanced spoiler for better downforce", 300, "Blue", "spoiler", "Celica ST20");
        new Product("gt-4 Spoiler", "gt-4 spoiler", 250, "Blue", "spoiler", "Celica ST20");
        new Product("HIRO spoiler", "HIRO aerodynamic racing wing", 420, "Blue", "spoiler", "Celica ST20");
        new Product("gt-4 riser blocks", "Riser blocks for gt-4 spoiler", 100, "Blue", "spoiler", "Celica ST20");
        // Splitters:
        new Product("TRD GP Splitter", "TRD Enhanced splitter for increased downforce", 150, "White", "splitter", "Celica ST20");
        new Product("Aero Splitter", "Performance Aero splitter for increased downforce", 100, "White", "splitter", "Celica ST20");
        // Diffusers:
        new Product("EndWorks Diffuser", "Diffuser made by EndWorks", 450, "Blue", "diffuser", "Celica ST20");
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

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public static void setAllProducts(ArrayList<Product> allProducts) {
        Product.allProducts = allProducts;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}