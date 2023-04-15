package com.example.sale.Controller;

import com.example.sale.Dto.ShopDto;
import com.example.sale.Model.RepairInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Service.ShopService;
import com.example.sale.Service.UserService;
import com.example.sale.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
        String redisInfo = RedisService.Redis(httpServletRequest);
        if (redisInfo != null) {
            UserInfo userInfo = userService.findUserByPetName(redisInfo);
            repairInfo.setUserId(userInfo.getUserId());
            repairInfo.setAddTime(new Date());
            shopService.ShopSave(repairInfo, redisInfo);
            return "success";
        } else {
            return "null";
        }
    }

    @PostMapping(value = "/shop/del")
    private String ShopDel(@RequestBody List<RepairInfo> repairInfoList, HttpServletRequest httpServletRequest) {
        String redisInfo = RedisService.Redis(httpServletRequest);
        if (redisInfo != null) {
            UserInfo userInfo = userService.findUserByPetName(redisInfo);
            for (RepairInfo repairInfo:repairInfoList) {
                repairInfo.setUserId(userInfo.getUserId());
                shopService.ShopDelete(repairInfo);
            }
            return "success";
        }
        return "fail";
    }

    @PostMapping(value = "/shop")
    public ShopDto Shop(HttpServletRequest httpServletRequest) {
        String redisInfo = RedisService.Redis(httpServletRequest);
        ShopDto shopDto = new ShopDto();
        if (redisInfo != null) {
            UserInfo userInfo = userService.findUserByPetName(redisInfo);
            long userId = userInfo.getUserId();
            return shopService.ShopInfo(userId);
        }
        return shopDto;
    }

}
