package com.example.sale.Repository;

import com.example.sale.Model.ProInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProInfoRepository extends JpaRepository<ProInfo, String> {

    List<ProInfo> findAll();

    ProInfo findByProName(String proName);

    ProInfo findByProId(long proId);

    @Query("SELECT u FROM ProInfo u WHERE u.proName LIKE %:value% OR u.proClass LIKE %:value%")
    List<ProInfo> findByKeyword(@Param("value") String value);

    List<ProInfo> findByProClass(String tag);
}
