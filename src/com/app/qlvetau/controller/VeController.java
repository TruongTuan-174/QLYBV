package com.app.qlvetau.controller;

import com.app.qlvetau.dao.VeDAO;
import com.app.qlvetau.model.entity.Ve;
import java.io.IOException;
import java.util.List;

public class VeController {
    private VeDAO dao = new VeDAO();

    public void addVe(String loaiGhe, double donGia) throws Exception {
        if (loaiGhe.isEmpty() || donGia <= 0) throw new Exception("Thông tin không hợp lệ");
        Ve ve = new Ve(0, loaiGhe, donGia);
        dao.add(ve);
    }

    public List<Ve> getAllVe() throws IOException, ClassNotFoundException {
        return dao.getAll();
    }
}