package com.example.sunhappy.models;

public class Shirt {
    int shirtImage;
    String shirtName;
    double shirtPrice;

    //constructor

    public Shirt(int shirtImage, String shirtName, double shirtPrice) {
        this.shirtImage = shirtImage;
        this.shirtName = shirtName;
        this.shirtPrice = shirtPrice;
    }

    //getter and setter

    public int getShirtImage() {
        return shirtImage;
    }

    public void setShirtImage(int shirtImage) {
        this.shirtImage = shirtImage;
    }

    public String getShirtName() {
        return shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public double getShirtPrice() {
        return shirtPrice;
    }

    public void setShirtPrice(double shirtPrice) {
        this.shirtPrice = shirtPrice;
    }
}
