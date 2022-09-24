package com.taoism.discipline.serviceimpl;

import java.util.List;

import com.taoism.discipline.entity.LoginEntity;

public interface LoginImpl {

	void insert(String token);
	
	List<LoginEntity> selectByOpenid(String openid);
}
