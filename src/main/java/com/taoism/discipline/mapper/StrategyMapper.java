package com.taoism.discipline.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taoism.discipline.entity.StrategyEntity;

@Mapper
public interface StrategyMapper{

    StrategyEntity selectByDate(@Param("date") Date date);

    void insert(StrategyEntity userEntity);
    

}