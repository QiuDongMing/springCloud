package com.coderme.auth.data.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author qiudm
 * @date 2018/5/29 18:25
 * @desc
 */
@Document(collection="t_user")
public class User {

    @Id
    private String id;

    private String userId;

    private String name;

    private String nickName;

    private String password;

    private Integer userType;

    private Long birthday;

    private String tel;

    private Long createTime;

    private Integer status;







}
