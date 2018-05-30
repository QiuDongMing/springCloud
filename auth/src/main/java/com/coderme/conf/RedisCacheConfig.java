package com.coderme.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author qiudm
 * @date 2018/5/30 17:08
 * @desc
 */
@Configuration
//@EnableCaching
public class RedisCacheConfig {

    @Value("${spring.redis.host}")
    private  String redisHost;

    @Value("${spring.redis.port}")
    private  int redisPort;

    @Value("${spring.redis.password}")
    private  String password;

    @Bean
    public RedisConnectionFactory redisCF(){
        JedisConnectionFactory jcf=new JedisConnectionFactory();
        jcf.setHostName(redisHost);
        jcf.setPort(redisPort);
        jcf.setPassword(password);
        jcf.afterPropertiesSet();
        jcf.setUsePool(true);
        return  jcf;
    }

    @Bean
    public RedisTemplate redisTemplate(){
        final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
        template.setConnectionFactory( redisCF() );
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }



}
