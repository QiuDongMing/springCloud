package com.coderme.auth.service.impl;

import com.coderme.auth.dao.IUserDao;
import com.coderme.auth.data.base.BasicUserInfo;
import com.coderme.auth.data.po.User;
import com.coderme.auth.service.ICacheService;
import com.coderme.auth.service.IUserService;
import com.coderme.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;


/**
 * @author qiudm
 * @date 2018/5/30 15:09
 * @desc
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;
    @Autowired
    private ICacheService cacheService;

    @Override
    public BasicUserInfo getBasicUserInfo(String userId) {
        if (Objects.isNull(userId)) {
            return null;
        }
        BasicUserInfo basicUserInfo = cacheService.getBasicUserInfo(userId);
        if (Objects.nonNull(basicUserInfo)) {
            return basicUserInfo;
        }
        User user = userDao.getByUserId(userId);
        if (Objects.nonNull(user)) {
            basicUserInfo = BeanUtil.copy(user, BasicUserInfo.class);
            cacheService.cacheBasicUserInfo(basicUserInfo);
            return basicUserInfo;
        }
        return null;
    }

}
