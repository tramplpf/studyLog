package com.lpf.domain;

/**
 * 定义一个实体类
 *
 * @author lpf
 * @date 2020/12/20 15:13
 */
public class Student {

    private String userName;
    private int age;
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
