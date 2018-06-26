package com.liangjiahao.dao;

import com.liangjiahao.view.FalseDialog;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Clob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbBLOB {
    public DbBLOB() {
    }

    public static void addText(File f, int id) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "UPDATE qgtest SET context = ? Where id =" + id;
        PreparedStatement pstmt = con.prepareStatement(sql);
        InputStream inFile = new FileInputStream(f);
        pstmt.setAsciiStream(1, inFile, f.length());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            FalseDialog.getFalseDialog("成功！");
        } else {
            FalseDialog.getFalseDialog("失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static String getText(int id) throws Exception {
        DbUtil dbu = new DbUtil();
        String s = null;
        Connection con = dbu.getCon();
        String sql = "select context from qgtest where id = " + id;
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Clob c = (Clob)rs.getClob("context");
            if (c == null) {
                return "";
            }

            s = new String(c.getSubString(1L, (int)c.length()));
        }

        dbu.close(pstmt, con);
        return s;
    }

    public static void addPic(File f, int id) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "UPDATE qgtest SET pic = ? Where id =" + id;
        PreparedStatement pstmt = con.prepareStatement(sql);
        InputStream inFile = new FileInputStream(f);
        pstmt.setBinaryStream(1, inFile, f.length());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            FalseDialog.getFalseDialog("成功！");
        } else {
            FalseDialog.getFalseDialog("失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static boolean getPic(int id) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "select pic from qgtest where id = " + id;
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Blob b = (Blob)rs.getBlob("pic");
            if (b == null) {
                return false;
            } else {
                FileOutputStream out = new FileOutputStream(new File("D:\\writed" + id + ".png"));
                out.write(b.getBytes(1L, (int)b.length()));
                out.close();
                dbu.close(pstmt, con);
                return true;
            }
        } else {
            FalseDialog.getFalseDialog("连接不到数据库！");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        addPic(new File("/home/logichacker/java_project/src/com/images/QGLogin2.jpg"), 1);
    }
}