package com.example.sale.Controller;

import com.example.sale.Model.ProInfo;
import com.example.sale.Service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProContorller {
    @Autowired
    private ProService proService;

//    数据列表
    @GetMapping("/products/list")
    public List<ProInfo> ProductsList() {
        List<ProInfo> ProInfo = proService.findAll();
        return ProInfo;
    }

    //    单条数据添加
    @PostMapping("/products/add")
    public String ProductsAdd(@RequestBody ProInfo proInfo) {
        System.out.println(proInfo.getProId());
        proService.savePro(proInfo);
        return proInfo.getProName();
    }

//    单条数据更新
    @PostMapping("/products/update")
    public Map ProductUpdate(@RequestBody ProInfo proInfo) {
        Map<String, String> map = new HashMap<>();
        map = proService.updatePro(proInfo);
        if (!map.isEmpty()) {
            System.out.println("——————— UPDATE DATA START ———————");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " : " + value);
            }
            System.out.println("——————— UPDATE DATA END ———————");
        } else {
            System.out.println("——————— UPDATE DATA START ———————");
            System.out.println("DATA NOT UPDATE");
            System.out.println("——————— UPDATE DATA END ———————");
        }
        return map;
    }

    @GetMapping("/products/seacrh")
    public List ProductSearch(@RequestParam("value") String value) {
        List<ProInfo> proInfoList = proService.findPro(value);
        return proInfoList;
    }
//    @PostMapping("/products/seacrh")
//    public List ProductSearch(@RequestParam("value") String value) {
//
//    }
}
