package com.example.sunhappy.models;

public class Short {
    int shortImage;
    String shortName;
    double shortPrice;

    //constructor

    public Short(int shortImage, String shortName, double shortPrice) {
        this.shortImage = shortImage;
        this.shortName = shortName;
        this.shortPrice = shortPrice;
    }

    //getter and setter

    public int getShortImage() {
        return shortImage;
    }

    public void setShortImage(int shortImage) {
        this.shortImage = shortImage;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public double getShortPrice() {
        return shortPrice;
    }

    public void setShortPrice(double shortPrice) {
        this.shortPrice = shortPrice;
    }
}
