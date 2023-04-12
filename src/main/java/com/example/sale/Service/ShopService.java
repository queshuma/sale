package com.example.sale.Service;

import com.example.sale.Dto.OrderDto;
import com.example.sale.Dto.SentDto;
import com.example.sale.Dto.ShopDto;
import com.example.sale.Model.ProInfo;
import com.example.sale.Model.SentInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Repository.ProInfoRepository;
import com.example.sale.Repository.SentRepository;
import com.example.sale.Repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private SentRepository sentRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ProInfoRepository proInfoRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ModelMapper modelMapper;

    public float sentCost(float cost, long proId) {
        SentInfo sentInfo = sentRepository.findByProId(proId);
        return sentInfo.getSentDiscount() * cost;
    }

    public float cost(long proId, int rentTime) {
        SentInfo sentInfo = sentRepository.findByProId(proId);
        if (rentTime < 7) {
            return rentTime * sentInfo.getSentFirstPay();
        } else if(rentTime < 15) {
            return rentTime * sentInfo.getSentSecondPay();
        } else if(rentTime < 45) {
            return rentTime * sentInfo.getSentThirdPay();
        } else if(rentTime < 60) {
            return rentTime * sentInfo.getSentForthPay();
        } else {
            return rentTime * sentInfo.getSentFirthPay();
        }
    }

    public OrderDto ShopInfo(List<SentDto> sentDtoList, HttpServletRequest httpServletRequest) {
        List<ShopDto> shopDtoList = new ArrayList<>();
        float costSum = 0;
        for (SentDto sentDto:sentDtoList) {
            ProInfo proInfo = proInfoRepository.findByProId(sentDto.getProId());
            SentInfo sentInfo = sentRepository.findByProId(sentDto.getProId());
            ShopDto shopDto;
            shopDto = modelMapper.map(sentDto, ShopDto.class);
            modelMapper.map(proInfo, shopDto);
            modelMapper.map(sentInfo, shopDto);
            shopDto.setSentCost(cost(sentDto.getProId(), sentDto.getRentTime()));
            shopDto.setCost(sentCost(shopDto.getSentCost(), shopDto.getProId()));
            costSum += shopDto.getCost();
            shopDtoList.add(shopDto);
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setShopDtoList(shopDtoList);
        Cookie[] cookies = httpServletRequest.getCookies();
        UserInfo user = null;
        for (Cookie c : cookies) {
            String cachedValue = redisTemplate.opsForValue().get(c.getName());
            if (c.getValue().equals(cachedValue)) {
                UserInfo userInfo = userInfoRepository.findByUserPetName(c.getName());
                modelMapper.map(userInfo, orderDto);
                orderDto.setCostSum(costSum);
                return orderDto;
            }
        }
        return orderDto;
    }
}
