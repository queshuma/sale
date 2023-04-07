package com.example.sale.Service;

import com.example.sale.Model.ProInfo;
import com.example.sale.Repository.ProInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map updatePro(ProInfo proInfo) {
        Map<String, String> map = new HashMap<>();
        long productId = proInfo.getProId();
        String productName = proInfo.getProName();
        ProInfo product = proInfoRepository.findByProIdAndProName(productId, productName);
        if (!product.getProClass().equals(proInfo.getProClass())) {
            map.put("BeforeClass", product.getProClass());
            map.put("AfterClass", proInfo.getProClass());
            product.setProClass(proInfo.getProClass());
        }
        if (!product.getProHas().equals(proInfo.getProHas())) {
            map.put("BeforeHas", product.getProHas());
            map.put("AfterHas", proInfo.getProHas());
            product.setProHas(proInfo.getProHas());
        }
        if (product.getProQual() != proInfo.getProQual()) {
            map.put("BeforeQual", String.valueOf((product.getProQual())));
            map.put("AfterQual", String.valueOf(proInfo.getProQual()));
            product.setProQual(proInfo.getProQual());
        }
        if (map != null) {
            proInfoRepository.save(product);
        }
        return map;

    }

    //查找产品
    public List findPro(String value) {
        List<ProInfo> proInfoList  = proInfoRepository.findByKeyword(value);
        return proInfoList;
    }

    //根据类别查找
    public List findProTag(String tag) {
        List<ProInfo> proInfoList  = proInfoRepository.findByKeyword(tag);
        return proInfoList;
    }
}
