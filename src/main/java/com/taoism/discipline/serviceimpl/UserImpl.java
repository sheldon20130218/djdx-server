package com.taoism.discipline.serviceimpl;

import com.taoism.discipline.entity.UserEntity;

public interface UserImpl {
	
	UserEntity register(String openid);
	
	Integer selectCountByOpenid(String openid);
	
	UserEntity selectByOpenid(String openid);

	UserEntity modifyUserNickname(String token, String nickname, String avatarBase64);

}
