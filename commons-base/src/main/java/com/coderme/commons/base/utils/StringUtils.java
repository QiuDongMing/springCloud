package com.coderme.commons.base.utils;

import java.util.UUID;

/**
 * @author qiudm
 * @date 2018/5/31 14:34
 * @desc
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-", "");
        return uuidStr;
    }


}
