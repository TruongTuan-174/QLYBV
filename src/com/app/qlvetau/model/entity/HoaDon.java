package com.app.qlvetau.model.entity;

import com.app.qlvetau.model.interfaces.IFileEntity;
import com.app.qlvetau.model.interfaces.ICanCalculate;
import java.util.List;

public class HoaDon implements IFileEntity, ICanCalculate {
    private int maHoaDon;
    private int maNguoiMua;
    private List<ChiTietHD> chiTietHDs; // <= 4 items

    public HoaDon() {}

    public HoaDon(int maHoaDon, int maNguoiMua, List<ChiTietHD> chiTietHDs) {
        this.maHoaDon = maHoaDon;
        this.maNguoiMua = maNguoiMua;
        this.chiTietHDs = chiTietHDs;
    }

    // Getters and Setters
    public int getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(int maHoaDon) { this.maHoaDon = maHoaDon; }
    public int getMaNguoiMua() { return maNguoiMua; }
    public void setMaNguoiMua(int maNguoiMua) { this.maNguoiMua = maNguoiMua; }
    public List<ChiTietHD> getChiTietHDs() { return chiTietHDs; }
    public void setChiTietHDs(List<ChiTietHD> chiTietHDs) { this.chiTietHDs = chiTietHDs; }

    @Override
    public double calculateTotal() {
        // Tính tổng tiền dựa trên chi tiết và đơn giá từ Ve (cần truy vấn VeDAO)
        double total = 0;
        for (ChiTietHD ct : chiTietHDs) {
            // Giả sử có VeDAO để lấy donGia
            // total += ct.getSoLuong() * veDAO.getById(ct.getMaVe()).getDonGia();
        }
        return total;
    }

    @Override
    public String toString() {
        return "HoaDon: " + maHoaDon + " - NguoiMua: " + maNguoiMua + " - ChiTiet: " + chiTietHDs;
    }
}