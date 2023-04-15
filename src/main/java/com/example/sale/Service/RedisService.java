package com.example.sale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class RedisService {

    private static RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static String  cacheValue = null;

    public static String Redis(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    String cachedValue = redisTemplate.opsForValue().get(c.getValue());
                    return cachedValue;
                }
            }
        }
        return cacheValue;
    }
}
