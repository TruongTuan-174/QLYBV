package com.app.qlvetau.view;

import com.app.qlvetau.controller.BaoCaoController;
import com.app.qlvetau.model.entity.NguoiMua;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class FormBaoCao extends JFrame {
    private BaoCaoController controller = new BaoCaoController();
    private JTable table;
    private DefaultTableModel tableModel;

    public FormBaoCao() {
        setTitle("Báo Cáo Thanh Toán");
        setSize(600, 400);
        setLayout(new BorderLayout());

        JButton btnLoad = new JButton("Lập Bảng Kê");
        JPanel panel = new JPanel();
        panel.add(btnLoad);

        // Bảng hiển thị
        tableModel = new DefaultTableModel(new String[]{"Mã Người Mua", "Họ Tên", "Tổng Tiền"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện
        btnLoad.addActionListener(e -> {
            try {
                Map<NguoiMua, Double> baoCao = controller.getBaoCaoThanhToan();
                tableModel.setRowCount(0);
                for (Map.Entry<NguoiMua, Double> entry : baoCao.entrySet()) {
                    NguoiMua nm = entry.getKey();
                    tableModel.addRow(new Object[]{nm.getMaNguoiMua(), nm.getHoTen(), entry.getValue()});
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });
    }
}