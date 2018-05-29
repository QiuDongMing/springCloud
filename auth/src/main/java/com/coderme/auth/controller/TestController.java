package com.coderme.auth.controller;
import com.coderme.auth.service.remote.FaqService;
import com.coderme.commons.base.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiudm
 * @date 2018/5/23 19:19
 * @desc
 */
@RestController
@RequestMapping("test")
public class TestController {

//    @Autowired
//    private FaqService faqService;

    @GetMapping("test")
    public JsonResult test() {
        return JsonResult.SUCCESS("auth test");
    }

//    @GetMapping("faqTest")
//    public JsonResult faqTest() {
//        return faqService.test();
//    }



}
