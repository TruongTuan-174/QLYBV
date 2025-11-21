package com.app.qlvetau.dao;

import com.app.qlvetau.model.entity.NguoiMua;
import java.io.IOException;
import java.util.List;

public class NguoiMuaDAO {
    private static final String FILE_NAME = "NGUOIMUA.DAT";

    public void add(NguoiMua nguoiMua) throws IOException, ClassNotFoundException {
        List<NguoiMua> list = FileUtil.readFromFile(FILE_NAME);
        nguoiMua.setMaNguoiMua(generateId(list));
        list.add(nguoiMua);
        FileUtil.writeToFile(FILE_NAME, list);
    }

    public List<NguoiMua> getAll() throws IOException, ClassNotFoundException {
        return FileUtil.readFromFile(FILE_NAME);
    }

    private int generateId(List<NguoiMua> list) {
        return list.isEmpty() ? 10000 : list.get(list.size() - 1).getMaNguoiMua() + 1;
    }
}