package com.coderme.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/5/28 14:32
 * @desc
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        HttpServletResponse rsp = ctx.getResponse();

        String token = request.getHeader("access-token");
        if (Objects.isNull(token)) {
            //过滤该请求，不往下级服务去转发请求，到此结束
            ctx.setSendZuulResponse(false);
            rsp.setStatus(200);
            rsp.setCharacterEncoding("UTF-8");
            rsp.setContentType("application-json");
            ctx.setResponse(rsp);
            ctx.setResponseBody("{\"resultCode\":500,\"resultMsg\":\"token过期\"}");
            
        } else {
            //验证权限

            rsp.setHeader("userID", "1001");
        }

        return null;
    }

}
