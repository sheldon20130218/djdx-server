package com.taoism.discipline.enumtype;

public enum LoginType {
	
	CODE("code"),TOKEN("token");
	
	private String name;
	
	LoginType(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
