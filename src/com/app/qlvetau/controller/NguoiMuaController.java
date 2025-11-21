package com.app.qlvetau.controller;

import com.app.qlvetau.dao.NguoiMuaDAO;
import com.app.qlvetau.model.entity.NguoiMua;
import java.io.IOException;
import java.util.List;

public class NguoiMuaController {
    private NguoiMuaDAO dao = new NguoiMuaDAO();

    public void addNguoiMua(String hoTen, String diaChi, String loai) throws Exception {
        if (hoTen.isEmpty() || diaChi.isEmpty() || loai.isEmpty()) throw new Exception("Thông tin không được rỗng");
        NguoiMua nm = new NguoiMua(0, hoTen, diaChi, loai);
        dao.add(nm);
    }

    public List<NguoiMua> getAllNguoiMua() throws IOException, ClassNotFoundException {
        return dao.getAll();
    }
}