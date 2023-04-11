package com.example.sale.Controller;

import com.example.sale.Dto.ShopDto;
import com.example.sale.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/shop/")
    public float Shop(@RequestBody List<ShopDto> shopDtoList) {
        float cost = 0;
        if (shopDtoList != null) {
            for (ShopDto shopDto:shopDtoList) {
                cost += shopService.cost(shopDto.getProId(), shopDto.getRentTime());
            }
            return cost;
        } else {
            return cost;
        }
    }
}
