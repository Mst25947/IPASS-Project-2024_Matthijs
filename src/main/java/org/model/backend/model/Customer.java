package org.model.backend.model;
public class Customer {
    private String name;
    private String adress;
    private String state;
    private String email;
    private String phone;
    private String password;
    private String customerId;

    public Customer(String name, String adress, String state, String email, String phone, String password, String customerId){
        this.name = name;
        this.adress = adress;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.customerId = customerId;
    }
}
