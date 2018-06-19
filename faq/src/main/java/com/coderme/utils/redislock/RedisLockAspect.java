package com.coderme.utils.redislock;

import com.coderme.faq.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author qiudm
 * @date 2018/6/15 17:37
 * @desc
 */
@Aspect
@Component
public class RedisLockAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.coderme.utils.redislock.RedisLock)")
    public void redisLockPoint() {
    }

    @Around("redisLockPoint()")
    public Object intercepter(ProceedingJoinPoint pjp) throws Throwable {
        Object object;
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);
        String redisKey = redisLock.key();
        Object[] args = pjp.getArgs();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        redisKey += getRedisKey(parameterAnnotations, args);
        String redisValue = stringRedisTemplate.opsForValue().get(redisKey);

        if (Objects.isNull(redisValue)) {
            Long redisValueSet = System.currentTimeMillis() + redisLock.expireTime() * 1000;
            String redisVal = String.valueOf(redisValueSet);
            stringRedisTemplate.opsForValue().set(redisKey, redisVal, redisLock.expireTime(), TimeUnit.SECONDS);
            object = pjp.proceed();
        } else {
            Long redisExpireValue = Long.valueOf(redisValue);
            if (Objects.nonNull(redisExpireValue)) {
                if (System.currentTimeMillis() > redisExpireValue) {
                    stringRedisTemplate.delete(redisKey);
                }
            }
            throw new ServiceException(redisLock.msg());
        }

        return object;
    }


    private String getRedisKey(Annotation[][] parameterAnnotations, Object[] args) {
        StringBuffer redisKey = new StringBuffer();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                if (parameterAnnotations[i][j] instanceof RedisParamLock) {
                    redisKey.append(args[i].toString());
                }
            }
        }
        return redisKey.toString();
    }


}
