package com.app.qlvetau.model.entity;

import com.app.qlvetau.model.interfaces.IFileEntity;

public class Ve implements IFileEntity {
    private int maVe;
    private String loaiGhe;
    private double donGia;

    public Ve() {}

    public Ve(int maVe, String loaiGhe, double donGia) {
        this.maVe = maVe;
        this.loaiGhe = loaiGhe;
        this.donGia = donGia;
    }

    // Getters and Setters
    public int getMaVe() { return maVe; }
    public void setMaVe(int maVe) { this.maVe = maVe; }
    public String getLoaiGhe() { return loaiGhe; }
    public void setLoaiGhe(String loaiGhe) { this.loaiGhe = loaiGhe; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    @Override
    public String toString() {
        return maVe + " - " + loaiGhe + " - " + donGia;
    }
}