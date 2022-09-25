package com.taoism.discipline.enumtype;

public enum SubType {
	
	CODE("code"),TOKEN("token");
	
	private String name;
	
	SubType(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
