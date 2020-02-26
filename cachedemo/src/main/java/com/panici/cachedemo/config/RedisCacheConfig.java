package com.panici.cachedemo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        //设置过期时间
        return redisCacheConfiguration.entryTtl(Duration.ofMinutes(30))
                //json序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(
                                new GenericJackson2JsonRedisSerializer()
                        ));
    }


    @Override
    public KeyGenerator keyGenerator() {
        return (Object target, Method method, Object... params) ->
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(target.getClass().getName())
                    .append(":")
                    .append(method.getName())
                    .append(":");
            for (Object param : params) {
                stringBuilder.append(param.toString());
            }
            return stringBuilder.toString();
        };
    }
}
