package com.liangjiahao.view;

import com.liangjiahao.service.ForTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Enquire1 extends JDialog {
    private static final long serialVersionUID = 4311937573657530110L;
    private final JPanel contentPanel = new JPanel();
    private JComboBox comboBox;
    private JTextField textField;
    private String sN;
    private Vector<Vector<String>> v;
    JCheckBox checkBox;

    public Enquire1(final JTable table, final DefaultTableModel dtm) {
        this.setTitle("precise enquiry");
        this.setBounds(100, 100, 249, 161);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout((LayoutManager)null);
        String[] list = new String[]{"姓名", "方向", "年级", "班级", "电话", "邮箱", "宿舍", "地址"};
        this.comboBox = new JComboBox(list);
        this.comboBox.setBounds(14, 13, 92, 24);
        this.contentPanel.add(this.comboBox);
        this.textField = new JTextField();
        this.textField.setBounds(120, 13, 86, 24);
        this.contentPanel.add(this.textField);
        this.textField.setColumns(10);
        this.checkBox = new JCheckBox("无视选项");
        this.checkBox.setBounds(14, 46, 133, 27);
        this.contentPanel.add(this.checkBox);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(2));
        this.getContentPane().add(buttonPane, "South");
        JButton cancelButton = new JButton("OK");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String got = (String)Enquire1.this.comboBox.getSelectedItem();
                if (Enquire1.this.checkBox.isSelected()) {
                    try {
                        Enquire1.this.v = ForTable.getPartData(Enquire1.this.textField.getText());
                        dtm.setDataVector(Enquire1.this.v, ForTable.getTitle());
                        table.setModel(dtm);
                        table.updateUI();
                        Enquire1.this.close();
                        return;
                    } catch (Exception var5) {
                        var5.printStackTrace();
                    }
                }

                if (got.equals("姓名")) {
                    Enquire1.this.sN = "namee";
                }

                if (got.equals("方向")) {
                    Enquire1.this.sN = "groupp";
                }

                if (got.equals("年级")) {
                    Enquire1.this.sN = "grade";
                }

                if (got.equals("班级")) {
                    Enquire1.this.sN = "class";
                }

                if (got.equals("电话")) {
                    Enquire1.this.sN = "phone";
                }

                if (got.equals("邮箱")) {
                    Enquire1.this.sN = "email";
                }

                if (got.equals("宿舍")) {
                    Enquire1.this.sN = "dormitory";
                }

                if (got.equals("地址")) {
                    Enquire1.this.sN = "address";
                }

                try {
                    Enquire1.this.v = ForTable.getPartData(Enquire1.this.sN, Enquire1.this.textField.getText());
                    dtm.setDataVector(Enquire1.this.v, ForTable.getTitle());
                    table.setModel(dtm);
                    table.updateUI();
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                Enquire1.this.close();
            }
        });
        cancelButton.setActionCommand("OK");
        buttonPane.add(cancelButton);
        this.getRootPane().setDefaultButton(cancelButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enquire1.this.close();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    private void close() {
        this.dispose();
    }
}
