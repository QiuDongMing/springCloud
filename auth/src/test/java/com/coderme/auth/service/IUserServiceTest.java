package com.coderme.auth.service;

import com.alibaba.fastjson.JSON;
import com.coderme.auth.BaseTest;
import com.coderme.auth.data.base.BasicUserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/5/30 15:59
 * @desc
 */
public class IUserServiceTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(IUserServiceTest.class);

    @Autowired
    private IUserService userService;

    @Test
    public void getBasicUserInfo() throws Exception {
        String userId = "1000003";
        BasicUserInfo basicUserInfo = userService.getBasicUserInfo(userId);
        logger.error("basicUserInfo:{}", JSON.toJSONString(basicUserInfo));
    }




}