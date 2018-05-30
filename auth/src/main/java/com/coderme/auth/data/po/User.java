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

    private String tel;

    private String nickName;

    private String headPic;

    private String password;

    /**
     * 用户类型
     * @see com.coderme.auth.enums.UserEnums.UserType
     */
    private Integer userType;

    /**
     * 用户状态
     * @see com.coderme.auth.enums.UserEnums.UserStatus
     */
    private Integer status;

    /**
     * 简介
     */
    private String intro;

    private Long birthday;

    private Long registerTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegistTime(Long registerTime) {
        this.registerTime = registerTime;
    }
}
