package com.example.sale.Controller;

import com.example.sale.Model.UserInfo;
import com.example.sale.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MastContorller {
    @Autowired
    private UserService userService;

//    所有用户信息
    @GetMapping(value = "/mast")
    public List<UserInfo> mast() {
        List<UserInfo> userInfoList = userService.findAll();
        return userInfoList;

    }
}
