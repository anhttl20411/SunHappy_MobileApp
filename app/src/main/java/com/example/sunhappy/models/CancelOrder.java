package com.example.sunhappy.models;

public class CancelOrder {
    int cancelImage;
    String cancelName;
    double cancelPrice;

    public CancelOrder(int cancelImage, String cancelName, double cancelPrice) {
        this.cancelImage = cancelImage;
        this.cancelName = cancelName;
        this.cancelPrice = cancelPrice;
    }

    public int getCancelImage() {
        return cancelImage;
    }

    public void setCancelImage(int cancelImage) {
        this.cancelImage = cancelImage;
    }

    public String getCancelName() {
        return cancelName;
    }

    public void setCancelName(String cancelName) {
        this.cancelName = cancelName;
    }

    public double getCancelPrice() {
        return cancelPrice;
    }

    public void setCancelPrice(double cancelPrice) {
        this.cancelPrice = cancelPrice;
    }
}
