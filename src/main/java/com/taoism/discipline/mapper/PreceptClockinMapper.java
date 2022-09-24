package com.taoism.discipline.mapper;

import com.taoism.discipline.entity.PreceptClockinEntity;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * 戒文打卡表 PreceptClockinEntityMapper Class
 * create time : 2022-09-11 17:02:49
 */
public interface PreceptClockinMapper {

    /**
     * 查询列表
     * @param entity
     * @return
     */
    List<PreceptClockinEntity> selectListByParams(@Param("clockinDate") Date clockinDate, @Param("openid") String openid);

    /**
     * 根据打卡日期和用户openid删除三条信息
     * @param id
     */
    void deleteByParams(@Param("clockinDate") Date clockinDate, @Param("openid") String openid,@Param("preceptDataType") String preceptDataType);

    /*
     * 根据打卡日期、用户、戒文类型删除一条信息
     * */
    void delete(@Param("clockinDate") Date clockinDate, @Param("openid") String openid,@Param("preceptDataType") String preceptDataType);
    /**
     * 插入
     * @param entity
     */
    void insert(PreceptClockinEntity entity);

}