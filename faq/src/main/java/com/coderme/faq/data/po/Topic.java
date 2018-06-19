package com.coderme.faq.data.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author qiudm
 * @date 2018/5/25 14:48
 * @desc
 */
@Document(collection="t_topic")
@Data
public class Topic {

    @Id
    private String id;

    private String userId;

    private String title;

    private String content;

    private Long createTime;


}
