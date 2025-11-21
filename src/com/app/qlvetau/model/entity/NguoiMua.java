package com.app.qlvetau.model.entity;

import com.app.qlvetau.model.interfaces.IFileEntity;

public class NguoiMua implements IFileEntity {
    private int maNguoiMua;
    private String hoTen;
    private String diaChi;
    private String loai; // mua lẻ, mua tập thể, mua qua mạng

    public NguoiMua() {}

    public NguoiMua(int maNguoiMua, String hoTen, String diaChi, String loai) {
        this.maNguoiMua = maNguoiMua;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loai = loai;
    }

    // Getters and Setters
    public int getMaNguoiMua() { return maNguoiMua; }
    public void setMaNguoiMua(int maNguoiMua) { this.maNguoiMua = maNguoiMua; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getLoai() { return loai; }
    public void setLoai(String loai) { this.loai = loai; }

    @Override
    public String toString() {
        return maNguoiMua + " - " + hoTen + " - " + diaChi + " - " + loai;
    }
}