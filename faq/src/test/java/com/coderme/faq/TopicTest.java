package com.coderme.faq;

import com.alibaba.fastjson.JSON;
import com.coderme.BaseTest;
import com.coderme.faq.dao.ITopicDao;
import com.coderme.faq.data.po.Topic;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

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
    public void insertTopic() throws Exception {
        for (int i=0;i<80;i++){
            Topic topic = new Topic();
            topic.setId("100" + i);
            topic.setTitle("titles" + i);
            topic.setUserId("userId" + i);
            topic.setCreateTime(System.currentTimeMillis());
            topicDao.insertTopic(topic);
            Thread.sleep(new Random().nextInt(3)*100);
        }
    }



    @Test
    public void findByPk() {
        logger.error("findByPk");
        String id = "1";
        Topic topic = topicDao.findByPK(id);
        logger.error("topic:{}", JSON.toJSONString(topic));
    }



}
