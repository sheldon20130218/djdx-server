package com.taoism.discipline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taoism.discipline.entity.UserExtensionEntity;
import com.taoism.discipline.model.UserInfo;
import com.taoism.discipline.service.UserService;
import com.taoism.discipline.utils.TokenUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/modifyUserNickname")
	public UserInfo modifyUserNickname(@RequestHeader(value = "token") String token,String nickname,String avatarBase64) {
		String openid = TokenUtil.getOpenid(token);
		UserInfo info = userService.modifyUserNickname(openid,nickname,avatarBase64);
		
		return info;
	}
	
	@PostMapping("/user/findUserInfo")
	public UserInfo findUserInfo(@RequestHeader(value = "token") String token) {
		String openid = TokenUtil.getOpenid(token);
		UserInfo info = userService.selectUserInfo(openid);
		
		return info;
	}
	
	@PostMapping("/user/updateExtension")
	public UserInfo updateExtension(@RequestHeader(value = "token") String token, @RequestBody JSONObject jsonObj) {
		String openid = TokenUtil.getOpenid(token);
		
		UserInfo info = userService.updateExtension(openid,jsonObj);
		return info;
	}
	
	
}
