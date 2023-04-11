package com.example.sale.Service;

import com.example.sale.Model.SentInfo;
import com.example.sale.Repository.ProInfoRepository;
import com.example.sale.Repository.SentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//租赁价格修改
@Service
public class SentService {

    @Autowired
    private SentRepository sentRepository;

    @Autowired
    private ProInfoRepository proInfoRepository;

    public SentInfo saveInfo(SentInfo sentInfo) {
        if (proInfoRepository.findByProId(sentInfo.getProId()) != null) {
            sentRepository.save(sentInfo);
        }
        return sentInfo;
    }

}
