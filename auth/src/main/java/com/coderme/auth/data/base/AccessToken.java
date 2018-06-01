package com.coderme.auth.data.base;

/**
 * @author qiudm
 * @date 2018/5/31 14:09
 * @desc
 */
public class AccessToken {

    private String openId;

    private String userId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
