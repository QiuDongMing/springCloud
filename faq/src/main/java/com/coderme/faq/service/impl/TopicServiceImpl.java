package com.coderme.faq.service.impl;

import com.coderme.commons.base.utils.IDGenerator;
import com.coderme.commons.base.utils.MapUtils;
import com.coderme.commons.base.utils.PageVO;
import com.coderme.faq.controller.param.TopicParam;
import com.coderme.faq.dao.ITopicDao;
import com.coderme.faq.data.po.Topic;
import com.coderme.faq.exception.ServiceException;
import com.coderme.faq.service.ITopicService;
import com.coderme.utils.redislock.RedisLock;
import com.coderme.utils.redislock.RedisParamLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/6/19 16:08
 * @desc
 */
@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicDao topicDao;

    @Override
    @RedisLock(key = "addTopic:", msg = "操作太频繁")
    public String publish(TopicParam param, @RedisParamLock String userId) {
        Topic topic =convertToTopic(param);
        String id = String.valueOf(IDGenerator.idWorker.nextId());
        topic.setId(id);
        topic.setCreateTime(System.currentTimeMillis());
        topic.setUserId(userId);
        topicDao.insertTopic(topic);
        return id;
    }


    @Override
    public void update(TopicParam param, String userId) {
        String id = param.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException("帖子id不能为空");
        }
        Topic topic = getById(id);
        if (Objects.isNull(topic)) {
            throw new ServiceException("帖子不存在");
        }

        topic.setTitle(param.getTitle());
        topic.setContent(param.getContent());

        Map<String, Object> updateMaps = MapUtils.java2Map(topic);
        topicDao.update(id, updateMaps, Topic.class);
    }


    private Topic convertToTopic(TopicParam param) {
        Topic topic = new Topic();
        topic.setId(param.getId());
        topic.setTitle(param.getTitle());
        topic.setContent(param.getContent());
        return topic;
    }


    @Override
    public PageVO<Topic> list(Integer pageIndex, Integer pageSize) {
        PageVO<Topic> list = topicDao.findList(pageIndex, pageSize);
        return list;
    }

    @Override
    public Topic getById(String id) {
        return topicDao.findByPK(id);
    }
}
