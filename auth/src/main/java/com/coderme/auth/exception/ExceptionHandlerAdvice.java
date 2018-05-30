package com.coderme.auth.exception;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.BindException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiudm
 * @date 2018/5/28 17:54
 * @desc
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public void handlerErrors(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws Exception {
        logger.error("接口请求错误：{}",request.getRequestURI());
        logger.error("错误内容:");
        e.printStackTrace();

        int resultCode = 100100;
        String resultMsg = "服务器繁忙，请稍后再试！";
        String detailMsg = "";

        if (e instanceof MissingServletRequestParameterException || e instanceof BindException) {
            resultCode = 100101;
            resultMsg = "请求参数验证失败，缺少必填参数或参数错误";
        } else if (e instanceof MethodArgumentNotValidException) {
            resultCode = 100102;
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            resultMsg = allErrors.get(0).getDefaultMessage();
        } else if (e instanceof ServiceException) {
            ServiceException ex = ((ServiceException) e);

            resultCode = null == ex.getResultCode() ? 0 : ex.getResultCode();
            resultMsg = ex.getMessage();
        } else  {
            detailMsg = e.getMessage();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", resultCode);
        map.put("resultMsg", resultMsg);
        map.put("detailMsg", detailMsg);

        String text = JSON.toJSONString(map);

        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);
        response.getWriter().flush();
    }



}
