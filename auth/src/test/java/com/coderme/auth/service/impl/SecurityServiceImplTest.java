package com.coderme.auth.service.impl;

import com.coderme.auth.BaseTest;
import com.coderme.auth.controller.param.RegisterParam;
import com.coderme.auth.data.po.User;
import com.coderme.auth.enums.UserEnums;
import com.coderme.auth.service.ISecurityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/5/30 16:26
 * @desc
 */
public class SecurityServiceImplTest extends BaseTest {

    @Autowired
    private ISecurityService securityService;

    @Test
    public void register() throws Exception {
        RegisterParam param = new RegisterParam();
        param.setPassword("123456");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 2, 16);
        param.setBirthday(calendar.getTimeInMillis());
        param.setNickName("");
        param.setHeadPic("headPic");
        securityService.register(param);
    }

}