package com.example.sale.Repository;

import com.example.sale.Model.RepairInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<RepairInfo, String> {
    List<RepairInfo> findByUserId(long userId);

    RepairInfo findByUserIdAndProId(long userId, long proId);
}
