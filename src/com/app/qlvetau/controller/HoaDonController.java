package com.app.qlvetau.controller;

import com.app.qlvetau.dao.HoaDonDAO;
import com.app.qlvetau.dao.NguoiMuaDAO;
import com.app.qlvetau.model.entity.ChiTietHD;
import com.app.qlvetau.model.entity.HoaDon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonController {
    private HoaDonDAO dao = new HoaDonDAO();
    private NguoiMuaDAO nguoiMuaDAO = new NguoiMuaDAO();

    public void addHoaDon(int maNguoiMua, List<ChiTietHD> chiTietHDs) throws Exception {
        if (nguoiMuaDAO.getAll().stream().noneMatch(nm -> nm.getMaNguoiMua() == maNguoiMua)) throw new Exception("Người mua không tồn tại");
        if (chiTietHDs.size() > 4) throw new Exception("Không quá 4 loại vé");
        for (ChiTietHD ct : chiTietHDs) {
            if (ct.getSoLuong() > 20) throw new Exception("Số lượng không quá 20");
        }
        HoaDon hd = new HoaDon(0, maNguoiMua, chiTietHDs);
        dao.add(hd);
    }

    public List<HoaDon> getAllHoaDon() throws IOException, ClassNotFoundException {
        return dao.getAll();
    }
}