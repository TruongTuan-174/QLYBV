package com.app.qlvetau.controller;

import com.app.qlvetau.dao.HoaDonDAO;
import com.app.qlvetau.dao.NguoiMuaDAO;
import com.app.qlvetau.model.entity.HoaDon;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class SortController {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private NguoiMuaDAO nguoiMuaDAO = new NguoiMuaDAO();

    public List<HoaDon> sortByHoTen() throws IOException, ClassNotFoundException {
        List<HoaDon> list = hoaDonDAO.getAll();
        list.sort(Comparator.comparing(hd -> {
            try {
                return nguoiMuaDAO.getAll().stream()
                    .filter(nm -> nm.getMaNguoiMua() == hd.getMaNguoiMua())
                    .findFirst().orElseThrow().getHoTen();
            } catch (Exception e) {
                return "";
            }
        }));
        return list;
    }

    public List<HoaDon> sortBySoLuongVe() throws IOException, ClassNotFoundException {
        List<HoaDon> list = hoaDonDAO.getAll();
        list.sort(Comparator.comparingInt(hd -> hd.getChiTietHDs().stream().mapToInt(ChiTietHD::getSoLuong).sum()).reversed());
        return list;
    }
}