package com.coderme.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.coderme.auth.data.base.BasicUserInfo;
import com.coderme.auth.exception.ServiceException;
import com.coderme.auth.service.ICacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Objects;

import static com.coderme.auth.constans.CacheKey.AUTH_BASIC_USER_INFO;

/**
 * @author qiudm
 * @date 2018/5/30 18:15
 * @desc
 */
@Service
public class CacheServiceImpl implements ICacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void cacheBasicUserInfo(BasicUserInfo basicUserInfo) {
        if (Objects.isNull(basicUserInfo) || Objects.isNull(basicUserInfo.getUserId())) {
            throw new ServiceException("基础用户信息缓存参数异常");
        }
        redisTemplate.opsForHash().put(AUTH_BASIC_USER_INFO, basicUserInfo.getUserId(), basicUserInfo);
        logger.info("cache basic userInfo:{}", JSON.toJSONString(basicUserInfo));
    }

    @Override
    public BasicUserInfo getBasicUserInfo(String userId) {
        if (Objects.isNull(userId)) {
            return null;
        }
        HashOperations<String, String, BasicUserInfo> hashOperations = redisTemplate.opsForHash();
        BasicUserInfo basicUserInfo = hashOperations.get(AUTH_BASIC_USER_INFO, userId);
        return basicUserInfo;
    }


}
