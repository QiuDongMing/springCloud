package com.coderme.auth.dao.impl;

import com.coderme.auth.dao.IUserIdxDao;
import com.coderme.auth.data.po.UserIdx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/5/30 11:23
 * @desc
 */
@Repository
public class UserIdxDaoImpl implements IUserIdxDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String nextUserId() {
        Query query = new Query(Criteria.where("_id").is(1));
        Update update = new Update();
        update.inc("userId", 1);
        UserIdx userIdx = mongoTemplate.findAndModify(query, update, UserIdx.class);
        return String.valueOf(userIdx.getUserId() + 1);
    }


    @Override
    public void initUserIdx() {
        UserIdx userIdx = mongoTemplate.findById(1, UserIdx.class);
        if (Objects.isNull(userIdx)) {
            userIdx = new UserIdx();
            userIdx.setId(1);
            userIdx.setUserId(100001);
            userIdx.setDesc("用户id自增");
            mongoTemplate.insert(userIdx);
        }
    }
}
