package com.app.qlvetau.controller;

import com.app.qlvetau.dao.HoaDonDAO;
import com.app.qlvetau.dao.NguoiMuaDAO;
import com.app.qlvetau.model.business.HoaDonCalculator;
import com.app.qlvetau.model.entity.HoaDon;
import com.app.qlvetau.model.entity.NguoiMua;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaoCaoController {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private NguoiMuaDAO nguoiMuaDAO = new NguoiMuaDAO();
    private HoaDonCalculator calculator = new HoaDonCalculator();

    public Map<NguoiMua, Double> getBaoCaoThanhToan() throws IOException, ClassNotFoundException {
        List<HoaDon> hoaDons = hoaDonDAO.getAll();
        List<NguoiMua> nguoiMuas = nguoiMuaDAO.getAll();
        Map<NguoiMua, Double> baoCao = new HashMap<>();
        for (NguoiMua nm : nguoiMuas) {
            double total = calculator.calculateTotalForNguoiMua(nm.getMaNguoiMua(), hoaDons);
            baoCao.put(nm, total);
        }
        return baoCao;
    }
}