package com.example.sale.Controller;

import com.example.sale.Model.ProInfo;
import com.example.sale.Model.SentInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Service.ProService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProContorller {
    @Autowired
    private ProService proService;

    //数据列表
    @GetMapping("/products/list")
    public List<ProInfo> ProductsList() {
        List<ProInfo> ProInfo = proService.findAll();
        return ProInfo;
    }

    //单条数据添加
    @PostMapping("/products/add")
    public String ProductsAdd(@RequestBody ProInfo proInfo) {
        System.out.println(proInfo.getProId());
        proService.savePro(proInfo);
        return proInfo.getProName();
    }

    //单条数据更新
    @PostMapping("/products/update")
    public ProInfo ProductUpdate(@RequestBody ProInfo proInfo) {
        proService.updatePro(proInfo);
        return proInfo;
    }

    //产品搜索
    @GetMapping("/products/search")
    public List ProductSearch(@RequestParam("value") String value) {
        List<ProInfo> proInfoList = proService.findPro(value);
        return proInfoList;
    }

    //产品分类
    @GetMapping("/products/tag")
    public List ProductTag(@RequestParam("tag") String tag) {
        List<UserInfo> userInfoList = proService.findProTag(tag);
        System.out.println(userInfoList);
        return userInfoList;
    }

}
