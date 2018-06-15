package com.coderme.utils.redislock;

import java.lang.annotation.*;

/**
 * @author qiudm
 * @date 2018/6/15 17:35
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Inherited
public @interface RedisParamLock {

}
