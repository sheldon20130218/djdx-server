package com.taoism.discipline.mapper;

import com.taoism.discipline.entity.UserExtensionEntity;

public interface UserExtensionMapper {

    int delete(String openid);

    int insert(UserExtensionEntity record);

    UserExtensionEntity selectByOpenid(String openid);

    int updateByOpenid(UserExtensionEntity record);

}