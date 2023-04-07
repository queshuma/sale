package com.example.sale.Repository;

import com.example.sale.Model.ProInfo;
import com.example.sale.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserInfoRepository<S extends UserInfo> extends JpaRepository<UserInfo, String> {

    List<UserInfo> findAll();

    @Query("SELECT u FROM UserInfo u WHERE u.userPhone = :value OR u.userEmail =:value")
    UserInfo findByKeyword(@Param("value") String value);

    UserInfo findByUserEmailOrUserPhone(String email, String phone);

    UserInfo findByUserPetName(String name);

    UserInfo findByUserId(long id);

    UserInfo findByUserPetNameOrUserPhoneOrUserEmail(String name, String phone, String email);
    @Override
    <S extends UserInfo> S save(S entity);
}
