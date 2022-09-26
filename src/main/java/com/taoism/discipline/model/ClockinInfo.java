package com.taoism.discipline.model;

import java.util.ArrayList;
import java.sql.Date;

public class ClockinInfo {
	
	private ArrayList<PreceptClockin> elementaryRank = new ArrayList<PreceptClockin>();
	
	private ArrayList<PreceptClockin> middleRank = new ArrayList<PreceptClockin>();
	
	private ArrayList<PreceptClockin> highRank = new ArrayList<PreceptClockin>();
	
	private Date date;
	
	//初真打卡标志
	private Boolean elementaryClockIn = false;
	
	//中级打卡标志
	private Boolean middleClockIn = false;
	
	//高级打卡标志
	private Boolean highClockIn = false;
	
	private String highRanktitle;

	public ArrayList<PreceptClockin> getElementaryRank() {
		return elementaryRank;
	}

	public void setElementaryRank(ArrayList<PreceptClockin> elementaryRank) {
		if(null == elementaryRank || elementaryRank.isEmpty()) {
			return;
		}
		
		this.elementaryRank.addAll(elementaryRank);
	}

	public ArrayList<PreceptClockin> getMiddleRank() {
		return middleRank;
	}

	public void setMiddleRank(ArrayList<PreceptClockin> middleRank) {
		if(null == middleRank || middleRank.isEmpty()) {
			return;
		}
		this.middleRank.addAll(middleRank);
	}

	public ArrayList<PreceptClockin> getHighRank() {
		return highRank;
	}

	public void setHighRank(ArrayList<PreceptClockin> highRank) {
		if(null == highRank || highRank.isEmpty()) {
			return;
		}
		this.highRank.addAll(highRank);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHighRanktitle() {
		return highRanktitle;
	}

	public void setHighRanktitle(String highRanktitle) {
		this.highRanktitle = highRanktitle;
	}

	public Boolean getElementaryClockIn() {
		return elementaryClockIn;
	}

	public void setElementaryClockIn(Boolean elementaryClockIn) {
		this.elementaryClockIn = elementaryClockIn;
	}

	public Boolean getMiddleClockIn() {
		return middleClockIn;
	}

	public void setMiddleClockIn(Boolean middleClockIn) {
		this.middleClockIn = middleClockIn;
	}

	public Boolean getHighClockIn() {
		return highClockIn;
	}

	public void setHighClockIn(Boolean highClockIn) {
		this.highClockIn = highClockIn;
	}
	
}
