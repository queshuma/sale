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

    public List<ProInfo> findAll() {
        return proInfoRepository.findAll();
    }

    public void savePro(ProInfo proInfo) {
        proInfoRepository.save(proInfo);
    }

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

    public List findPro(String value) {
        List<ProInfo> proInfoList  = proInfoRepository.findByKeyword(value);
        return proInfoList;
    }
}
