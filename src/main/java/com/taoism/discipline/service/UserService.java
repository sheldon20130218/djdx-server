package com.taoism.discipline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.mapper.UserMapper;
import com.taoism.discipline.serviceimpl.UserImpl;
import com.taoism.discipline.utils.TokenUtil;

import java.util.Date;

@Service
@Transactional
public class UserService implements UserImpl {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity register(String openid){
        // 查询当前用户在数据库中是否存在，不存在则插入新数据
        if(userMapper.selectCountByOpenid(openid) < 1){
        	UserEntity entity = new UserEntity();
			entity.setOpenid(openid);
			entity.setNickname("微信用户");
			entity.setRegDate(new Date());
			entity.setToken(TokenUtil.getToken(openid));
			entity.setStatus(1);//激活状态
            userMapper.insert(entity);
        }
        
        return userMapper.selectByOpenid(openid);
    }

    
    private UserEntity selectByUid(Integer uid){
        return userMapper.selectByUid(uid);
    }

    @Override
    public UserEntity selectByOpenid(String openid){
        return userMapper.selectByOpenid(openid);
    }
    
    @Override
    public Integer selectCountByOpenid(String openid){
    	return userMapper.selectCountByOpenid(openid);
    }

	@Override
	public UserEntity modifyUserNickname(String token, String nickname, String avatarBase64) {
		String openid = TokenUtil.getOpenid(token);
		UserEntity entity = userMapper.selectByOpenid(openid);
		entity.setNickname(nickname);
		entity.setAvatarBase64(avatarBase64);
		userMapper.updateUserNickname(entity);
		
		return entity;
	}
}
