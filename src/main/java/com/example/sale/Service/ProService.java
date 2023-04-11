package com.example.sale.Service;

import com.example.sale.Model.ProInfo;
import com.example.sale.Repository.ProInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//产品信息
@Service
public class ProService {
    @Autowired
    private ProInfoRepository proInfoRepository;

    //查找所有产品
    public List<ProInfo> findAll() {
        return proInfoRepository.findAll();
    }

    //保存产品数据
    public void savePro(ProInfo proInfo) {
        proInfoRepository.save(proInfo);
    }

    //更新产品数据
    public ProInfo updatePro(ProInfo proInfo) {
        long productId = proInfo.getProId();
//        ProInfo product = proInfoRepository.findByProId(productId);
        proInfoRepository.save(proInfo);
        return proInfo;

    }

    //查找产品
    public List findPro(String value) {
        List<ProInfo> proInfoList  = proInfoRepository.findByKeyword(value);
        return proInfoList;
    }

    //根据类别查找
    public List findProTag(String tag) {
        List<ProInfo> proInfoList  = proInfoRepository.findByProClass(tag);
        return proInfoList;
    }
}
