package com.lemonwind.test.utils;

/**
 * create by lemonwind on 2018/11/21
 */
public enum ColorEnum {

    BLACK(0, "黑色"),
    WRITE(1, "白色"),
    RED(2, "红色")

    ;

    private int code;
    private String remark;

    ColorEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }

}
