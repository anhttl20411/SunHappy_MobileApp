package com.example.sunhappy.models;

public class PreparingOrder {
    int preparingImage;
    String preparingName;
    double preparingPrice;

    //constructor

    public PreparingOrder(int preparingImage, String preparingName, double preparingPrice) {
        this.preparingImage = preparingImage;
        this.preparingName = preparingName;
        this.preparingPrice = preparingPrice;
    }

    //getter and setter

    public int getPreparingImage() {
        return preparingImage;
    }

    public void setPreparingImage(int preparingImage) {
        this.preparingImage = preparingImage;
    }

    public String getPreparingName() {
        return preparingName;
    }

    public void setPreparingName(String preparingName) {
        this.preparingName = preparingName;
    }

    public double getPreparingPrice() {
        return preparingPrice;
    }

    public void setPreparingPrice(double preparingPrice) {
        this.preparingPrice = preparingPrice;
    }
}
