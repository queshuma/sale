package com.example.sale.Service;

import com.example.sale.Dto.UserDto;
import com.example.sale.Model.UserInfo;
import com.example.sale.Repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

//    对象转换工具
    @Autowired
    private ModelMapper modelMapper;

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
    //    用户注册
    public String registUser(UserInfo userInfo) {
        UserInfo user = userInfoRepository.findByUserEmailOrUserPhone(userInfo.getUserEmail(), userInfo.getUserPhone());
        System.out.println(user);
        if (user == null) {
            if (userInfoRepository.findByUserPetName(userInfo.getUserPetName()) == null) {
                Date t = new Date();
                userInfo.setUserDate(t);
                userInfoRepository.save(userInfo);
                return "账号：" + userInfo.getUserPetName() + " 注册成功！";
            } else {
                return "该账号名已存在！请重新设置";
            }
        } else {
            System.out.println("该邮箱或者手机号已被注册！");
            return "该邮箱或者手机号已被注册！";
        }
    }

//    用户信息获取
    public UserDto findUserInfo(String value) {
        UserInfo userInfo  = userInfoRepository.findByKeyword(value);

        System.out.println(userInfo.getUserDate());
        UserDto userDto = new UserDto(userInfo.getUserId(), userInfo.getUserName(), userInfo.getUserPetName(), userInfo.getUserSex(),
                                        userInfo.getUserPhone(), userInfo.getUserAddress(), userInfo.getUserEmail(),
                                        userInfo.getUserDate()
                                    );
        return userDto;
    }

//    用户信息修改
    public String modifyUserInfo(UserInfo userInfo) {
        UserInfo user = userInfoRepository.findByUserId(userInfo.getUserId());
        userInfoRepository.save(user);
        return "success";
    }
}
