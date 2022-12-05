package com.example.sunhappy.models;

public class DeliveredOrder {
    int deliveredImage;
    String deliveredName;
    double deliveredPrice;

    public DeliveredOrder(int deliveredImage, String deliveredName, double deliveredPrice) {
        this.deliveredImage = deliveredImage;
        this.deliveredName = deliveredName;
        this.deliveredPrice = deliveredPrice;
    }

    public int getDeliveredImage() {
        return deliveredImage;
    }

    public void setDeliveredImage(int deliveredImage) {
        this.deliveredImage = deliveredImage;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public double getDeliveredPrice() {
        return deliveredPrice;
    }

    public void setDeliveredPrice(double deliveredPrice) {
        this.deliveredPrice = deliveredPrice;
    }
}
