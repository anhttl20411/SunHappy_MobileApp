package com.example.sunhappy.models;

public class Address {
    String Ten,SDT,Tinh,Huyen,Xa,Duong;


    public Address(String ten, String SDT, String tinh, String huyen, String xa, String duong) {
        Ten = ten;
        this.SDT = SDT;
        Tinh = tinh;
        Huyen = huyen;
        Xa = xa;
        Duong = duong;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String tinh) {
        Tinh = tinh;
    }

    public String getHuyen() {
        return Huyen;
    }

    public void setHuyen(String huyen) {
        Huyen = huyen;
    }

    public String getXa() {
        return Xa;
    }

    public void setXa(String xa) {
        Xa = xa;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String duong) {
        Duong = duong;
    }
}
