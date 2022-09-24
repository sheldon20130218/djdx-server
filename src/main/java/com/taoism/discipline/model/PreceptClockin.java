package com.taoism.discipline.model;

/*
 * 打卡记录model
 * 
 * */
public class PreceptClockin {
	
	private Long preceptId;
	
	private String precept;
	
	private String preceptDataType;
	
	private Boolean isClockin;

	public Boolean getIsClockin() {
		return isClockin;
	}

	public void setIsClockin(Boolean isClockin) {
		this.isClockin = isClockin;
	}

	public Long getPreceptId() {
		return preceptId;
	}

	public void setPreceptId(Long preceptId) {
		this.preceptId = preceptId;
	}

	public String getPreceptDataType() {
		return preceptDataType;
	}

	public void setPreceptDataType(String preceptDataType) {
		this.preceptDataType = preceptDataType;
	}
	
	public String getPrecept() {
		return precept;
	}

	public void setPrecept(String precept) {
		this.precept = precept;
	}
	
}
