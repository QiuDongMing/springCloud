package com.coderme.faq.controller;

import com.coderme.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/5/22 20:12
 * @desc
 */
@RestController
@RequestMapping("test")
public class TestController {


    @GetMapping("test")
    public JsonResult test() {
        return JsonResult.SUCCESS("faq test");
    }


    public void test2(String name, Integer age, String str) {

        String s = str;
    }





}
