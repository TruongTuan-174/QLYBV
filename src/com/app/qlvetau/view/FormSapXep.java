package com.app.qlvetau.view;

import com.app.qlvetau.controller.SortController;
import com.app.qlvetau.model.entity.HoaDon;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormSapXep extends JFrame {
    private SortController controller = new SortController();
    private JRadioButton rbHoTen, rbSoLuong;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormSapXep() {
        setTitle("Sắp Xếp Hóa Đơn");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Panel lựa chọn
        JPanel panelOption = new JPanel();
        rbHoTen = new JRadioButton("Theo Họ Tên Người Mua");
        rbSoLuong = new JRadioButton("Theo Số Lượng Vé (Giảm Dần)");
        ButtonGroup group = new ButtonGroup();
        group.add(rbHoTen);
        group.add(rbSoLuong);
        JButton btnSort = new JButton("Sắp Xếp");
        panelOption.add(rbHoTen);
        panelOption.add(rbSoLuong);
        panelOption.add(btnSort);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new String[]{"Mã Hóa Đơn", "Mã Người Mua", "Chi Tiết Vé"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelOption, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện
        btnSort.addActionListener(e -> {
            try {
                List<HoaDon> list;
                if (rbHoTen.isSelected()) {
                    list = controller.sortByHoTen();
                } else if (rbSoLuong.isSelected()) {
                    list = controller.sortBySoLuongVe();
                } else {
                    JOptionPane.showMessageDialog(this, "Chọn tiêu chí sắp xếp!");
                    return;
                }
                tableModel.setRowCount(0);
                for (HoaDon hd : list) {
                    tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaNguoiMua(), hd.getChiTietHDs().toString()});
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });
    }
}