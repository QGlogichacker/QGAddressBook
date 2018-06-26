package com.liangjiahao.view;

import com.liangjiahao.dao.DbOperate;
import com.liangjiahao.model.Member;
import com.liangjiahao.service.ForTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertData extends JDialog {
    private static final long serialVersionUID = -1766152345260221800L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private Member mem;
    private JTextField textField_8;

    public Member getMem() {
        return this.mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        try {
            InsertData dialog = new InsertData((JTable)null, (DefaultTableModel)null);
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public InsertData(final JTable table, final DefaultTableModel dtm) {
        this.setTitle("Delete Data");
        this.setBounds(100, 100, 901, 160);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout((LayoutManager)null);
        JLabel label = new JLabel("*姓名");
        label.setBounds(32, 13, 38, 18);
        this.contentPanel.add(label);
        label = new JLabel("方向");
        label.setBounds(152, 13, 30, 18);
        this.contentPanel.add(label);
        label = new JLabel("班级");
        label.setBounds(357, 13, 30, 18);
        this.contentPanel.add(label);
        label = new JLabel("电话");
        label.setBounds(468, 13, 30, 18);
        this.contentPanel.add(label);
        label = new JLabel("邮箱");
        label.setBounds(571, 13, 30, 18);
        this.contentPanel.add(label);
        label = new JLabel("宿舍");
        label.setBounds(684, 13, 30, 18);
        this.contentPanel.add(label);
        label = new JLabel("地址");
        label.setBounds(786, 13, 30, 18);
        this.contentPanel.add(label);
        this.textField = new JTextField();
        this.textField.setBounds(331, 37, 86, 24);
        this.contentPanel.add(this.textField);
        this.textField.setColumns(10);
        this.textField_1 = new JTextField();
        this.textField_1.setBounds(436, 37, 86, 24);
        this.contentPanel.add(this.textField_1);
        this.textField_1.setColumns(10);
        this.textField_2 = new JTextField();
        this.textField_2.setBounds(547, 37, 86, 24);
        this.contentPanel.add(this.textField_2);
        this.textField_2.setColumns(10);
        this.textField_3 = new JTextField();
        this.textField_3.setBounds(655, 37, 86, 24);
        this.contentPanel.add(this.textField_3);
        this.textField_3.setColumns(10);
        this.textField_4 = new JTextField();
        this.textField_4.setBounds(14, 37, 86, 24);
        this.contentPanel.add(this.textField_4);
        this.textField_4.setColumns(10);
        this.textField_5 = new JTextField();
        this.textField_5.setBounds(120, 37, 86, 24);
        this.contentPanel.add(this.textField_5);
        this.textField_5.setColumns(10);
        this.textField_6 = new JTextField();
        this.textField_6.setBounds(225, 37, 86, 24);
        this.contentPanel.add(this.textField_6);
        this.textField_6.setColumns(10);
        this.textField_8 = new JTextField();
        this.textField_8.setColumns(10);
        this.textField_8.setBounds(762, 37, 86, 24);
        this.contentPanel.add(this.textField_8);
        label = new JLabel("年级");
        label.setBounds(257, 13, 30, 18);
        this.contentPanel.add(label);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(2));
        this.getContentPane().add(buttonPane, "South");
        JButton cancelButton = new JButton("OK");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertData.this.Insert(table, dtm);
            }
        });
        cancelButton.setActionCommand("OK");
        buttonPane.add(cancelButton);
        this.getRootPane().setDefaultButton(cancelButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertData.this.close();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public void close() {
        this.dispose();
    }

    public void Insert(JTable table, DefaultTableModel dtm) {
        if (this.textField_4.getText().equals("")) {
            FalseDialog fd = new FalseDialog("名称不能为空！");
            fd.setDefaultCloseOperation(2);
            fd.setVisible(true);
        } else {
            this.mem = new Member(this.textField_4.getText(), this.textField_5.getText(), this.textField_6.getText(), this.textField.getText(), this.textField_1.getText(), this.textField_2.getText(), this.textField_3.getText(), this.textField_8.getText());

            try {
                DbOperate.addMember(this.mem);
            } catch (Exception var5) {
                var5.printStackTrace();
                FalseDialog.getFalseDialog("添加对象失败！");
            }

            try {
                dtm.setDataVector(ForTable.getData(), ForTable.getTitle());
                table.setModel(dtm);
                table.updateUI();
            } catch (Exception var4) {
                FalseDialog.getFalseDialog("刷新失败！");
                var4.printStackTrace();
            }

            this.close();
        }
    }
}
