package com.liuxin.toolbox.comparelist;

public class Person {
    private int id;

    private String name;

    private int age;

    private String address;

    private String tel;

    private String sex;

    private String remark;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Person(int id, String name, int age, String address, String tel, String sex, String remark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
        this.sex = sex;
        this.remark = remark;
    }
}
