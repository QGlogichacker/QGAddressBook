package com.liangjiahao.dao;

import com.liangjiahao.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbOperate {
    public DbOperate() {
    }

    public static void delMember(Member mem) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "delete from qgtest where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, mem.getId());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static void delMember(int i) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "delete from qgtest where id=" + i;
        PreparedStatement pstmt = con.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        if (result != 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static void addMember(Member mem) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "INSERT INTO qgtest VALUES(null,?,?,?,?,?,?,?,?,null,null)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, mem.getName());
        pstmt.setString(2, mem.getGroup());
        pstmt.setString(3, mem.getGrade());
        pstmt.setString(4, mem.getClas());
        pstmt.setString(5, mem.getPhone());
        pstmt.setString(6, mem.getEmail());
        pstmt.setString(7, mem.getDormitory());
        pstmt.setString(8, mem.getAddress());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static void main(String[] args) throws Exception {
        enquireAll();
    }

    public static void updateMember(Member mem) throws Exception {
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "UPDATE qgtest SET namee = ? ,groupp = ?,grade = ?,class = ?,phone =?,email = ?,dormitory = ?,address = ? WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, mem.getName());
        pstmt.setString(2, mem.getGroup());
        pstmt.setString(3, mem.getGrade());
        pstmt.setString(4, mem.getClas());
        pstmt.setString(5, mem.getPhone());
        pstmt.setString(6, mem.getEmail());
        pstmt.setString(7, mem.getDormitory());
        pstmt.setString(8, mem.getAddress());
        pstmt.setInt(9, mem.getId());
        int result = pstmt.executeUpdate();
        if (result != 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }

        dbu.close((com.mysql.jdbc.PreparedStatement)pstmt, con);
    }

    public static List<Member> enquireAll() throws Exception {
        List<Member> memberList = new ArrayList();
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "select id,namee,groupp,grade,class,phone,email,dormitory,address from qgtest";
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String mName = rs.getString("namee");
            String mGroup = rs.getString("groupp");
            String mGrade = rs.getString("grade");
            String mClas = rs.getString("class");
            String mPhone = rs.getString("phone");
            String mEmail = rs.getString("email");
            String mDor = rs.getString("dormitory");
            String mAdd = rs.getString("address");
            Member mem = new Member(id, mName, mGroup, mGrade, mClas, mPhone, mEmail, mDor, mAdd);
            memberList.add(mem);
        }

        dbu.close(pstmt, con);
        return memberList;
    }

    public static List<Member> enquirePart(String s1, String s2) throws Exception {
        List<Member> memberList = new ArrayList();
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "select id,namee,groupp,grade,class,phone,email,dormitory,address from qgtest WHERE " + s1 + " = '" + s2 + "'";
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String mName = rs.getString("namee");
            String mGroup = rs.getString("groupp");
            String mGrade = rs.getString("grade");
            String mClas = rs.getString("class");
            String mPhone = rs.getString("phone");
            String mEmail = rs.getString("email");
            String mDor = rs.getString("dormitory");
            String mAdd = rs.getString("address");
            Member mem = new Member(id, mName, mGroup, mGrade, mClas, mPhone, mEmail, mDor, mAdd);
            memberList.add(mem);
        }

        dbu.close(pstmt, con);
        return memberList;
    }

    public static List<Member> enquirePart(String s1) throws Exception {
        List<Member> memberList = new ArrayList();
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "SELECT * FROM qgtest WHERE namee = '" + s1 + "' OR groupp = '" + s1 + "' OR class = '" + s1 + "' OR phone = '" + s1 + "' OR email = '" + s1 + "' OR dormitory = '" + s1 + "' OR address = '" + s1 + "'";
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String mName = rs.getString("namee");
            String mGroup = rs.getString("groupp");
            String mGrade = rs.getString("grade");
            String mClas = rs.getString("class");
            String mPhone = rs.getString("phone");
            String mEmail = rs.getString("email");
            String mDor = rs.getString("dormitory");
            String mAdd = rs.getString("address");
            Member mem = new Member(id, mName, mGroup, mGrade, mClas, mPhone, mEmail, mDor, mAdd);
            memberList.add(mem);
        }

        dbu.close(pstmt, con);
        return memberList;
    }

    public static List<Member> fuzzyEnquirePart(String s1, String s2) throws Exception {
        List<Member> memberList = new ArrayList();
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "select id,namee,groupp,grade,class,phone,email,dormitory,address from qgtest WHERE " + s1 + " LIKE '" + s2 + "'";
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String mName = rs.getString("namee");
            String mGroup = rs.getString("groupp");
            String mGrade = rs.getString("grade");
            String mClas = rs.getString("class");
            String mPhone = rs.getString("phone");
            String mEmail = rs.getString("email");
            String mDor = rs.getString("dormitory");
            String mAdd = rs.getString("address");
            Member mem = new Member(id, mName, mGroup, mGrade, mClas, mPhone, mEmail, mDor, mAdd);
            memberList.add(mem);
        }

        dbu.close(pstmt, con);
        return memberList;
    }

    public static List<Member> fuzzyEnquirePart(String s1) throws Exception {
        List<Member> memberList = new ArrayList();
        DbUtil dbu = new DbUtil();
        Connection con = dbu.getCon();
        String sql = "SELECT * FROM qgtest WHERE namee LIKE '" + s1 + "' OR groupp LIKE '" + s1 + "' OR class LIKE '" + s1 + "' OR phone LIKE '" + s1 + "' OR email LIKE '" + s1 + "' OR dormitory LIKE '" + s1 + "' OR address LIKE '" + s1 + "'";
        com.mysql.jdbc.PreparedStatement pstmt = (com.mysql.jdbc.PreparedStatement)con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String mName = rs.getString("namee");
            String mGroup = rs.getString("groupp");
            String mGrade = rs.getString("grade");
            String mClas = rs.getString("class");
            String mPhone = rs.getString("phone");
            String mEmail = rs.getString("email");
            String mDor = rs.getString("dormitory");
            String mAdd = rs.getString("address");
            Member mem = new Member(id, mName, mGroup, mGrade, mClas, mPhone, mEmail, mDor, mAdd);
            memberList.add(mem);
        }

        dbu.close(pstmt, con);
        return memberList;
    }
}