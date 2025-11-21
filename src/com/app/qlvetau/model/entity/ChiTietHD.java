package com.app.qlvetau.model.entity;

import com.app.qlvetau.model.interfaces.IFileEntity;

public class ChiTietHD implements IFileEntity {
    private int maVe;
    private int soLuong; // <= 20

    public ChiTietHD() {}

    public ChiTietHD(int maVe, int soLuong) {
        this.maVe = maVe;
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public int getMaVe() { return maVe; }
    public void setMaVe(int maVe) { this.maVe = maVe; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    @Override
    public String toString() {
        return "Ve: " + maVe + " - So luong: " + soLuong;
    }
}