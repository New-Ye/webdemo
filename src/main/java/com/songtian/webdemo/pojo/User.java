package com.songtian.webdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private Integer sex;
    private Integer age;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthDate;
    private List<Slave> list;

    @Override
    public String toString() {
        return "User{" +
                " name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", list=" + list +
                '}';
    }

    public List<Slave> getList() {
        return list;
    }

    public void setList(List<Slave> list) {
        this.list = list;
    }
/*
    private String slave;


    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthdate='" + birthdate + '\'' +
                ", salve='" + slave + '\'' +
                '}';
    }


    public String getSalve() {
        return slave;
    }

    public void setSalve(String salve) {
        this.slave = salve;
    }
*/

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
