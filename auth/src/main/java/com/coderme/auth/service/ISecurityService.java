package com.coderme.auth.service;

import com.coderme.auth.controller.param.LoginParam;
import com.coderme.auth.controller.param.RegisterParam;
import com.coderme.auth.data.base.AccessToken;

/**
 * @author qiudm
 * @date 2018/5/30 16:00
 * @desc
 */
public interface ISecurityService {

    /**
     * 注册
     * @param param
     */
    void register(RegisterParam param);


    /**
     * 登录
     * @param param
     */
    AccessToken login(LoginParam param);




}
