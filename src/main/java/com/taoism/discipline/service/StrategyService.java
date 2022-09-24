package com.taoism.discipline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taoism.discipline.entity.StrategyEntity;
import com.taoism.discipline.mapper.StrategyMapper;
import com.taoism.discipline.utils.DateUtil;

import java.util.Date;

@Service
@Transactional
public class StrategyService {

    @Autowired
    StrategyMapper strategyMapper;

    public void insert(StrategyEntity strategyEntity){
        // 查询当前策略在数据库中是否存在
        StrategyEntity result = strategyMapper.selectByDate(strategyEntity.getDate());
        if(result == null){
            strategyMapper.insert(strategyEntity);
        }
    }

    public StrategyEntity selectByDate(Date date){
        return strategyMapper.selectByDate(DateUtil.toSqlDate(date));
    }

}
