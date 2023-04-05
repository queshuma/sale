package com.example.sale;

import com.example.sale.config.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@SpringBootTest
class SaleApplicationTests {

//    @Test
//    void contextLoads() {
//    }
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {
        String key = "testKey";
        String value = "testValue";

        // 添加缓存
        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);


        // 从缓存中获取值
        String cachedValue = redisTemplate.opsForValue().get(key);
        assertEquals(value, cachedValue);
        System.out.println(cachedValue);
    }

    @Test
    public void testToken() {
        String username = "testUser";

        // 生成Token
        String token = TokenUtil.generateToken(username);
        assertNotNull(token);
        System.out.println(token);

        // 验证Token
        boolean isValid = TokenUtil.verifyToken(token);
        assertTrue(isValid);
        System.out.println(isValid);
    }
}
