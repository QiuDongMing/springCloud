package com.coderme.commons.base.enums;

/**
 * @author qiudm
 * @date 2018/5/29 14:15
 * @desc
 */
public enum CommonErrorCodes {
    SUCCESS(1, "成功"),
    FAILURE(0, "失败"),
    ACCOUNT_NOT_EXIST(100100, "账户不存在");


    private int code;
    private String desc;

    private CommonErrorCodes(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
