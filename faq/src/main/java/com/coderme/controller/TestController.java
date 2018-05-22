package com.coderme.controller;

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
@RequestMapping
public class TestController {

    @GetMapping("test")
    public JsonResult test() {
        return JsonResult.SUCCESS("test");
    }


}
