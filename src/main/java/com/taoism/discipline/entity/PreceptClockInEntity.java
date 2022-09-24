package com.taoism.discipline.entity;

public class PreceptClockInEntity {

	private Integer clockinId;
	
	private String openid;
	
	private String preceptDataType;
	
	private String clockinDate;
	
	private String createBy;
	
	private String createDate;

	public Integer getClockinId() {
		return clockinId;
	}

	public void setClockinId(Integer clockinId) {
		this.clockinId = clockinId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPreceptDataType() {
		return preceptDataType;
	}

	public void setPreceptDataType(String preceptDataType) {
		this.preceptDataType = preceptDataType;
	}

	public String getClockinDate() {
		return clockinDate;
	}

	public void setClockinDate(String clockinDate) {
		this.clockinDate = clockinDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
