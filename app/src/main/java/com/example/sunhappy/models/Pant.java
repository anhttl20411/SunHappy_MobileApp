package com.example.sunhappy.models;

public class Pant {
    int pantImage;
    String pantName;
    double pantPrice;

    //constructor

    public Pant(int pantImage, String pantName, double pantPrice) {
        this.pantImage = pantImage;
        this.pantName = pantName;
        this.pantPrice = pantPrice;
    }

    //getter and getter

    public int getPantImage() {
        return pantImage;
    }

    public void setPantImage(int pantImage) {
        this.pantImage = pantImage;
    }

    public String getPantName() {
        return pantName;
    }

    public void setPantName(String pantName) {
        this.pantName = pantName;
    }

    public double getPantPrice() {
        return pantPrice;
    }

    public void setPantPrice(double pantPrice) {
        this.pantPrice = pantPrice;
    }
}
