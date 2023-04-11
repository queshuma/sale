package com.example.sale.Controller;

import com.example.sale.Model.SentInfo;
import com.example.sale.Service.SentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentController {

    @Autowired
    private SentService sentService;

    //租赁价格修改
    @PostMapping(value = "/rent/modify")
    public SentInfo ProductsAdd(@RequestBody SentInfo sentInfo) {
        System.out.println(sentInfo.getProId());
        sentService.saveInfo(sentInfo);
        return sentInfo;
    }

}
