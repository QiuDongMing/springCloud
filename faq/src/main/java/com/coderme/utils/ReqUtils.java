package com.coderme.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/6/19 15:51
 * @desc
 */
@Component
public class ReqUtils implements InitializingBean {

    public static ReqUtils instance;

    private ReqUtils() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }


    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return null;
        } else {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
    }

    public String getUserId() {
        return getRequest().getHeader("userID");
    }


}
