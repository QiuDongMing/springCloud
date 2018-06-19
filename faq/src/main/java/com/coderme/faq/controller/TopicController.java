package com.coderme.faq.controller;

import com.coderme.faq.controller.param.TopicParam;
import com.coderme.commons.base.utils.JsonResult;
import com.coderme.faq.service.ITopicService;
import com.coderme.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author qiudm
 * @date 2018/5/28 17:28
 * @desc
 */
@RequestMapping("topic/")
@RestController
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @PostMapping(value = "publish")
    public JsonResult publish(@RequestBody @Valid TopicParam param) {
        String userId = ReqUtils.instance.getUserId();
        return JsonResult.SUCCESS(topicService.publish(param, userId));
    }

    @PostMapping(value = "update")
    public JsonResult update(@RequestBody @Valid TopicParam param) {
        String userId = ReqUtils.instance.getUserId();
        topicService.update(param, userId);
        return JsonResult.SUCCESS();
    }


    @GetMapping(value = "list/{pageIndex}/{pageSize}")
    public JsonResult list(@PathVariable Integer pageIndex, @PathVariable Integer pageSize) {
        return JsonResult.SUCCESS(topicService.list(pageIndex, pageSize));
    }









}
