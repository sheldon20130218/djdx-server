package com.taoism.discipline.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taoism.discipline.entity.UserEntity;

@Mapper
public interface UserMapper{

    UserEntity selectByOpenid(@Param("openid") String openid);

    UserEntity selectByUid(@Param("uid") Integer uid);

    void insert(UserEntity userEntity);

	Integer selectCountByOpenid(@Param("openid") String openid);

	void updateUserNickname(UserEntity entity);
}