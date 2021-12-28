package com.ekremsaglam.springboot.controller;

import com.ekremsaglam.springboot.dto.ProductDetailDto;
import com.ekremsaglam.springboot.dto.UserInfoDetailDto;
import com.ekremsaglam.springboot.entity.Category;
import com.ekremsaglam.springboot.entity.Product;
import com.ekremsaglam.springboot.entity.UserInfo;
import com.ekremsaglam.springboot.service.entityservice.UserInfoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoEntityService userInfoEntityService;

    @GetMapping("/users")
    public List<UserInfo> findAllProductList(){
        return userInfoEntityService.findAll();
    }

    @GetMapping("/users/{name}")
    public UserInfo findUserInfoByName(@PathVariable String name)
    {
        return userInfoEntityService.findByName(name);
    }

    @GetMapping("/users/{phoneNumber}")
    public UserInfo findUserInfoByPhoneNumber(@PathVariable String phoneNumber)
    {
        return userInfoEntityService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/users/dto/{id}")
    public UserInfoDetailDto findProductDtoById(@PathVariable Long id){

        UserInfo userInfo = userInfoEntityService.findById(id);

        UserInfoDetailDto userInfoDetailDto = convertUserInfoToUserInfoDetailDto(userInfo);

        return userInfoDetailDto;
    }
    private UserInfoDetailDto convertUserInfoToUserInfoDetailDto(UserInfo userInfo) {

        UserInfoDetailDto userInfoDetailDto = new UserInfoDetailDto();
        userInfoDetailDto.setName(userInfo.getName());
        userInfoDetailDto.setSurName(userInfo.getSurName());
        userInfoDetailDto.setUserName(userInfo.getSurName());
        return userInfoDetailDto;
    }

}
