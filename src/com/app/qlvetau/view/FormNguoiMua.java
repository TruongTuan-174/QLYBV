package com.app.qlvetau.view;

import com.app.qlvetau.controller.NguoiMuaController;
import com.app.qlvetau.model.entity.NguoiMua;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormNguoiMua extends JFrame {
    private NguoiMuaController controller = new NguoiMuaController();
    private JTextField txtHoTen, txtDiaChi, txtLoai;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormNguoiMua() {
        setTitle("Quản Lý Người Mua");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel panelInput = new JPanel(new GridLayout(4, 2));
        panelInput.add(new JLabel("Họ Tên:"));
        txtHoTen = new JTextField();
        panelInput.add(txtHoTen);
        panelInput.add(new JLabel("Địa Chỉ:"));
        txtDiaChi = new JTextField();
        panelInput.add(txtDiaChi);
        panelInput.add(new JLabel("Loại:"));
        txtLoai = new JTextField();
        panelInput.add(txtLoai);
        JButton btnAdd = new JButton("Thêm");
        panelInput.add(btnAdd);
        JButton btnLoad = new JButton("Hiển Thị Danh Sách");
        panelInput.add(btnLoad);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new String[]{"Mã", "Họ Tên", "Địa Chỉ", "Loại"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện
        btnAdd.addActionListener(e -> {
            try {
                controller.addNguoiMua(txtHoTen.getText(), txtDiaChi.getText(), txtLoai.getText());
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });

        btnLoad.addActionListener(e -> loadData());
    }

    private void loadData() {
        try {
            tableModel.setRowCount(0);
            List<NguoiMua> list = controller.getAllNguoiMua();
            for (NguoiMua nm : list) {
                tableModel.addRow(new Object[]{nm.getMaNguoiMua(), nm.getHoTen(), nm.getDiaChi(), nm.getLoai()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}