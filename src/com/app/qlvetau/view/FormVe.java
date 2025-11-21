package com.app.qlvetau.view;

import com.app.qlvetau.controller.VeController;
import com.app.qlvetau.model.entity.Ve;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormVe extends JFrame {
    private VeController controller = new VeController();
    private JTextField txtLoaiGhe, txtDonGia;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormVe() {
        setTitle("Quản Lý Vé");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel panelInput = new JPanel(new GridLayout(3, 2));
        panelInput.add(new JLabel("Loại Ghế:"));
        txtLoaiGhe = new JTextField();
        panelInput.add(txtLoaiGhe);
        panelInput.add(new JLabel("Đơn Giá:"));
        txtDonGia = new JTextField();
        panelInput.add(txtDonGia);
        JButton btnAdd = new JButton("Thêm");
        panelInput.add(btnAdd);
        JButton btnLoad = new JButton("Hiển Thị Danh Sách");
        panelInput.add(btnLoad);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new String[]{"Mã Vé", "Loại Ghế", "Đơn Giá"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện
        btnAdd.addActionListener(e -> {
            try {
                controller.addVe(txtLoaiGhe.getText(), Double.parseDouble(txtDonGia.getText()));
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
            List<Ve> list = controller.getAllVe();
            for (Ve ve : list) {
                tableModel.addRow(new Object[]{ve.getMaVe(), ve.getLoaiGhe(), ve.getDonGia()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}