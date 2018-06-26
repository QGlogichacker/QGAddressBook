package com.liangjiahao.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FalseDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            FalseDialog dialog = new FalseDialog();
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("连错误对话框都没法开了");
        }

    }

    public FalseDialog() {
        this.setType(Type.UTILITY);
        this.setAlwaysOnTop(true);
        this.setBounds(100, 100, 288, 110);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        this.contentPanel.add(panel, "Center");
        JLabel label = new JLabel("用户名或密码不能为空");
        label.setFont(new Font("微软雅黑", 0, 20));
        panel.add(label);
    }

    public FalseDialog(String st) {
        this.setType(Type.UTILITY);
        this.setAlwaysOnTop(true);
        this.setBounds(100, 100, 288, 110);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        this.contentPanel.add(panel, "Center");
        JLabel label = new JLabel(st);
        label.setFont(new Font("微软雅黑", 0, 20));
        panel.add(label);
    }

    public static void getFalseDialog(String c) {
        try {
            FalseDialog dialog = new FalseDialog(c);
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("连错误对话框都没法开了");
        }

    }
}
