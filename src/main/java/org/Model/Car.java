package org.Model;
import java.util.Date;

public class Car {
    private String brand;
    private String type;
    private String color;
    private boolean frontBumper;
    private boolean rearBumper;
    private boolean sideSkirt;
    private boolean spoiler;

    public Car(String brand, String type, String color, boolean frontBumper, boolean rearBumper, boolean sideSkirt, boolean spoiler){
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.frontBumper = frontBumper;
        this.rearBumper = rearBumper;
        this.sideSkirt = sideSkirt;
        this.spoiler = spoiler;
    }
}

