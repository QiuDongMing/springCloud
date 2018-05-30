package com.coderme.auth.dao;


/**
 * @author qiudm
 * @date 2018/5/30 11:22
 * @desc
 */
public interface IUserIdxDao {


    String nextUserId(Integer userType);


    void initUserIdx(Integer userType);


}
