package com.coderme.auth.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/5/30 13:50
 * @desc
 */
public class UserEnums {


    public enum UserType {
        COMMON_USER(1, "普通用户"),
        SYS_USER(2, "系统用户");

        private int type;
        private String desc;

        UserType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 用户状态
     */
    public enum UserStatus {
        NOMAL(1,"正常"),
        WAIT_FOR_ACTIVE(2, "待激活"),
        FORBIDDEN(3, "禁用");

        private int status;
        private String desc;

        UserStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public int getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 账户类型
     */
    public enum AccountType {
        tel,
        wx,
        qq;

        public static List<String> getAllType() {
            return Arrays
                    .stream(AccountType.values()).map(AccountType::name)
                    .collect(Collectors.toList());
        }
    }


















}
