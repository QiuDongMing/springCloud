package com.coderme.demo.enums;

/**
 * @author qiudm
 * @date 2018/5/29 9:56
 * @desc
 */
public class AccountEnum {

    public enum AccountType {
        tel,
        wechat;
    }


    public static void main(String[] args) {

        System.out.println("AccountType.tel.name() = " + AccountType.tel.name());

    }



}
