package com.taoism.discipline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.model.UserInfo;
import com.taoism.discipline.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/modifyUserNickname/{token}")
	public UserInfo modifyUserNickname(@PathVariable("token") String token,String nickname,String avatarBase64) {
		
		UserEntity entity = userService.modifyUserNickname(token,nickname,avatarBase64);
		return new UserInfo(entity);
	}
}
