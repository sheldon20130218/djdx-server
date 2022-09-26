package com.taoism.discipline.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taoism.discipline.entity.PreceptClockinEntity;
import com.taoism.discipline.entity.PreceptEntity;
import com.taoism.discipline.entity.StrategyEntity;
import com.taoism.discipline.mapper.PreceptClockinMapper;
import com.taoism.discipline.mapper.PreceptMapper;
import com.taoism.discipline.mapper.StrategyMapper;
import com.taoism.discipline.model.ClockinInfo;
import com.taoism.discipline.model.PreceptClockin;
import com.taoism.discipline.serviceimpl.ClockinImpl;

@Service
@Transactional
public class ClockinService implements ClockinImpl{
	
	@Autowired
	PreceptClockinMapper preceptClockinMapper;
  
	@Autowired
	PreceptMapper preceptMapper;
	
	@Autowired
	StrategyMapper strategyMapper;

  	//根据类型日期用户打卡
	@Override
	public List<PreceptClockin> Clockin(String openid, Date date, String preceptIds, String preceptDataType) {
		this.delete(openid, date, preceptDataType);
		this.insert(openid, date, preceptIds, preceptDataType);
		
		Long[] ids = stringToArray(preceptIds);
		List<PreceptEntity> list = preceptMapper.selectByPreceptIds(ids);
		List<PreceptClockin> clockinInfoList = new ArrayList<PreceptClockin>();
		for (PreceptEntity entity : list) {
			PreceptClockin preceptClockin = this.toPreceptClockin(entity,true);
			clockinInfoList.add(preceptClockin);
		}
		return clockinInfoList;
	}
	
	private void insert(String openid, Date date, String preceptIds, String preceptDataType) {
		PreceptClockinEntity entity = new PreceptClockinEntity();
		entity.setClockinDate(date);
		entity.setOpenid(openid);
		entity.setPreceptIds(preceptIds);
		entity.setPreceptDataType(preceptDataType);
		preceptClockinMapper.insert(entity);
	}
	
	private void delete(String openid, Date date,String preceptDataType) {
		preceptClockinMapper.delete(date, openid,preceptDataType);
	}
	
	private Long[] stringToArray(String preceptIds) {
		String str = preceptIds.replace("[", "").replace("]", "");
		String[] idStrAarry = str.split(",");
		Long[] idArray = new Long[idStrAarry.length];
		for(int i = 0; i < idStrAarry.length; i++) {
			idArray[i] = Long.parseLong(idStrAarry[i]);
		}
		return idArray;
	}
	
	private PreceptClockin toPreceptClockin(PreceptEntity entity,Boolean isClockin) {
		PreceptClockin preceptClockin = new PreceptClockin();
		preceptClockin.setIsClockin(isClockin);
		preceptClockin.setPrecept(entity.getContent());
		preceptClockin.setPreceptDataType(entity.getDataType());
		preceptClockin.setPreceptId(entity.getPreceptId());
		return preceptClockin;
	}

	@Override
	public ClockinInfo getHistoryClockinInfo(String openid, Date date) {
		ClockinInfo clockinInfo = new ClockinInfo();
		//1.按时间、openid获取打卡信息
		List<PreceptClockinEntity> preceptClockinEntitylist =preceptClockinMapper.selectListByParams(date, openid);
		
		String clockinPreceptIdsStr = ",";
		for (PreceptClockinEntity preceptClockinEntity : preceptClockinEntitylist) {
			if("1".equals(preceptClockinEntity.getPreceptDataType())) {
				clockinInfo.setElementaryClockIn(true);
			}
			if("2".equals(preceptClockinEntity.getPreceptDataType())) {
				clockinInfo.setMiddleClockIn(true);
			}
			if("3".equals(preceptClockinEntity.getPreceptDataType())) {
				clockinInfo.setHighClockIn(true);
			}
			
			clockinPreceptIdsStr = clockinPreceptIdsStr + preceptClockinEntity.getPreceptIds() + ",";
		}
		
		//2.按时间获取策略信息
		StrategyEntity strategyEntity = strategyMapper.selectByDate(date);
		if(null == strategyEntity ||  strategyEntity.getPreceptIds().isBlank()) {
			return clockinInfo;
		}
		String strategyPrecept = strategyEntity.getPreceptIds();
		String[] strategyPreceptIdsStr = strategyPrecept.split(",");
		Long[] strategyPreceptIds = new Long[strategyPreceptIdsStr.length];
		for(int i = 0; i<strategyPreceptIdsStr.length; i++) {
			strategyPreceptIds[i] = Long.parseLong(strategyPreceptIdsStr[i].trim());
		}
		
		//3.按照策略获取所有戒文信息
		List<PreceptEntity> list = preceptMapper.selectByPreceptIds(strategyPreceptIds);
		System.out.println(list.size());
		if(null == list || list.size() == 0) {
			return clockinInfo;
		}
		
		ArrayList<PreceptClockin> elementaryRank = new ArrayList<PreceptClockin>();
		
		ArrayList<PreceptClockin> middleRank = new ArrayList<PreceptClockin>();
		
		ArrayList<PreceptClockin> highRank = new ArrayList<PreceptClockin>();
		
		for (PreceptEntity entity : list) {
			String subStr = "," + entity.getPreceptId().toString() + ",";
			Boolean isClockin = clockinPreceptIdsStr.indexOf(subStr) > -1;
			
			PreceptClockin preceptClockin = this.toPreceptClockin(entity,isClockin);
			if("1".equals(entity.getDataType().trim())) {
				elementaryRank.add(preceptClockin);
			}
			if("2".equals(entity.getDataType().trim())) {
				middleRank.add(preceptClockin);
			}
			if("3".equals(entity.getDataType().trim())) {
				highRank.add(preceptClockin);
			}
		}
		
		clockinInfo.setElementaryRank(elementaryRank);
		clockinInfo.setMiddleRank(middleRank);
		clockinInfo.setHighRank(highRank);
		
		clockinInfo.setDate(date);
		
		return clockinInfo;
	}
	
	
	private String getHighRankTitle(List<PreceptEntity> list) {
		String title = null;
		for (PreceptEntity entity : list) {
			if("3".equals(entity.getDataType())) {
				
			}
		}
		
		return title;
		
	}
	
}
