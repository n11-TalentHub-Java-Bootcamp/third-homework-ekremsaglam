package com.ekremsaglam.springboot.dao;

import com.ekremsaglam.springboot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

    public UserInfo findAllByName(String name);
    public UserInfo findAllByPhoneNumber(String phoneNumber);
}