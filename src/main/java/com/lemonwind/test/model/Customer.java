package com.lemonwind.test.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * create by lemonwind on 2018/12/5
 */
public class Customer {

    @Range(min = 0, max = 5, message = "cid 应该在 {min} 和 {max} 之间")
    private int cid;
    @NotEmpty(message = "用户姓名不能为空")
    private String name;
    @Range(min=0, max = 200, message = "年龄应该在 {min} 和 {max} 之间")
    private int age;
    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotNull(message = "创建的功夫不能为空")
    private Kongfu kongfu;

    public Customer(int cid, String name, int age, String address, Kongfu kongfu) {
        this.cid = cid;
        this.name = name;
        this.age = age;
        this.address = address;
        this.kongfu = kongfu;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public Kongfu getKongfu() {
        return kongfu;
    }

    public void setKongfu(Kongfu kongfu) {
        this.kongfu = kongfu;
    }
}
