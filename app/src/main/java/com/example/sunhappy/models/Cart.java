package com.example.sunhappy.models;

public class Cart {
    int productThumb;
    String productName;
    double productPrice;

    public Cart(int productThumb, String productName, String productPrice) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productPrice = Double.parseDouble(productPrice);
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
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