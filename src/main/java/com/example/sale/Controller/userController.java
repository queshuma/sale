package com.example.sale.Controller;

import com.example.sale.Model.ProInfo;
import com.example.sale.Service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("userController")
public class userController {

    @Autowired
    private ProService proService;

    @GetMapping("/")
    public List<ProInfo> test() {
        String proName = "索尼A7m3";
        List<ProInfo> ProInfo = proService.findAll();
        return ProInfo;
    }
}
