package org.model.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactForm implements Serializable {
    private String name;
    private String email;
    private String message;
    public static List<ContactForm> allContactForms = new ArrayList<>();

    public ContactForm(){
    }
    public ContactForm(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public static List<ContactForm> getAllContactForms() {
        return allContactForms;
    }

    public static void setAllContactForms(List<ContactForm> allContactForms) {
        ContactForm.allContactForms = allContactForms;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}



