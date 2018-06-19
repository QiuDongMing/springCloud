package com.coderme.faq.dao;


import com.coderme.commons.base.utils.PageVO;
import com.coderme.faq.data.po.Topic;

import java.util.Map;

/**
 * @author qiudm
 * @date 2018/5/25 14:59
 * @desc
 */
public interface ITopicDao {

    void insertTopic(Topic topic);

    Topic findByPK(String id);

    void update(String id, Map<String, Object> updateFiledMaps, Class<?> clazz);

    PageVO<Topic> findList(Integer pageIndex, Integer pageSize);
}
