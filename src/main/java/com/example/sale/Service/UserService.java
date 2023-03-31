package com.example.sale.Service;

import com.example.sale.Dto.UserDto;
import com.example.sale.Model.UserInfo;
import com.example.sale.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

//    用户登陆
    public String findUser(String eorp, String password) {
        UserInfo userInfo  = userInfoRepository.findByKeyword(eorp);
        System.out.println(userInfo.getUserPassword());
        System.out.println(password);
//        密码匹配
        if (userInfo.getUserPassword().equals(password)) {
            return userInfo.getUserPetName();
        } else {
            return null;
        }
    }

//    用户信息获取
    public UserDto findUserInfo(String value) {
        UserInfo userInfo  = userInfoRepository.findByKeyword(value);

        UserDto userDto = new UserDto(userInfo.getUserId(), userInfo.getUserName(), userInfo.getUserSex(),
                                        userInfo.getUserPhone(), userInfo.getUserAddress(), userInfo.getUserEmail()
                                        );
        return userDto;
    }

//    用户注册
    public UserInfo saveUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return userInfo;
    }
}
