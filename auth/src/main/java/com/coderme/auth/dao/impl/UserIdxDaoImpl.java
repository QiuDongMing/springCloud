package com.coderme.auth.dao.impl;

import com.coderme.auth.dao.IUserIdxDao;
import com.coderme.auth.data.po.UserIdx;
import com.coderme.auth.enums.UserEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.coderme.auth.enums.UserEnums.*;

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
    public String nextUserId(Integer userType) {
        initUserIdx(userType);
        Query query = new Query(Criteria.where("_id").is(userType));
        Update update = new Update();
        update.inc("userId", 1);
        UserIdx userIdx = mongoTemplate.findAndModify(query, update, UserIdx.class);
        return String.valueOf(userIdx.getUserId() + 1);
    }


    @Override
    public void initUserIdx(Integer userType) {
        UserIdx userIdx = mongoTemplate.findById(userType, UserIdx.class);
        if (Objects.isNull(userIdx)) {
            userIdx = new UserIdx();
            userIdx.setId(userType);
            if(Objects.equals(userType, UserType.COMMON_USER.getType())) {
                userIdx.setUserId(1000000);
                userIdx.setDesc("用户id自增");
            }
            if(Objects.equals(userType, UserType.SYS_USER.getType())) {
                userIdx.setUserId(10000);
                userIdx.setDesc("管理员id自增");
            }
            mongoTemplate.insert(userIdx);
        }
    }
}
