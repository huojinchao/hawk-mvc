package com.hawk.mvc.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @author: huojc1
 * @createtime: 2019-09-03 22:18
 * <p>------------------------------------------------------------</p>
 * <p> Modification of records</p>
 * <p> Number, date, modifier, reason</p>
 * <p> 1 </p>
 **/
public class User {
    private String username;
    private String password;
    private String name;
    private Integer age;
    private Float salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  //获取数据格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //json 返回数据序列化
    private Date birthDay;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", birthDay=" + birthDay +
                '}';
    }
}
