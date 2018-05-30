package com.coderme.commons.base.utils;

import java.util.Base64;

/**
 * @author qiudm
 * @date 2018/5/30 16:19
 * @desc
 */
public class BASE64Util {
    public BASE64Util() {
    }

    public static String decodeAsString(String input) {
        return new String(Base64.getDecoder().decode(input));
    }

    public static byte[] decodeAsBytes(String input) {
        return Base64.getDecoder().decode(input);
    }

    public static String encode(byte[] buf) {
        return new String(Base64.getEncoder().encode(buf));
    }
}
