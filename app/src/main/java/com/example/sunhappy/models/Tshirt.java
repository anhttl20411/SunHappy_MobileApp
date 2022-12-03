package com.example.sunhappy.models;

public class Tshirt {
    int tshirtImage;
    String tshirtName;
    double tshirtPrice;

    //constructor

    public Tshirt(int tshirtImage, String tshirtName, double tshirtPrice) {
        this.tshirtImage = tshirtImage;
        this.tshirtName = tshirtName;
        this.tshirtPrice = tshirtPrice;
    }

    //getter and setter

    public int getTshirtImage() {
        return tshirtImage;
    }

    public void setTshirtImage(int tshirtImage) {
        this.tshirtImage = tshirtImage;
    }

    public String getTshirtName() {
        return tshirtName;
    }

    public void setTshirtName(String tshirtName) {
        this.tshirtName = tshirtName;
    }

    public double getTshirtPrice() {
        return tshirtPrice;
    }

    public void setTshirtPrice(double tshirtPrice) {
        this.tshirtPrice = tshirtPrice;
    }
}
