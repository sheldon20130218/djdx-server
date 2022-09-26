package com.taoism.discipline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.entity.UserExtensionEntity;
import com.taoism.discipline.mapper.UserExtensionMapper;
import com.taoism.discipline.mapper.UserMapper;
import com.taoism.discipline.model.UserInfo;
import com.taoism.discipline.serviceimpl.UserImpl;
import com.taoism.discipline.utils.TokenUtil;

import java.util.Date;

@Service
@Transactional
public class UserService implements UserImpl {

    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserExtensionMapper userExtensionMapper;

    @Override
    public UserInfo register(String openid){
    	
        // 查询当前用户在数据库中是否存在，不存在则插入新数据
        if(userMapper.selectCountByOpenid(openid) < 1){
        	UserEntity entity = new UserEntity();
			entity.setOpenid(openid);
			entity.setNickname("微信用户");
			entity.setRegDate(new Date());
			entity.setToken(TokenUtil.getToken(openid));
			entity.setStatus(1);//激活状态
            userMapper.insert(entity);
            
            UserExtensionEntity userExtensionEntity = new UserExtensionEntity();
            userExtensionEntity.setOpenid(openid);
            userExtensionEntity.setCreateDate(new Date());
            userExtensionEntity.setCreateBy(openid);
            userExtensionMapper.insert(userExtensionEntity);
        }
        UserEntity userEntity = userMapper.selectByOpenid(openid);
        UserExtensionEntity userExtensionEntity = userExtensionMapper.selectByOpenid(openid);
        
        return new UserInfo(userEntity,userExtensionEntity);
    }

    
    private UserEntity selectByUid(Integer uid){
        return userMapper.selectByUid(uid);
    }

    @Override
    public UserInfo selectByOpenid(String openid){
    	UserEntity userEntity = userMapper.selectByOpenid(openid);
    	UserExtensionEntity userExtensionEntity = userExtensionMapper.selectByOpenid(openid);
        return new UserInfo(userEntity,userExtensionEntity);
    }
    
    @Override
    public Integer selectCountByOpenid(String openid){
    	return userMapper.selectCountByOpenid(openid);
    }

	@Override
	public UserInfo modifyUserNickname(String openid, String nickname, String avatarBase64) {
		UserEntity entity = userMapper.selectByOpenid(openid);
		entity.setNickname(nickname);
		entity.setAvatarBase64(avatarBase64);
		userMapper.updateUserNickname(entity);
		
		UserExtensionEntity userExtensionEntity = userExtensionMapper.selectByOpenid(openid);
		
		return new UserInfo(entity,userExtensionEntity);
	}

	@Override
	public UserInfo selectUserInfo(String openid) {
		UserEntity entity = userMapper.selectByOpenid(openid);
		UserExtensionEntity userExtensionEntity = userExtensionMapper.selectByOpenid(openid);
		return new UserInfo(entity,userExtensionEntity);
	}


	@Override
	public UserInfo updateExtension(String openid, JSONObject jsonObj) {
		UserEntity entity = userMapper.selectByOpenid(openid);
		UserExtensionEntity userExtensionEntity = userExtensionMapper.selectByOpenid(openid);
		
		userExtensionEntity.setLegalName(jsonObj.getString("legalName"));
		userExtensionEntity.setGender(jsonObj.getString("gender"));
		userExtensionEntity.setMobile(jsonObj.getString("phoneNum"));
		userExtensionEntity.setSect(jsonObj.getString("sect"));
		userExtensionEntity.setMaster(jsonObj.getString("master"));
		userExtensionEntity.setAddress(jsonObj.getString("address"));
		userExtensionEntity.setHatDate(new Date(Long.parseLong(jsonObj.getString("hatDate"))));
		userExtensionEntity.setHatAddress(jsonObj.getString("hatAddress"));
		userExtensionEntity.setReceivePreceptsDate(new Date(Long.parseLong(jsonObj.getString("receivePreceptsDate"))));
		userExtensionEntity.setReceivePreceptsAddress(jsonObj.getString("receivePreceptsAddress"));
		userExtensionEntity.setCertificateCode(jsonObj.getString("certificateCode"));
		userExtensionEntity.setSpeciality(jsonObj.getString("specialty"));
		
		userExtensionMapper.updateByOpenid(userExtensionEntity);
		UserInfo info = new UserInfo(entity,userExtensionEntity);
		
		return info;
	}
}
