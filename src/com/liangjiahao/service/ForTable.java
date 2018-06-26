package com.liangjiahao.service;

import com.liangjiahao.dao.DbOperate;
import com.liangjiahao.model.Member;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class ForTable {
    public ForTable() {
    }

    public static DefaultTableModel getModel() throws Exception {
        Vector<String> title = new Vector();
        title.add("数据id");
        title.add("姓名");
        title.add("方向");
        title.add("年级");
        title.add("班级");
        title.add("电话");
        title.add("邮箱");
        title.add("宿舍");
        title.add("地址");
        List<Member> vm = DbOperate.enquireAll();
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        DefaultTableModel dtm = new DefaultTableModel(data, title);
        return dtm;
    }

    public static Vector<Vector<String>> getData() throws Exception {
        List<Member> vm = DbOperate.enquireAll();
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        return data;
    }

    public static Vector<String> getTitle() throws Exception {
        Vector<String> title = new Vector();
        title.add("数据id");
        title.add("姓名");
        title.add("方向");
        title.add("年级");
        title.add("班级");
        title.add("电话");
        title.add("邮箱");
        title.add("宿舍");
        title.add("地址");
        return title;
    }

    public static Vector<Vector<String>> getPartData(String s1, String s2) throws Exception {
        List<Member> vm = DbOperate.enquirePart(s1, s2);
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        return data;
    }

    public static Vector<Vector<String>> getPartData(String s1) throws Exception {
        List<Member> vm = DbOperate.enquirePart(s1);
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        return data;
    }

    public static Vector<Vector<String>> getFuzzyPartData(String s1, String s2) throws Exception {
        List<Member> vm = DbOperate.fuzzyEnquirePart(s1, s2);
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        return data;
    }

    public static Vector<Vector<String>> getFuzzyPartData(String s1) throws Exception {
        List<Member> vm = DbOperate.fuzzyEnquirePart(s1);
        Vector<Vector<String>> data = new Vector();

        for(int i = 0; i < vm.size(); ++i) {
            Vector<String> v = new Vector();
            Member mem = (Member)vm.get(i);
            v.add(String.valueOf(mem.getId()));
            v.add(mem.getName());
            v.add(mem.getGroup());
            v.add(mem.getGrade());
            v.add(mem.getClas());
            v.add(mem.getPhone());
            v.add(mem.getEmail());
            v.add(mem.getDormitory());
            v.add(mem.getAddress());
            data.add(v);
        }

        return data;
    }
}
