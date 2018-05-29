package com.coderme.demo.rebuild;

/**
 * @author qiudm
 * @date 2018/5/29 10:55
 * @desc
 */
public class A {

    public void methold(AParam AParam) {


    }


    public void methold2() {
        String name = "a";
        Integer age = 10;
        methold(new AParam(name, age));
    }



}
