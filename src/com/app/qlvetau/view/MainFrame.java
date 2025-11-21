package com.app.qlvetau.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Quản Lý Bán Vé Tàu Hỏa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JButton btnNguoiMua = new JButton("Quản Lý Người Mua");
        JButton btnVe = new JButton("Quản Lý Vé");
        JButton btnHoaDon = new JButton("Lập Hóa Đơn");
        JButton btnSapXep = new JButton("Sắp Xếp Hóa Đơn");
        JButton btnBaoCao = new JButton("Báo Cáo Thanh Toán");

        btnNguoiMua.addActionListener(e -> new FormNguoiMua().setVisible(true));
        btnVe.addActionListener(e -> new FormVe().setVisible(true));
        btnHoaDon.addActionListener(e -> new FormHoaDon().setVisible(true));
        btnSapXep.addActionListener(e -> new FormSapXep().setVisible(true));
        btnBaoCao.addActionListener(e -> new FormBaoCao().setVisible(true));

        add(btnNguoiMua);
        add(btnVe);
        add(btnHoaDon);
        add(btnSapXep);
        add(btnBaoCao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}