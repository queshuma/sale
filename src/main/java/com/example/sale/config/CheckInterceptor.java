package com.example.sale.config;

import com.example.sale.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
    public class CheckInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        UserInfo user = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                String cachedValue = redisTemplate.opsForValue().get(c.getName());
                if (c.getValue().equals(cachedValue)) {
                    return true;
                }
            }
        } else {
            httpServletRequest.getRequestDispatcher("/user/login").forward(httpServletRequest, response);
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
