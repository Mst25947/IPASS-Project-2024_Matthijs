package org.model.backend.model;

public class Car {
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

    public Car(String brand, String type, String color, boolean frontBumper, boolean rearBumper, boolean sideSkirt, boolean spoiler, boolean frontLip, boolean splitter, boolean diffuser){
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
    }

    // Getters for all attributes
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public boolean isFrontBumper() {
        return frontBumper;
    }

    public boolean isRearBumper() {
        return rearBumper;
    }

    public boolean isSideSkirt() {
        return sideSkirt;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public boolean isFrontLip() {
        return frontLip;
    }

    public boolean isSplitter() {
        return splitter;
    }

    public boolean isDiffuser() {
        return diffuser;
    }
}