package com.taoism.discipline.controller;

import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.service.LoginService;
import com.taoism.discipline.service.UserService;
import com.taoism.discipline.utils.TokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;
    
    @Autowired
    LoginService loginService;
    
    @GetMapping("/login")
    public UserEntity login(@RequestHeader(value = "token") String token) {
    	
    	UserEntity userEntity = new UserEntity();
    	
		String openid = TokenUtil.getOpenid(token);
		if(openid == null) {
			return userEntity;
		}else {
			userEntity = userService.selectByOpenid(openid);
			//登陆表记录一下
			loginService.insert(openid);
		}    	
    	return userEntity;
    }

}
