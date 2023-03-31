package com.example.sale.Repository;

import com.example.sale.Model.ProInfo;
import com.example.sale.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    List<UserInfo> findAll();

    @Query("SELECT u FROM UserInfo u WHERE u.userPhone = :value OR u.userEmail =:value")
    UserInfo findByKeyword(@Param("value") String value);
}
