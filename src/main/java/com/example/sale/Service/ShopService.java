package com.example.sale.Service;

import com.example.sale.Model.SentInfo;
import com.example.sale.Repository.SentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    private SentRepository sentRepository;

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
}
