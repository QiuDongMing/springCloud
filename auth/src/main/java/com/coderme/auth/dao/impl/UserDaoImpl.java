package com.coderme.auth.dao.impl;

import com.coderme.auth.dao.IUserDao;
import com.coderme.auth.data.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author qiudm
 * @date 2018/5/30 11:21
 * @desc
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public User getByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }


    @Override
    public User getByTel(String tel) {
        Query query = new Query(Criteria.where("tel").is(tel));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User getByNickName(String nickName) {
        Query query = new Query(Criteria.where("nickName").is(nickName));
        return mongoTemplate.findOne(query, User.class);
    }
}
