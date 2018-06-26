package com.liangjiahao.view;

import com.liangjiahao.dao.DbBLOB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Details extends JFrame {
    private static final long serialVersionUID = 9182721252071158263L;
    private JPanel contentPane;
    private boolean hasImage;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Details frame = new Details(1);
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public Details(final int id) throws Exception {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ExpFrame.class.getResource("/images/QGicon.png")));
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 721, 706);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);
        JDesktopPane desktopPane = new JDesktopPane();
        this.contentPane.add(desktopPane, "Center");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 149, 665, 487);
        desktopPane.add(scrollPane);
        final JTextArea tA = new JTextArea(DbBLOB.getText(id));
        scrollPane.setViewportView(tA);
        this.lblNewLabel = new JLabel("");
        this.hasImage = DbBLOB.getPic(id);
        if (this.hasImage) {
            this.lblNewLabel.setIcon(this.getIcon(id));
        }

        this.lblNewLabel.setBounds(509, 13, 156, 129);
        desktopPane.add(this.lblNewLabel);
        JButton button = new JButton("修改文本");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = "";

                try {
                    s = Details.this.inText(id);
                } catch (Exception var4) {
                    var4.printStackTrace();
                    FalseDialog.getFalseDialog("无法插入到数据库");
                }

                tA.setText(s);
                tA.updateUI();
            }
        });
        button.setBounds(14, 109, 93, 27);
        desktopPane.add(button);
        JButton button_1 = new JButton("修改图片");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Details.this.inPic(id);
                } catch (Exception var3) {
                    var3.printStackTrace();
                    FalseDialog.getFalseDialog("无法插入到数据库");
                }

            }
        });
        button_1.setBounds(382, 109, 113, 27);
        desktopPane.add(button_1);
    }

    private String inText(int id) throws Exception {
        FileDialog fd = new FileDialog(this, "选择你的文件", 0);
        fd.setLocation(400, 250);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {
            DbBLOB.addText(new File(fd.getDirectory() + fd.getFile()), id);
            String c = DbBLOB.getText(id);
            return c;
        } else {
            return "";
        }
    }

    private void inPic(int id) throws Exception {
        FileDialog fd = new FileDialog(this, "选择你的图片", 0);
        fd.setLocation(400, 250);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {
            DbBLOB.addPic(new File(fd.getDirectory() + fd.getFile()), id);
            DbBLOB.getPic(id);
            this.lblNewLabel.setIcon(this.getIcon(id));
            this.lblNewLabel.updateUI();
        }
    }

    public ImageIcon getIcon(int id) {
        ImageIcon imageIcon = new ImageIcon("D:\\writed" + id + ".png");
        Image image = imageIcon.getImage();
        Image smallImage = image.getScaledInstance(122, 162, 2);
        ImageIcon smallIcon = new ImageIcon(smallImage);
        return smallIcon;
    }
}
