package com.coderme.auth.controller.param;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author qiudm
 * @date 2018/5/30 17:53
 * @desc 普通用户注册参数
 */
public class RegisterParam {

    private String name;

    @Size(min = 11, max = 11, message = "手机号长度为11位")
    @Pattern(regexp = "^1[1-9]{10}", message = "手机格式不正确")
    private String tel;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    private String headPic;

    @Size(min = 6, max = 20, message="密码长度6-20位")
    @Pattern(regexp="[_a-zA-Z0-9]+", message="密码为字母数字下划线组成")
    @NotBlank(message = "密码不能为空")
    private String password;

    private Long birthday;

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

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
}
