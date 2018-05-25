package com.coderme.faq;

import com.alibaba.fastjson.JSON;
import com.coderme.BaseTest;
import com.coderme.faq.dao.ITopicDao;
import com.coderme.faq.data.po.Topic;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qiudm
 * @date 2018/5/25 15:09
 * @desc
 */
public class TopicTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(TopicTest.class);

    @Autowired
    private ITopicDao topicDao;



    @Test
    public void insertTopic(){
        Topic topic = new Topic();
        topic.setId("1");
        topic.setTitle("title");
        topic.setUserId("userId");
        topicDao.insertTopic(topic);
    }



    @Test
    public void findByPk() {
        logger.error("findByPk");
        String id = "1";
        Topic topic = topicDao.findByPK(id);
        logger.error("topic:{}", JSON.toJSONString(topic));
    }



}
