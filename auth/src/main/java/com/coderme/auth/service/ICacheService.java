package com.coderme.auth.service;

import com.coderme.auth.data.base.BasicUserInfo;

/**
 * @author qiudm
 * @date 2018/5/30 18:14
 * @desc
 */
public interface ICacheService {

    void cacheBasicUserInfo(BasicUserInfo basicUserInfo);

    BasicUserInfo getBasicUserInfo(String userId);




}
