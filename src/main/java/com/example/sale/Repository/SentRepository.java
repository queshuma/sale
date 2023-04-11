package com.example.sale.Repository;

import com.example.sale.Model.SentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentRepository extends JpaRepository<SentInfo, String> {

    SentInfo findByProId(long proId);

}
