package com.taoism.discipline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taoism.discipline.entity.PreceptEntity;


@Mapper
public interface PreceptMapper {
	
	List<PreceptEntity> selectAll();
	
	List<PreceptEntity> selectByPreceptIds(Integer[] preceptIds);
}
