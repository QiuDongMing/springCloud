package com.coderme.faq.dao;


import com.coderme.faq.data.po.Topic;

/**
 * @author qiudm
 * @date 2018/5/25 14:59
 * @desc
 */
public interface ITopicDao {

    void insertTopic(Topic topic);

    Topic findByPK(String id);


}
