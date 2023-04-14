package com.example.sale.Controller;

import com.example.sale.Dto.OrderDto;
import com.example.sale.Dto.SentDto;
import com.example.sale.Dto.ShopDto;
import com.example.sale.Model.RepairInfo;
import com.example.sale.Model.SentInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Repository.ShopRepository;
import com.example.sale.Repository.UserInfoRepository;
import com.example.sale.Service.ShopService;
import com.example.sale.Service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping(value = "/shop/add")
    public String ShopAdd (@RequestBody RepairInfo repairInfo, HttpServletRequest httpServletRequest) {
        Cookie[] cookies=httpServletRequest.getCookies();
        String cachedValue = null;
        Date date = new Date();
        if (cookies != null) {
            for (Cookie c : cookies) {
                cachedValue = redisTemplate.opsForValue().get(c.getValue());
                if (cachedValue != null) {
                    UserInfo userInfo = userService.findUserByPetName(cachedValue);
                    repairInfo.setUserId(userInfo.getUserId());
                    repairInfo.setAddTime(date);
                    shopService.ShopSave(repairInfo, cachedValue);
                    return "success";
                }
            }
        } else {
            return "null";
        }
        return null;
    }

    @PostMapping(value = "/shop")
    public ShopDto Shop(HttpServletRequest httpServletRequest) {
        Cookie[] cookies=httpServletRequest.getCookies();
        String cachedValue = null;
        Date date = new Date();
        ShopDto shopDto = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                cachedValue = redisTemplate.opsForValue().get(c.getValue());
                if (cachedValue != null) {
                    UserInfo userInfo = userService.findUserByPetName(cachedValue);
                    long userId = userInfo.getUserId();
                    return shopService.ShopInfo(userId);
                }
            }
        }
        return shopDto;
    }

}
