package com.taoism.discipline.controller;

import com.taoism.discipline.model.UserInfo;
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
    public UserInfo login(@RequestHeader(value = "token") String token) {
    	
    	UserInfo info = new UserInfo();
    	
		String openid = TokenUtil.getOpenid(token);
		if(openid == null) {
			return info;
		}else {
			info = userService.selectByOpenid(openid);
			//登陆表记录一下
			loginService.insert(openid);
		}    	
    	return info;
    }

}
