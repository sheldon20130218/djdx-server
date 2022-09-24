package com.taoism.discipline.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.model.UserInfo;
import com.taoism.discipline.model.VxapiVerificationInfo;
import com.taoism.discipline.service.LoginService;
import com.taoism.discipline.service.UserService;
import com.taoism.discipline.utils.WxqqApiUtil;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    UserService userService;
    
    @Autowired
    LoginService loginService;
    
    @Resource(name = "vxapiVerificationCache")
	private Cache<String, VxapiVerificationInfo> vxapiVerificationCache;
    
    @GetMapping("/register")
    public UserInfo register(@PathVariable("code") String code) {
    	
    	UserEntity userEntity = new UserEntity();

		//1.获取vxqqapi 验证信息
		VxapiVerificationInfo vInfo = vxapiVerificationCache.get(code, k -> selectVinfo(k));
		
		//验证不通过,直接返回为null
		if(null == vInfo.getOpenid()) {
			return new UserInfo(userEntity);
		}else {
			userEntity = userService.register(vInfo.getOpenid());
			//登陆表记录一下
			loginService.insert(vInfo.getOpenid());
		}    		    		    	
    	return new UserInfo(userEntity);
    }
    
    private VxapiVerificationInfo selectVinfo(String code) {
    	VxapiVerificationInfo vInfo = WxqqApiUtil.getVxapiVerificationInfo(code);
		return vInfo;
	}




    


}
