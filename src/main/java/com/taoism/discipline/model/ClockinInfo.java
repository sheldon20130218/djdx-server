package com.taoism.discipline.model;

import java.util.ArrayList;

public class ClockinInfo {
	
	private ArrayList<PreceptClockin> elementaryRank = new ArrayList<PreceptClockin>();
	
	private ArrayList<PreceptClockin> middleRank = new ArrayList<PreceptClockin>();
	
	private ArrayList<PreceptClockin> highRank = new ArrayList<PreceptClockin>();
	
	private String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
