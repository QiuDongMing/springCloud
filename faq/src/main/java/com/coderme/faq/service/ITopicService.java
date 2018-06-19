package com.coderme.faq.service;

import com.coderme.commons.base.utils.PageVO;
import com.coderme.faq.controller.param.TopicParam;
import com.coderme.faq.data.po.Topic;

/**
 * @author qiudm
 * @date 2018/6/19 16:06
 * @desc
 */
public interface ITopicService {

    /**
     * 新增帖子
     * @param param
     * @param userId
     * @return
     */
    String publish(TopicParam param, String userId);

    /**
     *
     * @param param
     * @param userId
     */
    void update(TopicParam param, String userId);


    Topic getById(String id);


    PageVO<Topic> list(Integer pageIndex, Integer pageSize);
}
