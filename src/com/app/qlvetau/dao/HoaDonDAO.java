package com.app.qlvetau.dao;

import com.app.qlvetau.model.entity.HoaDon;
import java.io.IOException;
import java.util.List;

public class HoaDonDAO {
    private static final String FILE_NAME = "HOADON.DAT";

    public void add(HoaDon hoaDon) throws IOException, ClassNotFoundException {
        List<HoaDon> list = FileUtil.readFromFile(FILE_NAME);
        hoaDon.setMaHoaDon(generateId(list));
        list.add(hoaDon);
        FileUtil.writeToFile(FILE_NAME, list);
    }

    public List<HoaDon> getAll() throws IOException, ClassNotFoundException {
        return FileUtil.readFromFile(FILE_NAME);
    }

    private int generateId(List<HoaDon> list) {
        return list.isEmpty() ? 10000 : list.get(list.size() - 1).getMaHoaDon() + 1;
    }
}