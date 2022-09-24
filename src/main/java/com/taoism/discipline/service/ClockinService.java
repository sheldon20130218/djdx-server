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
			PreceptClockin preceptClockin = this.toPreceptClockin(entity);
			clockinInfoList.add(preceptClockin);
		}
		return clockinInfoList;
	}

	@Override
	public ClockinInfo selectByDate(String openid, Date date) {
		// TODO Auto-generated method stub
		StrategyEntity strategyEntity = strategyMapper.selectByDate(date);
		
		Long[] ids = stringToArray(strategyEntity.getPreceptIds());
		List<PreceptEntity> list = preceptMapper.selectByPreceptIds(ids);
		List<PreceptClockin> elementaryRank = new ArrayList<PreceptClockin>();
		List<PreceptClockin> middleRank = new ArrayList<PreceptClockin>();
		List<PreceptClockin> highRank = new ArrayList<PreceptClockin>();
		
		
		
		return null;
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
	
	private PreceptClockin toPreceptClockin(PreceptEntity entity) {
		PreceptClockin preceptClockin = new PreceptClockin();
		preceptClockin.setIsClockin(true);
		preceptClockin.setPrecept(entity.getContent());
		preceptClockin.setPreceptDataType(entity.getDataType());
		preceptClockin.setPreceptId(entity.getPreceptId());
		return preceptClockin;
	}


    
}
