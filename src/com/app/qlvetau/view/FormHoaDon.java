package com.app.qlvetau.view;

import com.app.qlvetau.controller.HoaDonController;
import com.app.qlvetau.model.entity.ChiTietHD;
import com.app.qlvetau.model.entity.HoaDon;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormHoaDon extends JFrame {
    private HoaDonController controller = new HoaDonController();
    private JTextField txtMaNguoiMua, txtMaVe, txtSoLuong;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<ChiTietHD> chiTietHDs = new ArrayList<>();

    public FormHoaDon() {
        setTitle("Lập Hóa Đơn");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel panelInput = new JPanel(new GridLayout(4, 2));
        panelInput.add(new JLabel("Mã Người Mua:"));
        txtMaNguoiMua = new JTextField();
        panelInput.add(txtMaNguoiMua);
        panelInput.add(new JLabel("Mã Vé:"));
        txtMaVe = new JTextField();
        panelInput.add(txtMaVe);
        panelInput.add(new JLabel("Số Lượng:"));
        txtSoLuong = new JTextField();
        panelInput.add(txtSoLuong);
        JButton btnAddChiTiet = new JButton("Thêm Chi Tiết");
        panelInput.add(btnAddChiTiet);
        JButton btnSaveHoaDon = new JButton("Lưu Hóa Đơn");
        panelInput.add(btnSaveHoaDon);
        JButton btnLoad = new JButton("Hiển Thị Danh Sách");
        panelInput.add(btnLoad);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new String[]{"Mã Hóa Đơn", "Mã Người Mua", "Chi Tiết Vé"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện
        btnAddChiTiet.addActionListener(e -> {
            try {
                int maVe = Integer.parseInt(txtMaVe.getText());
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                if (soLuong > 20) throw new Exception("Số lượng không quá 20");
                chiTietHDs.add(new ChiTietHD(maVe, soLuong));
                JOptionPane.showMessageDialog(this, "Thêm chi tiết thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });

        btnSaveHoaDon.addActionListener(e -> {
            try {
                int maNguoiMua = Integer.parseInt(txtMaNguoiMua.getText());
                controller.addHoaDon(maNguoiMua, chiTietHDs);
                JOptionPane.showMessageDialog(this, "Lưu hóa đơn thành công!");
                chiTietHDs.clear();
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
            List<HoaDon> list = controller.getAllHoaDon();
            for (HoaDon hd : list) {
                tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaNguoiMua(), hd.getChiTietHDs().toString()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}