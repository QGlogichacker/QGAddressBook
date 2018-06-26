package com.liangjiahao.view;

import com.liangjiahao.model.User;
import com.liangjiahao.service.DbLogin;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.RavenGraphiteSkin;
import org.jvnet.substance.theme.SubstanceDarkVioletTheme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = -1659204222296907123L;
    private JPanel contentPane;
    private JTextField userNameT;
    private JPanel panel;
    private JPasswordField passwordT;
    private JButton button;
    private JButton button_1;

    public static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys
                .hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceDarkVioletTheme());
            SubstanceLookAndFeel.setSkin(new RavenGraphiteSkin());
            InitGlobalFont(new Font("Dialog", Font.PLAIN, 14));

        } catch (Exception var2) {
            FalseDialog.getFalseDialog("美化包加载失败");
        }


        LoginFrame frame = null;
        try {
            frame = new LoginFrame();
            frame.setResizable(false);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getMainFrame() throws Exception {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public LoginFrame() throws IOException {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ExpFrame.class.getResource("/images/QGicon.png")));
        this.setForeground(new Color(47, 79, 79));
        this.setAlwaysOnTop(true);
        this.setBackground(new Color(0, 0, 0));
        this.setDefaultCloseOperation(3);
        this.setTitle("QG Member System");
        this.setBounds(100, 100, 500, 361);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, 501, 330);
        this.contentPane.add(this.panel);
        this.panel.setLayout(null);
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!LoginFrame.this.userNameT.getText().equals("") && !LoginFrame.this.passwordT.getText().equals("")) {
                    User us = new User(LoginFrame.this.userNameT.getText(), LoginFrame.this.passwordT.getText());

                    try {
                        if (DbLogin.DbCheck(us)) {
                            System.out.println("用户通过验证");
                            LoginFrame.this.getMainFrame();
                            LoginFrame.this.close();
                        } else {
                            FalseDialog dialogx = new FalseDialog("用户名或密码错误！");
                            dialogx.setDefaultCloseOperation(2);
                            dialogx.setVisible(true);
                        }
                    } catch (Exception var4) {
                        var4.printStackTrace();
                        System.out.println("无法链接数据库");
                    }

                } else {
                    FalseDialog dialog = new FalseDialog("用户名或密码不能为空！");
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                }
            }
        });
        this.button = new JButton("");
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.userNameT.setText("");
            }
        });
        JButton button_2 = new JButton("");
        button_2.setBounds(149, 253, 47, 47);
        button_2.setContentAreaFilled(false);
        button_2.setBorderPainted(false);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!LoginFrame.this.userNameT.getText().equals("") && !LoginFrame.this.passwordT.getText().equals("")) {
                    User us = new User(LoginFrame.this.userNameT.getText(), LoginFrame.this.passwordT.getText());

                    try {
                        if (DbLogin.DbCheck(us)) {
                            System.out.println("OK");
                            ChangePassword.getFrame((String[])null);
                        } else {
                            FalseDialog dialogx = new FalseDialog("用户名或密码错误！");
                            dialogx.setDefaultCloseOperation(2);
                            dialogx.setVisible(true);
                        }
                    } catch (Exception var4) {
                        var4.printStackTrace();
                        System.out.println("无法链接数据库");
                    }

                } else {
                    FalseDialog dialog = new FalseDialog("用户名或密码不能为空！");
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                }
            }
        });
        button_2.setBounds(149, 253, 52, 43);
        this.panel.add(button_2);
        this.button.setContentAreaFilled(false);
        this.button.setBorderPainted(false);
        this.button.setBounds(113, 133, 47, 47);
        this.panel.add(this.button);
        this.button_1 = new JButton("");
        this.button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.passwordT.setText("");
            }
        });
        this.button_1.setContentAreaFilled(false);
        this.button_1.setBorderPainted(false);
        this.button_1.setBounds(113, 193, 47, 47);
        this.panel.add(this.button_1);
        btnNewButton.setBounds(327, 249, 47, 47);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        this.panel.add(btnNewButton);
        this.userNameT = new JTextField();
        this.userNameT.setForeground(new Color(255, 255, 255));
        this.userNameT.setFont(new Font("微软雅黑", 0, 24));
        this.userNameT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.userNameT.setText("");
            }
        });
        this.userNameT.setBounds(185, 139, 176, 30);
        this.panel.add(this.userNameT);
        this.userNameT.setBackground(new Color(40, 50, 52));
        this.userNameT.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.userNameT.setColumns(10);
        this.passwordT = new JPasswordField();
        this.passwordT.setFont(new Font("宋体", 0, 24));
        this.passwordT.setForeground(new Color(255, 255, 255));
        this.passwordT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.this.passwordT.setText("");
            }
        });
        this.passwordT.setBounds(183, 197, 179, 30);
        this.passwordT.setBackground(new Color(40, 50, 52));
        this.passwordT.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.panel.add(this.passwordT);
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 501, 330);
        this.panel.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ExpFrame.class.getResource("/images/QGLogin2.jpg"))));
    }

    private void close() {
        this.dispose();
    }
}
