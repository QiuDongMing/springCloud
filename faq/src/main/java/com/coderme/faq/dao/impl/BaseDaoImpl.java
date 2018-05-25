package com.coderme.faq.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author qiudm
 * @date 2018/5/25 15:01
 * @desc
 */
@Repository
public class BaseDaoImpl {

    @Autowired
    protected MongoTemplate mongoTemplate;

}
