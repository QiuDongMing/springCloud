package com.coderme.utils;

import com.coderme.auth.constans.Constants;

/**
 * @author qiudm
 * @date 2018/5/31 13:38
 * @desc
 */
public class KeyBuilder {


    /**
     * 生成token相关缓存
     * @param cacheKeyPre
     * @param token
     * @return
     */
    public static String tokenKey(String cacheKeyPre, String token) {
        return String.format("%1$s:%2$s", cacheKeyPre, token);
    }

    /**
     * 用户基础信息
     * @return
     */
    public static String basicUserInfoKey() {
        return Constants.CacheKeyPre.BASIC_USER_INFO;
    }






}
