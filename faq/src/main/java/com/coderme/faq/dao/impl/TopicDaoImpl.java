package com.coderme.faq.dao.impl;

import com.coderme.faq.dao.ITopicDao;
import com.coderme.faq.data.po.Topic;
import org.springframework.stereotype.Repository;

/**
 * @author qiudm
 * @date 2018/5/25 14:59
 * @desc
 */
@Repository
public class TopicDaoImpl extends BaseDaoImpl implements ITopicDao {

    @Override
    public void insertTopic(Topic topic) {
        mongoTemplate.insert(topic);
    }


    @Override
    public Topic findByPK(String id) {
        return mongoTemplate.findById(id, Topic.class);
    }
}
