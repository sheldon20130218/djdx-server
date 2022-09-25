package com.taoism.discipline.serviceimpl;

import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.model.UserInfo;

public interface UserImpl {
	
	UserInfo register(String openid);
	
	Integer selectCountByOpenid(String openid);
	
	UserInfo selectByOpenid(String openid);

	UserInfo modifyUserNickname(String openid, String nickname, String avatarBase64);
	
	UserInfo selectUserInfo(String openid);

}
