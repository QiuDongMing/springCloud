package com.coderme.commons.base.utils;


import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author qiudm
 * @date 2018/5/30 16:18
 * @desc
 */
public class Md5Util {
    private static final String mex = "a";
    private static final String outerSalt = "87dfsfg908jklkjer";
    private static final String HMAC_SHA1 = "HmacSHA1";

    public Md5Util() {
    }

    public static String md5Hex(String key) {
        return DigestUtils.md5Hex("a" + key);
    }

    public static String outerMd5Hex(String key) {
        return DigestUtils.md5Hex("87dfsfg908jklkjer" + key);
    }

    public static String hmac_sha1(String key, String data) {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");

        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] e = mac.doFinal(data.getBytes());
            return BASE64Util.encode(e);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
