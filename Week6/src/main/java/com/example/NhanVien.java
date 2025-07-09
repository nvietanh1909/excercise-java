package com.example;

import javafx.beans.property.*;

public class NhanVien {
    // Fields
    private SimpleStringProperty ma;
    private SimpleStringProperty ten;
    private SimpleStringProperty namsinh;
    private SimpleStringProperty songayLV;
    private SimpleFloatProperty luongCB;
    
    // Getters and Setters
    public String getMa() {
        return ma.get();
    }

    public void setMa(String ma) {
        this.ma.set(ma);
    }

    public String getTen() {
        return ten.get();
    }

    public void setTen(String ten) {
        this.ten.set(ten);
    }

    public String getNamsinh() {
        return namsinh.get();
    }

    public void setNamsinh(String namsinh) {
        this.namsinh.set(namsinh);
    }

    public String getSongayLV() {
        return songayLV.get();
    }

    public void setSongayLV(String songayLV) {
        this.songayLV.set(songayLV);
    }

    public float getLuongCB() {
        return luongCB.get();
    }

    public void setLuongCB(Float luongCB) {
        this.luongCB.set(luongCB);
    }

    public float TinhLuong() {
        return luongCB.get() * Integer.parseInt(songayLV.get());
    }

    // Constructor
    public NhanVien(String ma, String ten, String namsinh, String songayLV, Float luongCB) {
        this.ma = new SimpleStringProperty(ma);
        this.ten = new SimpleStringProperty(ten);
        this.namsinh = new SimpleStringProperty(namsinh);
        this.songayLV = new SimpleStringProperty(songayLV);
        this.luongCB = new SimpleFloatProperty(luongCB);
    }

    public NhanVien() {
        this.ma = new SimpleStringProperty();
        this.ten = new SimpleStringProperty();
        this.namsinh = new SimpleStringProperty();
        this.songayLV = new SimpleStringProperty();
        this.luongCB = new SimpleFloatProperty();
    }

   
}
