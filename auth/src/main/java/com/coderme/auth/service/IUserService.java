package com.coderme.auth.service;

import com.coderme.auth.data.base.BasicUserInfo;

/**
 * @author qiudm
 * @date 2018/5/30 14:57
 * @desc
 */
public interface IUserService {

    BasicUserInfo getBasicUserInfo(String userId);


}
