package com.taoism.discipline.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taoism.discipline.model.ClockinInfo;
import com.taoism.discipline.model.PreceptClockin;
import com.taoism.discipline.service.ClockinService;
import com.taoism.discipline.utils.TokenUtil;


@RestController
@RequestMapping("/api")
public class ClockinController {
	
	@Autowired
	ClockinService clockinService;
	
	@PostMapping("/clockin/elementary")
    public List<PreceptClockin> getElementary(@RequestHeader(value = "token") String token,Long time,String preceptIds) {
		String openid = TokenUtil.getOpenid(token);
		return clockinService.Clockin(openid, new Date(time), preceptIds,"1");
    }
	
	@PostMapping("/clockin/intermediate")
    public List<PreceptClockin> getIntermediate(@RequestHeader(value = "token") String token, Long time,String preceptIds) {
		String openid = TokenUtil.getOpenid(token);
		return clockinService.Clockin(openid,new Date(time), preceptIds,"2");
    }
	
	@PostMapping("/clockin/superior")
    public List<PreceptClockin> getSuperior(@RequestHeader(value = "token") String token,Long time,String preceptIds) {
		String openid = TokenUtil.getOpenid(token);
		return clockinService.Clockin(openid, new Date(time), preceptIds,"3");
    }
	
	
	
	@PostMapping("/clockin/history")
    public ClockinInfo getHistory(@RequestHeader(value = "token") String token, Long time) {
		String openid = TokenUtil.getOpenid(token);
		ClockinInfo clockinInfo = clockinService.getHistoryClockinInfo(openid,new Date(time));
		
		return clockinInfo;
    }

}
