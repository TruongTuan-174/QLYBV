package com.app.qlvetau.dao;

import com.app.qlvetau.model.entity.Ve;
import java.io.IOException;
import java.util.List;

public class VeDAO {
    private static final String FILE_NAME = "VE.DAT";

    public void add(Ve ve) throws IOException, ClassNotFoundException {
        List<Ve> list = FileUtil.readFromFile(FILE_NAME);
        ve.setMaVe(generateId(list));
        list.add(ve);
        FileUtil.writeToFile(FILE_NAME, list);
    }

    public List<Ve> getAll() throws IOException, ClassNotFoundException {
        return FileUtil.readFromFile(FILE_NAME);
    }

    public Ve getById(int maVe) throws IOException, ClassNotFoundException {
        List<Ve> list = getAll();
        return list.stream().filter(v -> v.getMaVe() == maVe).findFirst().orElse(null);
    }

    private int generateId(List<Ve> list) {
        return list.isEmpty() ? 10000 : list.get(list.size() - 1).getMaVe() + 1;
    }
}