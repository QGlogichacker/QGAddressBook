package com.liangjiahao.view;

import com.liangjiahao.service.ForTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Enquire2 extends JDialog {
    private static final long serialVersionUID = 4311937573657530110L;
    private final JPanel contentPanel = new JPanel();
    private JComboBox comboBox;
    private JTextField textField;
    private String sN;
    private Vector<Vector<String>> v;
    JCheckBox checkBox;
    private JButton btnNewButton;

    public Enquire2(final JTable table, final DefaultTableModel dtm) {
        this.setTitle("fuzzy enquiry");
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
                String got = (String)Enquire2.this.comboBox.getSelectedItem();
                if (Enquire2.this.checkBox.isSelected()) {
                    try {
                        Enquire2.this.v = ForTable.getFuzzyPartData(Enquire2.this.textField.getText());
                        dtm.setDataVector(Enquire2.this.v, ForTable.getTitle());
                        table.setModel(dtm);
                        table.updateUI();
                        Enquire2.this.close();
                        return;
                    } catch (Exception var5) {
                        var5.printStackTrace();
                    }
                }

                if (got.equals("姓名")) {
                    Enquire2.this.sN = "namee";
                }

                if (got.equals("方向")) {
                    Enquire2.this.sN = "groupp";
                }

                if (got.equals("年级")) {
                    Enquire2.this.sN = "grade";
                }

                if (got.equals("班级")) {
                    Enquire2.this.sN = "class";
                }

                if (got.equals("电话")) {
                    Enquire2.this.sN = "phone";
                }

                if (got.equals("邮箱")) {
                    Enquire2.this.sN = "email";
                }

                if (got.equals("宿舍")) {
                    Enquire2.this.sN = "dormitory";
                }

                if (got.equals("地址")) {
                    Enquire2.this.sN = "address";
                }

                try {
                    Enquire2.this.v = ForTable.getFuzzyPartData(Enquire2.this.sN, Enquire2.this.textField.getText());
                    dtm.setDataVector(Enquire2.this.v, ForTable.getTitle());
                    table.setModel(dtm);
                    table.updateUI();
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                Enquire2.this.close();
            }
        });
        this.btnNewButton = new JButton("说明");
        this.btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    try {
                        ExpFrame frame = new ExpFrame("1，%：表示任意0个或多个字符。可匹配任意类型和长度的字符，有些情况下若是中文，请使用两个百分号（%%）表示。\n将会把u_name为“张三”，“张猫三”、“三脚猫”，“唐三藏”等等有“三”的记录全找出来。 \n2，_： 表示任意单个字符。匹配单个任意字符，它常用来限制表达式的字符长度语句： \n只找出“唐三藏”这样u_name为三个字且中间一个字是“三”的； \n3，[ ]：表示括号内所列字符中的一个（类似正则表达式）。指定一个字符、字符串或范围，要求所匹配对象为它们中的任一个。\n[ ] 内有一系列字符（01234、abcde之类的）则可略写为“0-4”、“a-e” \n如老[1-9' 将找出老1、老2、……、老9； \n4，[^ ] ：表示不在括号所列之内的单个字符。其取值和 [] 相同，但它要求所匹配对象为指定字符以外的任一个字符。 \n比如 [^张李王]三'将找出不姓“张”、“李”、“王”的“赵三”、“孙三”等； \n也可以用上面的省略法\n5，查询内容包含通配符时 \n由于通配符的缘故，导致我们查询特殊字符“%”、“_”、“[”的语句无法正常实现，而把特殊字符用“[ ]”括起便可正常查询。");
                        frame.setVisible(true);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

            }
        });
        buttonPane.add(this.btnNewButton);
        cancelButton.setActionCommand("OK");
        buttonPane.add(cancelButton);
        this.getRootPane().setDefaultButton(cancelButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enquire2.this.close();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    private void close() {
        this.dispose();
    }
}
