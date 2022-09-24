package com.taoism.discipline.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.benmanes.caffeine.cache.Cache;
import com.taoism.discipline.entity.PreceptEntity;
import com.taoism.discipline.entity.StrategyEntity;
import com.taoism.discipline.mapper.PreceptMapper;
import com.taoism.discipline.mapper.StrategyMapper;
import com.taoism.discipline.utils.DateUtil;

@Service
@Transactional
public class PreceptService {

	@Autowired
	PreceptMapper preceptMapper;
	
	@Autowired
	StrategyMapper strategyMapper;
	
	@Resource(name = "preceptCache")
	private Cache<String, List<PreceptEntity>> preceptListCache;
	
    @Cacheable(key = "#date")
    public List<PreceptEntity> getPreceptsByDate(String date) {
        return preceptListCache.get(date, k -> selectPreceptsForDate(k));
    }
    
    public List<PreceptEntity> selectPreceptsForDate(String date){  	
    	java.util.Date ud = DateUtil.toDate(date, "yyyy-MM-dd");
    	Date sd = DateUtil.toSqlDate(ud);
    	StrategyEntity strategyEntity = strategyMapper.selectByDate(sd);
    	
    	if(strategyEntity == null || strategyEntity.getPreceptIds().isBlank()) {
			return null;
		}else {
			String str = strategyEntity.getPreceptIds().replace("[", "").replace("]", "");
			String[] strArray = str.split(",");
			Integer[] preceptIds = new Integer[strArray.length];
			for(int i=0;i<strArray.length;i++) {
				preceptIds[i] = Integer.parseInt(strArray[i]);
			}
			
			List<PreceptEntity> list = preceptMapper.selectByPreceptIds(preceptIds);
			return list;
		}
    	
    }
    
	public List<PreceptEntity> selectAll(){
		return preceptMapper.selectAll();
	}
	
	public List<PreceptEntity> preceptsForToday(){
		String today = new Date(new java.util.Date().getTime()).toString();
		return getPreceptsByDate(today);		
	}
	
	public List<PreceptEntity> selectByPreceptIds(Integer[] preceptIds){
		return null;
	}
}
