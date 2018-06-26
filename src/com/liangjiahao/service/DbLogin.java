package com.liangjiahao.service;

import com.liangjiahao.dao.DbUtil;
import com.liangjiahao.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbLogin {
    public DbLogin() {
    }

    public static void main(String[] args) throws Exception {
        User us = new User("11", "11");
        System.out.println(DbCheck(us));
    }

    public static boolean DbCheck(User us) throws Exception {
        DbUtil db = new DbUtil();
        Connection con = db.getCon();
        String sql = "select * from user";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        do {
            if (!rs.next()) {
                db.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
                return false;
            }
        } while(!us.getUserName().equals(rs.getString("UserName")) || !us.getUserPassword().equals(rs.getString("UserPassword")));

        return true;
    }
}
