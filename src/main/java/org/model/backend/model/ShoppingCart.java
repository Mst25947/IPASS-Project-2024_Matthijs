package org.model.backend.model;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private ArrayList<Product> products;
    private String name;
    private String email;
    private float totalPrice;
    public static List<ShoppingCart> allShoppingCarts = new ArrayList<>();

    public ShoppingCart(){
    }
    public ShoppingCart(String name, String email, float totalPrice){
        this.name = name;
        this.email = email;
        this.totalPrice = totalPrice;
        allShoppingCarts.add(this);
    }

    public static List<ShoppingCart> getAllShoppingCarts() {
        return allShoppingCarts;
    }

    public static void setAllShoppingCards(List<ShoppingCart> allShoppingCards) {
        ShoppingCart.allShoppingCarts = allShoppingCards;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    //Methode om de totaalprijs van de winkelwagen te berekenen.
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}