package com.coderme.faq.controller.param;

import org.hibernate.validator.constraints.NotBlank;
/**
 * @author qiudm
 * @date 2018/5/28 17:33
 * @desc
 */
public class TopicParam {

    @NotBlank(message = "标题不能为空")
    private String title;




}
