package com.jomchen.test.utils;

import java.util.EnumSet;

/**
 * create by Jomchen on 12/30/18
 */
public enum CodeEnum {

    FAIL(-1, "fail"),
    SUCCESS(0, "success")

    ;

    private int code;
    private String message;
    private static EnumSet<CodeEnum> CODE_ENUM = EnumSet.allOf(CodeEnum.class);

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static CodeEnum getCodeEnum(int code) {
        for (CodeEnum codeEnum : CODE_ENUM) {
            if (code == codeEnum.getCode()) {
                return codeEnum;
            }
        }
        return null;
    }
}
