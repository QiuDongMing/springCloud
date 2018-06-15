package com.coderme.faq.dao.impl;

import com.coderme.faq.dao.ITopicDao;
import com.coderme.faq.data.po.Topic;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public void update(String id, Map<String, Object> updateFiledMaps, Class<?> clazz) {
        if(Objects.isNull(id) || CollectionUtils.isEmpty(updateFiledMaps)) {
            return;
        }
        Criteria criteria = new Criteria("_id").is(id);
        Update update = new Update();
        updateFiledMaps.entrySet().forEach(entry -> update.set(entry.getKey(), entry.getValue()));
        mongoTemplate.findAndModify(new Query(criteria), update, clazz);
    }

}
