package com.jomchen.test.utils;

/**
 * create by Jomchen on 2018/11/21
 */
public enum TypeEnum {

    OBJECT(0, "对象"),
    ARRAY(1, "数组"),
    LIST(2, "LIST集合")

    ;

    private int code;
    private String remark;

    TypeEnum(int code, String remark) {
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
