package com.coderme.auth.dao;

import com.coderme.auth.data.po.User;

/**
 * @author qiudm
 * @date 2018/5/30 11:21
 * @desc
 */
public interface IUserDao {

    void insert(User user);

    User getByUserId(String userId);

    User getByTel(String tel);

    User getByNickName(String nickName);



}
