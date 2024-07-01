package org.model.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
    private String brand;
    private String type;
    private String color;
    private boolean frontBumper;
    private boolean rearBumper;
    private boolean sideSkirt;
    private boolean spoiler;
    private boolean frontLip;
    private boolean splitter;
    private boolean diffuser;

    private static List<Car> allCars = new ArrayList<>();

    public Car(String brand, String type, String color, boolean frontBumper, boolean rearBumper, boolean sideSkirt, boolean spoiler, boolean frontLip, boolean splitter, boolean diffuser) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.frontBumper = frontBumper;
        this.rearBumper = rearBumper;
        this.sideSkirt = sideSkirt;
        this.spoiler = spoiler;
        this.frontLip = frontLip;
        this.splitter = splitter;
        this.diffuser = diffuser;
        allCars.add(this);
    }
    //Er worden hier een aantal Auto objecten geinitialiseerd zodat deze geselecteerd kunnen worden door de gebruiker op de webppagina.
    static {
        new Car("Toyota", "Celica T23", "Red", true, true, true, true, true, false, false);
        new Car("Toyota", "Celica ST20", "Blue", true, true, true, true, false, true, true);
        new Car("Toyota", "Celica ST18", "Black", true, true, true, false, true, false, false);
        new Car("Toyota", "GT-86", "Yellow", true, true, false, true, true, true, true);
    }

    public static void setAllCars(List<Car> allCars) {
        Car.allCars = allCars;
    }

    public static List<Car> getAllCars(){
        return allCars;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDiffuser(boolean diffuser) {
        this.diffuser = diffuser;
    }

    public void setFrontBumper(boolean frontBumper) {
        this.frontBumper = frontBumper;
    }

    public void setFrontLip(boolean frontLip) {
        this.frontLip = frontLip;
    }

    public void setRearBumper(boolean rearBumper) {
        this.rearBumper = rearBumper;
    }

    public void setSideSkirt(boolean sideSkirt) {
        this.sideSkirt = sideSkirt;
    }

    public void setSplitter(boolean splitter) {
        this.splitter = splitter;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDiffuser() {
        return diffuser;
    }

    public boolean isFrontBumper() {
        return frontBumper;
    }

    public boolean isFrontLip() {
        return frontLip;
    }

    public boolean isRearBumper() {
        return rearBumper;
    }

    public boolean isSideSkirt() {
        return sideSkirt;
    }

    public boolean isSplitter() {
        return splitter;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public static void addCar(Car car) {
        allCars.add(car);
    }

}