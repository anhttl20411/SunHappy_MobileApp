package com.example.sunhappy.models;

import java.sql.Blob;

public class ProductAll {
    int productImage;
    String productName;
    double productPrice;

    //constructor

    public ProductAll(int productImage, String productName, double productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }


    //getter and setter

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
