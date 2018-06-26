package com.liangjiahao.view;

import com.liangjiahao.dao.DbPassword;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangePassword extends JDialog {
    private static final long serialVersionUID = -7340405842131967834L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textField;

    public static void getFrame(String[] args) {
        try {
            ChangePassword dialog = new ChangePassword("11");
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public ChangePassword(final String name) throws IOException {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ExpFrame.class.getResource("/images/QGicon.png")));
        this.setTitle("Please Input Your New PassWord!");
        this.setBounds(100, 100, 301, 130);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout((LayoutManager)null);
        this.textField = new JTextField();
        this.textField.setBounds(33, 13, 222, 24);
        this.contentPanel.add(this.textField);
        this.textField.setColumns(10);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(2));
        this.getContentPane().add(buttonPane, "South");
        JButton cancelButton = new JButton("OK");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ChangePassword.this.textField.getText().equals("")) {
                    FalseDialog.getFalseDialog("不能为空！");
                } else {
                    try {
                        DbPassword.updatePassword(name, ChangePassword.this.textField.getText());
                    } catch (Exception var3) {
                        var3.printStackTrace();
                        FalseDialog.getFalseDialog("修改密码失败！");
                    }

                    FalseDialog.getFalseDialog("修改密码成功！");
                    ChangePassword.this.close();
                }
            }
        });
        cancelButton.setActionCommand("OK");
        buttonPane.add(cancelButton);
        this.getRootPane().setDefaultButton(cancelButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword.this.close();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public void close() {
        this.dispose();
    }
}
