package com.liangjiahao.dao;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static String dbUrl = "jdbc:mysql://localhost:3306/qg?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String dbUserName = "root";
    private static String dbPassword = "logichacker";
    private static String jdbcName = "com.mysql.jdbc.Driver";

    public DbUtil() {
    }

    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    public void close(PreparedStatement pstmt, Connection con) throws Exception {
        if (pstmt != null) {
            pstmt.close();
            if (con != null) {
                con.close();
            }
        }

    }

    public static void main(String[] ages) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        con.close();
    }
}
