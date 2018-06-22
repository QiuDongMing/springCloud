package com.coderme.faq.controller;

import com.coderme.commons.base.utils.JsonResult;
import com.coderme.faq.service.ITestService;
import com.coderme.utils.redislock.RedisLock;
import com.coderme.utils.redislock.RedisParamLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private ITestService testService;

    @Value("${env.name}") // git配置文件里的key
            String envName;


    @GetMapping("test/{id}")
    @RedisLock(key = "lock:")
    public JsonResult test(@RedisParamLock @PathVariable String id) {
        return JsonResult.SUCCESS("faq test envName:" + envName + ",id=" + id);
    }

    public void test2(String name, Integer age, String str) {

        String s = str;
    }


    @RequestMapping("asyncTest/{count}")
    public JsonResult asyncTest(@PathVariable int count) {
        testService.asyncTest(count);
        return JsonResult.SUCCESS();
    }



}
