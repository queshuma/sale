package com.example.sale.Service;

import com.example.sale.Dto.OrderDto;
import com.example.sale.Dto.SentDto;
import com.example.sale.Dto.ShopDto;
import com.example.sale.Dto.ShopProDto;
import com.example.sale.Model.ProInfo;
import com.example.sale.Model.RepairInfo;
import com.example.sale.Model.SentInfo;
import com.example.sale.Model.UserInfo;
import com.example.sale.Repository.ProInfoRepository;
import com.example.sale.Repository.SentRepository;
import com.example.sale.Repository.ShopRepository;
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
    private ShopRepository shopRepository;

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

    public RepairInfo ShopSave(RepairInfo repairInfo, String name) {
        shopRepository.save(repairInfo);
        return repairInfo;
    }

    public ShopDto ShopInfo(long userId) {
        List<ShopProDto> shopProDtos = new ArrayList<>();
        ShopDto shopDto = new ShopDto();
        float costSum = 0;
        List<RepairInfo> repairInfos = shopRepository.findByUserId(userId);
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        for (RepairInfo repairInfo: repairInfos) {
            long proId = repairInfo.getProId();
            ProInfo proInfo = proInfoRepository.findByProId(proId);
            SentInfo sentInfo = sentRepository.findByProId(proId);
            ShopProDto shopProDto;
            shopProDto = modelMapper.map(repairInfo, ShopProDto.class);
            modelMapper.map(proInfo, shopProDto);
            shopProDto.setSentCost(cost(proId, repairInfo.getSentTime()));
            shopProDto.setCost(sentCost(shopProDto.getSentCost(), proId));
            costSum += shopProDto.getCost();
            shopProDtos.add(shopProDto);
        }
        shopDto.setShopProDto(shopProDtos);
        shopDto.setCostSum(costSum);
        return shopDto;
    }

    public String OrderInfo(List<SentDto> sentDtoList, HttpServletRequest httpServletRequest) {
        return "success";
    }
}
