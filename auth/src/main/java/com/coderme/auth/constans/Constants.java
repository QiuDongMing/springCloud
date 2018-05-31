package com.coderme.auth.constans;

/**
 * @author qiudm
 * @date 2018/5/31 13:50
 * @desc
 */
public class Constants {


    /**
     * 过期时间 单位：毫秒
     */
    public interface Expire {
        long SECOND = 1000L;
        long MINUTE = 60000L;
        long HOURE = 3600000L;
        long MONTH = 108000000L;
    }


    /**
     * 缓存前缀
     */
    public interface CacheKeyPre {
        String TOKEN_USER_LOGIN = "token_user_login";
        String BASIC_USER_INFO = "basic_user_info";
    }













}
