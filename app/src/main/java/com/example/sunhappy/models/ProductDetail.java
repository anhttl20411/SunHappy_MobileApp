package com.example.sunhappy.models;

public class ProductDetail {
    int productDetailThumb;
    String productDetailName;
    double productDetailPrice;

    //constructor

    public ProductDetail(int productDetailThumb, String productDetailName, double productDetailPrice) {
        this.productDetailThumb = productDetailThumb;
        this.productDetailName = productDetailName;
        this.productDetailPrice = productDetailPrice;
    }


    //getter and setter


    public int getProductDetailThumb() {
        return productDetailThumb;
    }

    public void setProductDetailThumb(int productDetailThumb) {
        this.productDetailThumb = productDetailThumb;
    }

    public String getProductDetailName() {
        return productDetailName;
    }

    public void setProductDetailName(String productDetailName) {
        this.productDetailName = productDetailName;
    }

    public double getProductDetailPrice() {
        return productDetailPrice;
    }

    public void setProductDetailPrice(double productDetailPrice) {
        this.productDetailPrice = productDetailPrice;
    }
}
