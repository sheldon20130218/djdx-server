package com.taoism.discipline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 戒文打卡表
 * create time : 2022-09-11 17:02:49
 *
 */
@Table(name = "t_precept_clockin")
public class PreceptClockinEntity {
    /**
     *   主键ID
     */
    @Id
    @Column(name = "clockin_id")
    private Long clockinId;

    /**
     *   用户openid
     */
    private String openid;

    /**
     *   打卡的戒文ids,逗号隔开
     */
    @Column(name = "precept_ids")
    private String preceptIds;

    /**
     *   戒文类型,1:初级;2:中级;3:高级
     */
    @Column(name = "precept_data_type")
    private String preceptDataType;

    /**
     *   打卡日期
     */
    @Column(name = "clockin_date")
    private Date clockinDate;

    public Long getClockinId() {
        return clockinId;
    }

    public void setClockinId(Long clockinId) {
        this.clockinId = clockinId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPreceptIds() {
        return preceptIds;
    }

    public void setPreceptIds(String preceptIds) {
        this.preceptIds = preceptIds;
    }

    public String getPreceptDataType() {
        return preceptDataType;
    }

    public void setPreceptDataType(String preceptDataType) {
        this.preceptDataType = preceptDataType == null ? null : preceptDataType.trim();
    }

    public Date getClockinDate() {
        return clockinDate;
    }

    public void setClockinDate(Date clockinDate) {
        this.clockinDate = clockinDate;
    }

    /**
     * auto generator
     */
    public String toString() {
        return super.toString()
        +"\nclockinId:" + this.clockinId
        +"\nopenid:" + this.openid
        +"\npreceptIds:" + this.preceptIds
        +"\npreceptDataType:" + this.preceptDataType
        +"\nclockinDate:" + this.clockinDate
        ;
    }
}