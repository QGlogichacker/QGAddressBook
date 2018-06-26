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

public class UpdateTable extends JDialog {
    private static final long serialVersionUID = 8849421438735909968L;
    private final JPanel contentPanel = new JPanel();
    private JTextField memclass;
    private JTextField memphone;
    private JTextField mememail;
    private JTextField memdormitory;
    private JTextField memname;
    private JTextField memgroup;
    private JTextField memgrade;
    private Member mem;
    private int memId;
    private JTextField memaddress;

    public Member getMem() {
        return this.mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        try {
            UpdateTable dialog = new UpdateTable((JTable)null, (DefaultTableModel)null, 0);
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public UpdateTable(final JTable table, final DefaultTableModel dtm, int id) {
        this.setMemId(id);
        this.setTitle("Update Data");
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
        this.memclass = new JTextField();
        this.memclass.setBounds(331, 37, 86, 24);
        this.contentPanel.add(this.memclass);
        this.memclass.setColumns(10);
        this.memphone = new JTextField();
        this.memphone.setBounds(436, 37, 86, 24);
        this.contentPanel.add(this.memphone);
        this.memphone.setColumns(10);
        this.mememail = new JTextField();
        this.mememail.setBounds(547, 37, 86, 24);
        this.contentPanel.add(this.mememail);
        this.mememail.setColumns(10);
        this.memdormitory = new JTextField();
        this.memdormitory.setBounds(655, 37, 86, 24);
        this.contentPanel.add(this.memdormitory);
        this.memdormitory.setColumns(10);
        this.memname = new JTextField();
        this.memname.setBounds(14, 37, 86, 24);
        this.contentPanel.add(this.memname);
        this.memname.setColumns(10);
        this.memgroup = new JTextField();
        this.memgroup.setBounds(120, 37, 86, 24);
        this.contentPanel.add(this.memgroup);
        this.memgroup.setColumns(10);
        this.memgrade = new JTextField();
        this.memgrade.setBounds(225, 37, 86, 24);
        this.contentPanel.add(this.memgrade);
        this.memgrade.setColumns(10);
        this.memaddress = new JTextField();
        this.memaddress.setColumns(10);
        this.memaddress.setBounds(762, 37, 86, 24);
        this.contentPanel.add(this.memaddress);
        label = new JLabel("年级");
        label.setBounds(257, 13, 30, 18);
        this.contentPanel.add(label);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(2));
        this.getContentPane().add(buttonPane, "South");
        JButton cancelButton = new JButton("OK");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateTable.this.Update(table, dtm);
            }
        });
        cancelButton.setActionCommand("OK");
        buttonPane.add(cancelButton);
        this.getRootPane().setDefaultButton(cancelButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateTable.this.close();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public void close() {
        this.dispose();
    }

    public void Update(JTable table, DefaultTableModel dtm) {
        if (this.memname.getText().equals("")) {
            FalseDialog fd = new FalseDialog("名称不能为空！");
            fd.setDefaultCloseOperation(2);
            fd.setVisible(true);
        } else {
            this.mem = new Member(this.memId, this.memname.getText(), this.memgroup.getText(), this.memgrade.getText(), this.memclass.getText(), this.memphone.getText(), this.mememail.getText(), this.memdormitory.getText(), this.memaddress.getText());
                System.out.println(this.mem.getId() + this.mem.toString());
            try {
                DbOperate.updateMember(this.mem);
            } catch (Exception var5) {
                var5.printStackTrace();
                FalseDialog.getFalseDialog("更新对象失败！");
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

    public int getMemId() {
        return this.memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }
}
