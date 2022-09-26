package com.taoism.discipline.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taoism.discipline.entity.StrategyEntity;
import com.taoism.discipline.mapper.StrategyMapper;
import com.taoism.discipline.utils.TokenUtil;

@RestController
@RequestMapping("/api")
public class DataInsertController {
	
	@Autowired
	StrategyMapper strategyMapper;

	
	@PostMapping("/data/strategyInit")
	public void strategyInit(@RequestHeader(value = "token") String token) {
		String openid = TokenUtil.getOpenid(token);
		//1.删除所有的策略信息
		//strategyMapper
		this.strategyMapper.deleteAll();
		
		int[] eids = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] mids = new int[]{11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
		int[] hids = new int[]{311,312,313,314,315,316,317,318,319,320};
		
		//定义初始日期:2022/9/1
		Date startDate = new Date(2022-1900, 8, 1);
		
		//时间跨度：27*10=270天
		Long duration = 270L;
		
		//Date endDate = new Date(startDate.getTime() + 24L*60L*60L*1000L * duration);
		
		for(int i = 0; i < duration; i++) {
			//循环内md 组
			int md = i % 10;
			
			int[] midsIns = new int[30];
			for(int j= 0; j < 30 ; j++) {
				midsIns[j] = mids[j] + md*30;
			}
			int hd = i % 27;
			int[] hidsIns = new int[10];
			for(int j= 0; j < 10 ; j++) {
				hidsIns[j] = hids[j] + hd*10;
			}
			
			int[] pids = new int[50];
			
			for(int k = 0; k < 10; k++) {
				pids[k] = eids[k];
			}
			for(int k = 10; k < 40; k++) {
				pids[k] = midsIns[k - 10];
			}
			for(int k = 40; k < 50; k++) {
				pids[k] = hidsIns[k - 40];
			}
			String pidsStr = Arrays.toString(pids).replace("[", "").replace("]", "");
			StrategyEntity entity = new StrategyEntity();
			
			entity.setCreateBy("admin");
			Date currentDay = new Date(startDate.getTime() + 24L*60L*60L*1000L*i);
			System.out.println(currentDay);
			entity.setDate(currentDay);
			entity.setPreceptIds(pidsStr);
			entity.setCreateDate(new Timestamp(startDate.getTime()));
			
			strategyMapper.insert(entity);
		}
	}
}
