package com.app.qlvetau.model.business;

import com.app.qlvetau.model.entity.HoaDon;
import com.app.qlvetau.dao.VeDAO;
import java.util.List;

public class HoaDonCalculator {
    private VeDAO veDAO = new VeDAO();

    public double calculateTotal(HoaDon hoaDon) {
        double total = 0;
        for (var ct : hoaDon.getChiTietHDs()) {
            var ve = veDAO.getById(ct.getMaVe());
            if (ve != null) {
                total += ct.getSoLuong() * ve.getDonGia();
            }
        }
        return total;
    }

    public double calculateTotalForNguoiMua(int maNguoiMua, List<HoaDon> hoaDons) {
        double total = 0;
        for (HoaDon hd : hoaDons) {
            if (hd.getMaNguoiMua() == maNguoiMua) {
                total += calculateTotal(hd);
            }
        }
        return total;
    }
}