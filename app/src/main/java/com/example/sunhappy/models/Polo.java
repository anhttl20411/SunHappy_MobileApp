package com.example.sunhappy.models;

public class Polo {
    int poloImage;
    String poloName;
    double poloPrice;

    //constructor

    public Polo(int poloImage, String poloName, double poloPrice) {
        this.poloImage = poloImage;
        this.poloName = poloName;
        this.poloPrice = poloPrice;
    }

    //getter and setter

    public int getPoloImage() {
        return poloImage;
    }

    public void setPoloImage(int poloImage) {
        this.poloImage = poloImage;
    }

    public String getPoloName() {
        return poloName;
    }

    public void setPoloName(String poloName) {
        this.poloName = poloName;
    }

    public double getPoloPrice() {
        return poloPrice;
    }

    public void setPoloPrice(double poloPrice) {
        this.poloPrice = poloPrice;
    }
}
