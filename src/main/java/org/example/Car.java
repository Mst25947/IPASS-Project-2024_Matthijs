package org.example;
import java.util.Date;

public class Car {
    private String brand;

    private String type;
    private Date productionYear;
    private String color;

    public Car(String brand, String type, Date productionYear, String color){
        this.brand = brand;
        this.type = type;
        this.productionYear = productionYear;
        this.color = color;
    }
}

