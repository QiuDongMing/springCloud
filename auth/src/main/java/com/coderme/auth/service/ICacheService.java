package com.coderme.auth.service;

import com.coderme.auth.data.base.AccessToken;
import com.coderme.auth.data.base.BasicUserInfo;

/**
 * @author qiudm
 * @date 2018/5/30 18:14
 * @desc
 */
public interface ICacheService {

    /**
     * 缓存基础用户信息
     *
     * @param basicUserInfo
     */
    void cacheBasicUserInfo(BasicUserInfo basicUserInfo);

    /**
     * 获取基础用户信息
     *
     * @param userId
     * @return
     */
    BasicUserInfo getBasicUserInfo(String userId);


    /**
     * 缓存登录用户token
     * @param token
     */
    void cacheLoginUserToken(String token, long t, AccessToken accessToken);


    /**
     * 获取登录用户token
     * @param token
     * @return
     */
    AccessToken getCacheLoginUserToken(String token);





}
