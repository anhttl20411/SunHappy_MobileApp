package com.example.sunhappy.models;

public class OrderPreparing {
    public String ProductNamePreparing;
    public String ProductClassifyPreparing;
    public String ProductSizePreparing;
    public Integer ProductAmountPreparing;
    public Integer ProductPricePreparing;
    public int ProductImage;
//Tạo constructor
    public OrderPreparing(String productNamePreparing, String productClassifyPreparing, String productSizePreparing, Integer productAmountPreparing, Integer productPricePreparing, int productImage) {
        ProductNamePreparing = productNamePreparing;
        ProductClassifyPreparing = productClassifyPreparing;
        ProductSizePreparing = productSizePreparing;
        ProductAmountPreparing = productAmountPreparing;
        ProductPricePreparing = productPricePreparing;
        ProductImage = productImage;
    }
//Getter setter
    public String getProductNamePreparing() {
        return ProductNamePreparing;
    }

    public void setProductNamePreparing(String productNamePreparing) {
        ProductNamePreparing = productNamePreparing;
    }

    public String getProductClassifyPreparing() {
        return ProductClassifyPreparing;
    }

    public void setProductClassifyPreparing(String productClassifyPreparing) {
        ProductClassifyPreparing = productClassifyPreparing;
    }

    public String getProductSizePreparing() {
        return ProductSizePreparing;
    }

    public void setProductSizePreparing(String productSizePreparing) {
        ProductSizePreparing = productSizePreparing;
    }

    public Integer getProductAmountPreparing() {
        return ProductAmountPreparing;
    }

    public void setProductAmountPreparing(Integer productAmountPreparing) {
        ProductAmountPreparing = productAmountPreparing;
    }

    public Integer getProductPricePreparing() {
        return ProductPricePreparing;
    }

    public void setProductPricePreparing(Integer productPricePreparing) {
        ProductPricePreparing = productPricePreparing;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }
}

