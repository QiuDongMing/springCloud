package com.coderme.faq.controller.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author qiudm
 * @date 2018/5/28 17:33
 * @desc
 */
@Data
public class TopicParam {

    private String id;

    @NotBlank(message = "标题不能为空")
    private String title;

    private String content;

}
