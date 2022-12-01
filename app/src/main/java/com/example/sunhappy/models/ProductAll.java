package com.example.sunhappy.models;

import java.sql.Blob;

public class ProductAll {
    int productId;
    Blob productImage;
    String productName;
    double productPrice;
    String productDescription;

    //constructor


    public ProductAll(int productId, Blob productImage, String productName, double productPrice, String productDescription) {
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }


    //getter and setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Blob getProductImage() {
        return productImage;
    }

    public void setProductImage(Blob productImage) {
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
