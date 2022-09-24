package com.taoism.discipline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taoism.discipline.entity.LoginEntity;

@Mapper
public interface LoginMapper{

    List<LoginEntity> selectByOpenid(@Param("openid") String openid);

    void insert(LoginEntity loginEntity);

}