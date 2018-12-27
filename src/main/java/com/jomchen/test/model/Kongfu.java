package com.jomchen.test.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * create by Jomchen on 2018/12/5
 */
public class Kongfu {

    @Range(min = 0, max = 5, message = "kid 应该在 {min} 和 {max} 之间")
    private int kid;
    @NotEmpty(message = "功夫名字不能为空")
    private String name;
    @Range(min = 0, max = 9, message = "等级应该在 {min} 和 {max} 之间")
    private int level;

    public Kongfu(int kid, String name, int level) {
        this.kid = kid;
        this.name = name;
        this.level = level;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
