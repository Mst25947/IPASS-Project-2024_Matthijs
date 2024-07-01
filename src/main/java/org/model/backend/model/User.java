package org.model.backend.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String address; // Corrected spelling
    private String email;
    private String phoneNumber;
    private String password;
    private String userId;
    private ShoppingCart myShoppingCart;
    public static List<User> allUsers = new ArrayList<>();

    public User() {
    }

    public User(String name, String address, String email, String phoneNumber, String password, String userId) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userId = userId;
        this.myShoppingCart = null;
        allUsers.add(this);
    }

    //Een testuser wordt standaard geinitialiseerd bij launch.
    static User testUser = new User("Test User", "Teststraat 1", "test@gmail.com", "06-12345678", "test123", "1");

    public static User getTestUser() {
        return testUser;
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(List<User> allUsers) {
        User.allUsers = allUsers;
    }

    public void setMyShoppingCart(ShoppingCart myShoppingCart) {
        this.myShoppingCart = myShoppingCart;
    }

    public ShoppingCart getMyShoppingCart() {
        return myShoppingCart;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() { // Corrected spelling
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) { // Corrected spelling
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void setTestUser(User testUser) {
        User.testUser = testUser;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    //Een make-shift authenticatie methode voor de loginResource.
    public static User findUserByNameAndPassword(String name, String password) {
        for (User user : allUsers) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}