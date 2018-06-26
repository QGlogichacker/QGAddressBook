package com.liangjiahao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DbPassword {
    public DbPassword() {
    }

    public static void updatePassword(String name, String password) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "UPDATE user SET UserPassword =? WHERE UserName = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setString(2, name);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static void main(String[] args) throws Exception {
        updatePassword("11", "233333");
    }
}
