package com.example.sale.Controller;

import com.example.sale.Dto.UserDto;
import com.example.sale.Model.ProInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Service.ProService;
import com.example.sale.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserContorller {
    @Autowired
    private UserService userService;

//    用户登陆
    @GetMapping(value = "/user/login")
    public String userLogin(@RequestParam(name = "EORP") String EORP,
                            @RequestParam(name = "Password") String Password) {
        String user = userService.findUser(EORP, Password);
        if (user != null) {
            return user;
        } else {
            return "Login Failure";
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
//    @PostMapping("/user/modify")
//    public String UserModify(@RequestBody UserInfo userInfo) {
//        return userService.modifyUserInfo(userInfo);
//    }
}
