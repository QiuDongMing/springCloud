package com.coderme.auth.controller.param;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author qiudm
 * @date 2018/5/31 10:22
 * @desc 登录参数
 */
public class LoginParam {

    /**
     * @see com.coderme.auth.enums.UserEnums.AccountType
     */
    @NotEmpty(message = "账户类型不能为空")
    private String accountType;

    private String accountNum;

    private String password;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
