package com.example.sale.Controller;

import com.auth0.jwt.JWT;
import com.example.sale.Dto.UserDto;
import com.example.sale.Model.ProInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Service.ProService;
import com.example.sale.Service.UserService;
import com.example.sale.config.Token;
import com.example.sale.config.TokenUtil;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RestController
public class UserContorller {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //    对象转换工具
    @Autowired
    private ModelMapper modelMapper;

//    用户登陆
//    @CachePut(value = "tokenCache", key = "#token")
    @GetMapping(value = "/user/login")
    public String userLogin(HttpServletResponse httpServletResponse,
                            HttpServletRequest httpServletRequest,
                            @RequestParam(name = "EORP") String EORP,
                            @RequestParam(name = "Password") String Password) {
        String user = userService.findUser(EORP, Password);
        if (user != null) {
            Cookie[] cookies=httpServletRequest.getCookies();
            for(Cookie cookie: cookies){
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
            String token = TokenUtil.generateToken(user);
//            Token tokenObj = new Token();
            redisTemplate.opsForValue().set(user, token, 24, TimeUnit.HOURS);
            System.out.println("token:" + token);
            System.out.println("user:" + user);
            Cookie cookie = new Cookie(user, token);
            httpServletResponse.addCookie(cookie);
            // 将 Token 保存到数据库或者缓存中
            return token;
        } else {
            return "";
        }

    }

//    用户信息
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> UserInfo(@RequestParam("value") String value) {
        UserDto userDto = userService.findUserInfo(value);
        return ResponseEntity.ok(userDto);
    }

//    用户注册
    @PostMapping("/user/register")
    public String UserRegister(@RequestBody UserInfo userInfo) {
        return userService.registUser(userInfo);
    }

//    用户信息修改
//    @Cacheable(value = "tokenCache", key = "#token")
    @PostMapping("/user/modify")
    public UserInfo UserModify(HttpServletRequest httpServletRequest,
                                @RequestBody UserDto userDto) {
        Cookie[] cookies = httpServletRequest.getCookies();
        UserInfo user = null;
        System.out.println("查看cookie");
        for(Cookie cookie: cookies){
            System.out.println(cookie.getName());
        }
        for (Cookie c : cookies) {
            String cachedValue = redisTemplate.opsForValue().get(c.getName());
            if (c.getValue().equals(cachedValue)) {
                System.out.println("cookie---------");
                System.out.println(c.getName());
                UserInfo userInfo = userService.findUserByPetName(c.getName());
                System.out.println(userInfo);
                BeanUtils.copyProperties(userDto, userInfo);
                System.out.println(userInfo);
                userService.modifyUser(userInfo);
                return userInfo;
            }
        }
        return null;
//        return userService.modifyUserInfo(userInfo);
    }
}
