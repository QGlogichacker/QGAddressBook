package com.liangjiahao.model;

public class Member {
    private int id;
    private String name;
    private String group;
    private String grade;
    private String clas;
    private String phone;
    private String email;
    private String dormitory;
    private String address;

    public Member(int id, String name, String group, String grade, String clas, String phone, String email, String dormitory, String address) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.grade = grade;
        this.clas = clas;
        this.phone = phone;
        this.email = email;
        this.dormitory = dormitory;
        this.address = address;
    }

    public Member(String name, String group, String grade, String clas, String phone, String email, String dormitory, String address) {
        this.name = name;
        this.group = group;
        this.grade = grade;
        this.clas = clas;
        this.phone = phone;
        this.email = email;
        this.dormitory = dormitory;
        this.address = address;
    }

    public Member(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClas() {
        return this.clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDormitory() {
        return this.dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        String st = null;
        st = "姓名" + this.name + "方向" + this.group + "年级" + this.grade + "班级" + this.clas + "电话" + this.phone + "邮箱" + this.email + "宿舍" + this.dormitory + "地址" + this.address;
        return st;
    }
}
