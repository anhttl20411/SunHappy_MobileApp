package com.example.sunhappy.models;

public class ProductFavorite {
    int ProductThumb;
    String ProductName;
    double ProductPrice;

    public ProductFavorite(int productThumb, String productName, double productPrice) {
        ProductThumb = productThumb;
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public int getProductThumb() {
        return ProductThumb;

    }

    public void setProductThumb(int productId) {
        ProductThumb = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }
}
