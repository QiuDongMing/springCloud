package com.coderme.faq.controller;

import com.coderme.faq.controller.param.TopicParam;
import com.coderme.commons.base.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author qiudm
 * @date 2018/5/28 17:28
 * @desc
 */
@RequestMapping("topic")
@RestController
public class TopicController {


    @PostMapping(value = "/publish")
    public JsonResult publish(@RequestBody @Valid TopicParam param) {

        return JsonResult.SUCCESS();
    }





}
