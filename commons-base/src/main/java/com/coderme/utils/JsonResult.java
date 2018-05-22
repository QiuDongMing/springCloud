package com.coderme.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author qiudm
 * @date 2018/5/22 12:31
 * @desc
 */
public class JsonResult extends JSONObject {

    private static final long serialVersionUID = 1L;

    private static final int SUCCESS = 0;

    private static final int FAILURE = 1;

    private static final int ERROR = 500;


    public JsonResult(int resultCode, String resultMsg) {
        setResultCode(resultCode);
        setResultMsg(resultMsg);
    }

    public JsonResult(int resultCode, String resultMsg, Object data) {
        setResultCode(resultCode);
        setResultMsg(resultMsg);
        setData(data);
    }



    public static JsonResult SUCCESS(String resultMsg) {
        return new JsonResult(SUCCESS, resultMsg);
    }

    public static JsonResult SUCCESS() {
        return SUCCESS(null);
    }

    public static JsonResult SUCCESS(String resultMsg, Object data) {
        return new JsonResult(SUCCESS, resultMsg, data);
    }

    public static JsonResult SUCCESS(Object data) {
        return SUCCESS(null, data);
    }


    public static JsonResult FAILURE(String resultMsg) {
        return new JsonResult(FAILURE, resultMsg);
    }


    public static JsonResult ERROR(Exception e) {
        return new JsonResult(ERROR, "服务器繁忙", e.getMessage());
    }



    public Object getResultCode() {
        return get("resultCode");
    }

    public void setResultCode(int resultCode) {
       put("resultCode", resultCode);
    }

    public String getResultMsg() {
        return getString("resultMsg");
    }

    public void setResultMsg(String resultMsg) {
        put("resultMsg", resultMsg);
    }

    public Object getData() {
        return get("data");
    }

    public void setData(Object data) {
        put("data", data);
    }
}
