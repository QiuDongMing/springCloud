package com.coderme.utils.redislock;

import java.lang.annotation.*;

/**
 * @author qiudm
 * @date 2018/6/15 17:28
 * @desc
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    String key() default "";

    long expireTime() default 10;

    String msg() default "获取锁失败";
}
