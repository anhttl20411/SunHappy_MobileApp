package com.example.sunhappy.models;

public class TopProduct {
    int topProductImage;
    String topProductName;
    double topProductPrice;

    //constructor

    public TopProduct(int topProductImage, String topProductName, double topProductPrice) {
        this.topProductImage = topProductImage;
        this.topProductName = topProductName;
        this.topProductPrice = topProductPrice;
    }


    //getter and setter

    public int getTopProductImage() {
        return topProductImage;
    }

    public void setTopProductImage(int topProductImage) {
        this.topProductImage = topProductImage;
    }

    public String getTopProductName() {
        return topProductName;
    }

    public void setTopProductName(String topProductName) {
        this.topProductName = topProductName;
    }

    public double getTopProductPrice() {
        return topProductPrice;
    }

    public void setTopProductPrice(double topProductPrice) {
        this.topProductPrice = topProductPrice;
    }
}
