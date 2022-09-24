package com.taoism.discipline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taoism.discipline.entity.LoginEntity;
import com.taoism.discipline.mapper.LoginMapper;
import com.taoism.discipline.serviceimpl.LoginImpl;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LoginService implements LoginImpl{

    @Autowired
    LoginMapper loginMapper;

    @Override
    public void insert(String openid){
    	LoginEntity entity = new LoginEntity();
    	entity.setLoginTime(new Date());
    	entity.setOpenid(openid);
        loginMapper.insert(entity);
        
    }

    @Override
    public List<LoginEntity> selectByOpenid(String openid){
        return loginMapper.selectByOpenid(openid);
    }
}
