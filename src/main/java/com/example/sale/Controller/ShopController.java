package com.example.sale.Controller;

import com.example.sale.Dto.OrderDto;
import com.example.sale.Dto.SentDto;
import com.example.sale.Dto.ShopDto;
import com.example.sale.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/shop")
    public OrderDto Shop(@RequestBody List<SentDto> sentDtoList, HttpServletRequest httpServletRequest) {
        float cost = 0;
        if (sentDtoList != null) {
            return shopService.ShopInfo(sentDtoList, httpServletRequest);
        } else {
            return null;
        }
    }
}
