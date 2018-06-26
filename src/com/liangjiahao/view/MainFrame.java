package com.liangjiahao.view;

import com.liangjiahao.dao.DbOperate;
import com.liangjiahao.service.ExcelIO;
import com.liangjiahao.service.ForTable;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.RavenGraphiteSkin;
import org.jvnet.substance.theme.SubstanceDarkVioletTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = -5990367711108106902L;
    private static JPanel contentPane;
    private static DefaultTableModel dtm;
    public static Vector<String> title;
    public static Vector<Vector<String>> data;
    private static JTable table_2;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceDarkVioletTheme());
            SubstanceLookAndFeel.setSkin(new RavenGraphiteSkin());
        } catch (Exception var2) {
            FalseDialog.getFalseDialog("美化包加载失败");
        }


        try {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public MainFrame() throws Exception {
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/home/logichacker/java_project/src/com/images/QGicon.png")));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ExpFrame.class.getResource("/images/QGicon.png")));
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 948, 377);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(46, 58, 58));
        this.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setBackground(new Color(52, 57, 60));
        panel.setLayout(new BorderLayout(0, 0));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(52, 57, 60));
        panel.add(scrollPane);
        title = ForTable.getTitle();
        data = ForTable.getData();
        dtm = new DefaultTableModel(data, title);
        table_2 = new MainFrame.JReTable(dtm);
        table_2.setBackground(new Color(46, 58, 58));
        scrollPane.setViewportView(table_2);
        JToolBar toolBar = new JToolBar();
        panel.add(toolBar, "North");
        JButton button = new JButton("刷新");
        toolBar.add(button);
        JButton btnNewButton_2 = new JButton("插入");
        toolBar.add(btnNewButton_2);
        JButton btnNewButton = new JButton("删除");
        toolBar.add(btnNewButton);
        JButton btnNewButton_1 = new JButton("更新");
        toolBar.add(btnNewButton_1);
        JButton btnNewButton_3 = new JButton("打印");
        toolBar.add(btnNewButton_3);
        JButton btnNewButton_4 = new JButton("查询");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enquire1 dialog = new Enquire1(MainFrame.table_2, MainFrame.dtm);
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
                dialog.setResizable(false);
            }
        });
        toolBar.add(btnNewButton_4);
        JButton button_1 = new JButton("模糊");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enquire2 dialog = new Enquire2(MainFrame.table_2, MainFrame.dtm);
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
                dialog.setResizable(false);
            }
        });
        toolBar.add(button_1);
        JButton button_2 = new JButton("导出");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.outExcel();
            }
        });
        toolBar.add(button_2);
        JButton button_3 = new JButton("导入");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.inExcel();
            }
        });
        toolBar.add(button_3);
        JButton button_4 = new JButton("更多");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainFrame.table_2.getSelectedRow() == -1) {
                    FalseDialog dialog = new FalseDialog("未选中行！");
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } else {
                    try {
                        Details frame = new Details(Integer.valueOf((String)MainFrame.dtm.getValueAt(MainFrame.table_2.getSelectedRow(), MainFrame.dtm.findColumn("数据id"))));
                        frame.setVisible(true);
                        frame.setResizable(false);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                        FalseDialog.getFalseDialog("无法打开窗口");
                    }

                }
            }
        });
        toolBar.add(button_4);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MainFrame.table_2.print();
                } catch (PrinterException var3) {
                    var3.printStackTrace();
                    FalseDialog.getFalseDialog("打印失败！");
                }

            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainFrame.table_2.getSelectedRow() == -1) {
                    FalseDialog dialog = new FalseDialog("未选中行！");
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } else {
                    try {
                        UpdateTable dialogx = new UpdateTable(MainFrame.table_2, MainFrame.dtm, Integer.valueOf((String)MainFrame.dtm.getValueAt(MainFrame.table_2.getSelectedRow(), MainFrame.dtm.findColumn("数据id"))));
                        dialogx.setDefaultCloseOperation(2);
                        dialogx.setVisible(true);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                        FalseDialog.getFalseDialog("数据窗口打开失败！");
                    }

                }
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MainFrame.table_2.getSelectedRow() == -1) {
                        FalseDialog dialog = new FalseDialog("未选中行！");
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                        return;
                    }

                    MainFrame.this.delData();
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.insertData();
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.reflashTable();
            }
        });
    }

    public void reflashTable() {
        try {
            dtm.setDataVector(ForTable.getData(), ForTable.getTitle());
            table_2.updateUI();
        } catch (Exception var2) {
            FalseDialog.getFalseDialog("刷新失败！");
            var2.printStackTrace();
        }

    }

    public void insertData() {
        try {
            InsertData dialog = new InsertData(table_2, dtm);
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
            dialog.setResizable(false);
        } catch (Exception var2) {
            var2.printStackTrace();
            FalseDialog.getFalseDialog("对话框无法被创建！");
            System.out.println();
        }

    }

    public void delData() throws NumberFormatException, Exception {
        Vector<Integer> v = new Vector();

        int i;
        for(i = 0; i < table_2.getSelectedRows().length; ++i) {
            int temp = Integer.valueOf((String)dtm.getValueAt(table_2.getSelectedRows()[i], dtm.findColumn("数据id")));
            v.add(temp);
        }

        for(i = 0; i < v.size(); ++i) {
            DbOperate.delMember((Integer)v.get(i));
        }

        this.reflashTable();
    }

    private void outExcel() {
        FileDialog fd = new FileDialog(this, "保存表格内数据", 1);
        fd.setLocation(400, 250);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {
            String file = fd.getDirectory() + fd.getFile() + ".xls";

            try {
                ExcelIO.outTable(table_2, new File(file));
            } catch (IOException var4) {
                System.out.println(var4.getMessage());
                var4.printStackTrace();
            }

        }
    }

    private void inExcel() {
        try {
            try {
                ExpFrame frame = new ExpFrame("本输入将跳过所有空行或者第一列为空的行，\n并将每行前8个数据分别作为姓名,方向,年级,班级,电话,邮箱,宿舍,地址");
                frame.setVisible(true);
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        FileDialog fd = new FileDialog(this, "导入excel内数据", 0);
        fd.setLocation(400, 250);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {
            ExcelIO.inExcel(fd.getDirectory() + fd.getFile());

            try {
                dtm.setDataVector(ForTable.getData(), ForTable.getTitle());
                table_2.setModel(dtm);
                table_2.updateUI();
            } catch (Exception var3) {
                FalseDialog.getFalseDialog("刷新失败！");
                var3.printStackTrace();
            }

        }
    }

    class JReTable extends JTable {
        private static final long serialVersionUID = 1L;

        JReTable(DefaultTableModel dtm) {
            super(dtm);
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}
