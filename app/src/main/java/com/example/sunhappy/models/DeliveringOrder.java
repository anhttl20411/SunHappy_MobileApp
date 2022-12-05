package com.example.sunhappy.models;

public class DeliveringOrder {
    int deliveringImage;
    String deliveringName;
    double deliveringPrice;

    public DeliveringOrder(int deliveringImage, String deliveringName, double deliveringPrice) {
        this.deliveringImage = deliveringImage;
        this.deliveringName = deliveringName;
        this.deliveringPrice = deliveringPrice;
    }

    public int getDeliveringImage() {
        return deliveringImage;
    }

    public void setDeliveringImage(int deliveringImage) {
        this.deliveringImage = deliveringImage;
    }

    public String getDeliveringName() {
        return deliveringName;
    }

    public void setDeliveringName(String deliveringName) {
        this.deliveringName = deliveringName;
    }

    public double getDeliveringPrice() {
        return deliveringPrice;
    }

    public void setDeliveringPrice(double deliveringPrice) {
        this.deliveringPrice = deliveringPrice;
    }
}